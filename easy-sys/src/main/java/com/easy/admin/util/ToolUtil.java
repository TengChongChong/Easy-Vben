package com.easy.admin.util;


import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;

/**
 * 工具类
 * 封装框架里常用的方法
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
public class ToolUtil {
    private ToolUtil() {}

    public static String getTmpDir() {
        return System.getProperty("java.io.tmpdir");
    }


    /**
     * 检查参数是否为空
     * @param object 参数
     * @return true/false
     * @throws EasyException
     */
    public static boolean checkParams(Object object) throws EasyException {
        if (object != null) {
            return true;
        } else {
            throw new EasyException(GlobalException.FAILED_TO_GET_DATA);
        }
    }

    /**
     * 检查结果
     *
     * @param isSuccess 是否成功
     * @return true/false
     * @throws EasyException
     */
    public static boolean checkResult(boolean isSuccess) throws EasyException {
        return (Boolean) checkResult(isSuccess, true);
    }

    /**
     * 检查结果
     *
     * @param isSuccess 是否成功
     * @param object 返回数据
     * @return object
     * @throws EasyException
     */
    public static Object checkResult(boolean isSuccess, Object object) throws EasyException {
        if (isSuccess) {
            return object;
        } else {
            throw new EasyException(GlobalException.LOCK_ERROR);
        }
    }

}
