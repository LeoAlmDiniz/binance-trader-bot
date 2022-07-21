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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="tb_para_oper")
public class OperationParameterModel {
	
	@Id
	@NotNull
	@Column(name="nm_para")
    private String name;
	
	@Column(name="nm_valor")
	private String value;
	
	@Column(name="dh_cria")
	private LocalDateTime creationTimestamp;
	
	@Column(name="dh_alte")
	private LocalDateTime lastModificationTimestamp;
	
}
