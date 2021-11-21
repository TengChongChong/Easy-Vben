package com.easy.admin.sys.service;

/**
 * 导入回调
 *
 * @author TengChongChong
 * @date 2019-04-26
 */
public interface ImportService {

    /**
     * 验证数据，插入临时表后调用
     * 注: 返回false会触发异常回滚
     *
     * @param templateId 模板id
     * @param userId 用户id
     * @return true/false
     */
    boolean verificationData(String templateId, String userId);

    /**
     * 导入前回调，插入正式表之前会调用此方法
     * 建议导入正式表之前使用次方法再次验证数据，防止验证 ~ 导入之间数据发送变动
     * 注: 返回false会触发异常回滚
     *
     * @param templateId 模板id
     * @param userId 用户id
     * @return true/false
     */
    boolean beforeImport(String templateId, String userId);

    /**
     * 导入后回调
     * 插入正式表后会调用此方法
     * 注: 返回false会触发异常回滚
     *
     * @return true/false
     */
    boolean afterImport();
}
