package de.keil.bpm.basic.core;

import java.text.DecimalFormat;
import java.util.ArrayList;

import de.keil.bpm.basic.interfaces.Observer;

public class Calculator {
	
	private Observer observer;
	
	private ArrayList<Long> timestamps;
	private long lastTimestamp;

	private ArrayList<Long> timeFrame;
	
	private int beatsPerBar;
	private int recordedBeats;
	
	public Calculator(Observer observer, int beatsPerBar, int recordedBeats) {
		this.observer = observer;
		
		this.beatsPerBar = beatsPerBar;
		this.recordedBeats = recordedBeats;
		
		timestamps = new ArrayList<Long>();
		timeFrame = new ArrayList<Long>();
		lastTimestamp = 0;
	}
	
	public void trigger() {
		if (lastTimestamp == 0) {
			lastTimestamp = System.currentTimeMillis();
		} else {
			long nowTimestamp = System.currentTimeMillis();
			long deltaTimestamp = nowTimestamp - lastTimestamp;
			lastTimestamp = nowTimestamp;

			timestamps.add(deltaTimestamp);
			shiftTimeFrame(deltaTimestamp);
			
			// mean
			double meanTimestamp = Calculator.meanFilter(timeFrame);
			double meanBeats = 60000 / meanTimestamp;
			double meanBar = meanBeats / recordedBeats;
			
			// current
			double currentBeats = 60000 / deltaTimestamp;
			double currentBar = meanBeats / recordedBeats;

			// variance
			double variance = Calculator.varianceFilter(timestamps);
			double upperTimestamp = meanTimestamp + variance;
			double upperBeats = 60000 / upperTimestamp;
			double upperBar = upperBeats / recordedBeats;
			double lowerTimestamp = meanTimestamp - variance;
			double lowerBeats = 60000 / lowerTimestamp;
			double lowerBar = lowerBeats / recordedBeats;



			DecimalFormat format1 = new DecimalFormat("0.0");
			DecimalFormat format2 = new DecimalFormat("0.00");
			
			observer.triggerMeanValue(format1.format(meanBar));
			observer.triggerMeanValueR(Double.toString(Math.round(meanBar)));
			observer.triggerCurrentValue(format2.format(currentBar));
			observer.triggerMeanUpperValue(format1.format(upperBar));
			observer.triggerMeanLowerValue(format1.format(lowerBar));
		}
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
