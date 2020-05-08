package com.yj.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

public class MallPropertiesUtil {
	
	static Map<String,String> confMap=new HashMap<>();
	
	private static Logger log= LoggerFactory.getLogger(MallPropertiesUtil.class);
	
	public  static void init() {
		ResourceBundle resource = ResourceBundle.getBundle("hyhealth");
		for(Iterator<String> iter = resource.keySet().iterator();iter.hasNext();) {
			String key = iter.next();
			confMap.put(key, resource.getString(key));
		}
	}
	public static String getValue(String key)throws Exception {
		return new String(confMap.get(key).getBytes("ISO8859-1"),"utf-8");
	}
	public static String getValueWithoutException(String key){
		String value="";
		try {
			value = new String(confMap.get(key).getBytes("ISO8859-1"), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
		return value;
	}
}
