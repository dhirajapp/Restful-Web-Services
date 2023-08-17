package com.dhirajapp.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@Autowired
	private MessageSource messageSource ;

	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");

	}
	
	@GetMapping(path = "/hello-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s" , name));

	}
	
	@GetMapping(path = "/hello-world-internationalized")
	 public String helloWorldInternationalized() {
	return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	 }
	
}
