/**
 * 
 */
package de.keil.bpm.basic;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import de.keil.bpm.basic.core.Calculator;
import de.keil.bpm.basic.gui.MainFrame;

/**
 * @author keil
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		long[] data = new long[]{1,2,3,4,5,6};
//		
//		System.out.println("mean " + Calculator.meanFilter(data));
//		System.out.println("variance " + Calculator.varianceFilter(data));
		
		new MainFrame();
		
//		Frame f = new Frame("basic bpm");
//		f.setSize(400, 600);
//		f.setLocation(100, 100);
//		f.setVisible(true);
//
//		f.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
//		
//		
//		
//		f.addKeyListener( new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			long last;
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
//					System.out.println("### ENTER");
//					long now = System.currentTimeMillis();
//					long delta = now - last;
//					
//					System.out.println("### delta " + delta);
//					
//					long result = 60000/delta;
//					
//					System.out.println("### result " + result);
//					
//					long tackt = result / 2;
//					
//					System.out.println("### TACKT " + tackt + "\n\n");
//					
//					last = now;
//				}
//					
//				
//			}
//		});
//
	}

}
