package com.dhirajapp.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

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
	
}
