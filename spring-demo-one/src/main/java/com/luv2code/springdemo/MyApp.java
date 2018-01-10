package com.luv2code.springdemo;

public class MyApp {
	public static void main(String[] args) {
		// CREATE THE OBJECT
		Coach theCoach = new TrackCoach();
		// USE THE OBJECT
		System.out.println(theCoach.getDailyWorkout());
	}
}
