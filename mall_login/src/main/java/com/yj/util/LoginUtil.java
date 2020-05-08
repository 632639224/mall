package com.yj.util;

import com.yj.constants.MallConstants;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginUtil {

	public static Map<String, Object> getLoginUser(String heyCode) {

		String userjson = RedisUtil.get(MallConstants.PREFIX_USER_KEY + heyCode);
		if (StringUtils.isNotEmpty(userjson)) {
			Map<String, Object> result = (Map<String, Object>) GsonUtil.gsonToMap(userjson);
			return result;
		}
		return null;
	}

	public static Map<String, Object> getWebLoginUser(String token) {

		String userjson = RedisUtil.get(MallConstants.PREFIX_WEB_USER_KEY + token);
		if (StringUtils.isNotEmpty(userjson)) {
			Map<String, Object> result = (Map<String, Object>) GsonUtil.gsonToMap(userjson);
			return result;
		}
		return null;
	}

	public static Map<String, Object> getWebLoginUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("token".equals(cookie.getName())) {
					return getWebLoginUser(cookie.getValue());
				}
			}
		}
		return null;
	}

	public static void removeWebUser(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("token".equals(cookie.getName())) {
					RedisUtil.remove(MallConstants.PREFIX_WEB_USER_KEY + cookie.getValue());
					break;
				}
				cookie.setValue(null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
	}

	public static void packageLoginInfo(Map<String, String> params) {
		String _token = params.get("_token");
		if(StringUtils.isNotEmpty(_token)) {
			Map<String, Object> loginUser = LoginUtil.getLoginUser(_token);
			if(loginUser!=null) {
				params.put("loginUserId", ((Double)loginUser.get("id")).intValue() + "");
				params.put("loginUserName", (String) loginUser.get("userName"));
				params.put("loginPhoneNo", (String)loginUser.get("phoneNo"));
			}
		}
	}
}
