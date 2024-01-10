package com.koneko.consulting;

public class Demo{
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> user = Class.forName("com.koneko.consulting.vo.User");
		System.out.println(user);
		Class<?> conn = Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println(conn);
	}
	public static void get(int n, char from, char to, char inner) {
		if(n == 1) {
			System.out.println("n = " + n + "\tfrom = " + from + "\tto = " + to);
			return;
		}
		get(n - 1, from, inner, to);
		System.out.println("n = " + n + "\tfrom = " + from + "\tto = " + to);
		get(n -1, inner, to, from);
	}
}
