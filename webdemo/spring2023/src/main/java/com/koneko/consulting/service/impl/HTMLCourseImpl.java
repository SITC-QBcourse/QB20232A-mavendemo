package com.koneko.consulting.service.impl;

import com.koneko.consulting.service.ICourse;

public class HTMLCourseImpl implements ICourse{
	@Override
	public void learn() {
		System.out.println("【HTML】学习HTML课程");
	}
}
