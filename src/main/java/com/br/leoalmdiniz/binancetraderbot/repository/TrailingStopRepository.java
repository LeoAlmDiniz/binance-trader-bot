package com.br.leoalmdiniz.binancetraderbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.leoalmdiniz.binancetraderbot.model.TrailingStopModel;

@Repository
public interface TrailingStopRepository extends JpaRepository<TrailingStopModel, Short> {
	
}
