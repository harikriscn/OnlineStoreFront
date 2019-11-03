package com.store.online.OnlineStoreFront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.store.online.Controller","com.store.online.POJO", 
		"com.store.online.Service", "com.store.online.Exception", "com.store.online.Dao","com.store.online.Mapper"})
public class OnlineStoreFrontApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(OnlineStoreFrontApplication.class, args);
	}
}
