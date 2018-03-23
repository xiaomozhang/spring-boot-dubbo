package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.example.service.ProviderService;

@SpringBootApplication
@ImportResource("classpath:example-dubbo-consumer.xml")
public class Application {
	
	@Autowired
	private ProviderService providerService;

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(Application.class, args);
	}

}
