package com.koneko.consulting.config;

import com.koneko.consulting.listener.KonekoEventListener;

public class KonekoEventConfig {
	
	public KonekoEventListener eventListener() {
		return new KonekoEventListener();
	}
}
