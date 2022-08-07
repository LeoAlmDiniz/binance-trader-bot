package com.br.leoalmdiniz.binancetraderbot.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum CandlestickIntervalExtension {
  WEBSOCKET("ws");

  private final String intervalId;

  CandlestickIntervalExtension(String intervalId) {
    this.intervalId = intervalId;
  }

  public String getIntervalId() {
    return intervalId;
  }
}
