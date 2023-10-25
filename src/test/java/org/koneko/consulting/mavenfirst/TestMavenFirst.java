package org.koneko.consulting.mavenfirst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMavenFirst {
	@Test
	public void testSayHello() {
		MavenFirst mf = new MavenFirst();
		String result = mf.sayHello("laoyang");
		Assertions.assertEquals("helllo laoyang", result);
	}
}
