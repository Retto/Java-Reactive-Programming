package com.retto.reactive.controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import reactor.core.publisher.Mono;

@RestController
@Log
public class MyController {

	@GetMapping("/hello")
	public Mono<String> greetingMessage() {
		log.info("Method started!");
	    Mono<String> value = computeMessage()
			.zipWith(getDataFromDB())
			.map(tuple -> tuple.getT1() + " - " + tuple.getT2());
		
		log.info("Method ended!");
		
		return value;
	}

	private Mono<String> computeMessage() {
		return Mono.just("Reactive Method Call:" + System.currentTimeMillis()).delayElement(Duration.ofSeconds(4));
	}
	
	private Mono<String> getDataFromDB() {
		return Mono.just("Data from DB:" + System.currentTimeMillis()).delayElement(Duration.ofSeconds(2));
	}
}
