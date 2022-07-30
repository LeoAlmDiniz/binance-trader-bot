package com.br.leoalmdiniz.binancetraderbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.leoalmdiniz.binancetraderbot.dto.PriceDataDTO;

//class will be used by JavaConfig as a source of bean definitions
@Configuration
public class UpdatedCandlestickConfig {
	
	@Bean
	public PriceDataDTO updatedCandlestickInstance() {
		return PriceDataDTO.getInstance();
	}

}
