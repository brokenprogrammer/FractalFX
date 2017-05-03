package me.oskarmendel.util;

/**
 * ComplexNumber is a class that implements complex numbers for Java with the
 * most essential operations needed for this project.
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name ComplexNumber.java
 */
public class ComplexNumber {

	private double real;
	private double imaginary;

	/**
	 * Constructs a new complex number.
	 * 
	 * @param re - Real number.
	 * @param im - Imaginary number.
	 */
	public ComplexNumber(double re, double im) {
		this.real = re;
		this.imaginary = im;
	}

	/**
	 * Sets the real number of the complex number.
	 * 
	 * @param re - Real number.
	 */
	public void setReal(double re) {
		this.real = re;
	}

	/**
	 * Returns the real number of the complex number.
	 * 
	 * @return Real number of the complex number.
	 */
	public double getReal() {
		return this.real;
	}

	/**
	 * Sets the imaginary number of the complex number.
	 * 
	 * @param im - Imaginary number.
	 */
	public void setImaginary(double im) {
		this.imaginary = im;
	}

	/**
	 * Returns the imaginary number of the complex number.
	 * 
	 * @return Imaginary number of the complex number.
	 */
	public double getImaginary() {
		return this.imaginary;
	}

	/**
	 * The absolute value of the current complex number.
	 * 
	 * @return The absolute value of the current complex number.
	 */
	public double getAbs() {
		return Math.sqrt(imaginary * imaginary + real * real);
	}

	/**
	 * Returns the complex number as a string in the x + yi format.
	 * 
	 * @return A string of the complex number in x + yi format.
	 */
	@Override
	public String toString() {
		// TODO: Implement
		return "";
	}
}
