package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor 
{
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		logger.info("접근한 URL 경로 : " + getURLPath(request));
		logger.info("접근하는 매핑 : " + request.getMethod());
//		logger.info("요청 시각 : " + getCurrentTime());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception 
	{

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception 
	{
		logger.info("====================================================");
	}
	
	private String getURLPath(HttpServletRequest request)
	{
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		
		queryString = queryString == null? "" : "?" + queryString;
		return currentPath+queryString;
	}
	
//	private String getCurrentTime() 
//	{
//		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		
//		return formatter.format(calendar.getTime());
//	}
	
}

