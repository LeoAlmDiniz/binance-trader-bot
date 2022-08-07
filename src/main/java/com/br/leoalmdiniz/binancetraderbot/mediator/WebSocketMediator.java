package com.br.leoalmdiniz.binancetraderbot.mediator;

import java.io.Closeable;
import java.io.IOException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.domain.event.CandlestickEvent;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.br.leoalmdiniz.binancetraderbot.dto.CandlestickDTO;
import com.br.leoalmdiniz.binancetraderbot.dto.OperationParametersDTO;
import com.br.leoalmdiniz.binancetraderbot.enums.CandlestickIntervalExtension;

@Component
public class WebSocketMediator {

	private Closeable websocket;
	private CandlestickDTO candlestick;

	private final Logger LOGGER = LoggerFactory.getLogger(WebSocketMediator.class);
	
	public void listenOperationParametersRevision(OperationParametersDTO newOperationParametersDTO, OperationParametersDTO oldOperationParametersDTO, Set<String> activeFetchers) throws IOException {
		checkWebSocketInitialization(newOperationParametersDTO, activeFetchers);
		if ( !newOperationParametersDTO.equals(oldOperationParametersDTO) ) {
			checkCloseWhenParametersAlter(oldOperationParametersDTO);
			checkOperationPair(newOperationParametersDTO, oldOperationParametersDTO);
		}
		checkOperateGrid(newOperationParametersDTO);
	}

	private void checkWebSocketInitialization(OperationParametersDTO newOperationParametersDTO, Set<String> activeFetchers) {
		if (websocket == null && activeFetchers.contains( CandlestickIntervalExtension.WEBSOCKET.getIntervalId()) ) {
			LOGGER.info("Initializing websocket...");
			websocket = BinanceApiClientFactory.newInstance().newWebSocketClient().onCandlestickEvent(
					newOperationParametersDTO.getOperationPair().toLowerCase(), 
					CandlestickInterval.valueOf( newOperationParametersDTO.getOperationInterval() ),
					webSocketSupplier());
		}
	}
	
	private void checkOperateGrid(OperationParametersDTO newOperationParametersDTO) throws IOException {
		if ( !newOperationParametersDTO.operatesGrid()) {
			closeWebSocket();
		}
	}
	
	private void checkCloseWhenParametersAlter(OperationParametersDTO oldOperationParametersDTO) {
		if ( oldOperationParametersDTO.closeTradesWhenParametersAlter() ) {
			// TODO ASYNC CLOSE ALL OPEN TRADES
		}
	}
	
	private void checkOperationPair(OperationParametersDTO newOperationParametersDTO, OperationParametersDTO oldOperationParametersDTO) throws IOException {
		if ( !newOperationParametersDTO.getOperationPair().equals(oldOperationParametersDTO.getOperationPair()) ) {
			closeWebSocket();
		}
	}

	private BinanceApiCallback<CandlestickEvent> webSocketSupplier() {
		return new BinanceApiCallback<CandlestickEvent>() {
			@Override
			public void onResponse(CandlestickEvent ce) {
				System.out.println(ce);
				updateCandlestick(ce);
			}
		};
	}
	
	

	public void closeWebSocket() throws IOException {
		if (websocket != null) {
			LOGGER.info("Closing websocket...");
			websocket.close();
			websocket = null;
		}
	}

	public CandlestickDTO getCandlestick() {
		return this.candlestick;
	}
	
	private void updateCandlestick(CandlestickEvent ce) {
			this.candlestick.refresh(ce);
	}
	
}
