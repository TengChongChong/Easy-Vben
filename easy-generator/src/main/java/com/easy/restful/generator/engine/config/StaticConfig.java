package com.easy.restful.generator.engine.config;

import cn.hutool.core.util.StrUtil;
import com.easy.restful.generator.constant.GeneratorFileConst;
import com.easy.restful.generator.constant.GeneratorImportConst;
import com.easy.restful.generator.constant.GeneratorMethodConst;
import com.easy.restful.generator.model.FieldSet;
import com.easy.restful.generator.model.Generator;
import com.easy.restful.generator.model.Import;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 静态文件 模板生成的配置
 *
 * @author tengchong
 * @date 2019-01-09
 */
public class StaticConfig extends AbstractConfig {
    /**
     * 列表页面路径
     */
    private String listVuePath;
    /**
     * 表单页面路径
     */
    private String inputVuePath;
    /**
     * 接口js路径
     */
    private String apiJsPath;

    /**
     * 列表页面访问路径
     */
    private final String listViewPath;
    /**
     * 表单页面访问路径
     */
    private final String inputViewPath;

    /**
     * list 引入资源
     */
    private final List<Import> listImports = new ArrayList<>();

    /**
     * input 引入资源
     */
    private final List<Import> inputImports = new ArrayList<>();

    public StaticConfig(Generator generator) {
        super(generator);
        if (generator.isGeneratorFileListView()) {
            this.listVuePath = frontEndFilePath + generator.getViewPath() + File.separator + GeneratorFileConst.LIST_VUE;
        }
        if (generator.isGeneratorFileInputView()) {
            this.inputVuePath = frontEndFilePath + generator.getViewPath() + File.separator + GeneratorFileConst.INPUT_VUE;
        }
        if (generator.isGeneratorFileApi()) {
            this.apiJsPath = frontEndFilePath + generator.getApiPath();
        }
        this.listViewPath = generator.getViewPath().replace("/views", "") + "/list";
        this.inputViewPath = generator.getViewPath().replace("/views", "") + "/input";

        this.listImports.addAll(selectVariables(GeneratorFileConst.LIST_VUE));
        this.inputImports.addAll(selectVariables(GeneratorFileConst.INPUT_VUE));

        this.listImports.addAll(selectMethods(GeneratorFileConst.LIST_VUE, generator));
        this.inputImports.addAll(selectMethods(GeneratorFileConst.INPUT_VUE, generator));

        this.listImports.addAll(selectComponents(GeneratorFileConst.LIST_VUE));
        this.inputImports.addAll(selectComponents(GeneratorFileConst.INPUT_VUE));
    }

    private List<Import> selectVariables(String pageType) {
        List<Import> imports = new ArrayList<>();
        if (GeneratorFileConst.LIST_VUE.equals(pageType)) {

        } else if (GeneratorFileConst.INPUT_VUE.equals(pageType)) {
            boolean hasGrid1 = false;
            boolean hasGrid2 = false;
            for (FieldSet inputItem : generator.getInputItems()) {
                if ("1".equals(inputItem.getInputGrid())) {
                    hasGrid1 = true;
                }
                if ("2".equals(inputItem.getInputGrid())) {
                    hasGrid2 = true;
                }
                if (hasGrid1 && hasGrid2) {
                    break;
                }
            }
            Import imp = new Import("@/utils/const/form", GeneratorImportConst.TYPE_VARIABLE, GeneratorImportConst.IMPORT_TYPE_MULTIPLE);
            List<String> impArray = new ArrayList<>();
            if (hasGrid1) {
                impArray.add("FULL_FORM_LAYOUT");
            }
            if (hasGrid2) {
                impArray.add("FORM_LAYOUT");
            }
            imp.setImp(impArray);
            imports.add(imp);
        }

        return imports;
    }

    private List<Import> selectMethods(String pageType, Generator generator) {
        List<Import> imports = new ArrayList<>();
        if (GeneratorFileConst.LIST_VUE.equals(pageType)) {
            Import imp = new Import("@" + generator.getApiPath().replace(".js", ""), GeneratorImportConst.TYPE_METHOD, GeneratorImportConst.IMPORT_TYPE_MULTIPLE);
            if (generator.isGeneratorMethodsSelect()) {
                imp.getImp().add(GeneratorMethodConst.SELECT);
            }
            if (generator.isGeneratorMethodsRemove()) {
                imp.getImp().add(GeneratorMethodConst.REMOVE);
            }
            if (generator.isGeneratorMethodsExport()) {
                imp.getImp().add(GeneratorMethodConst.EXPORT_DATA);
            }
            if(!imp.getImp().isEmpty()){
                imports.add(imp);
            }
            if (hasDatePropertyType()) {
                imports.add(new Import("@/utils/util", GeneratorImportConst.TYPE_METHOD, GeneratorImportConst.IMPORT_TYPE_MULTIPLE, generator.isGeneratorMethodsExport() ? "formatDate,downloadFileById" : "formatDate"));
            } else if (generator.isGeneratorMethodsExport()) {
                imports.add(new Import("@/utils/util", GeneratorImportConst.TYPE_METHOD, GeneratorImportConst.IMPORT_TYPE_MULTIPLE, "downloadFileById"));
            }
        } else if (GeneratorFileConst.INPUT_VUE.equals(pageType)) {
            imports.add(new Import("@" + generator.getApiPath().replace(".js", ""), GeneratorImportConst.TYPE_METHOD, GeneratorImportConst.IMPORT_TYPE_MULTIPLE, "get," + GeneratorMethodConst.SAVE));
            imports.add(new Import("@/utils/tips", GeneratorImportConst.TYPE_METHOD, GeneratorImportConst.IMPORT_TYPE_MULTIPLE, "saveSuccessTip"));
            imports.add(new Import("@/utils/util", GeneratorImportConst.TYPE_METHOD, GeneratorImportConst.IMPORT_TYPE_MULTIPLE, "isNotBlank"));
        }
        return imports;
    }

    private List<Import> selectComponents(String pageType) {
        List<Import> imports = new ArrayList<>();
        if (GeneratorFileConst.LIST_VUE.equals(pageType)) {
            imports.add(new Import("@/components", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_MULTIPLE, "STable,Ellipsis"));
            imports.add(new Import("@/components/Easy/data-display/ProTable", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EProTable"));
            if (generator.isGeneratorMethodsSave()) {
                imports.add(new Import("@/components/Easy/general/BtnAdd", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EBtnAdd"));
                imports.add(new Import("@/components/Easy/general/BtnEdit", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EBtnEdit"));
            }
            if (generator.isGeneratorMethodsRemove()) {
                imports.add(new Import("@/components/Easy/general/BtnRemove", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EBtnRemove"));
                imports.add(new Import("@/components/Easy/general/BtnRemoveBatch", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EBtnRemoveBatch"));
            }
            if (hasDict()) {
                imports.add(new Import("@/components/Easy/data-display/DictTag", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EDictTag"));
                imports.add(new Import("@/components/Easy/data-entry/DictSelect", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EDictSelect"));
            }
            if (generator.isGeneratorMethodsImport()) {
                imports.add(new Import("@/components/Easy/general/BtnImport", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EBtnImport"));
            }
        } else if (GeneratorFileConst.INPUT_VUE.equals(pageType)) {
            imports.add(new Import("@/components/Easy/general/BtnSave", GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, "EBtnSave"));
            Map<String, String> components = new HashMap<>();
            // 输入组件
            for (FieldSet fieldSet : generator.getInputItems()) {
                if (StrUtil.isNotBlank(fieldSet.getDictType())) {
                    switch (fieldSet.getElementType()) {
                        case "select":
                            components.put("EDictSelect", "@/components/Easy/data-entry/DictSelect");
                            break;
                        case "radio":
                            components.put("EDictRadio", "@/components/Easy/data-entry/DictRadio");
                            break;
                        case "checkbox":
                            components.put("EDictCheckbox", "@/components/Easy/data-entry/DictCheckbox");
                            break;
                        default:
                    }
                } else if ("Date".equals(fieldSet.getPropertyType())) {
                    components.put("EDatePicker", "@/components/Easy/data-entry/DatePicker");
                }
            }

            for (Map.Entry<String, String> entry : components.entrySet()) {
                if ("EDatePicker".equals(entry.getKey())) {
                    imports.add(new Import("@/utils/const/datePattern", GeneratorImportConst.TYPE_VARIABLE, GeneratorImportConst.IMPORT_TYPE_MULTIPLE, "DATE_PATTERN"));
                }
                imports.add(new Import(entry.getValue(), GeneratorImportConst.TYPE_COMPONENT, GeneratorImportConst.IMPORT_TYPE_SINGLE, entry.getKey()));
            }
        }
        return imports;
    }

    private boolean hasDict() {
        for (FieldSet inputItem : generator.getInputItems()) {
            if (StrUtil.isNotBlank(inputItem.getDictType())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDatePropertyType() {
        for (FieldSet fieldSet : generator.getTableItems()) {
            if ("Date".equals(fieldSet.getPropertyType())) {
                return true;
            }
        }
        return false;
    }


    public String getListVuePath() {
        return listVuePath;
    }

    public String getInputVuePath() {
        return inputVuePath;
    }

    public String getApiJsPath() {
        return apiJsPath;
    }

    public String getListViewPath() {
        return listViewPath;
    }

    public String getInputViewPath() {
        return inputViewPath;
    }

    public List<Import> getListImports() {
        return listImports;
    }

    public List<Import> getInputImports() {
        return inputImports;
    }
}
