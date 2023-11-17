/**
 * 
 */
package com.koneko.consulting;

public class Demo {
	public static void main(String[] args) {
		A a = new B();
		a.abc();
	}
}

class A {
	public void abc() throws RuntimeException{}
}

class B extends A {//コンストラクター呼び出しは、コンストラクター内の最初のステートメントである必要があります
	private int[] abc;
	public void abc() throws NullPointerException{
		try {
			abc[0] = 1;
		}catch(NullPointerException n) {
			throw new NullPointerException("数组为开辟空间");
		}
	}
}