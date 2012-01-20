package de.keil.bpm.basic.gui;

/**
 * @author keil
 *
 */
public enum Color {
	 HEAD(new java.awt.Color(204, 204, 204)),
	 BODY(new java.awt.Color(221, 221, 221)),
	 RED(new java.awt.Color(204, 00, 00)),
	 GREEN(new java.awt.Color(00, 204, 00)),
	 BLUE(new java.awt.Color(00, 44, 77)),
	 GRAY(new java.awt.Color(33, 33, 33));

	 private java.awt.Color mColor;

	 /**
	 * @param c
	 */
	private Color(java.awt.Color c) {
		 mColor = c;
	 }

	 /**
	 * @return Color
	 */
	public java.awt.Color getColor() {
	   return mColor;
	 }
}
