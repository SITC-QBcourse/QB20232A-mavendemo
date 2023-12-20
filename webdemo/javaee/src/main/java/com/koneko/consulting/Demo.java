package com.koneko.consulting;

public class Demo{
	public static void main(String[] args) {
		int n = 5;
		char from = 'A';
		char to = 'B';
		char inner = 'C';
		get(n, from, to, inner);
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
