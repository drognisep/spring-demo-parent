package com.luv2code.springdemo;

public class SoccorCoach implements Coach {
	private FortuneService fortuneSvc;
	
	public SoccorCoach() {}
	
	public SoccorCoach(FortuneService service) {
		this.fortuneSvc = service;
	}

	@Override
	public String getDailyWorkout() {
		return "Run until you die from it!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneSvc.getFortune();
	}
}
