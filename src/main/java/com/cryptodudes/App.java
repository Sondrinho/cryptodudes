package com.cryptodudes;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class App implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    
    public static void main(String args[]) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... strings) throws Exception {
    	log.info("Currencyinformation will update every 30sec.");
    } 
}