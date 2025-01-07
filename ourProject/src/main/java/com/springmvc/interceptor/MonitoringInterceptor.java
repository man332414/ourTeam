package com.springmvc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

public class MonitoringInterceptor implements HandlerInterceptor
{
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	private String getURLPath(HttpServletRequest request)
	{
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();

		queryString = queryString == null? "" : "?" + queryString;
		return currentPath+queryString;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
		logger.info("접근한 URL 경로 : " + getURLPath(request));
		logger.info("접근하는 매핑 : " + request.getMethod());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("====================================================");
	}

	public MonitoringInterceptor() {}

}

