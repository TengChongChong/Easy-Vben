package com.easy.admin.cms.config.beetl;

import com.easy.admin.common.core.exception.EasyException;
import org.beetl.core.ConsoleErrorHandler;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.ErrorInfo;

import java.io.IOException;
import java.io.Writer;

/**
 * Beetl 异常处理器
 *
 * @author tengchong
 * @date 2021-12-07
 */
public class WebErrorHandler extends ConsoleErrorHandler {

    protected static final String VERSION = "<a href=\"http://ibeetl.com\" class=\"powered\">Powered by ibeetl.com</a>";
    protected static final String DEV_MODEL_STYLE = "<style><!-- *{margin:0;padding:0}.main{position:absolute;margin:auto;width:100%;z-index:9999999999999999999;}H1{font-family:Consolas,Arial,sans-serif;color:white;background-color:#a0a0a0;font-size:24px;padding-left:10px}H3{font-family:Consolas,sans-serif;color:#333;font-size:13px;font-weight:lighter;margin-top:5px;font-style:italic}BODY{font-family:Consolas,Arial,sans-serif;color:black;background-color:white}xmp{margin:auto;overflow:auto;width:100%;display: block;white-space: pre-wrap;font-family:simsun,sans-serif;background:white;color:black;font-size:13px;font-weight:lighter;color:#666;line-height:25px;}A{color:black}A.name{color:black}HR{color:#525d76}.t1{margin-top:0;}a.powered:hover{color:#dd1122}--></style>";
    protected static final String DEV_MODEL_ERROR = "<html><head><meta charset=\"utf-8\"><title>beetlException</title>"
            + DEV_MODEL_STYLE
            + "</head><body><div class='main'><h1>[title]</h1><HR size='1' noshade='noshade' class='t1'><xmp style='padding-left:20px'>[message]</xmp><HR size='1' noshade='noshade'><h3>"
            + VERSION + "</h3><div></body></html>";


    @Override
    public void processException(BeetlException e, GroupTemplate groupTemplate, Writer writer) {
        // 判断是否为CMS发布模式
//        Object releasePattern = e.gt.getSharedVars().get("release-pattern");
//        if (releasePattern != null && (boolean) releasePattern) {
//            throw new EasyException("模板解析失败");
//        }
        ErrorInfo error = new ErrorInfo(e);
        StringBuilder title;
        StringBuilder msg = new StringBuilder();

        if (error.getErrorCode().equals(BeetlException.CLIENT_IO_ERROR_ERROR)) {
            //不输出详细提示信息
            title = new StringBuilder(">>").append("客户端IO异常:").append(e.resource.getId());
            if (e.getCause() != null) {
                msg.append(e.getCause());
            }
            render(writer, title.toString(), msg.toString());
            return;
        }

        int line = error.getErrorTokenLine();

        title = new StringBuilder(">>").append(error.getType()).append(":").append(error.getErrorTokenText())
                .append(" 位于").append(line).append("行").append(" 资源:").append(e.resource.getId());

        if (error.getErrorCode().equals(BeetlException.TEMPLATE_LOAD_ERROR)) {
            if (error.getMsg() != null) {
                msg.append(error.getMsg());
            }
            render(writer, title.toString(), msg.toString());
            return;
        }

        if (e.getMessage() != null) {
            msg.append(e.getMessage()).append("\n");
        }

        //潜在问题，此时可能得到是一个新的模板，不过可能性很小，忽略！
        String content = null;
        Resource res = e.resource;
        //显示前后三行的内容
        int[] range = this.getRange(line);
        try {
            content = res.getContent(range[0], range[1]);
        } catch (IOException e1) {
        }
        if (content != null) {
            String[] strs = content.split(e.cr);
            int lineNumber = range[0];
            for (String str : strs) {
                msg.append(lineNumber).append("|").append(str.trim()).append("\n");
                lineNumber++;
            }
        }

        if (error.hasCallStack()) {
            msg.append("  ========================").append("\n");
            msg.append("  调用栈:").append("\n");
            for (int i = 0; i < error.getResourceCallStack().size(); i++) {
                msg.append("  ").append(error.getResourceCallStack().get(i)).append(" 行：")
                        .append(error.getTokenCallStack().get(i).line).append("\n");
            }
            Throwable t = error.getCause();
            if (t != null) {
                msg.append(t).append("\n");
            }
        }

        render(writer, title.toString(), msg.toString());

        try {
            writer.flush();
        } catch (IOException e1) {

        }
    }

    protected void render(Writer w, String title, String msg) {
        try {
            w.write(DEV_MODEL_ERROR.replace("[title]", title).replace("[message]", msg));
        } catch (IOException e) {
        }
        throw new EasyException(title + msg);
    }
}
