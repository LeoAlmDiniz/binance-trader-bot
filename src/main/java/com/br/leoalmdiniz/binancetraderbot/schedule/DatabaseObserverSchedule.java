package com.br.leoalmdiniz.binancetraderbot.schedule;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.br.leoalmdiniz.binancetraderbot.dto.OperationParametersDTO;
import com.br.leoalmdiniz.binancetraderbot.mediator.ActiveFetchersMediator;
import com.br.leoalmdiniz.binancetraderbot.mediator.OperationParametersMediator;
import com.br.leoalmdiniz.binancetraderbot.mediator.WebSocketMediator;

@Configuration
@EnableScheduling
public class DatabaseObserverSchedule {
	
	@Autowired OperationParametersMediator operationParametersMediator;
	@Autowired ActiveFetchersMediator activeFetchersMediator;
	@Autowired WebSocketMediator webSocketMediator;

	@Scheduled(fixedDelay = 10000)
	public void updateOperationParameters() throws IOException {
		OperationParametersDTO oldOperationParametersDTO = operationParametersMediator.getCurrentOperationParametersDTO();
		OperationParametersDTO newOperationParametersDTO = operationParametersMediator.getNewDTOFromRepository();
		Set<String> activeFetchers = activeFetchersMediator.getActiveFetchers();
		webSocketMediator.listenOperationParametersRevision(newOperationParametersDTO, oldOperationParametersDTO, activeFetchers);
		operationParametersMediator.updateCurrentDTO(newOperationParametersDTO);
	}
	
}
