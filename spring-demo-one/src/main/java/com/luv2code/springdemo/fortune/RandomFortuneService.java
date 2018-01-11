package com.luv2code.springdemo.fortune;

import java.util.Random;

import com.luv2code.springdemo.FortuneService;

public class RandomFortuneService implements FortuneService {
	private String[] fortunes = { "You gonna die!", "The weather will hold up today", "Bye, Felicia" };
	private Random r = new Random();
	
	@Override
	public String getFortune() {
		return fortunes[r.nextInt(fortunes.length)];
	}
}
