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

	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	
	@Autowired
	ObjectMapper objectMapper;

	@Scheduled(fixedRate = 30000)  // every 30 seconds
	public void pullCryptoInfo() throws Exception {


		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> results = restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/?limit=1", String.class);
		//Coin[] coins = objectMapper.readValue(results.getBody(), Coin[].class);
		//System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(coins));
		Coin[] result = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/?limit=5", Coin[].class);
		//String id= result[0].id;
		String name= result[1].name;
		String symbol= result[2].symbol;
		
		String price_usd= result[3].price_usd;
		String price_btc= result[4].price_btc;
		//String h_volume_usd= result[5].getPercent_change_24h();
		/*String market_cap_usd= result[6].market_cap_usd;
		String available_supply= result[7].available_supply;
		String total_supply= result[8].total_supply;
		String percent_change_oneh= result[9].percent_change_1h;
		String percent_change_h= result[10].percent_change_24h;
		
		*/
		
		//String name2= coins[1].name;
		
		DbConnection con = new DbConnection();
		
		
		//statement = con.Connection().createStatement();
		//resultSet = statement.executeQuery("select * from crypto.coin_info");
		preparedStatement = con.Connection().prepareStatement("insert into crypto.coin_info values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, "id");
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, "symbol");
        preparedStatement.setString(4, "price_usd");
        preparedStatement.setString(5, "price_btc");
        preparedStatement.setString(6, "h_volume_usd");
        preparedStatement.setString(7, "market_cap_usd");
        preparedStatement.setString(8, "available_supply");
        preparedStatement.setString(9, "total_supply");
        preparedStatement.setString(10, "percent_change_oneh");
        preparedStatement.setString(11,"percent_change_h");
        preparedStatement.setString(12, "percent_change_d");
        preparedStatement.setString(13, "last_updated");
        preparedStatement.executeUpdate();
		 
		
		
		
		
		
	}
}
