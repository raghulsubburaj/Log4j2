package com.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages=("com.calculation"))
public class ArithmeticOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArithmeticOperationApplication.class, args);
	}

}
