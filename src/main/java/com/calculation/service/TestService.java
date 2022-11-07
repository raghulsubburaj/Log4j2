package com.calculation.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public long add(long number1, long number2) {
		
		long addition = number1 + number2;

		return addition;

	}

	public long sub(long number1, long number2) {
		
		long subtraction = number1 - number2;

		return subtraction ;

	}

	public long mul(long number1, long number2) {
		
		long multiplication = number1 * number2;

		return multiplication;

	}

	public long div(long number1, long number2) {
		
		long division = number1 / number2;

		return division;

	}


}
