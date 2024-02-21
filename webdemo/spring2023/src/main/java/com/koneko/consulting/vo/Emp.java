package com.koneko.consulting.vo;

public class Emp {
	private Long empNo;
	private String eName;
	private Dept dept;
	@Override
	public String toString() {
		return "Hashcode[" + super.hashCode() + "]   Emp [empNo=" + empNo + ", eName=" + eName + "]";
	}
	
	
}
