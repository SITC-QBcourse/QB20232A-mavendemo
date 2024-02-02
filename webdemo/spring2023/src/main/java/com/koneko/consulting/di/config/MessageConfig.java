package com.koneko.consulting.di.config;

import lombok.Data;

@Data
public class MessageConfig extends Object{	
	private int port;
	private String host;
	private boolean enable;
	
	public MessageConfig() {}
	
	public MessageConfig(int port, boolean enable,String host) {
		this.host = host;
		this.port = port;
		this.enable = enable;
	}
}
