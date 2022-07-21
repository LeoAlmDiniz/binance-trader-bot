package com.br.leoalmdiniz.binancetraderbot.model;

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
@Table(name="tb_crit")
public class CriteriumModel {
	
	@Id
	@Column(name="cd_crit")
	@NotNull
    private Short code;
	
	@Column(name="nm_desc")
	private String description;
	
}
