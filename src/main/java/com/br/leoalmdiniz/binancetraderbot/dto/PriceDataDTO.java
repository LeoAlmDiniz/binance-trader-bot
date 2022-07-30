package com.br.leoalmdiniz.binancetraderbot.dto;

import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public final class PriceDataDTO {

	private static PriceDataDTO INSTANCE;
	private long openTime;
	private String currentPrice;
	
	private Map<String, CandlestickDTO> mostRecentCandlesticks;
	

	public static PriceDataDTO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PriceDataDTO();
		}
    	return INSTANCE;
    }
	
	public void refreshPrice(String price) {
		this.currentPrice = price;
	}

}
