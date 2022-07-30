package com.br.leoalmdiniz.binancetraderbot.utils;

public class PredicateUtils {
	
	public static Boolean booleanCheck(String value) {
		if ( "S".equals(value) || "Y".equals(value) 
				|| "SIM".equals(value) || "YES".equals(value) ) {
			return true;
		}
		return false;
	}

}
