package com.koneko.consulting;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Demo {
	public static void main(String[] args) throws Exception {
		String code = "东京经理情报专门";
		String temp = URLEncoder.encode(code,"iso8859-1");
		System.out.println(temp);
		
		temp = URLDecoder.decode(temp,"UTF-8");
		System.out.println(temp);
	}
}
