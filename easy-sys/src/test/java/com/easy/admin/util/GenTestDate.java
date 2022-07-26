package com.easy.admin.util;

import cn.hutool.core.io.FileUtil;

import java.util.UUID;

/**
 * 生成测试数据
 *
 * @author tengchong
 * @date 2022/7/25
 */
public class GenTestDate {

    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder();
        for (int i = 0; i < 20000; i++) {
            // 车辆
//            sql.append("INSERT INTO `biz_wdsj_1_zhaoyunceshicheliangbiao_742` VALUES ('" + UUID.randomUUID() + "', '" + i + "', '车辆" + i + "', '" + getCarNo(i) + "', '" + getIdCardNo(i) + "');\n");
            // 班级
//            sql.append("INSERT INTO `biz_wdsj_1_zhaoyunceshibanjibiao_672` VALUES ('" + UUID.randomUUID() + "', '"+i+"', '软件"+i+"班');\n");
            // 学生
//            sql.append("INSERT INTO `biz_wdsj_1_zhaoyunceshixueshengbiao_549` VALUES ('"+ UUID.randomUUID()+"', '"+i+"', '学生"+i+"', '"+getIdCardNo(i)+"', '30', '女', '"+i+"');\n");
            sql.append("INSERT INTO `biz_wdsj_1_zhaoyunceshifangchanbiao_789` VALUES ('"+ UUID.randomUUID()+"', '1', '1', '89', '25000', '张三"+i+"');\n");

        }

        FileUtil.writeUtf8String(sql.toString(), "/Users/tengchong/Desktop/biz_wdsj_1_zhaoyunceshifangchanbiao_789.sql");
    }

    public static String getIdCardNo(int index) {
        String prefix = "3203211992081";
        String indexStr = String.valueOf(index);
        for (int i = indexStr.length(); i < 5; i++) {
            prefix += "0";
        }
        return prefix + indexStr;
    }

    public static String getCarNo(int index) {
        String prefix = "苏A";
        String indexStr = String.valueOf(index);
        for (int i = indexStr.length(); i < 5; i++) {
            prefix += "0";
        }
        return prefix + indexStr;
    }
}
