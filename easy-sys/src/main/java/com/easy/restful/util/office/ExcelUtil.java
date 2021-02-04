package com.easy.restful.util.office;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import com.easy.restful.common.core.constant.CommonConst;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.sys.model.SysDownload;
import com.easy.restful.sys.service.SysDownloadService;
import com.easy.restful.util.file.FileUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Excel 工具
 *
 * @author tengchong
 * @date 2019-04-09
 */
@Component
public class ExcelUtil {

    private static SysDownloadService downloadService;

    private ExcelUtil() {
    }

    /**
     * excel 文件后缀 07
     */
    public static final String EXCEL_SUFFIX_XLSX = ".xlsx";
    /**
     * excel 文件后缀 03
     */
    public static final String EXCEL_SUFFIX_XLS = ".xls";

    /**
     * 导出数据并获取下载id
     *
     * @param title 文件&标题名称
     * @param sheetName sheet 名称
     * @param data 数据
     * @param clazz 类
     * @return 文件下载id
     */
    public static String writeAndGetDownloadId(String title, String sheetName, List<?> data, Class clazz) {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), clazz, data);
        FileOutputStream fos;
        String path = FileUtil.getTemporaryPath() + UUID.randomUUID() + EXCEL_SUFFIX_XLS;
        try {
            fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            throw new EasyException("文件写入失败[" + e.getMessage() + "]");
        }
        return downloadService.saveData(new SysDownload(title + EXCEL_SUFFIX_XLS, path)).getId();
    }

    /**
     * 写excel文件
     *
     * @param body  表格内容
     * @param head  表格标题 示例 标题1,标题2,标题3
     * @param title 标题行
     * @return 文件路径
     */
    public static String writFile(List<List<Object>> body, String head, String title) {
        return writFile(body, head.split(CommonConst.SPLIT), title, null, null);
    }

    /**
     * 写excel文件
     *
     * @param body      表格内容
     * @param head      表格标题 示例 标题1,标题2,标题3
     * @param title     标题行
     * @param sheetName sheet名称,默认为sheet1
     * @return 文件路径
     */
    public static String writFile(List<List<Object>> body, String head, String title, String sheetName) {
        return writFile(body, head.split(CommonConst.SPLIT), title, sheetName, null);
    }

    /**
     * 写excel文件
     *
     * @param body      表格内容
     * @param head      表格标题
     * @param title     标题行
     * @param sheetName sheet名称,默认为sheet1
     * @param path      文件路径
     * @return 文件路径
     */
    public static String writFile(List<List<Object>> body, String[] head, String title, String sheetName, String path) {
        if (StrUtil.isBlank(path)) {
            path = FileUtil.getTemporaryPath() + IdUtil.randomUUID() + EXCEL_SUFFIX_XLSX;
        }
        BigExcelWriter writer = cn.hutool.poi.excel.ExcelUtil.getBigWriter(path, sheetName);
        if (StrUtil.isNotBlank(title)) {
            //合并单元格，使用默认标题样式
            if (head != null && head.length > 0) {
                writer.merge(head.length - 1, title);
            } else {
                writer.merge(1, title);
            }
        }
        // 设置表格标题
        if (head != null) {
            writer.writeHeadRow(Arrays.asList(head));
        }
        // 设置内容
        if (body != null) {
            //写出内容
            writer.write(body, false);
        }
        //关闭writer，释放内存
        writer.close();
        return path;
    }

    @Autowired
    public void setDownloadService(SysDownloadService downloadService) {
        ExcelUtil.downloadService = downloadService;
    }
}
