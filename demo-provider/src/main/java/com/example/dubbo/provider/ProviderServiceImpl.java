package com.example.dubbo.provider;

import com.example.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	@Override
	public String sayHello(String name) {
		return "Hello:~~~~~~~~~~~~~~~~~~~~~~~~" + name + "你好，你好~~";
	}
}
