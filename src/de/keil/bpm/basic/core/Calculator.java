package de.keil.bpm.basic.core;

import java.util.ArrayList;

public class Calculator {

	public static double meanFilter(ArrayList<Long> source) {
		int counter = 0;
		double sum = 0;

		for (long l : source) {
			counter++;
			sum += l;
		}

		return sum/counter;
	}

	
	public static double varianceFilter(ArrayList<Long> source) {
		double mean = Calculator.meanFilter(source);
		int counter = 0;
		double sum = 0;
		
		for (long l : source) {
			double delta = (l-mean);
			//sum += Math.pow(delta, 2);
			sum += Math.abs(delta);
			counter++;
		}

		return sum/counter;
	}
	
	
	
	
	
	
}
