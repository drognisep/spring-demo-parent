package com.luv2code.springdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.MissingServletRequestParameterException;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@RequestParam("studentName") String name, Model model) {
		System.out.println("Value of message: " + name);
		model.addAttribute("message", "Yo! " + name.toUpperCase() + "!");
		return "helloworld";
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String missingParam() {
		System.err.println("\nMissing parameter in HelloWorldController\n");
		return "main-menu";
	}
}
