package de.keil.bpm.basic.gui;

/**
 * @author keil
 *
 */
public enum Font {
	 BIGLABEL(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 16)),
	 SMALLLABEL(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 12)),
	 BIGVALUE(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 32)),
	 NORMALVALUE(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 28)),
	 SMALLVALUE(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 20));

	 private java.awt.Font mFont;

	 /**
	 * @param f
	 */
	private Font(java.awt.Font f) {
		 mFont = f;
	 }

	 /**
	 * @return
	 */
	public java.awt.Font getFont() {
	   return mFont;
	 }
}