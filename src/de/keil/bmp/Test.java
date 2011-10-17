package de.keil.bmp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.spi.AudioFileReader;

import sun.audio.AudioData;
import sun.audio.AudioDataStream;

public class Test {

	public static void main(String[] args) {
		
		
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
