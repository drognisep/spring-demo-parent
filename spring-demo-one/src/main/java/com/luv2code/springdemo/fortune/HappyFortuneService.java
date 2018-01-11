package com.luv2code.springdemo.fortune;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {
	@Override
	public String getFortune() {
		return "Today is going to be a great day!";
	}
}
