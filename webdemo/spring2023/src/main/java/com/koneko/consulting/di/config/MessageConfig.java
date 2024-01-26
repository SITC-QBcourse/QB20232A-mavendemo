package com.koneko.consulting.di.config;

import lombok.Data;

@Data
public class MessageConfig {	
	private String host;
	private int port;
	private boolean enable;
	
	public MessageConfig(int port, boolean enable,String host) {
		this.host = host;
		this.port = port;
		this.enable = enable;
	}
}
