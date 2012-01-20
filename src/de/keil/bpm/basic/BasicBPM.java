package de.keil.bpm.basic;

import de.keil.bpm.basic.gui.LicenseFrame;
import de.keil.bpm.basic.gui.MainFrame;

public class BasicBPM {

	/**
	 * 
	 */
	public BasicBPM() {
		new LicenseFrame(this);

	}

	/**
	 * 
	 */
	public void run() {
		// Main Frame
		new MainFrame();

	}
}
