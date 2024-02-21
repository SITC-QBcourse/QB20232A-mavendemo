package com.koneko.consulting.vo;

import lombok.Data;

@Data
public class Address {
	private String country;
	private String provice;
	private String city;
	@Override
	public String toString() {
		return "Address [country=" + country + ", provice=" + provice + ", city=" + city + "]";
	}
	
	
}
