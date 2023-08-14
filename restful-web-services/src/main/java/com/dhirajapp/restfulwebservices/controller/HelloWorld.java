package com.dhirajapp.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
  
	@GetMapping(path="/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean ("Hello World");
		
	}
}
