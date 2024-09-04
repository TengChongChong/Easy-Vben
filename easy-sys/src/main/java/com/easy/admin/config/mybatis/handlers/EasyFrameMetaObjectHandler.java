package com.easy.admin.config.mybatis.handlers;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.config.sa.token.util.SessionUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充
 * 用于保存/修改的时候自动填充一些属性
 *
 * @author TengChongChong
 * @date 2019-05-14
 */
@Component
public class EasyFrameMetaObjectHandler implements MetaObjectHandler {
    /**
     * 创建人所在部门Id
     */
    private static final String DEPT_ID = "deptId";
    /**
     * 创建人
     */
    private static final String CREATE_USER = "createUser";
    /**
     * 创建时间
     */
    private static final String CREATE_DATE = "createDate";
    /**
     * 编辑人
     */
    private static final String EDIT_USER = "editUser";
    /**
     * 编辑时间
     */
    private static final String EDIT_DATE = "editDate";

    @Override
    public void insertFill(MetaObject metaObject) {
        SessionUserVO currentUser = null;
        try {
            currentUser = SessionUtil.getCurrentUser();
        } catch (Exception e) {
            // 如果获取不到用户则不设置用户类默认值
        }
        if (currentUser != null) {
            // 设置创建人&编辑人
            this.setFieldValByName(CREATE_USER, currentUser.getId(), metaObject);
            this.setFieldValByName(EDIT_USER, currentUser.getId(), metaObject);
            Object deptIdValue = this.getFieldValByName(DEPT_ID, metaObject);
            if (deptIdValue == null) {
                this.setFieldValByName(DEPT_ID, currentUser.getDeptId(), metaObject);
            }
        }
        Date now = new Date();
        this.setFieldValByName(CREATE_DATE, now, metaObject);
        this.setFieldValByName(EDIT_DATE, now, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        if (currentUser != null) {
            this.setFieldValByName(EDIT_USER, currentUser.getId(), metaObject);
        }
        this.setFieldValByName(EDIT_DATE, new Date(), metaObject);
    }
}
