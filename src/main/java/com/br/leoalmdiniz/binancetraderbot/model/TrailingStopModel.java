package com.br.leoalmdiniz.binancetraderbot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import org.jetbrains.annotations.NotNull;

import com.br.leoalmdiniz.binancetraderbot.model.constraint.TrailingStopConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="tb_trai_stop")
@TrailingStopConstraint
public class TrailingStopModel {
	
	@Id
	@Column(name="cd_trai_stop")
	@NotNull
    private Short code;
	
	@Column(name="vl_perc_ativ")
	@NotNull
	@Positive
	private BigDecimal percentGainToActivate;
	
	@Column(name="vl_perc_corr")
	@NotNull
	@Positive
	private BigDecimal percentCorrectionToClose;
	
}
