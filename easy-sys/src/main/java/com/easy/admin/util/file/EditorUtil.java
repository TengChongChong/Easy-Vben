package com.easy.admin.util.file;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.sys.common.constant.SysConst;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 富文本编辑器
 *
 * @author tengchong
 * @date 2022/6/28
 */
public class EditorUtil {
    /**
     * 图片选择器
     */
    private static final String IMAGE_SELECTOR = "img.editor-media.editor-image";

    /**
     * 最大图片大小（文件大小）：默认 500kb
     */
    private static final long MAX_IMAGE_LENGTH = 1024 * 500;

    /**
     * 处理内容中在临时目录的文件
     *
     * @param html 内容
     * @return 处理后的内容
     */
    public static String moveToFormal(String html) {
        Document document = Jsoup.parse(html);
        handleImage(document)
        ;
        return document.toString();
    }

    /**
     * 处理图片
     *
     * @param document Document
     */
    private static void handleImage(Document document) {
        Elements elements = document.select(IMAGE_SELECTOR);
        if (elements.size() == 0) {
            return;
        }
        for (Element element : elements) {
            String url = element.attr("src");
            if (StrUtil.isNotBlank(url) && FileUtil.inTemporaryPath(url)) {
                String path = FileUtil.getPath(url);
                File file = new File(path);
                if (file.exists()) {
                    // 如果文件过大，将文件压缩
                    if (file.length() > MAX_IMAGE_LENGTH) {
                        Integer width = getThumbnailWidth(file);
                        if(width != null){
                            path = ImageUtil.generateThumbnail(file, width);
                        }
                    }

                    // 文件存在
                    path = FileUtil.moveToFormal(path);
                    element.attr("src", SysConst.projectProperties.getProjectUrl() + FileUtil.getUrl(path));
                }
            }
        }
    }

    /**
     * 获取缩略图宽度
     * 根据源文件大小与期望文件大小计算缩小后大概的宽度
     *
     * @param file 文件
     * @return 宽度
     */
    private static Integer getThumbnailWidth(File file) {
        float proportion = (float) file.length() / EditorUtil.MAX_IMAGE_LENGTH;
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            return (int)(bufferedImage.getWidth() / proportion);
        } catch (IOException e) {
            // 如果没有读到宽度，则忽略转换
            return null;
        }
    }
}
