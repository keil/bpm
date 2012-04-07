package de.keil.bpm;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Test {

	public static void main(String[] args) {
		
		Display display = new Display();
	    final Shell shell = new Shell(display);
	    shell.setSize(300, 300);
	    shell.setLayout(new RowLayout());

	    shell.setText("Composite Example");

	    final Composite composite = new Composite(shell, SWT.NONE);
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 4;
	    composite.setLayout(gridLayout);

	    for (int loopIndex = 0; loopIndex < 28; loopIndex++) {
	      Label label = new Label(composite, SWT.SHADOW_NONE);
	      label.setText("Label " + loopIndex);
	    }

	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
		
		
		
//		float sampleRate = 8000;
//	    int sampleSizeInBits = 8;
//	    int channels = 1;
//	    boolean signed = true;
//	    boolean bigEndian = true;
//	    AudioFormat format =  new AudioFormat(sampleRate, 
//	      sampleSizeInBits, channels, signed, bigEndian);
//
//	    DataLine.Info info = new DataLine.Info(
//	    	    TargetDataLine.class, format);
//	    	  TargetDataLine line = (TargetDataLine)
//	    	    AudioSystem.getLine(info);
//	    
//	    	  line.open(format);
//	    	  line.start();
//	    	  
//	    int bufferSize = (int)format.getSampleRate() * format.getFrameSize();
//	    	  byte buffer[] = new byte[bufferSize];
//	    	  out = new ByteArrayOutputStream();
//	    	  while (externalTrigger) {
//	    	    int count = line.read(buffer, 0, buffer.length);
//	    	    if (count > 0) {
//	    	      out.write(buffer, 0, count);
//	    	    }
//	    	  }
//	    	  out.close();
//		
//	    byte audio[] = out.toByteArray();
//	    InputStream input = new ByteArrayInputStream(audio);
//	    AudioInputStream ais = new AudioInputStream(input, format, audio.length / format.getFrameSize());
//	    
//		File file = new File("");
//		
//		AudioFileFormat.Type type = AudioFileFormat.Type.WAVE;
//		AudioFileFormat format = new AudioFileFormat(type, new AudioFormat(),0);
//		
//		FileInputStream input = new FileInputStream(file);
//		AudioInputStream fileReader = new AudioInputStream(input,format.,1024l);
		
		
//		AudioDataStream ads = new AudioDataStream(AudioData)
//	    AudioFormat f = new AudioFormat(arg0, arg1, arg2, arg3, arg4, arg5, arg6)
	    
	}
	
	
}
