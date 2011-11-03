package de.keil.bpm.basic;

import java.awt.SplashScreen;

import de.keil.bpm.basic.gui.MainFrame;

public class Main {

	public static void main(String[] args) {
		final SplashScreen splash = SplashScreen.getSplashScreen();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(splash!=null) splash.close();

		// Main Frame
		new MainFrame();
	}
}
