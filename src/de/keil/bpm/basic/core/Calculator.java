package de.keil.bpm.basic.core;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// todo anschläge in de ´n letzen 15/30 sec

import de.keil.bpm.basic.interfaces.Observer;

/**
 * @author Roman Matthias Keil
 */
public class Calculator {

	/**
	 * observer
	 */
	private List<Observer> observer;

	/**
	 * list of delta timestamps
	 */
	private ArrayList<Long> deltaTimestamps;
	/**
	 * last timestamp
	 */
	private long lastTimestamp;

	/**
	 * list of delta timestamps
	 */
	private ArrayList<Long> timeFrame;

	/**
	 * base measure
	 */
	private int measure;

	/**
	 * standard formatter
	 */
	private DecimalFormat format1 = new DecimalFormat("0.0");
	/**
	 * standard formatter
	 */
	private DecimalFormat format2 = new DecimalFormat("0.00");

	/**
	 * @param beats
	 * @param measure
	 */
	public Calculator(Beat beat, Measure measure) {
		this.observer = new ArrayList<Observer>();

		this.measure = beat.beats() / measure.beats();

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

	// ////////////////////////////////////////////////
	// TRIGGER CALCULATOR
	// ////////////////////////////////////////////////

	/**
	 * triggers new signal
	 */
	/**
	 * 
	 */
	public void trigger() {
		if (lastTimestamp == 0) {
			lastTimestamp = System.currentTimeMillis();
		} else {
			// timestamp
			long nowTimestamp = System.currentTimeMillis();
			long deltaTimestamp = nowTimestamp - lastTimestamp;
			lastTimestamp = nowTimestamp;

			// set timestamp
			deltaTimestamps.add(deltaTimestamp);
			shiftTimeFrame(deltaTimestamp);

			// mean
			double meanTimestamp = Calculator.meanFilter(deltaTimestamps);
			double meanMeasure = 60000 / meanTimestamp;
			double meanBeat = meanMeasure / measure;

			// frame
			double meanFrameTimestamp = Calculator.meanFilter(timeFrame);
			double meanFrameMeasure = 60000 / meanFrameTimestamp;
			double meanFrameBeat = meanFrameMeasure / measure;

			// current
			double currentMeasure = 60000 / deltaTimestamp;
			double currentBeat = currentMeasure / measure;

			// variance
			double variance = Calculator.varianceFilter(deltaTimestamps);
			double upperTimestamp = meanTimestamp - variance;
			double upperMeasure = 60000 / upperTimestamp;
			double upperBeat = upperMeasure / measure;
			double lowerTimestamp = meanTimestamp + variance;
			double lowerMeasure = 60000 / lowerTimestamp;
			double lowerBeat = lowerMeasure / measure;

			// call observer
			for (Observer observer : this.observer) {
				// mean value
				observer.triggerMeanValue(format1.format(meanBeat));
				observer.triggerMeanValueRounded(Double.toString(Math.round(meanBeat)));

				// current
				observer.triggerCurrentValue(format2.format(currentBeat));
				// variance
				observer.triggerMeanUpperValue(format1.format(upperBeat));
				observer.triggerMeanLowerValue(format1.format(lowerBeat));

				// mean10
				observer.triggerMean10Value(format1.format(meanFrameBeat));
				observer.triggerMean10ValueRounded(Double.toString(Math.round(meanFrameBeat)));
			}
		}
	}

	/**
	 * @param value
	 */
	private void shiftTimeFrame(long value) {
		if (timeFrame.size() > 10)
			timeFrame.remove(0);
		timeFrame.add(value);
	}

	// ////////////////////////////////////////////////
	// STATIC
	// ////////////////////////////////////////////////

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

		return sum / counter;
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
			double delta = (l - mean);
			sum += Math.abs(delta);
			counter++;
		}
		return sum / counter;
	}
}