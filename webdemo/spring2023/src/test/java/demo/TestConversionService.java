package demo;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.koneko.consulting.config.KonekoEventConfig;
import com.koneko.consulting.event.KonekoEvent;
import com.koneko.consulting.vo.Dept;

@ContextConfiguration(locations = { "classpath:spring-base.xml" })
public class TestConversionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestConversionService.class);

	@Test
	public void test() {
		LOGGER.info("============测试开始===========");
		LOGGER.info("执行结果：{}");
		LOGGER.info("============测试结束===========");
	}
	@Test
	public void testI18N() {
		LOGGER.info("============测试开始===========");
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();	
		messageSource.setBasenames("i18n.Message");
		LOGGER.info("【Message默认资源】koneko-site = ：{}", messageSource.getMessage("koneko.site", null ,null));
		LOGGER.info("【Message中文资源】koneko-site = ：{}", messageSource.getMessage("koneko.site", null ,new Locale("zh","CN")));
		LOGGER.info("【Message英文资源】koneko-site = ：{}", messageSource.getMessage("koneko.site", null ,new Locale("en","US")));
		LOGGER.info("============测试结束===========");
	}
	@Test
	public void testEvent() {
		LOGGER.info("============测试开始===========");
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		con.register(KonekoEventConfig.class);
		con.refresh();
		KonekoEvent event = new KonekoEvent("【koneko.consulting】");
		con.publishEvent(event);
		LOGGER.info("============测试结束===========");
	}
	
	@Test
	public void testEnvironment() {
		LOGGER.info("============测试开始===========");
		ConfigurableApplicationContext con = new ClassPathXmlApplicationContext("spring-base.xml");
		ConfigurableEnvironment environment = con.getEnvironment();
		LOGGER.info("当前JDK版本：{}",environment.getProperty("java.specification.version"));
		LOGGER.info("============测试结束===========");
	}
	
	@Test
	public void testApplicationContext() {
		ApplicationContext con = new FileSystemXmlApplicationContext("c:\\laoyang\\spring-base.xml");
		LOGGER.info("============测试开始===========");
		Dept dept = con.getBean("dept",Dept.class);
		LOGGER.info("执行结果：{}",dept);
		LOGGER.info("============测试结束===========");
	}
	
	@Test
	public void testConversionService() {
		ConfigurableEnvironment environment = new StandardEnvironment();
		ConfigurableConversionService service = environment.getConversionService();
		Double num = service.convert("6.5", Double.class);
		LOGGER.info("num + 10 = {}",num + 10);
	}
	
}
