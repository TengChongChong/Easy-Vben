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
    private static final String IMAGE_SELECTOR = "img[src*=temporary]";

    /**
     * 视频选择器
     */
    private static final String VIDEO_SELECTOR = "source[src*=temporary]";

    /**
     * 附件选择器
     */
    private static final String ATTACHMENT_SELECTOR = "a[href*=temporary]";

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
        if (StrUtil.isBlank(html)) {
            return null;
        }
        Document document = Jsoup.parse(html);
        handleImage(document);
        handleVideo(document);
        handleAttachment(document);
        return document.body().html();
    }

    /**
     * 处理图片
     *
     * @param document Document
     */
    private static void handleImage(Document document) {
        Elements elements = getElements(document, IMAGE_SELECTOR);
        handleFile(elements, "src");
    }

    /**
     * 处理视频
     *
     * @param document Document
     */
    private static void handleVideo(Document document) {
        Elements elements = getElements(document, VIDEO_SELECTOR);
        handleFile(elements, "src");
    }

    /**
     * 处理附件
     *
     * @param document Document
     */
    private static void handleAttachment(Document document) {
        Elements elements = getElements(document, ATTACHMENT_SELECTOR);
        handleFile(elements, "href");
    }

    /**
     * 处理文件
     *
     * @param elements Elements
     * @param attr     attr
     */
    private static void handleFile(Elements elements, String attr) {
        if (elements.isEmpty()) {
            return;
        }

        for (Element element : elements) {
            String url = element.attr(attr);
            if (StrUtil.isNotBlank(url) && FileUtil.inTemporaryPath(url)) {
                FileInfo fileInfo = fileDetailService.getByUrl(url);
                fileInfo = fileDetailService.saveToFormal(null, "content-file", fileInfo);

                element.attr(attr, fileInfo.getUrl()).attr("data-file-id", fileInfo.getId());
            }
        }
    }

    private static Elements getElements(Document document, String selector) {
        return document.select(selector);
    }


    @Autowired
    public void setFileDetailService(FileDetailService fileDetailService) {
        EditorUtil.fileDetailService = fileDetailService;
    }
}
