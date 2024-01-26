package com.koneko.consulting.service;

import com.koneko.consulting.di.type.MessageSendStatus;

public interface IMessageService extends AutoCloseable{
	public MessageSendStatus send(String msg);
}
