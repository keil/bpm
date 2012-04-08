package de.keil.bpm.basic.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class LicenseWindow {

	public LicenseWindow(Display display) {
		Shell shell = new Shell(display);
		
		Point windowsSize = new Point(800, 600);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		//int topLocation = (screenSize.height - frameSize.height) / 2;
		//int leftLocation = (screenSize.width - frameSize.width) / 2;

		shell.setSize(windowsSize);
//		shell.setFullScreen(true);
		//setLocation(leftLocation, topLocation);

		//addWindowListener(this);

		//pack();
		//requestFocus();

		//setVisible(true);
		
//		shell.open();
//		display.sleep();
//		display.dispose();
		
		shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Display display = new Display();
		new LicenseWindow(display);
	}
}



