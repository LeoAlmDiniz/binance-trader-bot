package com.br.leoalmdiniz.binancetraderbot.mediator.bean;

import com.br.leoalmdiniz.binancetraderbot.repository.OperationParametersRepository;

public class OperationParameterBean {
	
	private OperationParametersRepository operationParametersRepository;
	
	public OperationParameterBean(OperationParametersRepository operationParametersRepository) {
		this.operationParametersRepository = operationParametersRepository;
	}

	public OperationParametersRepository getOperationParametersRepository() {
		return operationParametersRepository;
	}	

}
