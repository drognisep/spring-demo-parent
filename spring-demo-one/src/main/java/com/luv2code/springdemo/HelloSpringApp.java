package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Spring IoC allows us to get configurable object instances *WITHOUT* compile time coupling in the business code.
 * By default 'Beans' are singletons (configurable).
 */
public class HelloSpringApp {
	// OLD way of configuring Spring apps with XML... Yuck.
//	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Coach theCoach = context.getBean("myCoach", Coach.class);
//		System.out.println(theCoach.getDailyWorkout());
//		context.close();
//	}
	public static void main(String[] args) {
		// Get context and tell Spring what class is handling our config
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // Transitive compile time dependency on concrete implementations
		// NO transitive dependency on concrete implementations (check the imports!) 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(new String[] { "com.luv2code.springdemo" }); // <-- Use base package(s) instead :-D
		
		// Only depends on interface = good design!
		System.out.println("Get 'Coach' by Class. Highlander rules, there can be only one.");
		Coach coach = context.getBean(Coach.class);
		
		printMessage(coach);
		
		System.out.println("Get 'Coach' by config ID (config method name)");
		
		// Actually the same instance, see below.
		Coach coach2 = (Coach) context.getBean("theCoach");
		printMessage(coach2);
		
		// Defaults to singletons
		System.out.println("Same 'Coach' instance between invocations? " + (coach == coach2));
		
		// Configured to NOT be singletons
		System.out.println("Same 'FortuneService' instance between invocations? " + (context.getBean("fortuneService") == context.getBean("fortuneService")));
		
		try {
			Coach xmlCoach = (Coach) context.getBean("myCoach");
			printMessage(xmlCoach);
		} catch(RuntimeException r) {
			System.out.println("\n" + r.getMessage() + "\nUh-oh! Can't pick up our XML configured beans because we used *annotation* base config instead!\n");
			try {
				ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				Coach xmlCoach = (Coach) xmlContext.getBean("myCoach");
				System.out.print("From XML configured bean: ");
				printMessage(xmlCoach);
				xmlContext.close();
			} catch(RuntimeException r2) {
				r2.printStackTrace();
				System.out.println("This won't happen, we're good :-)");
			}
		}
		
		// ApplicationContext#close() doesn't exist, have to use narrow reference to ensure resource safety :-(
		context.close();
	}

	private static void printMessage(Coach coach) {
		System.out.println(String.format("Today's workout is \"%s\", and your fortune is \"%s\"", coach.getDailyWorkout(), coach.getDailyFortune()));
	}
}
