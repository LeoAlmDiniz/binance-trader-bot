package com.br.leoalmdiniz.binancetraderbot.config;

import java.beans.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.br.leoalmdiniz.binancetraderbot.dto.OperationParametersDTO;
import com.br.leoalmdiniz.binancetraderbot.model.OperationParameterModel;
import com.br.leoalmdiniz.binancetraderbot.repository.OperationParametersRepository;
import com.br.leoalmdiniz.binancetraderbot.schedule.DatabaseFetcher;
import com.br.leoalmdiniz.binancetraderbot.util.ReflectUtil;

//class will be used by JavaConfig as a source of bean definitions
@Configuration
public class OperationParametersConfig {
	
	@Autowired
	OperationParametersRepository operationParametersRepository;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DatabaseFetcher.class);
	
	@Bean
	public OperationParametersDTO operationParametersInstance() {
		OperationParametersDTO operationParametersDTO = OperationParametersDTO.newInstance();
		List<OperationParameterModel> operationParameters = operationParametersRepository.findAll();
		for (OperationParameterModel parameter : operationParameters) {
			Statement statement = new Statement(operationParametersDTO, 
					ReflectUtil.setterFrom(parameter.getName()),
					new String[] { parameter.getValue() }
			);
			try {
				statement.execute();
			} catch (Exception e) {
				LOGGER.error( "Could not fetch parameters from database. Cause: " + e.getCause() );
			}
		}
		LOGGER.info("Current parameters: " + operationParametersDTO.toString() );
		return operationParametersDTO;
	}

}
