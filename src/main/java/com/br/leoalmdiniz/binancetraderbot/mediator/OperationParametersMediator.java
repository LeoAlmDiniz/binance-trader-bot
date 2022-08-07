package com.br.leoalmdiniz.binancetraderbot.mediator;

import java.beans.Statement;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.br.leoalmdiniz.binancetraderbot.dto.OperationParametersDTO;
import com.br.leoalmdiniz.binancetraderbot.model.OperationParameterModel;
import com.br.leoalmdiniz.binancetraderbot.repository.OperationParametersRepository;
import com.br.leoalmdiniz.binancetraderbot.utils.PredicateUtils;
import com.br.leoalmdiniz.binancetraderbot.utils.ReflectUtils;

@Component
public class OperationParametersMediator {

	@Autowired private OperationParametersRepository operationParametersRepository;
	@Autowired private ActiveFetchersMediator activeFetchersMediator;
	
	private OperationParametersDTO currentOperationParametersDTO;
	private final Logger LOGGER = LoggerFactory.getLogger(OperationParametersMediator.class);
	
	public OperationParametersMediator() throws IOException  {
		currentOperationParametersDTO = OperationParametersDTO.newInstance();
	}
	
	public void updateCurrentDTO(OperationParametersDTO newOperationParametersDTO) throws IOException {
		currentOperationParametersDTO.refreshFields(newOperationParametersDTO);
		if (activeFetchersMediator != null) activeFetchersMediator.updateFetchers(newOperationParametersDTO); // Null safe initialisation
		LOGGER.info("Current parameters: " + currentOperationParametersDTO.toString() );
	}
	
	public OperationParametersDTO getNewDTOFromRepository() {
		OperationParametersDTO newOperationParametersDTO = OperationParametersDTO.newInstance();
		List<OperationParameterModel> databaseOperationParameters = operationParametersRepository.findAll();
		for (OperationParameterModel parameter : databaseOperationParameters) {
			Statement statement = new Statement(newOperationParametersDTO, 
					ReflectUtils.setterFrom(parameter.getName()),
					new String[] { parameter.getValue() }
			);
			try {
				statement.execute();
			} catch (Exception e) {
				LOGGER.error( "Could not fetch parameters from database. Cause: " + e.getCause() );
			}
		}
		return newOperationParametersDTO;
	}

	public OperationParametersDTO getCurrentOperationParametersDTO() {
		return currentOperationParametersDTO;
	}
	
}
