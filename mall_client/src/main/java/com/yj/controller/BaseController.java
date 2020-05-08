package com.yj.controller;

import com.yj.util.LoginUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class BaseController {

	public Map<String, String> getRequestParams(HttpServletRequest request) {
		Enumeration<String> parameterNames = request.getParameterNames();
		Map<String, String> result = new HashMap<String, String>();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = request.getParameter(key);
			if("".equals(value)) {
				value=null;
			}
			result.put(key, value);
		}
		LoginUtil.packageLoginInfo(result);
		return result;
	}
	public Map<String, String> getRequestParamsWithLower(HttpServletRequest request) {
		Enumeration<String> parameterNames = request.getParameterNames();
		Map<String, String> result = new HashMap<String, String>();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = request.getParameter(key);
			if("".equals(value)) {
				value=null;
			}
			result.put(key.toLowerCase(), value);
		}
		return result;
	}
	public static String getUrlParams(HttpServletRequest request) {
		List<String> list=new ArrayList<>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String key = parameterNames.nextElement();
			String value=request.getParameter(key);
			try {
				list.add(key + "=" + value);
			} catch (Exception e) {
			}
		}
		if(list.size()>0) {
			return "?"+list.stream().collect(Collectors.joining("&"));
		}
		return "";
	}
}
