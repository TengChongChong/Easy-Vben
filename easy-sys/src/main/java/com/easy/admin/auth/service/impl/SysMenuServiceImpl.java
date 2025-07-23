package com.easy.admin.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.type.MenuType;
import com.easy.admin.auth.dao.SysMenuMapper;
import com.easy.admin.auth.model.SysMenu;
import com.easy.admin.auth.model.vo.SysMenuVO;
import com.easy.admin.auth.service.SysMenuService;
import com.easy.admin.auth.service.SysRoleMenuService;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 菜单
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Override
    public List<SysMenuVO> select(SysMenuVO sysMenu) {
        QueryWrapper<SysMenu> queryWrapper = getQueryWrapper(sysMenu);
        return baseMapper.selectWithoutPage(queryWrapper);
    }

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll();
    }

    private QueryWrapper<SysMenu> getQueryWrapper(SysMenuVO sysMenu) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (sysMenu != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(sysMenu.getTitle())) {
                queryWrapper.like("t.title", sysMenu.getTitle());
            }
            // 权限标识
            if (Validator.isNotEmpty(sysMenu.getAuthCode())) {
                queryWrapper.like("t.auth_code", sysMenu.getAuthCode());
            }
            // 路由地址
            if (Validator.isNotEmpty(sysMenu.getPath())) {
                queryWrapper.like("t.path", sysMenu.getPath());
            }
            // 链接地址
            if (Validator.isNotEmpty(sysMenu.getLinkSrc())) {
                queryWrapper.like("t.link_src", sysMenu.getLinkSrc());
            }
            // 状态
            if (Validator.isNotEmpty(sysMenu.getStatus())) {
                if (sysMenu.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sysMenu.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sysMenu.getStatus());
                }
            }
        }
        return queryWrapper;
    }

    @Override
    public SysMenuVO get(String id) {
        SysMenu sysMenu = baseMapper.getById(id);
        if (sysMenu == null) {
            return null;
        }
        SysMenuVO sysMenuVO = new SysMenuVO();
        BeanUtil.copyProperties(sysMenu, sysMenuVO);
        // 查询其他相关业务数据
        return sysMenuVO;
    }

    @Override
    public SysMenuVO add(String parentId) {
        SysMenuVO sysMenu = new SysMenuVO();
        // 设置默认值
        if (Validator.isNotEmpty(parentId)) {
            SysMenu parentSysMenu = getById(parentId);
            if (parentSysMenu != null) {
                sysMenu.setParentId(parentId);
            }
        }
        sysMenu.setOrderNo(baseMapper.getMaxOrderNo(parentId) + 1);
        // 菜单
        sysMenu.setType(MenuType.MENU.getCode());
        // 启用
        sysMenu.setStatus(CommonStatus.ENABLE.getCode());
        return sysMenu;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 同时删除已分配的权限
            sysRoleMenuService.removeRoleMenu(ids);
            // 删除缓存的角色数据
            RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysMenuVO saveData(SysMenuVO sysMenuVO) {
        if (Validator.isEmpty(sysMenuVO.getId())) {
            // 新增,设置默认值
        }
        // 新增时设置排序值
        if (StrUtil.isBlank(sysMenuVO.getId()) && sysMenuVO.getOrderNo() == null) {
            sysMenuVO.setOrderNo(baseMapper.getMaxOrderNo(sysMenuVO.getParentId()) + 1);
        }

        if (StrUtil.isNotBlank(sysMenuVO.getQuery())) {
            try {
                new JSONObject(sysMenuVO.getQuery());
            } catch (Exception e) {
                throw new EasyException("路由参数必须为JSON格式，示例：{ name: \"张三\", sex: 1 }");
            }
        }

        // 检查path是否已存在
        if (checkHaving(sysMenuVO.getId(), "path", sysMenuVO.getPath())) {
            throw new EasyException("已存在路由地址为 " + sysMenuVO.getPath() + " 的菜单");
        }

        // 检查name是否已存在
        if (checkHaving(sysMenuVO.getId(), "name", sysMenuVO.getName())) {
            throw new EasyException("已存在组件Name为 " + sysMenuVO.getName() + " 的菜单");
        }

        SysMenu sysMenu = new SysMenu();
        BeanUtil.copyProperties(sysMenuVO, sysMenu);
        boolean isSuccess = saveOrUpdate(sysMenu);
        if (!isSuccess) {
            throw new EasyException(GlobalException.LOCK_ERROR);
        }
        // 同步保存后的id到VO
        sysMenuVO.setId(sysMenu.getId());

        // 保存其他相关业务数据

        // 删除缓存的角色数据
        RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        return sysMenuVO;
    }

    /**
     * 检查数据是否已经存在
     *
     * @param id    数据id
     * @param field 字段
     * @param value 值
     * @return true/false
     */
    private boolean checkHaving(String id, String field, String value) {
        if (Validator.isNotEmpty(value)) {
            QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(field, value);
            if (StrUtil.isNotBlank(id)) {
                queryWrapper.ne("id", id);
            }
            long count = baseMapper.selectCount(queryWrapper);
            return count > 0;
        }
        return false;
    }


    @Override
    public boolean setStatus(String id, String status, String type) {
        UpdateWrapper<SysMenu> setStatus = new UpdateWrapper<>();
        setStatus.set("status", status).eq("id", id);
        boolean isSuccess = update(setStatus);
        if (isSuccess && MenuType.MENU.getCode().equals(type)) {
            // 如果是菜单，同时修改子级的状态
            UpdateWrapper<SysMenu> setChildStatus = new UpdateWrapper<>();
            setChildStatus.set("status", status).eq("parent_id", id);
            update(setChildStatus);
            // 删除缓存的角色数据
            RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        }
        return isSuccess;
    }

    @Override
    public boolean saveOrder(List<SysMenu> sysMenuList) {
        boolean isSuccess = baseMapper.updateOrderBatch(sysMenuList) > 0;
        if (isSuccess) {
            // 删除缓存的角色数据
            RedisUtil.delByPrefix(RedisPrefix.SYS_ROLE);
        }
        return isSuccess;
    }

    @Override
    public boolean hasMenu(String title) {
        return baseMapper.countByTitle(title) > 0;
    }
}