package com.koneko.consulting.editor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import com.koneko.consulting.vo.Address;

public class AddressPropertyEditorRegistrar implements PropertyEditorRegistrar{
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		//根据Address类型匹配，如果发现要进行此类型对象的操作，则自动找到匹配的编辑器
		registry.registerCustomEditor(Address.class, new AddressPropertyEditor());
	}
}
