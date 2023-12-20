package com.koneko.consulting.linster;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class GlobalRequestAttributeListener implements ServletRequestAttributeListener {

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		if (srae.getName().equals("org.apache.catalina.ASYNC_SUPPORTED")) {

		} else
			System.out.printf("【GlobalRequestAttributeListener】属性移除触发：name = %s  value = %s%n", srae.getName(),
					srae.getValue());
	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		if (srae.getName().equals("org.apache.catalina.ASYNC_SUPPORTED")) {

		} else
			System.out.printf("【GlobalRequestAttributeListener】属性增加触发：name = %s  value = %s%n", srae.getName(),
					srae.getValue());
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		if (srae.getName().equals("org.apache.catalina.ASYNC_SUPPORTED")) {

		} else
			System.out.printf("【GlobalRequestAttributeListener】属性替换触发：name = %s  value = %s%n", srae.getName(),
					srae.getValue());
	}

}
