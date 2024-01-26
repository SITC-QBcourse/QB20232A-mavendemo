package com.koneko.consulting.service.impl;

import com.koneko.consulting.service.ICourse;

public class JavaCourseImpl implements ICourse{
	@Override
	public void learn() {
		System.out.println("【Java】学习Java课程");
	}
}
