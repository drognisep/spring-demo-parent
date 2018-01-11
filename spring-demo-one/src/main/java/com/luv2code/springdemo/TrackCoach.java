package com.luv2code.springdemo;

import com.luv2code.springdemo.fortune.HappyFortuneService;

public class TrackCoach implements Coach {
	FortuneService fortuneSvc = new HappyFortuneService();

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Compile time coupling to concrete implementation (gross): " + fortuneSvc.getFortune();
	}

}
