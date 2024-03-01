package com.koneko.consulting.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.xml.XmlValidationModeDetector;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

public class StartSpringApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartSpringApplication.class);
	public static final String RESOURCE_NAME = "classpath:spring-base.xml";
	public static void main(String[] args) throws Exception {
		 BeanDefinitionRegistry registry = new AnnotationConfigApplicationContext();
		 XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		 int count = reader.loadBeanDefinitions(RESOURCE_NAME);
		 if(count > 0) {
			 Document document = getdDocument(reader);
			 NodeList list = document.getElementsByTagName("bean");
			 System.out.println(list.getLength());
			 BeanDefinitionParserDelegate delegate = new BeanDefinitionParserDelegate(getReaderContext(reader));
			 for(int i = 0; i < list.getLength(); i++) {
				 Element ele = (Element) list.item(i);
				 BeanDefinitionHolder holder = delegate.parseBeanDefinitionElement(ele);
				 BeanDefinition definition = holder.getBeanDefinition();
				 LOGGER.info("【Bean配置】id = {}， class = {}",ele.getAttribute("id"),definition.getBeanClassName());
			 }
		 }
	}
	public static Document getdDocument(XmlBeanDefinitionReader reader) throws Exception{
		ResourceEntityResolver resolver = new ResourceEntityResolver(reader.getResourceLoader());
		reader.setEntityResolver(resolver);
		DocumentLoader loader = new DefaultDocumentLoader();
		InputSource source = new InputSource(reader.getResourceLoader().getResource(RESOURCE_NAME).getInputStream());
		Document document = loader.loadDocument(source, resolver, new DefaultHandler(), XmlValidationModeDetector.VALIDATION_XSD, true);
		return document;
	}
	public static XmlReaderContext getReaderContext(XmlBeanDefinitionReader reader) {
		XmlReaderContext context = reader.createReaderContext(reader.getResourceLoader().getResource(RESOURCE_NAME));
		return context;
	}
}
