package com.koneko.consulting.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
	private ServletContext servletContext; // 获取application实例

	@Override
	public void contextInitialized(ServletContextEvent sce) { // 进行初始化集合存储
		this.servletContext = sce.getServletContext(); // 存在有公共的application属性
		// Map集合之中的key表示用户名，而Value是保存当前的用户状态
		this.servletContext.setAttribute("online", new HashMap<String, Boolean>());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// 用户登录成功会设置session的属性内容，这样就会触发本方法的执行
		if ("userid".equals(se.getName())) { // 判断是否为指定的属性操作
			Map<String, Boolean> map = (Map<String, Boolean>) this.servletContext.getAttribute("online");
			map.put((String) se.getValue(), false); // 保存用户信息
			this.servletContext.setAttribute("online", map);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) { // 用户离开了
		Map<String, Boolean> map = (Map<String, Boolean>) this.servletContext.getAttribute("online");
		map.remove(se.getSession().getAttribute("userid")); // 删除数据
		this.servletContext.setAttribute("online", map);
	}
}
