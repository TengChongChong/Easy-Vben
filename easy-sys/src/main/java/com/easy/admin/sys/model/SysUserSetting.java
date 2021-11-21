package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 用户偏好设置
 *
 * @author TengChong
 * @date 2019-03-04 23:41:03
 */
@TableName("sys_user_setting")
public class SysUserSetting extends Model<SysUserSetting> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 提示类型
     */
    private String tipType;

    /**
     * 主题
     */
    private String themes;

    /**
     * 固定footer
     */
    private String fixedFooter;

    /**
     * 默认收起菜单
     */
    private String allowAsideMinimizing;

    /**
     * 固定头部
     */
    private String fixedHeader;

    /**
     * 页面loader
     */
    private String pageLoader;

    //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipType() {
        return tipType;
    }

    public void setTipType(String tipType) {
        this.tipType = tipType;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    public String getFixedFooter() {
        return fixedFooter;
    }

    public void setFixedFooter(String fixedFooter) {
        this.fixedFooter = fixedFooter;
    }

    public String getAllowAsideMinimizing() {
        return allowAsideMinimizing;
    }

    public void setAllowAsideMinimizing(String allowAsideMinimizing) {
        this.allowAsideMinimizing = allowAsideMinimizing;
    }

    public String getFixedHeader() {
        return fixedHeader;
    }

    public void setFixedHeader(String fixedHeader) {
        this.fixedHeader = fixedHeader;
    }

    public String getPageLoader() {
        return pageLoader;
    }

    public void setPageLoader(String pageLoader) {
        this.pageLoader = pageLoader;
    }
}
