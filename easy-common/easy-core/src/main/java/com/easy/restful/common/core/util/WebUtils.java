package com.easy.restful.common.core.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}

