package com.br.leoalmdiniz.binancetraderbot.enums;

public enum OperationParametersEnum {
	
	LONGS_ACTIVE("BULL"),
	SHORTS_ACTIVE("BEAR"),
	GRID_ACTIVE("GRID"),
	CLOSE_ON_CONDITION_REVERSED("BL_REVE_COND"),
	CLOSE_ON_PARAMETERS_ALTERED("BL_ALTE_PARA"),
	STOP_LOSS_ID("CD_STOP_LOSS"),
	TRAILING_STOP_ID("CD_TRAI_STOP"),
	REINFORCE_STRATEGY_ID("CD_ESTR_REFO"),
	TRADE_CRITERIA_ID("CD_CRIT_TROC");

	
	private String parameterName;
	
	OperationParametersEnum(String parameterName) {
		this.parameterName = parameterName;
	}
	
	public String getParameterName() {
		return parameterName;
	}
	
}
