package com.br.leoalmdiniz.binancetraderbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.leoalmdiniz.binancetraderbot.model.StopLossModel;

@Repository
public interface StopLossRepository extends JpaRepository<StopLossModel, Long> {
	
}
