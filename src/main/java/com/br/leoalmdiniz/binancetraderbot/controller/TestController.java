package com.br.leoalmdiniz.binancetraderbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.leoalmdiniz.binancetraderbot.model.OperationModel;
import com.br.leoalmdiniz.binancetraderbot.model.TrailingStopModel;
import com.br.leoalmdiniz.binancetraderbot.repository.OperationRepository;
import com.br.leoalmdiniz.binancetraderbot.repository.TrailingStopRepository;

@Controller
public class TestController {
	
	@Autowired
	private OperationRepository repository;
	
	@Autowired
	private TrailingStopRepository trailingRepo;
	
	@GetMapping("/get-sides")
	public ResponseEntity<OperationModel> getOperationSides() {
		var sides = repository.findAll();
		if (sides == null || sides.isEmpty()) {
			return ResponseEntity.ok().body(new OperationModel());
		}
		return ResponseEntity.ok().body( sides.get(0) ); 
	}
	
	@PostMapping("/post-trailing")
	public ResponseEntity<String> getOperationSides(@RequestBody TrailingStopModel input) {
		
		trailingRepo.save(input);
		
		return ResponseEntity.ok().body("Success");
	}


}
