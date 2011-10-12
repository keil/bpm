package de.keil.bpm.basic.interfaces;

public interface Observer {
	
	/**
	 * @param value
	 */
	void triggerMeanValue(String value);
	
	/**
	 * @param value
	 */
	void triggerMeanValueR(String value);
	
	/**
	 * @param value
	 */
	void triggerCurrentValue(String value);

	/**
	 * @param value
	 */
	void triggerMeanUpperValue(String value);
	
	/**
	 * @param value
	 */
	void triggerMeanLowerValue(String value);
}