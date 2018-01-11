package com.luv2code.springdemo;

public interface FortuneService {
	public default String getFortune() { return "No Fortune Service Available"; }
}
