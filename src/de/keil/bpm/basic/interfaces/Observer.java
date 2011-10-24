package de.keil.bpm.basic.interfaces;

/**
 * @author Roman Matthias Keil
 */
public interface Observer {

	/**
	 * @param value
	 */
	void triggerMeanValue(String value);

	/**
	 * @param value
	 */
	void triggerMeanValueRounded(String value);

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

	/**
	 * @param value
	 */
	void triggerMean10Value(String value);

	/**
	 * @param value
	 */
	void triggerMean10ValueRounded(String value);


}
