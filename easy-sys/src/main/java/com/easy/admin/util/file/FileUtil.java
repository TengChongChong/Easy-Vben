package com.easy.admin.util.file;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.common.constant.SysConst;
import com.easy.admin.auth.model.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;

/**
 * 文件工具
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
public class FileUtil {

    private FileUtil() {
    }

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 临时
     */
    private static final String TEMPORARY = "temporary";
    /**
     * 正式
     */
    private static final String FORMAL = "formal";

    /**
     * 静态目录名称
     */
    private static final String STATIC = "static";
    /**
     * 临时文件存放路径
     * 每天0点会清空前天的临时文件
     */
    public static final String TEMPORARY_PATH = SysConst.projectProperties.getFileUploadPath() + TEMPORARY + File.separator;

    /**
     * 正式文件存放路径
     */
    private static final String FORMAL_PATH = SysConst.projectProperties.getFileUploadPath() + FORMAL + File.separator;

    /**
     * 检查文件夹是否存在,如不存在则新建
     *
     * @param file 文件
     */
    private static void checkDirs(File file) {
        if (!file.exists() && !file.mkdirs()) {
            logger.debug("文件创建失败[{}]", file.getPath());
            throw new EasyException("文件创建失败[" + file.getPath() + "]");
        }
    }

    /**
     * 获取日期格式目录
     *
     * @return 目录 eg: 2020/01/01 或 2020\01\01
     */
    private static String getDatePath() {
        Date now = new Date();
        return DateUtil.year(now) + File.separator + (DateUtil.month(now) + 1) + File.separator + DateUtil.dayOfMonth(now);
    }

    /**
     * 获取临时文件存放路径
     *
     * @return 临时路径/yyyy/mm/dd/
     */
    public static String getTemporaryPath() {
        File file = new File(TEMPORARY_PATH + getDatePath());
        checkDirs(file);
        return file.getPath() + File.separator;
    }

    /**
     * 检查文件是否在临时目录
     *
     * @param path 文件路径
     * @return true/false
     */
    public static boolean inTemporaryPath(String path) {
        return StrUtil.isNotBlank(path) && path.contains(TEMPORARY);
    }

    /**
     * 检查文件是否在正式目录
     *
     * @param path 文件路径
     * @return true/false
     */
    public static boolean inFormalPath(String path) {
        return StrUtil.isNotBlank(path) && path.contains(FORMAL);
    }

    /**
     * 将临时目录下的文件移动到正式目录
     *
     * @param path 文件路径
     * @return 新路径
     */
    public static String moveToFormal(String path) {
        if (inFormalPath(path)) {
            return path;
        }
        File src = new File(path);
        if (src.exists()) {
            File file = new File(FORMAL_PATH + getDatePath());
            checkDirs(file);
            File dest = new File(file.getPath() + File.separator + src.getName());
            cn.hutool.core.io.FileUtil.copy(src, dest, true);
            return dest.getPath();
        } else {
            throw new EasyException("移动到正式目录失败[源文件 - " + path + " 不存在]");
        }
    }

    /**
     * 根据path获取访问url
     *
     * @param path 文件路径
     * @return url
     */
    public static String getUrl(String path) {
        if (path.contains(FORMAL)) {
            return "/static" + path.substring(path.indexOf(FORMAL) - 1);
        } else if (path.contains(TEMPORARY)) {
            return "/static" + path.substring(path.indexOf(TEMPORARY) - 1);
        } else {
            return path;
        }
    }

    /**
     * 根据访问url获取path
     *
     * @param url url
     * @return path
     */
    public static String getPath(String url) {
        if (url.contains(STATIC)) {
            return SysConst.projectProperties.getFileUploadPath() + url.substring(url.indexOf(STATIC) + STATIC.length() + 1);
        }
        return url;
    }

    /**
     * 根据正式路径下的文件访问url删除
     *
     * @param url url
     * @return true/false
     */
    public static boolean del(String url) {
        return delByPath(SysConst.projectProperties.getFileUploadPath() + url.replace("/" + STATIC + "/", ""));
    }

    /**
     * 根据文件路径删除
     *
     * @param path 路径
     * @return true/false
     */
    public static boolean delByPath(String path) {
        return cn.hutool.core.io.FileUtil.del(path);
    }

    /**
     * 设置头像缩略图
     *
     * @param sysUser sysUser
     * @return sysUser
     */
    public static SysUser initAvatar(SysUser sysUser) {
        if (StrUtil.isNotBlank(sysUser.getAvatar())) {
            sysUser.setAvatarLg(ImageUtil.getThumbnailUrlByUrl(sysUser.getAvatar(), ImageUtil.IMAGE_SIZE_LG));
            sysUser.setAvatarMd(ImageUtil.getThumbnailUrlByUrl(sysUser.getAvatar(), ImageUtil.IMAGE_SIZE_MD));
            sysUser.setAvatarSm(ImageUtil.getThumbnailUrlByUrl(sysUser.getAvatar(), ImageUtil.IMAGE_SIZE_SM));
            sysUser.setAvatarXs(ImageUtil.getThumbnailUrlByUrl(sysUser.getAvatar(), ImageUtil.IMAGE_SIZE_XS));
            sysUser.setAvatar(sysUser.getAvatar());
        }
        return sysUser;
    }
}
