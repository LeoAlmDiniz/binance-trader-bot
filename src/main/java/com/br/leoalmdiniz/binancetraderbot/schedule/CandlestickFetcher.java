package com.br.leoalmdiniz.binancetraderbot.schedule;

import java.beans.Statement;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.domain.event.CandlestickEvent;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.br.leoalmdiniz.binancetraderbot.dto.OperationParametersDTO;
import com.br.leoalmdiniz.binancetraderbot.dto.PriceDataDTO;
import com.br.leoalmdiniz.binancetraderbot.model.OperationParameterModel;
import com.br.leoalmdiniz.binancetraderbot.repository.OperationParametersRepository;
import com.br.leoalmdiniz.binancetraderbot.utils.PredicateUtils;
import com.br.leoalmdiniz.binancetraderbot.utils.ReflectUtils;

@Configuration
@EnableScheduling
public class CandlestickFetcher {

	@Autowired private OperationParametersRepository operationParametersRepository;
	@Autowired private OperationParametersDTO currentOperationParametersDTO;
	@Autowired private PriceDataDTO priceDataDTO;
	private Closeable ws;
	
	private final Logger LOGGER = LoggerFactory.getLogger(CandlestickFetcher.class);

	@Scheduled(fixedDelay = 10000)
	public void updateOperationParameters() throws IOException {
		if (ws == null ) {
			initializeWebSocket();
		}
		OperationParametersDTO databaseOperationParametersDTO = lookParameters();
		if (!databaseOperationParametersDTO.equals(currentOperationParametersDTO)) {
			String oldPair = currentOperationParametersDTO.getOperationPair();
			currentOperationParametersDTO.refreshFields(databaseOperationParametersDTO);
			LOGGER.info("Refreshed parameters: " + currentOperationParametersDTO.toString() );
			if (!oldPair.equals(currentOperationParametersDTO.getOperationPair())) {
				ws.close();
				ws = null;
			}
			if (PredicateUtils.booleanCheck(currentOperationParametersDTO.getExitIfParametersAlter())) {
				// ASYNC CLOSE ALL OPEN TRADES
			}
		}
	}

	private BinanceApiCallback<CandlestickEvent> candlestickSupplier() {
		return new BinanceApiCallback<CandlestickEvent>() {
			@Override
			public void onResponse(CandlestickEvent ce) {
				priceDataDTO.refreshPrice(ce.getClose());
			}
		};
	}

	private void initializeWebSocket() {
		LOGGER.info("Initializing websocket...");
		ws = BinanceApiClientFactory.newInstance().newWebSocketClient().onCandlestickEvent(
				currentOperationParametersDTO.getOperationPair().toLowerCase(), 
				CandlestickInterval.ONE_MINUTE, 
				candlestickSupplier());
	}
	
	private OperationParametersDTO lookParameters() {
		OperationParametersDTO databaseOperationParametersDTO = OperationParametersDTO.newInstance();
		List<OperationParameterModel> databaseOperationParameters = operationParametersRepository.findAll();
		for (OperationParameterModel parameter : databaseOperationParameters) {
			Statement statement = new Statement(databaseOperationParametersDTO, 
					ReflectUtils.setterFrom(parameter.getName()),
					new String[] { parameter.getValue() }
			);
			try {
				statement.execute();
			} catch (Exception e) {
				LOGGER.error( "Could not fetch parameters from database. Cause: " + e.getCause() );
			}
		}
		return databaseOperationParametersDTO;
	}

}
