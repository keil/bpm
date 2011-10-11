/**
 * 
 */
package de.keil.bpm.basic.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import de.keil.bpm.basic.core.Calculator;

/**
 * @author keil
 * 
 */
public class MainFrame extends Frame implements WindowListener, KeyListener {

	private ArrayList<Long> timestamps;
	private long lastTimestamp;

	public MainFrame() {
		super("basic bpm");

		Dimension frameSize = new Dimension(400, 600);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int topLocation = (screenSize.height - frameSize.height) / 2;
		int leftLocation = (screenSize.width - frameSize.width) / 2;

		setSize(frameSize);
		setLocation(leftLocation, topLocation);
		setVisible(true);

		timestamps = new ArrayList<Long>();
		lastTimestamp = 0;

		init();

		addWindowListener(this);
		addKeyListener(this);
	}

	private void init() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		System.out.println("\n##### ENTER");

		if (lastTimestamp == 0) {
			lastTimestamp = System.currentTimeMillis();
		} else {
			long nowTimestamp = System.currentTimeMillis();
			long deltaTimestamp = nowTimestamp - lastTimestamp;
			lastTimestamp = nowTimestamp;
			
			
			
			timestamps.add(deltaTimestamp);
			double meanTimestamp = Calculator.meanFilter(timestamps);
			
			/* */ System.out.print(" ### mean delta: " + meanTimestamp);
			/* */ System.out.print(" ### delta: " + deltaTimestamp);
			/* */ System.out.print("\n");
			
			double meanBreaks = 60000/meanTimestamp;
			
			/* */ System.out.print(" ### breaks: " + meanBreaks);
			/* */ System.out.print("\n"); 
			
			double meanTacks = meanBreaks/2;
			
			/* */ System.out.print(" ### mean tacks: " + meanTacks);
			/* */ System.out.print(" ### tacks: " + (60000/deltaTimestamp)/2);
			/* */ System.out.print("\n");

			//long result = 60000 / delta;

			//System.out.println("### result " + result);

			//long tackt = result / 2;

			DecimalFormat format = new DecimalFormat("0.00");
			String result = format.format(meanTacks);
			
			System.out.println("##### TACKT " + Math.round(meanTacks));
			System.out.println("##### TACKT " + result	 + "\n\n");

			//lastTimestamp = now;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(NORMAL);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent
	 * )
	 */
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent
	 * )
	 */
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
