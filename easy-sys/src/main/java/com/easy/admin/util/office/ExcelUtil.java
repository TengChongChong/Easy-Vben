package com.easy.admin.util.office;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelWriter;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.file.model.BaseFileInfo;
import com.easy.admin.file.model.FileDownload;
import com.easy.admin.file.service.FileDownloadService;
import com.easy.admin.file.storage.FileStorageFactory;
import com.easy.admin.sys.common.constant.ImportConst;
import com.easy.admin.sys.model.SysDict;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Excel 工具
 *
 * @author TengChongChong
 * @date 2019-04-09
 */
@Component
public class ExcelUtil {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    private static FileDownloadService downloadService;

    /**
     * 文件存储
     */
    private static FileStorageFactory fileStorageFactory;


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
     * @param title     文件&标题名称
     * @param sheetName sheet 名称
     * @param data      数据
     * @param clazz     类
     * @return 文件下载id
     */
    public static String writeAndGetDownloadId(String title, String sheetName, List<?> data, Class clazz) {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), clazz, data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new EasyException("文件写入失败[" + e.getMessage() + "]");
        }

        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        String objectName = fileStorageFactory.getFileStorage().getTemporaryPath() + UUID.randomUUID() + EXCEL_SUFFIX_XLS;

        // 保存文件
        fileStorageFactory.getFileStorage().uploadFile(
                fileStorageFactory.getFileStorageProperties().getDefaultBucket(),
                objectName,
                inputStream
        );

        // 保存下载信息
        return downloadService.saveData(
                new FileDownload(
                        title + EXCEL_SUFFIX_XLS,
                        fileStorageFactory.getFileStorageProperties().getDefaultBucket(),
                        objectName
                )
        ).getId();
    }

    /**
     * 生成excel
     *
     * @param name         模板名称
     * @param details      配置项
     * @param dictionaries 字典
     * @return path
     */
    public static BaseFileInfo writFile(String name, List<SysImportExcelTemplateDetail> details, Map<String, List<SysDict>> dictionaries) {
        return writFile(name, details, dictionaries, null);
    }

    /**
     * 生成excel
     *
     * @param name         模板名称
     * @param details      配置项
     * @param dictionaries 字典
     * @param body         数据
     * @return path
     */
    public static BaseFileInfo writFile(String name, List<SysImportExcelTemplateDetail> details, Map<String, List<SysDict>> dictionaries, List<List<Object>> body) {
        BigExcelWriter writer = cn.hutool.poi.excel.ExcelUtil.getBigWriter();

        // 设置默认行高
        writer.setDefaultRowHeight(20);
        // 设置冻结
        writer.setFreezePane(details.size(), 2);
        //合并单元格，使用默认标题样式
        if (!details.isEmpty() && details.size() > 1) {
            writer.merge(details.size() - 1, name);
        } else {
            writer.merge(1, name);
        }
        // 设置表格标题
        List<String> head = new ArrayList<>();
        for (int i = 0; i < details.size(); i++) {
            head.add(details.get(i).getTitle());
            if (details.get(i).getFieldLength() != null) {
                if (details.get(i).getFieldLength() > 32) {
                    // 字段长度大于32
                    int columnWidth = details.get(i).getFieldLength() / 4;
                    // 根据字段长度设置列宽，最宽不超过48
                    writer.setColumnWidth(i, Math.min(columnWidth, 48));
                }
            }
        }
        writer.writeHeadRow(head);
        // 设置select
        if (dictionaries != null) {
            setSelect(details, dictionaries, writer);
        }

        // 设置内容
        if (body != null) {
            //写出内容
            writer.write(body, false);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        writer.flush(outputStream);

        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        String objectName = fileStorageFactory.getFileStorage().getTemporaryPath() + UUID.randomUUID() + EXCEL_SUFFIX_XLS;
        // 保存文件
        fileStorageFactory.getFileStorage().uploadFile(
                fileStorageFactory.getFileStorageProperties().getDefaultBucket(),
                objectName,
                inputStream
        );

        return new BaseFileInfo(fileStorageFactory.getFileStorageProperties().getDefaultBucket(), objectName);
    }

    /**
     * 设置Excel下拉选项
     *
     * @param details 配置项
     * @param writer  ExcelWriter
     */
    public static void setSelect(List<SysImportExcelTemplateDetail> details, Map<String, List<SysDict>> dictionaries, ExcelWriter writer) {
        for (int i = 0; i < details.size(); i++) {
            if (StrUtil.isNotBlank(details.get(i).getReplaceTable()) && ImportConst.SYS_DICT.equals(details.get(i).getReplaceTable())) {
                List<String> selects = new ArrayList<>();
                dictionaries.get(details.get(i).getReplaceTableDictType()).forEach(dict -> selects.add(dict.getName()));
                writer.addSelect(new CellRangeAddressList(2, 200, i, i), ArrayUtil.toArray(selects, String.class));
            }
        }
    }

    @Autowired
    public void setDownloadService(FileDownloadService downloadService) {
        ExcelUtil.downloadService = downloadService;
    }

    @Autowired
    public void setFileStorageFactory(FileStorageFactory fileStorageFactory) {
        ExcelUtil.fileStorageFactory = fileStorageFactory;
    }
}
