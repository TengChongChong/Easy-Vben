package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotNull;

/**
 * 导入临时表
 *
 * @author TengChong
 * @date 2019-04-10
 */
 @TableName("sys_import_excel_temporary")
public class SysImportExcelTemporary extends Model<SysImportExcelTemporary> {

    @TableId(value = "id")
    @NotNull(message = "id不能为空")
    private String id;

    /**
     * 模板id
     */
    @NotNull(message = "模板id不能为空")
    private String templateId;

    /**
     * 导入用户id
     */
    private String userId;
    /**
     * 验证状态
     */
    private String verificationStatus;
    /**
     * 验证结果
     */
    private String verificationResults;

    /**
     * 导入字段
     */
    private String field1;

    /**
     * 导入字段
     */
    private String field2;

    /**
     * 导入字段
     */
    private String field3;

    /**
     * 导入字段
     */
    private String field4;

    /**
     * 导入字段
     */
    private String field5;

    /**
     * 导入字段
     */
    private String field6;

    /**
     * 导入字段
     */
    private String field7;

    /**
     * 导入字段
     */
    private String field8;

    /**
     * 导入字段
     */
    private String field9;

    /**
     * 导入字段
     */
    private String field10;

    /**
     * 导入字段
     */
    private String field11;

    /**
     * 导入字段
     */
    private String field12;

    /**
     * 导入字段
     */
    private String field13;

    /**
     * 导入字段
     */
    private String field14;

    /**
     * 导入字段
     */
    private String field15;

    /**
     * 导入字段
     */
    private String field16;

    /**
     * 导入字段
     */
    private String field17;

    /**
     * 导入字段
     */
    private String field18;

    /**
     * 导入字段
     */
    private String field19;

    /**
     * 导入字段
     */
    private String field20;

    /**
     * 导入字段
     */
    private String field21;

    /**
     * 导入字段
     */
    private String field22;

    /**
     * 导入字段
     */
    private String field23;

    /**
     * 导入字段
     */
    private String field24;

    /**
     * 导入字段
     */
    private String field25;

    /**
     * 导入字段
     */
    private String field26;

    /**
     * 导入字段
     */
    private String field27;

    /**
     * 导入字段
     */
    private String field28;

    /**
     * 导入字段
     */
    private String field29;

    /**
     * 导入字段
     */
    private String field30;

    /**
     * 导入字段
     */
    private String field31;

    /**
     * 导入字段
     */
    private String field32;

    /**
     * 导入字段
     */
    private String field33;

    /**
     * 导入字段
     */
    private String field34;

    /**
     * 导入字段
     */
    private String field35;

    /**
     * 导入字段
     */
    private String field36;

    /**
     * 导入字段
     */
    private String field37;

    /**
     * 导入字段
     */
    private String field38;

    /**
     * 导入字段
     */
    private String field39;

    /**
     * 导入字段
     */
    private String field40;

    /**
     * 导入字段
     */
    private String field41;

    /**
     * 导入字段
     */
    private String field42;

    /**
     * 导入字段
     */
    private String field43;

    /**
     * 导入字段
     */
    private String field44;

    /**
     * 导入字段
     */
    private String field45;

    /**
     * 导入字段
     */
    private String field46;

    /**
     * 导入字段
     */
    private String field47;

    /**
     * 导入字段
     */
    private String field48;

    /**
     * 导入字段
     */
    private String field49;

    /**
     * 导入字段
     */
    private String field50;

    //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getVerificationResults() {
        return verificationResults;
    }

    public void setVerificationResults(String verificationResults) {
        this.verificationResults = verificationResults;
    }
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }
    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }
    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }
    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }
    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }
    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }
    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }
    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }
    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }
    public String getField11() {
        return field11;
    }

    public void setField11(String field11) {
        this.field11 = field11;
    }
    public String getField12() {
        return field12;
    }

    public void setField12(String field12) {
        this.field12 = field12;
    }
    public String getField13() {
        return field13;
    }

    public void setField13(String field13) {
        this.field13 = field13;
    }
    public String getField14() {
        return field14;
    }

    public void setField14(String field14) {
        this.field14 = field14;
    }
    public String getField15() {
        return field15;
    }

    public void setField15(String field15) {
        this.field15 = field15;
    }
    public String getField16() {
        return field16;
    }

    public void setField16(String field16) {
        this.field16 = field16;
    }
    public String getField17() {
        return field17;
    }

    public void setField17(String field17) {
        this.field17 = field17;
    }
    public String getField18() {
        return field18;
    }

    public void setField18(String field18) {
        this.field18 = field18;
    }
    public String getField19() {
        return field19;
    }

    public void setField19(String field19) {
        this.field19 = field19;
    }
    public String getField20() {
        return field20;
    }

    public void setField20(String field20) {
        this.field20 = field20;
    }
    public String getField21() {
        return field21;
    }

    public void setField21(String field21) {
        this.field21 = field21;
    }
    public String getField22() {
        return field22;
    }

    public void setField22(String field22) {
        this.field22 = field22;
    }
    public String getField23() {
        return field23;
    }

    public void setField23(String field23) {
        this.field23 = field23;
    }
    public String getField24() {
        return field24;
    }

    public void setField24(String field24) {
        this.field24 = field24;
    }
    public String getField25() {
        return field25;
    }

    public void setField25(String field25) {
        this.field25 = field25;
    }
    public String getField26() {
        return field26;
    }

    public void setField26(String field26) {
        this.field26 = field26;
    }
    public String getField27() {
        return field27;
    }

    public void setField27(String field27) {
        this.field27 = field27;
    }
    public String getField28() {
        return field28;
    }

    public void setField28(String field28) {
        this.field28 = field28;
    }
    public String getField29() {
        return field29;
    }

    public void setField29(String field29) {
        this.field29 = field29;
    }
    public String getField30() {
        return field30;
    }

    public void setField30(String field30) {
        this.field30 = field30;
    }
    public String getField31() {
        return field31;
    }

    public void setField31(String field31) {
        this.field31 = field31;
    }
    public String getField32() {
        return field32;
    }

    public void setField32(String field32) {
        this.field32 = field32;
    }
    public String getField33() {
        return field33;
    }

    public void setField33(String field33) {
        this.field33 = field33;
    }
    public String getField34() {
        return field34;
    }

    public void setField34(String field34) {
        this.field34 = field34;
    }
    public String getField35() {
        return field35;
    }

    public void setField35(String field35) {
        this.field35 = field35;
    }
    public String getField36() {
        return field36;
    }

    public void setField36(String field36) {
        this.field36 = field36;
    }
    public String getField37() {
        return field37;
    }

    public void setField37(String field37) {
        this.field37 = field37;
    }
    public String getField38() {
        return field38;
    }

    public void setField38(String field38) {
        this.field38 = field38;
    }
    public String getField39() {
        return field39;
    }

    public void setField39(String field39) {
        this.field39 = field39;
    }
    public String getField40() {
        return field40;
    }

    public void setField40(String field40) {
        this.field40 = field40;
    }
    public String getField41() {
        return field41;
    }

    public void setField41(String field41) {
        this.field41 = field41;
    }
    public String getField42() {
        return field42;
    }

    public void setField42(String field42) {
        this.field42 = field42;
    }
    public String getField43() {
        return field43;
    }

    public void setField43(String field43) {
        this.field43 = field43;
    }
    public String getField44() {
        return field44;
    }

    public void setField44(String field44) {
        this.field44 = field44;
    }
    public String getField45() {
        return field45;
    }

    public void setField45(String field45) {
        this.field45 = field45;
    }
    public String getField46() {
        return field46;
    }

    public void setField46(String field46) {
        this.field46 = field46;
    }
    public String getField47() {
        return field47;
    }

    public void setField47(String field47) {
        this.field47 = field47;
    }
    public String getField48() {
        return field48;
    }

    public void setField48(String field48) {
        this.field48 = field48;
    }
    public String getField49() {
        return field49;
    }

    public void setField49(String field49) {
        this.field49 = field49;
    }
    public String getField50() {
        return field50;
    }

    public void setField50(String field50) {
        this.field50 = field50;
    }
}
