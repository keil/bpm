package de.keil.bpm.basic.gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.keil.bpm.basic.BasicBPM;

/**
 * @author keil
 *
 */
public class LicenseFrame extends Frame implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BasicBPM basicBPM;

	private Font fontLabelSmall = new Font(Font.SANS_SERIF, Font.PLAIN, 12);

	private Button bRun;
	private Button bClose;

	private Checkbox cAccept;
	private TextArea tText;

	private File file = new File("LICENSE");
	private String license = "";

	public LicenseFrame(BasicBPM observer) {
		super("Terms of Use");

		// TODO user interface
		basicBPM = observer;

		try {
			this.license = readLicense();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(ERROR);
		}

		initGUI();

		Dimension frameSize = new Dimension(600, 400);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int topLocation = (screenSize.height - frameSize.height) / 2;
		int leftLocation = (screenSize.width - frameSize.width) / 2;

		setSize(frameSize);
		setLocation(leftLocation, topLocation);

		addWindowListener(this);

		pack();
		requestFocus();

		setVisible(true);
	}

	private void initGUI() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(layout);

		tText = new TextArea();
		tText.setText(this.license);
		tText.setFont(fontLabelSmall);
		tText.setForeground(Color.BLUE.getColor());
		tText.setSize(600, 400);
		tText.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 600;
		add(tText, c);

		cAccept = new Checkbox("I signify my agreement to the Terms of Use",
				false);
		cAccept.setFont(fontLabelSmall);
		cAccept.setForeground(Color.BLUE.getColor());
		cAccept.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					bRun.setEnabled(true);
				} else if (arg0.getStateChange() == ItemEvent.DESELECTED) {
					bRun.setEnabled(false);
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 600;
		add(cAccept, c);

		Panel basePanel = new Panel();
		basePanel.setSize(50, 200);
		basePanel.setBackground(Color.BODY.getColor());
		basePanel.setLayout(new GridBagLayout());

		bClose = new Button("close");
		bClose.setFont(fontLabelSmall);
		bClose.setForeground(Color.GRAY.getColor());
		bClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 100;
		basePanel.add(bClose, c);

		bRun = new Button("accept");
		bRun.setFont(fontLabelSmall);
		bRun.setForeground(Color.GRAY.getColor());
		bRun.setEnabled(false);
		bRun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				basicBPM.run();

				// this.dispatchEvent(new WindowEvent(this,
				// WindowEvent.WINDOW_CLOSING));
				// .
				// TODO
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 100;
		basePanel.add(bRun, c);

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 600;
		add(basePanel, c);
	}

	private String readLicense() throws IOException {
		StringBuffer buffer = new StringBuffer();

		BufferedReader reader = new BufferedReader(new FileReader(file));

		String line = reader.readLine();

		while (line != null) {
			buffer.append(line);
			buffer.append("\n");
			line = reader.readLine();
		}

		return buffer.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(WindowEvent arg0) {
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
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowOpened(WindowEvent arg0) {
	}
}