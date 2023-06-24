package com.easy.admin.util.file;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileTypeUtil;
import com.easy.admin.common.core.exception.EasyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片工具类
 *
 * @author TengChongChong
 * @date 2019-03-10
 */
public class ImageUtil {

    private ImageUtil() {
    }

    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * lg缩略图尺寸
     */
    public static final int IMAGE_SIZE_LG = 640;
    /**
     * md缩略图尺寸
     */
    public static final int IMAGE_SIZE_MD = 320;
    /**
     * sm缩略图尺寸
     */
    public static final int IMAGE_SIZE_SM = 160;
    /**
     * xs缩略图尺寸
     */
    public static final int IMAGE_SIZE_XS = 80;

    /**
     * 根据文件头判断文件是否是图片
     * 注:方法未做文件是否存在验证
     *
     * @param file 文件
     * @return true/false
     */
    public static boolean isImage(File file) {
        String fileType = FileTypeUtil.getType(file);
        return ImgUtil.IMAGE_TYPE_JPG.equals(fileType) || ImgUtil.IMAGE_TYPE_PNG.equals(fileType) ||
                ImgUtil.IMAGE_TYPE_GIF.equals(fileType) || ImgUtil.IMAGE_TYPE_BMP.equals(fileType);

    }

    /**
     * 生成缩略图
     *
     * @param file 原图
     * @return true/false
     */
    public static boolean generateThumbnail(File file) {
        if (file.exists()) {
            if (isImage(file)) {
                generateThumbnail(file, IMAGE_SIZE_LG);
                generateThumbnail(file, IMAGE_SIZE_MD);
                generateThumbnail(file, IMAGE_SIZE_SM);
                generateThumbnail(file, IMAGE_SIZE_XS);
                return true;
            } else {
                throw new EasyException("原文件[" + file.getPath() + "]不是图片");
            }
        } else {
            throw new EasyException("原文件[" + file.getPath() + "]不存在");
        }
    }

    /**
     * 生成指定尺寸的缩略图
     *
     * @param file 原图
     * @param size 缩放后尺寸
     * @return 缩略图路径
     */
    public static String generateThumbnail(File file, int size) {
        if (file.exists()) {
            try {
                String destImagePath = file.getParent() + File.separator + getThumbnailName(file.getName(), size);
                BufferedImage bufferedImage = ImageIO.read(file);
                float scale = (float) size / bufferedImage.getWidth();
                if (scale > 1) {
                    return file.getPath();
                }
                ImgUtil.scale(file, new File(destImagePath), size, (int) (bufferedImage.getHeight() * scale), null);
                return destImagePath;
            } catch (IOException e) {
                logger.warn("生成缩略图发生异常" + e.getMessage());
                throw new EasyException("生成缩略图发生异常");
            }
        } else {
            throw new EasyException("原文件[" + file.getPath() + "]不存在");
        }
    }

    /**
     * 删除缩略图
     *
     * @param file 原图
     * @return true/false
     */
    public static boolean delThumbnail(File file) {
        if (file.exists()) {
            delThumbnail(file, IMAGE_SIZE_LG);
            delThumbnail(file, IMAGE_SIZE_MD);
            delThumbnail(file, IMAGE_SIZE_SM);
            delThumbnail(file, IMAGE_SIZE_XS);
            return true;
        }
        return false;
    }

    /**
     * 删除缩略图
     *
     * @param file 原图
     * @param size 缩略图尺寸
     * @return true/false
     */
    public static boolean delThumbnail(File file, int size) {
        String thumbnailPath = file.getParent() + File.separator + getThumbnailName(file.getName(), size);
        return cn.hutool.core.io.FileUtil.del(new File(thumbnailPath));
    }

    /**
     * 获取缩略图名称
     *
     * @param fileName 文件名称
     * @param size     尺寸
     * @return 缩略图名称
     */
    private static String getThumbnailName(String fileName, int size) {
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        return fileName + "_" + size + suffix;
    }

    /**
     * 根据原图路径获取缩略图path
     *
     * @param path 文件路径
     * @param size 尺寸
     * @return 缩略图路径
     */
    public static String getThumbnailPath(String path, int size) {
        File file = new File(path);
        return file.getParent() + File.separator + getThumbnailName(file.getName(), size);
    }

    /**
     * 根据原图路径获取缩略图url
     *
     * @param path 文件路径
     * @param size 尺寸
     * @return 缩略图url
     */
    public static String getThumbnailUrl(String path, int size) {
        return FileUtil.getUrl(getThumbnailPath(path, size));
    }

    /**
     * 根据原图url获取指定缩略图路径
     *
     * @param url  url
     * @param size 尺寸
     * @return 缩略图路径
     */
    public static String getThumbnailPathByUrl(String url, int size) {
        return getThumbnailPath(FileUtil.getPath(url), size);
    }

    /**
     * 根据原图url获取缩略图url
     *
     * @param url  url
     * @param size 尺寸
     * @return 缩略图url
     */
    public static String getThumbnailUrlByUrl(String url, int size) {
        return FileUtil.getUrl(getThumbnailPath(FileUtil.getUrl(url), size));
    }

}
