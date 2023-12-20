package com.koneko.consulting.linster;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class WebAttributeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.printf("【WebAttributeListener】属性增加：name = %s \t value = %s%n",scae.getName(),scae.getValue());
    }
    public void attributeRemoved(ServletContextAttributeEvent scae)  {
    	System.out.printf("【WebAttributeListener】属性修改：name = %s \t value = %s%n",scae.getName(),scae.getValue());
    }
    public void attributeReplaced(ServletContextAttributeEvent scae)  {
    	System.out.printf("【WebAttributeListener】属性删除：name = %s \t value = %s%n",scae.getName(),scae.getValue());
    }
	
}
