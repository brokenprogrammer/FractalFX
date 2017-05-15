/**
 * MIT License
 * 
 * Copyright (c) 2017 Oskar Mendel
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
