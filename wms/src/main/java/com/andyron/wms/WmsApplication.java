package com.andyron.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class WmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmsApplication.class, args);
	}

}
