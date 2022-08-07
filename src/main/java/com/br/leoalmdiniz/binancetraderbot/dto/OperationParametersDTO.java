package com.br.leoalmdiniz.binancetraderbot.dto;

import com.br.leoalmdiniz.binancetraderbot.utils.PredicateUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public final class OperationParametersDTO {

	private String operationPair;
	private String operateLong;
	private String operateShort;
	private String operateGrid;
	private String exitIfConditionsRevert;
	private String exitIfParametersAlter;
	private String stopLossId;
	private String trailingStopId;
	private String reinforceId;
	private String criteriaId;
	private String operationInterval;

	public static OperationParametersDTO newInstance() {
    	return new OperationParametersDTO();
    }
	
	public void refreshFields(OperationParametersDTO operationParametersDTO) {
		this.operationPair = operationParametersDTO.getOperationPair();
		this.operateLong = operationParametersDTO.getOperateLong();
		this.operateShort = operationParametersDTO.getOperateShort();
		this.operateGrid = operationParametersDTO.getOperateGrid();
		this.exitIfConditionsRevert = operationParametersDTO.getExitIfConditionsRevert();
		this.exitIfParametersAlter = operationParametersDTO.getExitIfParametersAlter();
		this.stopLossId = operationParametersDTO.getStopLossId();
		this.trailingStopId = operationParametersDTO.getTrailingStopId();
		this.reinforceId = operationParametersDTO.getReinforceId();
		this.criteriaId = operationParametersDTO.getCriteriaId();
		this.operationInterval = operationParametersDTO.getOperationInterval();
	}
	
	public boolean operatesGrid() {
		return PredicateUtils.booleanCheck(this.operateGrid);
	}
	
	public boolean closeTradesWhenParametersAlter() {
		return PredicateUtils.booleanCheck(this.exitIfParametersAlter);
	}

}
