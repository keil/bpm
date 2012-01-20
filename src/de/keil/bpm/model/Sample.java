package de.keil.bpm.model;

import java.util.Arrays;

public class Sample {

	/**
	 * sample data
	 */
	private byte[] bytes;
	/**
	 * sample size in bit
	 */
	private int size;
		
	/**
	 * @param size in bit
	 */
	public Sample(int size) {
		int i = size/8;
		if(size % 8 != 0) i++;

		this.size = size;
		this.bytes = new byte[i];
	}

	/**
	 * @param bytes
	 */
	public Sample(byte... bytes) {
		this.size = bytes.length*8;
		this.bytes = bytes;
	}

	/**
	 * @return the bytes
	 */
	public byte[] getBytes() {
		return bytes;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bytes);
		result = prime * result + size;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sample other = (Sample) obj;
		if (!Arrays.equals(bytes, other.bytes))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sample [bytes=" + Arrays.toString(bytes) + ", size=" + size
				+ "]";
	}

	public byte get(int i) {
		return bytes[i];
	}
	
	
}
