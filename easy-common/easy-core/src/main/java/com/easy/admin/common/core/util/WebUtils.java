package com.easy.admin.common.core.util;

import com.easy.admin.common.core.constant.CommonConst;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Web 相关
 *
 * @author TengChongChong
 * @date 2019-04-26
 */
public class WebUtils extends org.springframework.web.util.WebUtils {

	/**
	 * 获取 HttpServletRequest
	 *
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取 HttpServletResponse
	 *
	 * @return HttpServletResponse
	 */
	public HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	/**
	 * 设置跨域响应头
	 *
	 * @param response HttpServletResponse
	 */
	public static void setCors(HttpServletResponse response){
		// 此处配置的是允许任意域名跨域请求，可根据需求指定
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
		response.setHeader("Access-Control-Max-Age", "86400");
		response.setHeader("Access-Control-Allow-Headers", "*");
	}

	/**
	 * 判断请求是否为静态文件用于减少session读写频率
	 * 注: 仅根据CommonConst.STATIC_FILE_SUFFIX配置的后缀判断
	 *
	 * @param uri 请求地址
	 * @return true/false
	 */
	public static boolean isStaticRequest(String uri) {
		String[] staticFileSuffix = CommonConst.STATIC_FILE_SUFFIX;
		for (String suffix : staticFileSuffix) {
			if (uri.endsWith(suffix)) {
				return true;
			}
		}
		return false;
	}
}

