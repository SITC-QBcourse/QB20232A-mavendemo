package com.koneko.consulting.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.koneko.consulting.di.config.MessageConfig;
import com.koneko.consulting.service.IMessageService;
import com.koneko.consulting.service.impl.MessageServiceImpl;

@Configuration
public class KonekoConfig {
	
	@Bean("php")
	public MessageConfig config() {
		MessageConfig config = new MessageConfig();
		config.setHost("www.koneko-consulting.com");
		config.setPort(9999);
		config.setEnable(true);
		return config;
	}
	
	@Bean("html")
	public MessageConfig definit() {
		MessageConfig definit = new MessageConfig();
		definit.setHost("www.koneko-consulting.com");
		definit.setPort(8888);
		definit.setEnable(true);
		return definit;
	}
	
	@Bean
	@Primary
	public IMessageService getService1(MessageConfig php, MessageConfig html) {
		Map<String, MessageConfig> map = new HashMap<>();
		map.put("php", php);
		map.put("html", html);
		
		MessageServiceImpl service = new MessageServiceImpl();
		service.setMessageConfigs(map);
		return service;
	}
	@Bean("next")
	public IMessageService getService2(MessageConfig php, MessageConfig html) {
		Map<String, MessageConfig> map = new HashMap<>();
		map.put("php", php);
		map.put("html", html);
		
		MessageServiceImpl service = new MessageServiceImpl();
		service.setMessageConfigs(map);
		return service;
	}
}
