package com.luv2code.springdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.mvc.beans.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		// Create new student object
		Student student = new Student();
		// Add object to model
		model.addAttribute("student", student);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println("The Student: " + student);
		return "student-confirmation";
	}
}
