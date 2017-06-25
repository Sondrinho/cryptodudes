package com.cryptodudes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import com.cryptodudes.dto.Coin;

@Component
public class ScheduledTask {

	@Autowired
	ObjectMapper objectMapper;

	@Scheduled(fixedRate = 30000)  // every 30 seconds
	public void pullCryptoInfo() throws Exception {


		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/?limit=1", String.class);
		
		Coin[] coins = objectMapper.readValue(result.getBody(), Coin[].class);
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(coins)); 

	}
}
