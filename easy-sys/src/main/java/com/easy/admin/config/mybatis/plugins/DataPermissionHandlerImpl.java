package com.easy.admin.config.mybatis.plugins;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.handler.DataPermissionHandler;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.config.mybatis.annotation.EasyDataScope;
import com.easy.admin.config.mybatis.plugins.model.DataPermission;
import com.easy.admin.config.sa.token.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.ParenthesedExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.ParenthesedSelect;
import net.sf.jsqlparser.statement.select.Select;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义数据权限
 *
 * @author TengChongChong
 * @date 2024-07-22
 **/
@Slf4j
public class DataPermissionHandlerImpl implements DataPermissionHandler {
    @Override
    public Expression getSqlSegment(Expression where, String mappedStatementId) {
        log.debug("{}", where);
        log.debug("{}", mappedStatementId);
        // 数据权限注解
        EasyDataScope dataScope = getEasyDataScope(mappedStatementId);
        if (dataScope == null) {
            return where;
        }
        Expression sqlSegment = getSqlSegment(dataScope);
        log.debug("数据权限，{}", sqlSegment);
        return sqlSegment == null ? where : getExpression(where, sqlSegment);
        //return where;
    }

    /**
     * 获取mappedStatementId的注解
     *
     * @param mappedStatementId mappedStatementId
     * @return 注解
     */
    private EasyDataScope getEasyDataScope(String mappedStatementId) {
        String className = mappedStatementId.substring(0, mappedStatementId.lastIndexOf("."));
        String methodName = mappedStatementId.substring(mappedStatementId.lastIndexOf(".") + 1);
        Method[] methods;
        try {
            methods = Class.forName(className).getMethods();
        } catch (ClassNotFoundException e) {
            return null;
        }
        for (Method method : methods) {
            if (StrUtil.isBlank(method.getName()) || !method.getName().equals(methodName)) {
                continue;
            }
            return method.getAnnotation(EasyDataScope.class);
        }
        return null;
    }

    /**
     * 拼接需要在业务 SQL 中额外追加的数据权限 SQL
     *
     * @return 数据权限 SQL
     */
    private Expression getSqlSegment(EasyDataScope dataScope) {
        if (!StpUtil.isLogin()) {
            // 未登录
            return null;
        }
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        // 用户数据权限
        List<DataPermission> dataPermissionList = currentUser.getDataPermissionList();
        if (dataPermissionList == null || dataPermissionList.isEmpty()) {
            return null;
        }
        List<Expression> expressionList = new ArrayList<>();
        for (DataPermission dataPermission : dataPermissionList) {

            switch (dataPermission.getType()) {
                case SELF:
                    expressionList.add(new EqualsTo(new Column(getBusinessTableUserField(dataScope)), new StringValue(currentUser.getId())));
                    break;
                case MY_DEPT:
                    expressionList.add(new EqualsTo(new Column(getBusinessTableDeptField(dataScope)), new StringValue(currentUser.getDeptId())));
                    break;
                case MY_AND_SUB_DEPT:
                    ParenthesedSelect parenthesedSelect = new ParenthesedSelect();
                    parenthesedSelect.setSelect(getMyAndSubDeptSelectBody(currentUser.getDeptId()));
                    expressionList.add(
                            new InExpression(
                                    new Column(getBusinessTableDeptField(dataScope)),
                                    parenthesedSelect
                            )
                    );
                    break;
                case CUSTOM:
                    expressionList.add(
                            new InExpression(
                                    new Column(getBusinessTableDeptField(dataScope)),
                                    new ParenthesedExpressionList<>(dataPermission.getDeptIds().stream().map(StringValue::new).collect(Collectors.toList()))
                            )
                    );
                    break;
            }
        }

        if (expressionList.isEmpty()) {
            return null;
        } else if (expressionList.size() == 1) {
            return expressionList.get(0);
        } else {
            Expression expression = new OrExpression(expressionList.get(0), expressionList.get(1));
            if (expressionList.size() == 2) {
                return expression;
            }
            for (int i = 2; i < expressionList.size(); i++) {
                expression = new OrExpression(expression, expressionList.get(i));
            }
            return expression;
        }
    }

    /**
     * 获取sql中业务表所属部门Id字段名称
     *
     * @param dataScope 注解
     * @return 字段名
     */
    private String getBusinessTableDeptField(EasyDataScope dataScope) {
        return getBusinessTableAlias(dataScope) + dataScope.businessDeptField();
    }

    /**
     * 获取sql中业务表创建用户Id字段名称
     *
     * @param dataScope 注解
     * @return 字段名
     */
    private String getBusinessTableUserField(EasyDataScope dataScope) {
        return getBusinessTableAlias(dataScope) + dataScope.businessUserField();
    }

    /**
     * 获取sql中业务表的别名
     *
     * @param dataScope 注解
     * @return 别名
     */
    private String getBusinessTableAlias(EasyDataScope dataScope) {
        return StrUtil.isNotBlank(dataScope.businessTableAlias()) ? dataScope.businessTableAlias() + "." : "";
    }

    /**
     * 获取本部门及子部门SelectBody
     *
     * @param deptId 部门id
     * @return SelectBody
     */
    private Select getMyAndSubDeptSelectBody(String deptId) {
        Select select;
        try {
            select = (Select) CCJSqlParserUtil.parse("select dp_sd.id from sys_dept dp_sd where dp_sd.id = '" + deptId + "' or dp_sd.parent_id = '" + deptId + "'");
        } catch (JSQLParserException e) {
            throw new EasyException("获取数据权限SelectBody失败，", e.getMessage());
        }
        return select;
    }

    public static void main(String[] args) throws JSQLParserException {
        //Select select = (Select) CCJSqlParserUtil.parse("select id from sys_dept where id in (select id from sys_dept)");
        Select select = (Select) CCJSqlParserUtil.parse("SELECT  id,template_id,field_name,title,field_length,field_type,replace_table,replace_table_field_name,replace_table_field_value,replace_table_dict_type,order_no,aaa_required,aaa_only,create_date,create_user,edit_user,edit_date  FROM sys_import_excel_template_detail      WHERE  (template_id = ?) ORDER BY order_no ASC");
        System.out.println(select);
    }


    /**
     * 将数据权限 SQL 语句追加到数据权限 SQL 片段表达式里
     *
     * @param where      待执行 SQL Where 条件表达式
     * @param sqlSegment 数据权限 SQL 片段
     * @return Expression
     */
    private Expression getExpression(Expression where, Expression sqlSegment) {
        return (null != where) ? new AndExpression(where, sqlSegment) : sqlSegment;
    }
}
