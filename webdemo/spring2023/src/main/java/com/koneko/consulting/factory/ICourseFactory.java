package com.koneko.consulting.factory;
import java.lang.reflect.InvocationTargetException;

import com.koneko.consulting.service.ICourse;
public class ICourseFactory {
	private ICourseFactory() {}
	public static Object get() throws Exception, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("com.koneko.consulting.interfaces.impl.HTMLCourseImpl");
		return clazz.getDeclaredConstructor().newInstance();
	}
	public static ICourse getInstance(String className) throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, Exception {
		switch(className.toLowerCase()) {
		case "html":
			return (ICourse) get();
		case "java":
			return ()->System.out.println("【Java】学习Java课程");
		default :
			return null;
		}
	}
}
