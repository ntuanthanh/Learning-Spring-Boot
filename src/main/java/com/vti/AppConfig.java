package com.vti;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	 @Value("${abc.mysql.url}")
	 String mysqlUrl;
	 
	 @Bean
	  DatabaseConnector mysqlConfigure() {
	        DatabaseConnector mySqlConnector = new MySqlConnector();
	        // Set Url
	        System.out.println("Config Mysql Url: " + mysqlUrl);
	        mySqlConnector.setUrl(mysqlUrl);
	        // Set username, password, format, v.v...
	        return mySqlConnector;
	    }
}
