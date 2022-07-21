package com.br.leoalmdiniz.binancetraderbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.leoalmdiniz.binancetraderbot.model.OpenTradeStrategyModel;

@Repository
public interface OpenTradeStrategyRepository extends JpaRepository<OpenTradeStrategyModel, Long> {
	
}
