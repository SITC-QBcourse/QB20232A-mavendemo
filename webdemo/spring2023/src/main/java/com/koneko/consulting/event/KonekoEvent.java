package com.koneko.consulting.event;

import org.springframework.context.ApplicationEvent;

public class KonekoEvent extends ApplicationEvent{
	public KonekoEvent(Object source) {
		super(source);
	}
}
