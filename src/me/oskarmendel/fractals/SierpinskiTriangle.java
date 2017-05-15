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

import javafx.scene.canvas.GraphicsContext;
import me.oskarmendel.util.Point;

/**
 * The Sierpinski triangle is a fractal constructed from recursively subdivide a
 * triangle into smaller triangles.
 * 
 * More information is available at:
 * https://en.wikipedia.org/wiki/Sierpinski_triangle
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name SierpinskiTriangle.java
 */
public class SierpinskiTriangle {

	private static final int MAX_ITER = 8;

	/**
	 * Draws a Sierpinski triangle to the specified GraphicsContext.
	 * 
	 * @param width - width of the container or canvas.
	 * @param height - height of the container or canvas.
	 * @param gc - GraphicsContext to use to draw with.
	 */
	public void drawTriangle(int width, int height, GraphicsContext gc) {

		Point p1 = new Point((width / 4), height / 2);
		Point p2 = new Point(width / 2, height);
		Point p3 = new Point((width / 2) + width / 4, height / 2);

		genTriangle(gc, p1, p2, p3, 0);
	}

	/**
	 * Recursive method to generate the Sierpinski triangle. 
	 * This method draw one triangle and recursively calls itself three times to draw a 
	 * new triangle on each side of the drawn triangle.
	 * 
	 * @param gc - GraphicsContext to use to draw with.
	 * @param p1 - Top left point of the triangle.
	 * @param p2 - Bottom point of the triangle.
	 * @param p3 - Top right point of the triangle.
	 * @param iter - The current iteration.
	 */
	private void genTriangle(GraphicsContext gc, Point p1, Point p2, Point p3, int iter) {

		if (iter >= MAX_ITER) {
			return;
		}

		//Fills a polygon representing a triangle in the graphics context.
		double[] xpoint = { p1.getX(), p2.getX(), p3.getX() };
		double[] ypoint = { p1.getY(), p2.getY(), p3.getY() };
		gc.fillPolygon(xpoint, ypoint, 3);

		//Set points for the bottom left triangle.
		Point firstTrianglep3 = Point.midPoint(p1, p2);
		Point firstTrianglep2 = new Point(firstTrianglep3.getX() + (p2.getX() - p3.getX()) / 2,
				firstTrianglep3.getY() + (p2.getY() - p3.getY()) / 2);
		Point firstTrianglep1 = new Point(firstTrianglep3.getX() + (p1.getX() - p3.getX()) / 2,
				firstTrianglep3.getY() + (p1.getY() - p3.getY()) / 2);

		genTriangle(gc, firstTrianglep1, firstTrianglep2, firstTrianglep3, (iter + 1));

		//Set the points for the bottom right triangle.
		Point secondTrianglep3 = Point.midPoint(p2, p3);
		Point secondTrianglep2 = new Point(secondTrianglep3.getX() + (p2.getX() - p1.getX()) / 2,
				secondTrianglep3.getY() + (p2.getY() - p1.getY()) / 2);
		Point secondTrianglep1 = new Point(secondTrianglep3.getX() + (p3.getX() - p1.getX()) / 2,
				secondTrianglep3.getY() + (p3.getY() - p1.getY()) / 2);

		genTriangle(gc, secondTrianglep1, secondTrianglep2, secondTrianglep3, (iter + 1));
		
		//Set the points for the top triangle.
		Point thirdTrianglep3 = Point.midPoint(p1, p3);
		Point thirdTrianglep2 = new Point(thirdTrianglep3.getX() + (p1.getX() - p2.getX()) / 2,
				thirdTrianglep3.getY() + (p1.getY() - p2.getY()) / 2);
		Point thirdTrianglep1 = new Point(thirdTrianglep3.getX() + (p3.getX() - p2.getX()) / 2,
				thirdTrianglep3.getY() + (p3.getY() - p2.getY()) / 2);

		genTriangle(gc, thirdTrianglep1, thirdTrianglep2, thirdTrianglep3, (iter + 1));
	}
}
