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
 * @name Rectangle.java
 */
public class Rectangle implements Shape {

	private double x;
	private double y;

	private double width;
	private double height;

	private double angle;

	private Point center;

	/**
	 * Constructs a new Rectangle whose upper left corner is at the specified x and y 
	 * coordinate, and whose width and height are set to the specified values.
	 * 
	 * @param x - The specified X coordinate.
	 * @param y - The specified Y coordinate.
	 * @param w - The width of the Rectangle.
	 * @param h - The height of the Rectangle.
	 */
	public Rectangle(double x, double y, double w, double h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

	/**
	 * Constructs a new Rectangle whose upper left corner is at the specified x and y 
	 * coordinate, and whose width and height are specified of the arguments of the same name.
	 * Also rotates the Rectangle by the degrees specified.
	 * 
	 * @param x - The specified X coordinate.
	 * @param y - The specified Y coordinate.
	 * @param w - The width of the Rectangle.
	 * @param h - The height of the Rectangle.
	 * @param a - The angle to rotate the Rectangle by in degrees.
	 */
	public Rectangle(double x, double y, double w, double h, double a) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.angle = (a * Math.PI) / 180;

		this.center = new Point(x + (width / 2), y + (height / 2));
	}

	/**
	 * Computes the area for this Rectangle.
	 * 
	 * @return Area of this Rectangle.
	 */
	@Override
	public double getArea() {
		return (width*height);
	}

	/**
	 * Checks whether this Rectangle contains specified point.
	 * 
	 * @param p - Point to check.
	 * @return True if the point is inside this Rectangle.
	 */
	@Override
	public boolean contains(Point p) {
		if ((p.getX() >= this.x) && (p.getX() <= (this.x + width))) {
			if ((p.getY() >= this.y) && (p.getY() <= (this.y + height))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether this Rectangle contains the point at specified location x
	 * and y.
	 * 
	 * @param x - The specified x coordinate.
	 * @param y - The specified y coordinate.
	 * @return True if the point (x,y) is inside this Rectangle.
	 */
	@Override
	public boolean contains(double x, double y) {
		if ((x >= this.x) && (x <= (this.x + width))) {
			if ((y >= this.y) && (y <= (this.y + height))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Draws the outline of this Rectangle. The Rectangle is drawn using the
	 * GraphicsContext's current color.
	 * 
	 * @param gc - GraphicsContext object to use for drawing.
	 */
	@Override
	public void draw(GraphicsContext gc) {
		if (this.angle == 0.0) {
			gc.strokeRect(x, y, x + width, y + height);
		} else {
			// Set the points for all corners while translating the coordinates
			// the origin.
			Point topLeft = new Point(x - center.getX(), (y - center.getY()));
			Point topRight = new Point((x + width) - center.getX(), y - center.getY());
			Point bottomLeft = new Point(x - center.getX(), y + height - center.getY());
			Point bottomRight = new Point(x + width - center.getX(), x + width - center.getY());

			// Apply rotation to all the points.
			topLeft.rotate(angle);
			topRight.rotate(angle);
			bottomLeft.rotate(angle);
			bottomRight.rotate(angle);

			// Translate the points back while drawing lines between the points.
			gc.strokeLine((topLeft.getX() + center.getX()), (topLeft.getY() + center.getY()),
					(topRight.getX() + center.getX()), (topRight.getY() + center.getY()));
			
			gc.strokeLine((topLeft.getX() + center.getX()), (topLeft.getY() + center.getY()),
					(bottomLeft.getX() + center.getX()), (bottomLeft.getY() + center.getY()));
			
			gc.strokeLine((topRight.getX() + center.getX()), (topRight.getY() + center.getY()),
					(bottomRight.getX() + center.getX()), (bottomRight.getY() + center.getY()));
			
			gc.strokeLine((bottomLeft.getX() + center.getX()), (bottomLeft.getY() + center.getY()),
					(bottomRight.getX() + center.getX()), (bottomRight.getY() + center.getY()));
		}
	}

	/**
	 * Draws the outline of this Rectangle. The Rectangle is drawn using the
	 * Graphics2D's current color.
	 * 
	 * @param g - Graphics2D object to use for drawing.
	 */
	@Override
	public void draw(Graphics2D g) {
		if (this.angle == 0.0) {
			g.drawRect((int) x, (int) y, (int) (x + width), (int) (y + height));
		} else {
			// Set the points for all corners while translating the coordinates
			// the origin.
			Point topLeft = new Point(x - center.getX(), (y - center.getY()));
			Point topRight = new Point((x + width) - center.getX(), y - center.getY());
			Point bottomLeft = new Point(x - center.getX(), y + height - center.getY());
			Point bottomRight = new Point(x + width - center.getX(), x + width - center.getY());

			// Apply rotation to all the points.
			topLeft.rotate(angle);
			topRight.rotate(angle);
			bottomLeft.rotate(angle);
			bottomRight.rotate(angle);
			
			// Translate the points back while drawing lines between the points.
			g.drawLine((int) (topLeft.getX() + center.getX()), (int) (topLeft.getY() + center.getY()),
					(int) (topRight.getX() + center.getX()), (int) (topRight.getY() + center.getY()));
			
			g.drawLine((int) (topLeft.getX() + center.getX()), (int) (topLeft.getY() + center.getY()),
					(int) (bottomLeft.getX() + center.getX()), (int) (bottomLeft.getY() + center.getY()));
			
			g.drawLine((int) (topRight.getX() + center.getX()), (int) (topRight.getY() + center.getY()),
					(int) (bottomRight.getX() + center.getX()), (int) (bottomRight.getY() + center.getY()));
			
			g.drawLine((int) (bottomLeft.getX() + center.getX()), (int) (bottomLeft.getY() + center.getY()),
					(int) (bottomRight.getX() + center.getX()), (int) (bottomRight.getY() + center.getY()));
		}
	}

	/**
	 * Draws a filled Rectangle. The Rectangle is drawn using the
	 * GraphicsContext's current color.
	 * 
	 * @param gc - GraphicsContext object to use for drawing.
	 */
	@Override
	public void drawFill(GraphicsContext gc) {
		if (this.angle == 0.0) {
			gc.fillRect(x, y, x + width, y + height);
		} else {
			// Set the points for all corners while translating the coordinates
			// the origin.
			Point topLeft = new Point(x - center.getX(), (y - center.getY()));
			Point topRight = new Point((x + width) - center.getX(), y - center.getY());
			Point bottomLeft = new Point(x - center.getX(), y + height - center.getY());
			Point bottomRight = new Point(x + width - center.getX(), x + width - center.getY());

			// Apply rotation to all the points.
			topLeft.rotate(angle);
			topRight.rotate(angle);
			bottomLeft.rotate(angle);
			bottomRight.rotate(angle);
			
			double [] xPoints = {(topLeft.getX() + center.getX()), (topRight.getX() + center.getX()), 
					(bottomRight.getX() + center.getX()), (bottomLeft.getX() + center.getX())};
			
			double [] yPoints = {(topLeft.getY() + center.getY()), (topRight.getY() + center.getY()), 
					(bottomRight.getY() + center.getY()), (bottomLeft.getY() + center.getY())};
			
			gc.fillPolygon(xPoints, yPoints, 4);
		}
	}

	/**
	 * Draws a filled Rectangle. The Rectangle is drawn using the Graphics2D's
	 * current color.
	 * 
	 * @param g  - Graphics2D object to use for drawing.
	 */
	@Override
	public void drawFill(Graphics2D g) {
		if (this.angle == 0.0) {
			g.fillRect((int) x, (int) y, (int) (x + width), (int) (y + height));
		} else {
			// Set the points for all corners while translating the coordinates
			// the origin.
			Point topLeft = new Point(x - center.getX(), (y - center.getY()));
			Point topRight = new Point((x + width) - center.getX(), y - center.getY());
			Point bottomLeft = new Point(x - center.getX(), y + height - center.getY());
			Point bottomRight = new Point(x + width - center.getX(), x + width - center.getY());

			// Apply rotation to all the points.
			topLeft.rotate(angle);
			topRight.rotate(angle);
			bottomLeft.rotate(angle);
			bottomRight.rotate(angle);
			
			int [] xPoints = {(int) (topLeft.getX() + center.getX()), (int) (topRight.getX() + center.getX()), 
					(int) (bottomRight.getX() + center.getX()), (int) (bottomLeft.getX() + center.getX())};
			
			int [] yPoints = {(int) (topLeft.getY() + center.getY()), (int) (topRight.getY() + center.getY()), 
					(int) (bottomRight.getY() + center.getY()), (int) (bottomLeft.getY() + center.getY())};
			
			g.fillPolygon(xPoints, yPoints, 4);
		}
	}

}
