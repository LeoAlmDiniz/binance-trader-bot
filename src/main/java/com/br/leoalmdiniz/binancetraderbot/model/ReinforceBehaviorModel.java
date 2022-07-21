package com.br.leoalmdiniz.binancetraderbot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

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
@Table(name="tb_refo")
public class ReinforceBehaviorModel {
	
	@Id
	@Column(name="cd_refo")
	@NotNull
    private short code;
	
	@Column(name="bl_repe_cond")
	@NotNull
	private boolean reinforceWhenTriggerRepeats;
	
	@Column(name="vl_perc_qued")
	@Positive
	private BigDecimal percentDropToReinforce;
	
	@Column(name="vl_max_repe")
	@NotNull
	@PositiveOrZero
	private short maxNumberOfReinforcements;
	
}
