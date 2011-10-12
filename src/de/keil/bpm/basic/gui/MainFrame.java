/**
 * 
 */
package de.keil.bpm.basic.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import de.keil.bpm.basic.core.Calculator;
import de.keil.bpm.basic.interfaces.Observer;

// TOFDO, nur die letzten 10 werte buchen
// zweite berechnungsvariante
// reset taste, menue zum faktor einstellen , tackt einstellen

/**
 * @author keil
 * 
 */
public class MainFrame extends Frame implements WindowListener, KeyListener,
		Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Long> timestamps;
	private long lastTimestamp;

	private ArrayList<Long> timeFrame;

	// FONTS
	private Font fontLabel = new Font(Font.SANS_SERIF, Font.PLAIN, 8);
	private Font fontValueNormal = new Font(Font.SANS_SERIF, Font.PLAIN, 28);
	private Font fontValueBig = new Font(Font.SANS_SERIF, Font.PLAIN, 32);

	// COLORS
	// TODO: Colors

	// DEFAULT TEXT
	private String defaultNumber = "00";
	private String defaultDouble1 = "00.0";
	private String defaultDouble2 = "00.00";

	// Button
	private Button bClear;
	private Button bStart;

	// LABELS
	private Label lMeanLabel;
	private Label lMeanValue;
	private Label lMeanLabelR;
	private Label lMeanValueR;

	private Label lCurrentLabel;
	private Label lCurrentValue;
	private Label lMeanUpperLabel;
	private Label lMeanUpperValue;
	private Label lMeanLowerLabel;
	private Label lMeanLowerValue;

	// TODO 10 messungs state
	// TODO: Drop down Box

	public MainFrame() {
		super("basic bpm");

		init();
		clear();

		Dimension frameSize = new Dimension(400, 600);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int topLocation = (screenSize.height - frameSize.height) / 2;
		int leftLocation = (screenSize.width - frameSize.width) / 2;

		setSize(frameSize);
		setLocation(leftLocation, topLocation);

		setVisible(true);

		timestamps = new ArrayList<Long>();
		timeFrame = new ArrayList<Long>();
		lastTimestamp = 0;

		addWindowListener(this);
		addKeyListener(this);
	}

	private void init() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(layout);

		// TOP PANEL
		Panel topPanel = new Panel();
		topPanel.setSize(new Dimension(500, 100));
		topPanel.setBackground(Color.PINK); // TODO
		topPanel.setLayout(new GridBagLayout());

		// LEFT PANEL
		Panel leftPanel = new Panel();
		leftPanel.setSize(300, 200);
		leftPanel.setBackground(Color.DARK_GRAY); // TODO
		leftPanel.setLayout(new GridBagLayout());

		// RIGHT PANEL
		Panel rightPanel = new Panel();
		rightPanel.setSize(200, 400);
		rightPanel.setBackground(Color.BLUE); // TODO
		rightPanel.setLayout(new GridBagLayout());

		// ////////////////////////////////////////////////
		// TOP
		// ////////////////////////////////////////////////

		bClear = new Button("clear");// TODO: action Listener
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		topPanel.add(bClear, c);

		bStart = new Button("start");// TODO: how to run ?
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		topPanel.add(bStart, c);

		// ////////////////////////////////////////////////
		// LEFT
		// ////////////////////////////////////////////////

		lMeanLabel = new Label("Mean");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		leftPanel.add(lMeanLabel, c);

		lMeanValue = new Label(defaultDouble1);
		lMeanValue.setFont(fontValueBig);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		leftPanel.add(lMeanValue, c);

		lMeanLabelR = new Label("Mean");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		leftPanel.add(lMeanLabelR, c);

		lMeanValueR = new Label(defaultNumber);
		lMeanValueR.setFont(fontValueNormal);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		leftPanel.add(lMeanValueR, c);

		// ////////////////////////////////////////////////
		// RIGHT
		// ////////////////////////////////////////////////

		lCurrentLabel = new Label("Current");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		rightPanel.add(lCurrentLabel, c);

		lCurrentValue = new Label(defaultDouble2);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		rightPanel.add(lCurrentValue, c);

		lMeanUpperLabel = new Label("Upper Variance");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		rightPanel.add(lMeanUpperLabel, c);

		lMeanUpperValue = new Label(defaultDouble1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		rightPanel.add(lMeanUpperValue, c);

		lMeanLowerLabel = new Label("Lower Variance");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		rightPanel.add(lMeanLowerLabel, c);

		lMeanLowerValue = new Label(defaultDouble1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		rightPanel.add(lMeanLowerValue, c);

		// ////////////////////////////////////////////////
		// BASE
		// ////////////////////////////////////////////////

		// c.fill = GridBagConstraints.HORIZONTAL;
		// c.weighty = 100;
		// c.gridx = 0;
		// c.gridy = 0;
		// add(topPanel, c);

		c.weightx = 300;
		c.weighty = 200;
		c.gridx = 0;
		c.gridy = 1;
		add(leftPanel, c);

		c.weightx = 200;
		c.weighty = 400;
		c.gridx = 1;
		c.gridy = 1;
		add(rightPanel, c);

	}

	private void clear() {
		lMeanValue.setText(defaultDouble1);
		lMeanValueR.setText(defaultNumber);
		lCurrentValue.setText(defaultDouble2);
		lMeanUpperValue.setText(defaultDouble1);
		lMeanLowerValue.setText(defaultDouble1);
	}

	private void add(long value) {
		if (timeFrame.size() > 10)
			timeFrame.remove(0);
		timeFrame.add(value);
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
			add(deltaTimestamp);
			// double meanTimestamp = Calculator.meanFilter(timestamps);
			double meanTimestamp = Calculator.meanFilter(timeFrame);

			/* */System.out.print(" ### mean delta: " + meanTimestamp);
			/* */System.out.print(" ### delta: " + deltaTimestamp);
			/* */System.out.print("\n");

			double meanBreaks = 60000 / meanTimestamp;

			/* */System.out.print(" ### breaks: " + meanBreaks);
			/* */System.out.print("\n");

			double meanTacks = meanBreaks / 2;

			/* */System.out.print(" ### mean tacks: " + meanTacks);
			/* */System.out
					.print(" ### tacks: " + (60000 / deltaTimestamp) / 2);
			/* */System.out.print("\n");

			// long result = 60000 / delta;

			// System.out.println("### result " + result);

			// long tackt = result / 2;

			DecimalFormat format = new DecimalFormat("0.00");
			String result = format.format(meanTacks);

			System.out.println("##### TACKT " + Math.round(meanTacks));
			System.out.println("##### TACKT " + result + "\n");

			double variance = Calculator.varianceFilter(timestamps);

			/* */System.out.println("currwent " + meanTimestamp);
			/* */System.out.println("meanTimestamp " + deltaTimestamp);
			/* */System.out.println("variance " + variance);

			double upper = meanTimestamp + variance;
			double lower = meanTimestamp - variance;

			/* */System.out.println(" ### TACKT(upper) "
					+ format.format((60000 / upper) / 2));
			/* */System.out.println(" ### TACKT(lower) "
					+ format.format((60000 / lower) / 2));
			/* */System.out.print("\n");

			// lastTimestamp = now;

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

	/*
	 * (non-Javadoc)
	 * @see de.keil.bpm.basic.interfaces.Observer#triggerMeanValue(java.lang.String)
	 */
	@Override
	public void triggerMeanValue(String value) {
		lMeanValue.setText(value);
	}

	/* (non-Javadoc)
	 * @see de.keil.bpm.basic.interfaces.Observer#triggerMeanValueR(java.lang.String)
	 */
	@Override
	public void triggerMeanValueR(String value) {
		lMeanValueR.setText(value);
	}

	/* (non-Javadoc)
	 * @see de.keil.bpm.basic.interfaces.Observer#triggerCurrentValue(java.lang.String)
	 */
	@Override
	public void triggerCurrentValue(String value) {
		lCurrentValue.setText(value);
	}

	/* (non-Javadoc)
	 * @see de.keil.bpm.basic.interfaces.Observer#triggerMeanUpperValue(java.lang.String)
	 */
	@Override
	public void triggerMeanUpperValue(String value) {
		lMeanUpperValue.setText(value);
	}

	/* (non-Javadoc)
	 * @see de.keil.bpm.basic.interfaces.Observer#triggerMeanLowerValue(java.lang.String)
	 */
	@Override
	public void triggerMeanLowerValue(String value) {
		lMeanLowerValue.setText(value);
	}

}
