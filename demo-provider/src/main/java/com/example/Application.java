package com.example;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:example-dubbo-provider.xml")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Bean
	public CountDownLatch closeLatch() {
		return new CountDownLatch(1);
	}

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new SpringApplicationBuilder().sources(Application.class).web(false).run(args);

		logger.info("项目启动!");
//
//		SpringApplication.run(Application.class, args);
		SpringApplication application = new SpringApplication(Application.class);
		application.setRegisterShutdownHook(false);
		application.run(args);
		CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
		closeLatch.await();

	}
}
