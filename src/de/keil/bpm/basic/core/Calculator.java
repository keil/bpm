package de.keil.bpm.basic.core;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// todo anschläge in de ´n letzen 15/30 sec

import de.keil.bpm.basic.interfaces.Observer;

public class Calculator {

	private List<Observer> observer;
	
	private ArrayList<Long> deltaTimestamps;
	private long lastTimestamp;

	private ArrayList<Long> timeFrame;
	
	private int beats;
	private int measure;
	
	// formatter
	private DecimalFormat format1 = new DecimalFormat("0.0");
	private DecimalFormat format2 = new DecimalFormat("0.00");
	
	/**
	 * @param beats
	 * @param measure
	 */
	public Calculator(Beat beat, Measure measure) {
		this.observer = new ArrayList<Observer>();

		this.beats = beat.beats();
		this.measure = measure.beats();

		this.deltaTimestamps = new ArrayList<Long>();
		this.timeFrame = new ArrayList<Long>();
		this.lastTimestamp = 0;
	}
	
	/**
	 * @param beats
	 * @param measure
	 * @param observers
	 */
	public Calculator(Beat beat, Measure measure, Observer... observers) {
		this(beat, measure);
		for (Observer observer : observers) {
			this.observer.add(observer);	
		}
	}
	
	/**
	 * @param observers
	 */
	public void addObserver(Observer... observers) {
		for (Observer observer : observers) {
			this.observer.add(observer);	
		}
	}

	/**
	 * @param observers
	 */
	public void removeObserver(Observer... observers) {
		for (Observer observer : observers) {
			this.observer.remove(observer);	
		}
	}
	
	/**
	 * triggers new signal
	 */
	public void trigger() {
		if (lastTimestamp == 0) {
			lastTimestamp = System.currentTimeMillis();
		} else {
			long nowTimestamp = System.currentTimeMillis();
			long deltaTimestamp = nowTimestamp - lastTimestamp;
			lastTimestamp = nowTimestamp;

			deltaTimestamps.add(deltaTimestamp);
			shiftTimeFrame(deltaTimestamp);
			
			// mean
			// TODO, do not use 10er variant
			double meanTimestamp = Calculator.meanFilter(deltaTimestamps);
			double meanBeats = 60000 / meanTimestamp;
			double meanBar = meanBeats / measure;
			
//			double meanTimestamp = Calculator.meanFilter(timeFrame);
//			double meanBeats = 60000 / meanTimestamp;
//			double meanBar = meanBeats / recordedBeats;
			
			// current
			double currentBeats = 60000 / deltaTimestamp;
			double currentBar = meanBeats / measure;

			// variance
			double variance = Calculator.varianceFilter(deltaTimestamps);
			double upperTimestamp = meanTimestamp - variance;
			double upperBeats = 60000 / upperTimestamp;
			double upperBar = upperBeats / measure;
			double lowerTimestamp = meanTimestamp + variance;
			double lowerBeats = 60000 / lowerTimestamp;
			double lowerBar = lowerBeats / measure;

			// TODO: last ten elements

			// TOFO: fehler varianz



			// call observer 
			for (Observer observer : this.observer) {
				observer.triggerMeanValue(format1.format(meanBar));
				observer.triggerMeanValueR(Double.toString(Math.round(meanBar)));
				observer.triggerCurrentValue(format2.format(currentBar));
				observer.triggerMeanUpperValue(format1.format(upperBar));
				observer.triggerMeanLowerValue(format1.format(lowerBar));
			}
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
			sum += Math.abs(delta);
			counter++;
		}
		return sum/counter;
	}
}
