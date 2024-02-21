package com.koneko.consulting.editor;

import java.beans.PropertyEditorSupport;

import com.koneko.consulting.vo.Address;

public class AddressPropertyEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		//当资源设置之后，会触发方法的执行
		String[] result = text.split("-");
		Address address = new Address();
		address.setCountry(result[0]);
		address.setProvice(result[1]);
		address.setCity(result[2]);
		super.setValue(address);//保存bean对象
	}
}
