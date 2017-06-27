package com.cryptodudes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import com.cryptodudes.util.*;
import com.cryptodudes.dto.Coin;

@Component
public class ScheduledTask {

    private PreparedStatement preparedStatement = null;
  
	@Autowired
	ObjectMapper objectMapper;

	@Scheduled(fixedRate = 30000)  // every 30 seconds
	public void pullCryptoInfo() throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> results = restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/?limit=1", String.class);
		//Coin[] coins = objectMapper.readValue(results.getBody(), Coin[].class);
		//System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(coins));
		Coin[] result = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/?limit=5", Coin[].class);
		String id= result[0].id;
		String name= result[0].name;
		String symbol= result[0].symbol;
		String rank= result[0].rank;
		String price_usd= result[0].price_usd;
		String price_btc= result[0].price_btc;
		String volume_usd= result[0].volume_usd;
		String market_cap_usd= result[0].market_cap_usd;
		String available_supply= result[0].available_supply;
		String total_supply= result[0].total_supply;
		String percent_change_oneh= result[0].percent_change_1h;
		String percent_change_h= result[0].percent_change_24h;
		String percent_change_d= result[0].percent_change_7d;
		String last_updated= result[0].last_updated;
		
		DbConnection con = new DbConnection();
		
		preparedStatement = con.Connection().prepareStatement("insert into crypto.coin_info values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, symbol);
        preparedStatement.setString(4, rank);
        preparedStatement.setString(5, price_usd);
        preparedStatement.setString(6, price_btc);
        preparedStatement.setString(7, volume_usd);
        preparedStatement.setString(8, market_cap_usd);
        preparedStatement.setString(9, available_supply);
        preparedStatement.setString(10, total_supply);
        preparedStatement.setString(11,percent_change_oneh);
        preparedStatement.setString(12,percent_change_h);
        preparedStatement.setString(13, percent_change_d);
        preparedStatement.setString(14, last_updated);
        preparedStatement.executeUpdate();

	}
}
