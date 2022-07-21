package com.br.leoalmdiniz.binancetraderbot.util;

import org.apache.commons.lang3.StringUtils;

public class ReflectUtil {
	
	public static String setterFrom(String field) {
		if (field == null || field.isBlank() || field.isEmpty() ) {
			return null;
		}
		return "set" + field.toUpperCase().charAt(0) + StringUtils.substring(field, 1);
	}

}
