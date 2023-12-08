package com.koneko.consulting.factory;

import com.koneko.consulting.dao.IStudentDao;
import com.koneko.consulting.proxy.impl.StudentDaoProxy;

public class IStudentFactory {
	private IStudentFactory() {}
	public static IStudentDao getStudentDao() {
		return new StudentDaoProxy();
	}
}
