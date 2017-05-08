package me.oskarmendel.util;

/**
 * Point is a class that represents a point in a 2d plane.
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name Point.java
 */
public class Point {

	private int x;
	private int y;
	
	/**
	 * Constructs a new point at the specified coordinates.
	 * 
	 * @param x - X coordinate of the point.
	 * @param y - Y coordinate of the point.
	 */
	public Point(int x, int y) {
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
	public Point midPoint(Point p1, Point p2) {
		return new Point((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2);
	}
	
	/**
	 * Getter for the x coordinate of this point.
	 * 
	 * @return x coordinate of this point.
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Getter for the y coordinate of this point.
	 * 
	 * @return y coordinate of this point.
	 */
	public int getY() {
		return this.y;
	}
}
