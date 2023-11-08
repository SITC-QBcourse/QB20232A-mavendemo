package com.koneko.consulting;

public class Demo {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = com.koneko.consulting.Book.class.getClass();
		Object obj = clazz.getDeclaredConstructor().newInstance();
		Book book = (Book)obj;
		
	}
}

class Book{
	public Book() {
		System.out.println("【Book】对象实例化");
	}
}
