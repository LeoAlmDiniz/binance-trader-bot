package com.br.leoalmdiniz.binancetraderbot.schedule;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.config.JdbcNamespaceHandler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.binance.api.client.domain.market.CandlestickInterval;
import com.br.leoalmdiniz.binancetraderbot.mediator.ActiveFetchersMediator;

@EnableScheduling
public class RESTRequestsSchedule {
	
	@Autowired ActiveFetchersMediator activeFetchersMediator;
	
	//minuto hora dia-do-mes mes dia-da-semana comando
	@Scheduled(cron = "1 0 * * ?")
	public void updateOperationParameters1m() throws IOException {
		if (activeFetchersMediator.getActiveFetchers().contains(CandlestickInterval.ONE_MINUTE.getIntervalId())) {
			
		}
	}
	

}
