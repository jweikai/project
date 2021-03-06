package com.converter.base;


import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.springframework.web.util.HtmlUtils;

/**
 * 转义html代码
 * 
 * @author Jweikai
 * 
 */
public class EscapeConverter extends StrutsTypeConverter {

	@Override
	public String convertToString(Map context, Object o) {		
		if (o != null) {
			if (o instanceof String[]) {
				String[] str = (String[]) o;
				if (str != null && !StringUtils.isBlank(str[0])) {
					return HtmlUtils.htmlEscape(str[0]);
				}
			} else if (o instanceof String) {
				String str = (String) o;
				if (!StringUtils.isBlank(str)) {
					return HtmlUtils.htmlEscape(str);
				}
			}
		}
		return "";
	}

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return values;
	}

}
