package de.keil.bpm.basic.core;

public enum Measure {
	BEATS1("1 Beat", 1),
	BEATS2("2 Beats", 2),
	BEATS4("4 Beats", 4);

	private String value = "";
	private int beats;

	Measure(String arg0, int arg1) {
		this.value = arg0;
		this.beats = arg1;
	}

	public String toString() {
		return this.value;
	}

	public int beats() {
		return this.beats;
	}
}
