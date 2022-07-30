package com.br.leoalmdiniz.binancetraderbot.dto;

import com.binance.api.client.domain.event.CandlestickEvent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public final class CandlestickDTO {

	public final String interval;
	public Long openTime;
	public String open;
	public String high;
	public String low;
	public String close;
	
	public CandlestickDTO(String interval) {
		this.interval = interval;
	}
	
	public void refresh(CandlestickEvent ce) {
		this.openTime = ce.getOpenTime();
		this.open = ce.getOpen();
		this.high = ce.getHigh();
		this.low = ce.getLow();
		this.close = ce.getClose();
	}

}
