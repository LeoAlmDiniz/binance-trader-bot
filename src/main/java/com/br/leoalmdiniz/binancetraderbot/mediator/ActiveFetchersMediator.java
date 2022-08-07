package com.br.leoalmdiniz.binancetraderbot.mediator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.binance.api.client.domain.market.CandlestickInterval;
import com.br.leoalmdiniz.binancetraderbot.dto.OperationParametersDTO;
import com.br.leoalmdiniz.binancetraderbot.enums.CandlestickIntervalExtension;

@Component
public class ActiveFetchersMediator {
	
	private Set<String> activeFetchers;
	
	public ActiveFetchersMediator() throws IOException {
		activeFetchers = new HashSet<>();
	}
	
	public void updateFetchers(OperationParametersDTO newOperationParametersDTO) throws IOException {
		activeFetchers.clear();
		if ( newOperationParametersDTO.operatesGrid() ) {
			activeFetchers.add( CandlestickIntervalExtension.WEBSOCKET.getIntervalId() );
		}
		activeFetchers.add(CandlestickInterval.valueOf(newOperationParametersDTO.getOperationInterval()).getIntervalId() );
		// TODO: add active simulators
	}

	public Set<String> getActiveFetchers() {
		return activeFetchers;
	}

}
