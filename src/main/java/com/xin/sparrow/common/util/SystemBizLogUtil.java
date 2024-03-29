package com.xin.sparrow.common.util;

import com.xin.sparrow.common.exception.ExceptionMessageException;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class SystemBizLogUtil {

	
	public static String setTemplateData(Map<String, String> templateMap,String template) throws ExceptionMessageException {
		if(StringUtils.isEmpty(template)){
			return "";
		}
		Set<String> templateSet = templateMap.keySet();
		for (String string : templateSet) {
			String target = "&{"+string+"}";
			String value = templateMap.get(string);
			if(StringUtils.isEmpty(value)){
				value = "";
			}
			template = template.replace(target,  value);
		}
		if(template.contains("&{")){
            throw new ExceptionMessageException("缺少模板参数，template=" + template);
		}
		return template;
	}
	
	public static Map<String, String> put(String... parameter){
		Map<String, String> templateMap = new HashMap<>();
		for (String string : parameter) {
			Set<String> keySet = templateMap.keySet();
			templateMap.put((keySet.size()+1)+"", string);
		}
		return templateMap;
	}
	

	
}
