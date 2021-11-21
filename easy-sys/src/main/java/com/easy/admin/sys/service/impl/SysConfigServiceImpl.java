package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.common.constant.DataTypeConst;
import com.easy.admin.sys.dao.SysConfigMapper;
import com.easy.admin.sys.model.SysConfig;
import com.easy.admin.sys.service.SysConfigService;
import com.easy.admin.util.ToolUtil;
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

    /**
     * 列表
     *
     * @param object 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysConfig> select(SysConfig object, Page<SysConfig> page) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            // 查询条件
            // key
            if (Validator.isNotEmpty(object.getSysKey())) {
                queryWrapper.like("sys_key", object.getSysKey());
            }
            // value
            if (Validator.isNotEmpty(object.getValue())) {
                queryWrapper.like("value", object.getValue());
            }
            // 类型
            if (Validator.isNotEmpty(object.getType())) {
                queryWrapper.eq("type", object.getType());
            }
        }
        page.setDefaultDesc("create_date");
        return page(page, queryWrapper);
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
     * @param object 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysConfig saveData(SysConfig object) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        // 验证数据有效性
        switch (object.getType()) {
            case DataTypeConst.INTEGER:
                try {
                    Integer.parseInt(object.getValue());
                } catch (NumberFormatException e) {
                    throw new EasyException("请输入有效的数字");
                }
                break;
            case DataTypeConst.BOOLEAN:
                if (!CommonConst.TRUE.equals(object.getValue()) && !CommonConst.FALSE.equals(object.getValue())) {
                    throw new EasyException("请输入有效的boolean值");
                }
                break;
            default:
                break;
        }
        // 验证长度
        if(object.getValue().length() > 150){
            throw new EasyException("value长度超过限制，最多150个字符");
        }

        queryWrapper.eq("sys_key", object.getSysKey());
        if (object.getId() != null) {
            queryWrapper.ne("id", object.getId());
        }
        if (count(queryWrapper) > 0) {
            throw new EasyException("key[" + object.getSysKey() + "]已存在");
        }
        updateCache(object);
        return (SysConfig) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Override
    public SysConfig getByKey(String key) {
        if (StrUtil.isNotBlank(key)) {
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
        return null;
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