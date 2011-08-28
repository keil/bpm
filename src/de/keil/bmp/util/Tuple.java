package de.keil.bmp.util;

/**
 * @author Matthias
 *
 * @param <T0>
 * @param <T1>
 * @param <T2>
 */
public class Tuple<T0, T1, T2> {
	private T0 element0;
	private T1 element1;
	private T2 element2;

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 */
	public Tuple(T0 arg0, T1 arg1, T2 arg2) {
		super();
		this.element0 = arg0;
		this.element1 = arg1;
		this.element2 = arg2;
	}

	/**
	 * @return
	 */
	public T0 getElement0() {
		return element0;
	}

	/**
	 * @param element0
	 */
	public void setElement0(T0 element0) {
		this.element0 = element0;
	}

	/**
	 * @return
	 */
	public T1 getElement1() {
		return element1;
	}

	/**
	 * @param element1
	 */
	public void setElement1(T1 element1) {
		this.element1 = element1;
	}

	/**
	 * @return
	 */
	public T2 getElement2() {
		return element2;
	}

	/**
	 * @param element2
	 */
	public void setElement2(T2 element2) {
		this.element2 = element2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple<?, ?, ?> other = (Tuple<?, ?, ?>) obj;
		if (element0 == null) {
			if (other.element0 != null)
				return false;
		} else if (!element0.equals(other.element0))
			return false;
		if (element1 == null) {
			if (other.element1 != null)
				return false;
		} else if (!element1.equals(other.element1))
			return false;
		if (element2 == null) {
			if (other.element2 != null)
				return false;
		} else if (!element2.equals(other.element2))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element0 == null) ? 0 : element0.hashCode());
		result = prime * result + ((element1 == null) ? 0 : element1.hashCode());
		result = prime * result + ((element2 == null) ? 0 : element2.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Pair [element0=" + element0 + ", element1=" + element1 + "]";
	}
}