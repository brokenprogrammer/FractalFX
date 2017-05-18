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

import java.awt.Graphics2D;

import javafx.scene.canvas.GraphicsContext;

/**
 * Shape interface to act as a starting point for all objects that represent
 * some form of geometric shape.
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name Shape.java
 */
public interface Shape {

	/**
	 * Computes the area for target shape.
	 * 
	 * @return Area of the shape.
	 */
	public double getArea();

	/**
	 * Checks whether the shape contains specified point.
	 * 
	 * @param p - Point to check.
	 * @return True if the point is inside the shape.
	 */
	public boolean contains(Point p);

	/**
	 * Checks whether the shape contains the point at specified location x and y.
	 * 
	 * @param x - The specified x coordinate.
	 * @param y - The specified y coordinate.
	 * @return True if the point (x,y) is inside the shape.
	 */
	public boolean contains(double x, double y);

	/**
	 * Draws the outline of the shape. The shape is drawn using the
	 * GraphicsContext's current color.
	 * 
	 * @param gc - GraphicsContext object to use for drawing.
	 */
	public void draw(GraphicsContext gc);

	/**
	 * Draws the outline of the shape. The shape is drawn using the
	 * Graphics2D's current color.
	 * 
	 * @param g - Graphics2D object to use for drawing.
	 */
	public void draw(Graphics2D g);

	/**
	 * Draws a filled shape. The shape is drawn using the GraphicsContext's
	 * current color.
	 * 
	 * @param gc - GraphicsContext object to use for drawing.
	 */
	public void drawFill(GraphicsContext gc);

	/**
	 * Draws a filled shape. The shape is drawn using the Graphics2D's
	 * current color.
	 * 
	 * @param g - Graphics2D object to use for drawing.
	 */
	public void drawFill(Graphics2D g);
}
