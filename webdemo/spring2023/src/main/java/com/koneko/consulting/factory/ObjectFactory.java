package com.koneko.consulting.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ObjectFactory {
	private ObjectFactory() {}
	private static final String CONFIG = "com.koneko.consulting.config.Beans";
	private static Map<Object, Object> map = new HashMap<>();
	public static Map<Object, Object> getMap(String beanName){
		Map<Object, Object> map = new HashMap<>();
		ResourceBundle rb = ResourceBundle.getBundle(CONFIG);
		String beanClassName = rb.getString(beanName);
		Object instance = null;
		try {
			instance = Class.forName(beanClassName).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instance);
		map.put(beanName,instance);
		return map;
	}
	public static <T> T getInstance(String beanName, Class<T> returnType){
		return (T)getMap(beanName).get(beanName);
	}
}
