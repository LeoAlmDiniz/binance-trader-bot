package com.br.leoalmdiniz.binancetraderbot.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name="tb_trad_aber")
public class OpenTradeModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nr_sequ_trad_aber")
    private Long id;
	
	@Column(name="dh_aber")
	@NotNull
	private LocalDateTime openingDate;
	
	@OneToOne
	@JoinColumn(name = "cd_par")
	@NotNull
	private PairModel pair;
	
	@OneToOne
	@JoinColumn(name = "cd_oper")
	@NotNull
	private OperationModel operation;
	
	@Column(name = "vl_usdt_cmpr")
	private String UsdtBuyValue;
	
	@Column(name = "vl_toke_cmpr")
	private String TokenBuyValue;
	
	@Column(name = "vl_usdt_vend")
	private String UsdtSellValue;
	
	@Column(name = "vl_toke_vend")
	private String TokenSellValue;
	
	@OneToOne
	@JoinColumn(name = "nr_sequ_trad_aber")
	private OpenTradeStrategyModel tradeStrategy;
	
}
