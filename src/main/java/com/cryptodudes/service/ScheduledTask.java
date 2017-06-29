package com.cryptodudes.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

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

	@Scheduled(fixedRate = 60000)  // every 30 seconds
	public void pullCryptoInfo() throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> results = restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/?limit=1", String.class);
		//Coin[] coins = objectMapper.readValue(results.getBody(), Coin[].class);
		//System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(coins));
		Coin[] result = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/?limit=5", Coin[].class);
		
	
		int i;
		for (i=0; i < result.length ; i++) {
			Integer id=result[i].id;
			String name= result[i].name;
			String symbol= result[i].symbol;
			String rank= result[i].rank;
			Double price_usd= result[i].price_usd;
			Double price_btc= result[i].price_btc;
			Integer volume_usd= result[i].volume_usd;
			String market_cap_usd= result[i].market_cap_usd;
			String available_supply= result[i].available_supply;
			String total_supply= result[i].total_supply;
			String percent_change_oneh= result[i].percent_change_1h;
			String percent_change_h= result[i].percent_change_24h;
			String percent_change_d= result[i].percent_change_7d;
			Long last_updated = result[i].last_updated;

			DateTimeFormatter lastUpdatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDtm = Instant.ofEpochSecond(last_updated).atZone(ZoneId.of("GMT+1")).format(lastUpdatedDate);
			DbConnection con = new DbConnection();
			
			preparedStatement = con.Connection().prepareStatement("insert into crypto.coin_info values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        preparedStatement.setInt(1, id);
	        preparedStatement.setString(2, name);
	        preparedStatement.setString(3, symbol);
	        preparedStatement.setString(4, rank);
	        preparedStatement.setDouble(5, price_usd);
	        preparedStatement.setDouble(6, price_btc);
	        preparedStatement.setInt(7, volume_usd);
	        preparedStatement.setString(8, market_cap_usd);
	        preparedStatement.setString(9, available_supply);
	        preparedStatement.setString(10, total_supply);
	        preparedStatement.setString(11,percent_change_oneh);
	        preparedStatement.setString(12,percent_change_h);
	        preparedStatement.setString(13, percent_change_d);
	        preparedStatement.setString(14, formattedDtm);
	        preparedStatement.executeUpdate();
	        formattedDtm = null;
	        
	      

		}

		
		

		
		

	}
}