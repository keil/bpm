import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import swing2swt.layout.BoxLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Composite;


public class Main {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(800, 600));
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new BorderLayout(0, 0));
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("Home");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmPreferences = new MenuItem(menu_1, SWT.NONE);
		mntmPreferences.setText("Preferences");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setText("Exit");
		
		MenuItem mntmBeat = new MenuItem(menu, SWT.CASCADE);
		mntmBeat.setText("Beat");
		
		Menu menu_2 = new Menu(mntmBeat);
		mntmBeat.setMenu(menu_2);
		
		MenuItem mntmBeat_1 = new MenuItem(menu_2, SWT.RADIO);
		mntmBeat_1.setSelection(true);
		mntmBeat_1.setText("4/4 Beat");
		
		MenuItem mntmMeasure = new MenuItem(menu, SWT.CASCADE);
		mntmMeasure.setText("Measure");
		
		Menu menu_3 = new Menu(mntmMeasure);
		mntmMeasure.setMenu(menu_3);
		
		MenuItem mntmNewRadiobutton = new MenuItem(menu_3, SWT.RADIO);
		mntmNewRadiobutton.setText("1 Beat");
		
		MenuItem mntmBeats = new MenuItem(menu_3, SWT.RADIO);
		mntmBeats.setSelection(true);
		mntmBeats.setText("2 Beats");
		
		MenuItem mntmBeats_1 = new MenuItem(menu_3, SWT.RADIO);
		mntmBeats_1.setText("4 Beats");
		
		MenuItem mntmClear = new MenuItem(menu, SWT.NONE);
		mntmClear.setText("Clear");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayoutData(BorderLayout.CENTER);
		composite.setLayout(null);
		
		Label label = new Label(composite, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 56, SWT.NORMAL));
		label.setBounds(542, 10, 232, 110);
		label.setText("30:45");
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setAlignment(SWT.RIGHT);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 26, SWT.NORMAL));
		label_1.setBounds(10, 150, 100, 50);
		label_1.setText("00,0");
		
		Label lblMean = new Label(composite, SWT.NONE);
		lblMean.setAlignment(SWT.RIGHT);
		lblMean.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblMean.setBounds(10, 200, 100, 15);
		lblMean.setText("Mean (averaged)");
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setAlignment(SWT.RIGHT);
		label_2.setText("00");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 26, SWT.NORMAL));
		label_2.setBounds(10, 221, 100, 50);
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setAlignment(SWT.RIGHT);
		label_3.setText("Mean (averaged)");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		label_3.setBounds(10, 271, 100, 15);
		
		Label label_4 = new Label(composite, SWT.SEPARATOR | SWT.VERTICAL);
		label_4.setBounds(534, 10, 2, 522);
		
		Label label_5 = new Label(composite, SWT.SEPARATOR | SWT.VERTICAL);
		label_5.setBounds(169, 150, 2, 228);
		
		Label lblTime = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblTime.setText("Time:");
		lblTime.setBounds(552, 126, 222, 2);
		
		Label label_7 = new Label(composite, SWT.NONE);
		label_7.setText("00,00");
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_7.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_7.setAlignment(SWT.RIGHT);
		label_7.setBounds(234, 150, 100, 50);
		
		Label lblCurrent = new Label(composite, SWT.NONE);
		lblCurrent.setText("Current");
		lblCurrent.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblCurrent.setAlignment(SWT.RIGHT);
		lblCurrent.setBounds(234, 200, 100, 15);
		
		Label label_8 = new Label(composite, SWT.NONE);
		label_8.setText("00,0");
		label_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_8.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_8.setAlignment(SWT.RIGHT);
		label_8.setBounds(234, 221, 100, 50);
		
		Label lblUpperDeviation = new Label(composite, SWT.NONE);
		lblUpperDeviation.setText("Upper Deviation");
		lblUpperDeviation.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblUpperDeviation.setAlignment(SWT.RIGHT);
		lblUpperDeviation.setBounds(234, 271, 100, 15);
		
		Label label_9 = new Label(composite, SWT.NONE);
		label_9.setText("00,0");
		label_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_9.setAlignment(SWT.RIGHT);
		label_9.setBounds(234, 299, 100, 50);
		
		Label lblLower = new Label(composite, SWT.NONE);
		lblLower.setText("Lower Deviation");
		lblLower.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblLower.setAlignment(SWT.RIGHT);
		lblLower.setBounds(234, 349, 100, 15);
		
		Label lblSec = new Label(composite, SWT.NONE);
		lblSec.setText("15 sec.:");
		lblSec.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblSec.setAlignment(SWT.RIGHT);
		lblSec.setBounds(544, 150, 100, 15);
		
		Label label_10 = new Label(composite, SWT.NONE);
		label_10.setText("00,0");
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_10.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		label_10.setAlignment(SWT.RIGHT);
		label_10.setBounds(650, 138, 64, 30);
		
		Label lblFrameLine = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblFrameLine.setBounds(10, 400, 518, 2);
		
		Label lblFrame = new Label(composite, SWT.NONE);
		lblFrame.setText("00,0");
		lblFrame.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		lblFrame.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblFrame.setAlignment(SWT.RIGHT);
		lblFrame.setBounds(10, 408, 100, 35);
		
		Label lblFrame1 = new Label(composite, SWT.NONE);
		lblFrame1.setText("Frame");
		lblFrame1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblFrame1.setAlignment(SWT.RIGHT);
		lblFrame1.setBounds(10, 450, 100, 15);
		
		Label label_11 = new Label(composite, SWT.NONE);
		label_11.setText("00");
		label_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_11.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_11.setAlignment(SWT.RIGHT);
		label_11.setBounds(10, 471, 100, 35);
		
		Label lblFrame2 = new Label(composite, SWT.NONE);
		lblFrame2.setText("Frame");
		lblFrame2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblFrame2.setAlignment(SWT.RIGHT);
		lblFrame2.setBounds(10, 512, 100, 15);
		
		Label lblFrameSeperator = new Label(composite, SWT.SEPARATOR | SWT.VERTICAL);
		lblFrameSeperator.setText("Seperator");
		lblFrameSeperator.setBounds(116, 408, 2, 124);

	}
}
