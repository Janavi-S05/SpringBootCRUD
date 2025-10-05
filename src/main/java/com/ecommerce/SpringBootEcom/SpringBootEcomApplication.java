package com.ecommerce.SpringBootEcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEcomApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootEcomApplication.class, args);
		TestLombok t = TestLombok.builder().name("Janavi").age(22).build();
        TestLombok t1 = new TestLombok("Jan",17);
		System.out.println(t);
		System.out.println(t1); 

		// 		how this lombok got fixed? 
//		lombok.jar path is replaced by c:\lombok\lombok.jar previously 
//		it was in c:\Users\Janavi S\eclipse here janavi space might hv caused 
//		issues so replaced and in eclipse.ini added c:\lombok\lombok.jar path
	}

}
