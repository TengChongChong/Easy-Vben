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

