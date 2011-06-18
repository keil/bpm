/**
 * 
 */
package de.keil.bmp;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import de.keil.bmp.option.Options;

/**
 * @author Matthias
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<File> files = new HashSet<File>();

		for (String arg : args) {
			if (arg.startsWith("-") && arg.length() > 1) {
				if (!Options.set(arg)) {
					System.out.println("Option not recognized: " + arg);
					System.out.print(Options.describe());
					System.exit(0);
				}
			} else {
				File file = new File(arg);
				if (!file.exists()) {

				} else {
					files.add(new File(arg));
				}

			}
		}

		if (files.isEmpty()) {
			System.out.println("No files");
			System.exit(0);
		}

		System.out.println("### BPM ###");
		System.out.println("© Matthias Keil\n");

	}

}
