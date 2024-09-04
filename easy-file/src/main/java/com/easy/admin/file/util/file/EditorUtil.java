package com.easy.admin.file.util.file;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.file.service.FileDetailService;
import org.dromara.x.file.storage.core.FileInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class EditorUtil {

    private static FileDetailService fileDetailService;

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
     * @param objectId 数据id
     * @param html     内容
     * @return 处理后的内容
     */
    public static String moveToFormal(String objectId, String html) {
        Document document = Jsoup.parse(html);
        handleImage(objectId, document);
        return document.body().html();
    }

    /**
     * 处理图片
     *
     * @param objectId 数据id
     * @param document Document
     */
    private static void handleImage(String objectId, Document document) {
        Elements elements = document.select(IMAGE_SELECTOR);
        if (elements.isEmpty()) {
            return;
        }

        for (Element element : elements) {
            String url = element.attr("src");
            String fileId = element.attr("data-file-id");
            if (StrUtil.isNotBlank(url) && StrUtil.isNotBlank(fileId) && FileUtil.inTemporaryPath(url)) {
                FileInfo fileInfo = fileDetailService.get(fileId);
                fileInfo = fileDetailService.saveToFormal(objectId, "content-image", fileInfo);

                element.attr("src", fileInfo.getUrl())
                        .attr("data-file-id", fileInfo.getId());
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
            return (int) (bufferedImage.getWidth() / proportion);
        } catch (IOException e) {
            // 如果没有读到宽度，则忽略转换
            return null;
        }
    }

    @Autowired
    public void setFileDetailService(FileDetailService fileDetailService) {
        EditorUtil.fileDetailService = fileDetailService;
    }
}
