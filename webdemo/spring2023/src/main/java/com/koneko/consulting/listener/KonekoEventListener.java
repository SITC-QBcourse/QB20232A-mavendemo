package com.koneko.consulting.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

import com.koneko.consulting.event.KonekoEvent;

public class KonekoEventListener implements ApplicationListener<KonekoEvent>{
	private static final Logger LOGGER = LoggerFactory.getLogger(KonekoEventListener.class);
	@Override
	public void onApplicationEvent(KonekoEvent event) {
		LOGGER.info("事件源：{}",event.getSource());		
	}
}
