package com.br.leoalmdiniz.binancetraderbot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="tb_stop_loss")
public class StopLossModel {
	
	@Id
	@Column(name="cd_stop_loss")
	@NotNull
    private short code;
	
	@Column(name="vl_perc_perd")
	@NotNull
	private BigDecimal percentLoss;
	
}
