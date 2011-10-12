package de.keil.bpm.basic.core;

import java.text.DecimalFormat;
import java.util.ArrayList;

import de.keil.bpm.basic.interfaces.Observer;

public class Calculator {
	
	private Observer observer;
	
	private ArrayList<Long> timestamps;
	private long lastTimestamp;

	private ArrayList<Long> timeFrame;
	
	public Calculator(Observer observer) {
		this.observer = observer;
		
		timestamps = new ArrayList<Long>();
		timeFrame = new ArrayList<Long>();
		lastTimestamp = 0;
	}
	
	public void trigger() {
		System.out.println("\n##### ENTER");

		if (lastTimestamp == 0) {
			lastTimestamp = System.currentTimeMillis();
		} else {
			long nowTimestamp = System.currentTimeMillis();
			long deltaTimestamp = nowTimestamp - lastTimestamp;
			lastTimestamp = nowTimestamp;

			timestamps.add(deltaTimestamp);
			shiftTimeFrame(deltaTimestamp);
			// double meanTimestamp = Calculator.meanFilter(timestamps);
			double meanTimestamp = Calculator.meanFilter(timeFrame);

			/* */System.out.print(" ### mean delta: " + meanTimestamp);
			/* */System.out.print(" ### delta: " + deltaTimestamp);
			/* */System.out.print("\n");

			double meanBreaks = 60000 / meanTimestamp;

			/* */System.out.print(" ### breaks: " + meanBreaks);
			/* */System.out.print("\n");

			double meanTacks = meanBreaks / 2;

			/* */System.out.print(" ### mean tacks: " + meanTacks);
			/* */System.out
					.print(" ### tacks: " + (60000 / deltaTimestamp) / 2);
			/* */System.out.print("\n");

			// long result = 60000 / delta;

			// System.out.println("### result " + result);

			// long tackt = result / 2;

			DecimalFormat format = new DecimalFormat("0.00");
			String result = format.format(meanTacks);

			System.out.println("##### TACKT " + Math.round(meanTacks));
			System.out.println("##### TACKT " + result + "\n");

			double variance = Calculator.varianceFilter(timestamps);

			/* */System.out.println("currwent " + meanTimestamp);
			/* */System.out.println("meanTimestamp " + deltaTimestamp);
			/* */System.out.println("variance " + variance);

			double upper = meanTimestamp + variance;
			double lower = meanTimestamp - variance;

			/* */System.out.println(" ### TACKT(upper) "
					+ format.format((60000 / upper) / 2));
			/* */System.out.println(" ### TACKT(lower) "
					+ format.format((60000 / lower) / 2));
			/* */System.out.print("\n");

			// lastTimestamp = now;

		}
		
		
		String value = "@";
		observer.triggerMeanValue(value);
		observer.triggerMeanValueR(value);
		observer.triggerCurrentValue(value);
		observer.triggerMeanUpperValue(value);
		observer.triggerMeanLowerValue(value);
	}
	
	private void shiftTimeFrame(long value) {
		if (timeFrame.size() > 10)
			timeFrame.remove(0);
		timeFrame.add(value);
	}
	
	
	//////////////////////////////////////////////////
	// STATIC
	//////////////////////////////////////////////////
	
	/**
	 * @param source
	 * @return
	 */
	public static double meanFilter(ArrayList<Long> source) {
		int counter = 0;
		double sum = 0;

		for (long l : source) {
			counter++;
			sum += l;
		}

		return sum/counter;
	}

	/**
	 * @param source
	 * @return
	 */
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
