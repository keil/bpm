/**
 * 
 */
package de.keil.bpm;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.keil.bpm.option.Options;

/**
 * @author Matthias
 * 
 */
public class Main {

	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.setLevel(Level.FINEST);
		
		// HEADER
		System.out.println("### BPM ###");
		System.out.println("© Matthias Keil\n");
		
		
		// TODO Auto-generated method stub

		// OPTIONS
		Set<File> files = new HashSet<File>();
		for (String arg : args) {
			/* LOGGER */ LOGGER.finest("OPTION: " + arg); 
			if (arg.startsWith("-") && arg.length() > 1) {
				if (!Options.set(arg)) {
					/* LOGGER */ LOGGER.severe("Option not recognized: " + arg);
					System.exit(0);
				}
			} else {
				File file = new File(arg);
				if (!file.exists()) {
					/* LOGGER */ LOGGER.severe("File not exists: " + arg);
					System.exit(0);					
				} else {
					files.add(new File(arg));
				}
			}
		}

		if (files.isEmpty()) {
			/* LOGGER */ LOGGER.severe("No files");
			System.exit(0);
		}
		
		

		
		// Test
		
//		Frame f = new Frame();

		


	}

}
