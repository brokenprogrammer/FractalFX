package me.oskarmendel.util;

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
