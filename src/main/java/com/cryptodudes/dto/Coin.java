package com.cryptodudes.dto;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {

	public String id;
	public String name;
	public String symbol;
	public String rank;
	public Double volume_usd;
	public Double price_usd;
	public Double price_btc;
	public String market_cap_usd;
	public String available_supply;
	public String total_supply;
	public String percent_change_1h;
	public String percent_change_24h;
	public String percent_change_7d;
	public Long last_updated;

    public Coin( 
    	@JsonProperty("id") final String id,
		@JsonProperty("name") final String name,
		@JsonProperty("symbol") final String symbol,
		@JsonProperty("rank") final String rank,
		@JsonProperty("24h_volume_usd") final Double volume_usd,
		@JsonProperty("price_usd") final Double price_usd,
		@JsonProperty("price_btc") final Double price_btc,
		@JsonProperty("market_cap_usd") final String market_cap_usd,
		@JsonProperty("available_supply") final String available_supply,
		@JsonProperty("total_supply") final String total_supply,
		@JsonProperty("percent_change_1h") final String percent_change_1h,
		@JsonProperty("percent_change_24h") final String percent_change_24h,
		@JsonProperty("percent_change_7d") final String percent_change_7d,
		@JsonProperty("last_updated") final Long last_updated) {
    	
		this.id = id;
		this.name =name;
		this.symbol = symbol;
		this.rank = rank;
		this.volume_usd = volume_usd;
		this.price_usd =price_usd;
		this.price_btc = price_btc;
		this.market_cap_usd = market_cap_usd;
		this.available_supply = available_supply ;
		this.total_supply = total_supply;
		this.percent_change_1h = percent_change_1h;
		this.percent_change_24h = percent_change_24h;
		this.percent_change_7d = percent_change_7d;
		this.last_updated = last_updated;
    }

    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	public String getRank() {
		return rank;
	}



	public void setRank(String rank) {
		this.rank = rank;
	}


	public Double getvolume_usd() {
		return volume_usd;
	}



	public void setvolume_usd(Double volume_usd) {
		this.volume_usd = volume_usd;
	}


	public Double getPrice_usd() {
		return price_usd;
	}



	public void setPrice_usd(Double price_usd) {
		this.price_usd = price_usd;
	}



	public Double getPrice_btc() {
		return price_btc;
	}



	public void setPrice_btc(Double price_btc) {
		this.price_btc = price_btc;
	}



	public String getMarket_cap_usd() {
		return market_cap_usd;
	}



	public void setMarket_cap_usd(String market_cap_usd) {
		this.market_cap_usd = market_cap_usd;
	}



	public String getAvailable_supply() {
		return available_supply;
	}



	public void setAvailable_supply(String available_supply) {
		this.available_supply = available_supply;
	}



	public String getTotal_supply() {
		return total_supply;
	}



	public void setTotal_supply(String total_supply) {
		this.total_supply = total_supply;
	}



	public String getPercent_change_1h() {
		return percent_change_1h;
	}



	public void setPercent_change_1h(String percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
	}



	public String getPercent_change_24h() {
		return percent_change_24h;
	}



	public void setPercent_change_24h(String percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
	}

	public String getPercent_change_7d() {
		return percent_change_7d;
	}



	public void setPercent_change_7d(String percent_change_7d) {
		this.percent_change_7d = percent_change_7d;
	}



	public Long getLast_updated() {
		return last_updated;
	}



	public void setLast_updated(Long last_updated) {
		this.last_updated = last_updated;
	}

	

	@Override
    public String toString() {
        return "Quote{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", symbol=" + symbol +
                ", rank=" + rank +
                 ", volume_usd=" + volume_usd +
                ", price_usd=" + price_usd +
                ", price_btc=" + price_btc +
                ", market_cap_usd=" + market_cap_usd +
                ", available_supply=" + available_supply +
                ", total_supply=" + total_supply +
                ", percent_change_1h=" + percent_change_1h +
                ", percent_change_24h=" + percent_change_24h +
                ", percent_change_24h=" + percent_change_7d +
                ", last_updated=" + last_updated +
                '}';
    }
}