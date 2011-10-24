/**
 * 
 */
package de.keil.bpm.basic.gui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import de.keil.bpm.basic.core.Beat;
import de.keil.bpm.basic.core.Calculator;
import de.keil.bpm.basic.core.Measure;
import de.keil.bpm.basic.interfaces.Observer;

// TOFDO, nur die letzten 10 werte buchen
// zweite berechnungsvariante
// reset taste, menue zum faktor einstellen , tackt einstellen

/**
 * @author keil
 * 
 */
public class MainFrame extends Frame implements WindowListener, KeyListener, Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private ArrayList<Long> timestamps;
	// private long lastTimestamp;
	//
	// private ArrayList<Long> timeFrame;

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

	private Choice cBeat;
	private Choice cMeasure;

	// LABELS
	private Label lBeat;
	private Label lMeasure;

	private Label lMeanLabel;
	private Label lMeanValue;
	private Label lMeanLabelRounded;
	private Label lMeanValueRounded;

	private Label lCurrentLabel;
	private Label lCurrentValue;
	private Label lMeanUpperLabel;
	private Label lMeanUpperValue;
	private Label lMeanLowerLabel;
	private Label lMeanLowerValue;

	private Label lMean10Label;
	private Label lMean10Value;
	private Label lMean10LabelRounded;
	private Label lMean10ValueRounded;

	// TODO 10 messungs state
	// TODO: Drop down Box

	private Calculator bpmCalculator;

	private Beat defaultBeat = Beat.BEAT44;
	private Measure defaultMeasure = Measure.BEATS2;

	public MainFrame() {
		super("basic bpm");

		// bpmCalculator = new Calculator(defaultBeats, defaultMeasure, this);
		// // TODO, selection

		initCalculator();
		initGUI();
		clear();

		Dimension frameSize = new Dimension(400, 600);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int topLocation = (screenSize.height - frameSize.height) / 2;
		int leftLocation = (screenSize.width - frameSize.width) / 2;

		setSize(frameSize);
		setLocation(leftLocation, topLocation);

		setVisible(true);

		addWindowListener(this);
		addKeyListener(this);
	}

	private void initCalculator() {
		bpmCalculator = new Calculator(defaultBeat, defaultMeasure, this);
	}

	private void initGUI() {
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

		lBeat = new Label("Beat:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 100;
		topPanel.add(lBeat, c);

		cBeat = new Choice();
		cBeat.add(Beat.BEAT44.toString());
		cBeat.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().toString().equals(Beat.BEAT44)) {
					defaultBeat = Beat.BEAT44;
				}
				initCalculator();
				clear();
			}
		});
		cBeat.select(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 100;
		topPanel.add(cBeat, c);

		lMeasure = new Label("Measure:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 100;
		topPanel.add(lMeasure, c);

		cMeasure = new Choice();
		cMeasure.add(Measure.BEATS1.toString());
		cMeasure.add(Measure.BEATS2.toString());
		cMeasure.add(Measure.BEATS4.toString());
		cMeasure.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().toString().equals(Measure.BEATS1)) {
					defaultMeasure = Measure.BEATS1;
				} else if (e.getItem().toString().equals(Measure.BEATS2)) {
					defaultMeasure = Measure.BEATS2;
				} else if (e.getItem().toString().equals(Measure.BEATS4)) {
					defaultMeasure = Measure.BEATS4;
				}
				initCalculator();
				clear();
			}
		});
		cMeasure.select(1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 100;
		topPanel.add(cMeasure, c);

		bClear = new Button("clear");
		bClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		topPanel.add(bClear, c);

		bStart = new Button("start");
		bStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
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

		lMeanLabelRounded = new Label("Mean");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		leftPanel.add(lMeanLabelRounded, c);

		lMeanValueRounded = new Label(defaultNumber);
		lMeanValueRounded.setFont(fontValueNormal);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		leftPanel.add(lMeanValueRounded, c);

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

		// /////////

		// TODO SPACE LINE
		
		// /////////

		// /////

		// TODO: erster größer
		lMean10Label = new Label("Frame");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		rightPanel.add(lMean10Label, c);

		lMean10Value = new Label(defaultDouble1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		rightPanel.add(lMean10Value, c);

		lMean10LabelRounded = new Label("Frame");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		rightPanel.add(lMean10LabelRounded, c);

		lMean10ValueRounded = new Label(defaultNumber);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		rightPanel.add(lMean10ValueRounded, c);

		// TODO Active panel

		// ////////////////////////////////////////////////
		// BASE
		// ////////////////////////////////////////////////

		// c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.weightx = 400;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		add(topPanel, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
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
		lMeanValueRounded.setText(defaultNumber);
		lCurrentValue.setText(defaultDouble2);
		lMeanUpperValue.setText(defaultDouble1);
		lMeanLowerValue.setText(defaultDouble1);
		lMean10Value.setText(defaultDouble1);
		lMean10ValueRounded.setText(defaultNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		this.bpmCalculator.trigger();
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
	 * 
	 * @see
	 * de.keil.bpm.basic.interfaces.Observer#triggerMeanValue(java.lang.String)
	 */
	@Override
	public void triggerMeanValue(String value) {
		lMeanValue.setText(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.keil.bpm.basic.interfaces.Observer#triggerMeanValueR(java.lang.String)
	 */
	@Override
	public void triggerMeanValueRounded(String value) {
		lMeanValueRounded.setText(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.keil.bpm.basic.interfaces.Observer#triggerCurrentValue(java.lang.String
	 * )
	 */
	@Override
	public void triggerCurrentValue(String value) {
		lCurrentValue.setText(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.keil.bpm.basic.interfaces.Observer#triggerMeanUpperValue(java.lang
	 * .String)
	 */
	@Override
	public void triggerMeanUpperValue(String value) {
		lMeanUpperValue.setText(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.keil.bpm.basic.interfaces.Observer#triggerMeanLowerValue(java.lang
	 * .String)
	 */
	@Override
	public void triggerMeanLowerValue(String value) {
		lMeanLowerValue.setText(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.keil.bpm.basic.interfaces.Observer#triggerMean10Value(java.lang.String
	 * )
	 */
	@Override
	public void triggerMean10Value(String value) {
		lMean10Value.setText(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.keil.bpm.basic.interfaces.Observer#triggerMean10ValueRounded(java.
	 * lang.String)
	 */
	@Override
	public void triggerMean10ValueRounded(String value) {
		lMean10ValueRounded.setText(value);
	}

}
