package com.example.dubbo.consumer;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.ProviderService;

@Service
public class ConsumerService {
	
	@Autowired
	private ProviderService providerService;
	
	@PostConstruct
	public void init(){
		System.out.println(providerService.sayHello("哈哈哈~"));
	}

}
