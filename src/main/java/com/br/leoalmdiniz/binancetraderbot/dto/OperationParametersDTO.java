package com.br.leoalmdiniz.binancetraderbot.dto;

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

	public String operationPair;
	public String operateLong;
	public String operateShort;
	public String operateGrid;
	public String exitIfConditionsRevert;
	public String exitIfParametersAlter;
	public String stopLossId;
	public String trailingStopId;
	public String reinforceId;
	public String criteriaId;

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
	}

}
