package de.keil.bpm.model;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;

/**
 * @author keil
 * 
 */
public class Format {

	/**
	 * encoding technique, default PCM
	 */
	private AudioFormat.Encoding encoding;

	/**
	 * number of channels
	 */
	private int channels;

	/**
	 * number of samples per second per channel
	 */
	private int samplerate;

	/**
	 * number of bits per sample per second
	 */
	private int samplesize;

	/**
	 * number of frames
	 */
	private int framerate;

	/**
	 * number of bits per frame
	 */
	private int framesize;

	/**
	 * byte order
	 */
	private ByteOrder order;

	/**
	 * @param encoding
	 * @param channels
	 * @param samplerate
	 * @param samplesize
	 * @param framerate
	 * @param framesize
	 * @param order
	 */
	public Format(Encoding encoding, int channels, int samplerate,
			int samplesize, int framerate, int framesize, ByteOrder order) {
		super();
		this.encoding = encoding;
		this.channels = channels;
		this.samplerate = samplerate;
		this.samplesize = samplesize;
		this.framerate = framerate;
		this.framesize = framesize;
		this.order = order;
	}

	/**
	 * @return the encoding
	 */
	public AudioFormat.Encoding getEncoding() {
		return encoding;
	}

	/**
	 * @return the channels
	 */
	public int getChannels() {
		return channels;
	}

	/**
	 * @return the samplerate
	 */
	public int getSamplerate() {
		return samplerate;
	}

	/**
	 * @return the samplesize
	 */
	public int getSamplesize() {
		return samplesize;
	}

	/**
	 * @return the framerate
	 */
	public int getFramerate() {
		return framerate;
	}

	/**
	 * @return the framesize
	 */
	public int getFramesize() {
		return framesize;
	}

	/**
	 * @return the order
	 */
	public ByteOrder getOrder() {
		return order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channels;
		result = prime * result
				+ ((encoding == null) ? 0 : encoding.hashCode());
		result = prime * result + framerate;
		result = prime * result + framesize;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + samplerate;
		result = prime * result + samplesize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Format other = (Format) obj;
		if (channels != other.channels)
			return false;
		if (encoding == null) {
			if (other.encoding != null)
				return false;
		} else if (!encoding.equals(other.encoding))
			return false;
		if (framerate != other.framerate)
			return false;
		if (framesize != other.framesize)
			return false;
		if (order != other.order)
			return false;
		if (samplerate != other.samplerate)
			return false;
		if (samplesize != other.samplesize)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Format [encoding=" + encoding + ", channels=" + channels
				+ ", samplerate=" + samplerate + ", samplesize=" + samplesize
				+ ", framerate=" + framerate + ", framesize=" + framesize
				+ ", order=" + order + "]";
	}

}