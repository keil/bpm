package de.keil.bpm.basic.core;

public enum Beat {
	BEAT44("4/4 Beat", 4);
	
	private String value;
	private int beats;
	
	Beat(String arg0, int arg1) {
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
