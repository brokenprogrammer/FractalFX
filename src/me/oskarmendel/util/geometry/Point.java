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

package me.oskarmendel.util.geometry;

/**
 * Point is a class that represents a point in a 2d plane.
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name Point.java
 */
public class Point {

	private double x;
	private double y;
	
	/**
	 * Constructs a new point at the specified coordinates.
	 * 
	 * @param x - X coordinate of the point.
	 * @param y - Y coordinate of the point.
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the point in the middle between two specified points.
	 * 
	 * @param p1 - First point.
	 * @param p2 - Second point.
	 * 
	 * @return Point in the middle of the two given points.
	 */
	public static Point midPoint(Point p1, Point p2) {
		return new Point((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2);
	}
	
	/**
	 * Getter for the x coordinate of this point.
	 * 
	 * @return x coordinate of this point.
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Getter for the y coordinate of this point.
	 * 
	 * @return y coordinate of this point.
	 */
	public double getY() {
		return this.y;
	}
}
