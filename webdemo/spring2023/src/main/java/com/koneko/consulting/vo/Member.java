package com.koneko.consulting.vo;

import org.springframework.stereotype.Component;

@Component
public class Member {
	public String toString() {
		return "【" + super.hashCode() + "】Member对象实例";
	}
}
