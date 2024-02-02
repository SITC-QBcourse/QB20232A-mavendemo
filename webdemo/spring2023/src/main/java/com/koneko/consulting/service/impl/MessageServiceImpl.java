package com.koneko.consulting.service.impl;

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koneko.consulting.di.config.MessageConfig;
import com.koneko.consulting.di.type.MessageSendStatus;
import com.koneko.consulting.service.IMessageService;

public class MessageServiceImpl implements IMessageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
	private Map<String,MessageConfig> messageConfigs;
	private MessageConfig currentConfig;
	private MessageSendStatus status = MessageSendStatus.SUCCESS;
	
	private boolean contect() {
		LOGGER.info("链接服务器：{}:{}",this.currentConfig.getHost(),this.currentConfig.getPort());
		//lombok插件对于MessageConfig类中的enable的getter方法做出的一个适当的定义修改
		return this.currentConfig.isEnable();
	}

	@Override
	public MessageSendStatus send(String msg) {
		
		Iterator<Map.Entry<String, MessageConfig>> it = messageConfigs.entrySet().iterator();
		while(it.hasNext()) {
			this.currentConfig = it.next().getValue();
			if(this.contect()) {
				LOGGER.info("【信息发送】：{}",msg);
			}
		}
		try {
			this.close();
			return status;
		} catch (Exception e) {
			LOGGER.info("【发生异常】信息发送时产生异常：{}",e.getMessage());
			LOGGER.error("【发送失败】无法创建信息发送通道，信息发送失败！");
			return status = MessageSendStatus.FAILURE;
		}
	}
	//关闭操作要根据状态码的不同做出不同的处理
	@Override
	public void close() throws Exception {
		if(status.equals(MessageSendStatus.SUCCESS)) {
			LOGGER.info("【关闭通道】信息发送成功，断开信息发送的通道");
		}else {
			LOGGER.warn("【关闭通道】信息发送失败，断开信息发送的通道");
		}
	}
	
	public void setMessageConfigs(Map<String, MessageConfig> messageConfigs) {
		this.messageConfigs = messageConfigs;
	}
	public void setCurrentConfig(MessageConfig currentConfig) {
		this.currentConfig = currentConfig;
	}
}
