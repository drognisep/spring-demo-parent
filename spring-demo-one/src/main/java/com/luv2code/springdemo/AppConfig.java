package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.luv2code.springdemo.fortune.HappyFortuneService;

@Configuration
/*
 * This is the configuration class (can have multiple), it defines beans that the business code of the application can consume
 * without caring about the implementation details. THIS is IoC.
 * 
 * The method name is the default bean ID, but this can be overridden.
 */
public class AppConfig {
	@Bean
	@Scope(value="prototype") // Tells Spring to NOT return singletons, or stated in reverse, to always return a new instance.
	public FortuneService fortuneService() {
		// Return this app's FortuneService implementation, we can change this any time we want.
		return new HappyFortuneService();
	}
	
	@Bean
	public Coach theCoach() {
		// Beans can rely on other beans, and it's all opaque to the consumer. Nice!
		return new SoccorCoach(fortuneService());
	}
}
