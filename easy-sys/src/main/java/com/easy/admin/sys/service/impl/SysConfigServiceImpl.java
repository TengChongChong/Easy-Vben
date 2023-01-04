package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.constant.SysRoleConst;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.common.constant.DataTypeConst;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.sys.dao.SysConfigMapper;
import com.easy.admin.sys.model.SysConfig;
import com.easy.admin.sys.service.AsyncService;
import com.easy.admin.sys.service.SysConfigService;
import com.easy.admin.util.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 系统参数
 *
 * @author admin
 * @date 2019-03-03 15:52:44
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    @Autowired
    private AsyncService asyncService;

    /**
     * 列表
     *
     * @param sysConfig 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysConfig> select(SysConfig sysConfig, Page<SysConfig> page) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        if (sysConfig != null) {
            // 查询条件
            // key
            if (Validator.isNotEmpty(sysConfig.getSysKey())) {
                queryWrapper.like("t.sys_key", sysConfig.getSysKey());
            }
            // value
            if (Validator.isNotEmpty(sysConfig.getValue())) {
                queryWrapper.like("t.value", sysConfig.getValue());
            }
            // 备注
            if (Validator.isNotEmpty(sysConfig.getRemarks())) {
                queryWrapper.like("t.remarks", sysConfig.getRemarks());
            }
            // 类型
            if (Validator.isNotEmpty(sysConfig.getType())) {
                if (sysConfig.getType().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sysConfig.getType().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sysConfig.getType());
                }
            }
            // 系统
            if (Validator.isNotEmpty(sysConfig.getSys())) {
                if (sysConfig.getSys().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.sys", sysConfig.getSys().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.sys", sysConfig.getSys());
                }
            }
        }
        // 非系统管理员，仅显示非系统数据
        if (!ShiroUtil.havRole(SysRoleConst.SYS_ADMIN)) {
            queryWrapper.eq("t.sys", WhetherConst.NO);
        }
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public SysConfig get(String id) {
        return getById(id);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return 是否成功
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        boolean isSuccess = removeByIds(Arrays.asList(ids.split(",")));
        if (isSuccess) {
            refreshCache();
        }
        return isSuccess;
    }

    /**
     * 保存
     *
     * @param sysConfig 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysConfig saveData(SysConfig sysConfig) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        // 验证数据有效性
        switch (sysConfig.getType()) {
            case DataTypeConst.LONG:
                try {
                    Long.parseLong(sysConfig.getValue());
                } catch (NumberFormatException e) {
                    throw new EasyException("请输入有效的数字");
                }
                break;
            case DataTypeConst.BOOLEAN:
                if (!CommonConst.TRUE.equals(sysConfig.getValue()) && !CommonConst.FALSE.equals(sysConfig.getValue())) {
                    throw new EasyException("请输入有效的boolean值");
                }
                break;
            default:
                break;
        }
        // 验证长度
        if (sysConfig.getValue().length() > 255) {
            throw new EasyException("value长度超过限制，最多255个字符");
        }

        queryWrapper.eq("sys_key", sysConfig.getSysKey());
        if (sysConfig.getId() != null) {
            queryWrapper.ne("id", sysConfig.getId());
        }
        if (count(queryWrapper) > 0) {
            throw new EasyException("key[" + sysConfig.getSysKey() + "]已存在");
        }
        // 删除redis中的key
        RedisUtil.del(getRedisKey(sysConfig.getSysKey()));
        boolean isSuccess = saveOrUpdate(sysConfig);
        if (isSuccess) {
            // 再次删除redis中的key，防止高并发读写产生的脏数据
            asyncService.removeRedis(sysConfig.getSysKey(), 1000);
        }
        return sysConfig;
    }

    @Override
    public SysConfig getByKey(String key) {
        if (StrUtil.isBlank(key)) {
            return null;
        }

        SysConfig config = (SysConfig) RedisUtil.get(getRedisKey(key));
        if (config == null) {
            QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("sys_key,value,type");
            queryWrapper.eq("sys_key", key);
            config = getOne(queryWrapper);
            updateCache(config);
        }
        return config;
    }

    @Override
    public boolean refreshCache() {
        // 清空redis中sys config缓存
        RedisUtil.delByPrefix(RedisPrefix.SYS_CONFIG);
        // 从数据库查询config存入redis
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("sys_key,value,type");
        List<SysConfig> configs = list(queryWrapper);
        if (configs != null && !configs.isEmpty()) {
            for (SysConfig config : configs) {
                updateCache(config);
            }
        }
        return true;
    }

    /**
     * 向缓存中添加/修改系统参数
     *
     * @param config 系统参数
     */
    private void updateCache(SysConfig config) {
        if (config != null) {
            RedisUtil.set(getRedisKey(config.getSysKey()), config, 0);
        }
    }

    /**
     * 获取系统参数在redis中的key
     *
     * @param key key
     * @return key
     */
    private String getRedisKey(String key) {
        return RedisPrefix.SYS_CONFIG + key;
    }
}