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
 * Triangle represents the geometric shape of a Triangle.
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name Triangle.java
 */
public class Triangle implements Shape {

	private Point p1;
	private Point p2;
	private Point p3;
	
	private Point center;
	private double angle;
	
	/**
	 * Constructs a new Triangle using the specified three points.
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		
		// Setting the center to the barycenter of this Triangle.
		this.center = new Point((p1.getX() + p2.getX() + p3.getX()) / 3,
				(p1.getY() + p2.getY() + p3.getY()) / 3);
	}
	
	/**
	 * Constructs a new Triangle using the specified three points. Also
	 * rotates the Triangle using the specified angle which is counted in degrees.
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param a - The angle to rotate the Triangle by in degrees.
	 */
	public Triangle(Point p1, Point p2, Point p3, double a) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		
		// Setting the center to the barycenter of this Triangle.
		this.center = new Point((p1.getX() + p2.getX() + p3.getX()) / 3,
				(p1.getY() + p2.getY() + p3.getY()) / 3);
		
		this.angle = (a * Math.PI) / 180;
	}
	
	/**
	 * Computes the area for this Triangle.
	 * 
	 * @return Area of this Triangle.
	 */
	@Override
	public double getArea() {
		return ((p1.getX() - p3.getX()) * (p2.getY() - p1.getY()) -
				(p1.getX() - p2.getX()) * (p3.getY() - p1.getY())) * 0.5;
	}

	/**
	 * Checks whether this Triangle contains specified point.
	 * 
	 * @param p - Point to check.
	 * @return True if the point is inside this Triangle.
	 */
	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Checks whether this Triangle contains the point at specified location x
	 * and y.
	 * 
	 * @param x - The specified x coordinate.
	 * @param y - The specified y coordinate.
	 * @return True if the point (x,y) is inside this Triangle.
	 */
	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Draws the outline of this Triangle. The Triangle is drawn using the
	 * GraphicsContext's current color.
	 * 
	 * @param gc - GraphicsContext object to use for drawing.
	 */
	@Override
	public void draw(GraphicsContext gc) {
		if (this.angle == 0.0) {
			gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			gc.strokeLine(p2.getX(), p2.getY(), p3.getX(), p3.getY());
			gc.strokeLine(p3.getX(), p3.getY(), p1.getX(), p1.getY());
		} else {
			// Set the points for all corners while translating the coordinates
			// the origin.
			Point d1 = new Point(p1.getX() - center.getX(), p1.getX() - center.getY());
			Point d2 = new Point(p2.getX() - center.getX(), p2.getY() - center.getY());
			Point d3 = new Point(p3.getX() - center.getX(), p3.getY() - center.getY());
			
			// Apply rotation to all the points.
			d1.rotate(angle);
			d2.rotate(angle);
			d3.rotate(angle);
			
			// Translate the points back while drawing lines between the points.
			gc.strokeLine(d1.getX() + center.getX(), d1.getY() + center.getY(), 
					d2.getX() + center.getX(), d2.getY() + center.getY());
			gc.strokeLine(d2.getX() + center.getX(), d2.getY() + center.getY(), 
					d3.getX() + center.getX(), d3.getY() + center.getY());
			gc.strokeLine(d3.getX() + center.getX(), d3.getY() + center.getY(), 
					d1.getX() + center.getX(), d1.getY() + center.getY());
		}
	}

	/**
	 * Draws the outline of this Triangle. The Triangle is drawn using the
	 * Graphics2D's current color.
	 * 
	 * @param g - Graphics2D object to use for drawing.
	 */
	@Override
	public void draw(Graphics2D g) {
		if (this.angle == 0.0) {
			g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
			g.drawLine((int) p2.getX(), (int) p2.getY(), (int) p3.getX(), (int) p3.getY());
			g.drawLine((int) p3.getX(), (int) p3.getY(), (int) p1.getX(), (int) p1.getY());
		} else {
			// Set the points for all corners while translating the coordinates
			// the origin.
			Point d1 = new Point(p1.getX() - center.getX(), p1.getX() - center.getY());
			Point d2 = new Point(p2.getX() - center.getX(), p2.getY() - center.getY());
			Point d3 = new Point(p3.getX() - center.getX(), p3.getY() - center.getY());
			
			// Apply rotation to all the points.
			d1.rotate(angle);
			d2.rotate(angle);
			d3.rotate(angle);
			
			// Translate the points back while drawing lines between the points.
			g.drawLine((int) (d1.getX() + center.getX()), (int) (d1.getY() + center.getY()), 
					(int) (d2.getX() + center.getX()), (int) (d2.getY() + center.getY()));
			g.drawLine((int)(d2.getX() + center.getX()), (int) (d2.getY() + center.getY()), 
					(int) (d3.getX() + center.getX()), (int) (d3.getY() + center.getY()));
			g.drawLine((int) (d3.getX() + center.getX()), (int) (d3.getY() + center.getY()), 
					(int) (d1.getX() + center.getX()), (int) (d1.getY() + center.getY()));
		}
	}

	/**
	 * Draws a filled Triangle. The Triangle is drawn using the
	 * GraphicsContext's current color.
	 * 
	 * @param gc - GraphicsContext object to use for drawing.
	 */
	@Override
	public void drawFill(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Draws a filled Triangle. The Triangle is drawn using the Graphics2D's
	 * current color.
	 * 
	 * @param g  - Graphics2D object to use for drawing.
	 */
	@Override
	public void drawFill(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
