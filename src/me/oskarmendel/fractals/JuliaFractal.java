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

package me.oskarmendel.fractals;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import me.oskarmendel.util.ComplexNumber;

/**
 * JuliaFractal is used to draw a BufferedImage of a Julia Fractal. 
 * This fractal is drawn using the function: 
 * z^2 - c where z = (x + yi). (x + yi)^2 = x^2 + 2xyi - y^2 
 * 
 * More information is available at:
 * https://en.wikipedia.org/wiki/Julia_set
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name JuliaFractal.java
 */
public class JuliaFractal implements Fractal{

	private static final double MAX_RANGE = 1;
	private static final double MIN_RANGE = -1;
	private static final int THRESHOLD = 2;
	private static final int MAX_ITERATIONS = 100;

	/**
	 * Generates a Buffered image of a Julia Fractal.
	 * 
	 * @param width - Width of the image.
	 * @param height - Height of the image.
	 * @param realSeed - The seed number for the real number.
	 * @param imaginarySeed - The seed number for the imaginary number.
	 * @return A BufferedImage of a Julia Fractal.
	 */
	public BufferedImage generateFractal(int width, int height, double realSeed, double imaginarySeed) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster wr = (WritableRaster) img.getData();

		int x = 0; // X coordinate on the image;
		int y = 0; // Y coordinate on the image.
		int i; // Number of iterations.

		// Looping through each pixel making a complex number for each pixel.
		for (y = 0; y < height; y++) {
			for (x = 0; x < width; x++) {
				// Transforming the coordinates so it lies between the range -1
				// to 1.
				double a = x * (MAX_RANGE - MIN_RANGE) / width + MIN_RANGE;
				double b = y * (MAX_RANGE - MIN_RANGE) / height + MIN_RANGE;

				ComplexNumber c = new ComplexNumber(a, b);

				for (i = 0; i < MAX_ITERATIONS && c.getAbs() <= THRESHOLD; i++) {
					// Apply function for Julia Fractal
					applyFunction(c, realSeed, imaginarySeed);
				}

				wr.setSample(x, y, 0, i);
			}
		}

		// Set the content of raster to image.
		img.setData(wr);

		return img;
	}

	/**
	 * The function: z^2 - c, to apply on each pixel.
	 * 
	 * @param cn - Target complex number.
	 * @param realSeed - The seed for the real number.
	 * @param ImaginarySeed - The seed for the imaginary number.
	 */
	private void applyFunction(ComplexNumber cn, double realSeed, double imaginarySeed) {
		double re = cn.getReal() * cn.getReal() - cn.getImaginary() * cn.getImaginary() + realSeed;
		double im = 2 * cn.getReal() * cn.getImaginary() + imaginarySeed;
		cn.setReal(re);
		cn.setImaginary(im);
	}
	
	/**
	 * Returns the string representation of this class which is the class name itself.
	 * Because this fractal either draws to a canvas or generates an image this is the string
	 * representation that was chosen.
	 * 
	 * @return the name of this class.
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
