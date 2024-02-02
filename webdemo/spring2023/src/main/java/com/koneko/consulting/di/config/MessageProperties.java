package com.koneko.consulting.di.config;

import java.util.Properties;

import lombok.Data;

@Data
public class MessageProperties {
	private String subject;//操作主题
	//一般属性都是字符串配置，比如后续使用到数据库的时候基本都是String的资源
	private Properties attribute;
}
