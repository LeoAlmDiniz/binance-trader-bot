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
@Table(name="tb_estr_trad_aber")
public class OpenTradeStrategyModel {
	
	@Id
	@Column(name="nr_sequ_trad_aber")
    private Long id;
	
	@Column(name="bl_fech_alte_para")
	@NotNull
	private boolean closeWhenParametersAlter;
	
	@Column(name="bl_fech_reve_cond")
	@NotNull
	private boolean closeWhenConditionsRevert;
	
	@OneToOne
	@JoinColumn(name = "cd_stop_loss")
	@NotNull
	private StopLossModel stopLoss;
	
	@OneToOne
	@JoinColumn(name = "cd_trai_stop")
	@NotNull
	private TrailingStopModel trailingStop;
	
	@OneToOne
	@JoinColumn(name = "cd_refo")
	@NotNull
	private ReinforceBehaviorModel reinforceBehavior;
	
	@OneToOne
	@JoinColumn(name = "cd_crit")
	@NotNull
	private CriteriumModel criterium;
	
}
