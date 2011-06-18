package de.keil.bmp.option;

public class Options {

	private static boolean DEBUG;

	private Options() {
		initialize();
	}

	public static String describe() {
		StringBuffer buffer = new StringBuffer();
		String newLine = "\n";

		buffer.append("Options:" + newLine);
		buffer.append("  -debug            Debug Mode" + newLine);

		return buffer.toString();
	}

	public static boolean set(String option) {
		if (option.equals("-debug"))
			DEBUG = true;
		else
			return false;
		return true;
	}

	public static void initialize() {
		DEBUG = false;
	}

	public static void reset() {
		initialize();
	}

	public static void dump() {
		StringBuffer buffer = new StringBuffer();
		String newLine = "\n";

		buffer.append("Options:" + newLine);
		buffer.append("  -debug            " + DEBUG);

		System.out.println(buffer.toString());
	}

	public static boolean isDebug() {
		return DEBUG;
	}
}