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

/**
 * The Pythagoras tree is a plane fractal constructed from squares.
 * 
 * More information is available at:
 * https://en.wikipedia.org/wiki/Pythagoras_tree_(fractal)
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name PythagorasTree.java
 */
public class PythagorasTree {
	
	private static final int MAX_BRANCH = 14;
	
	/**
	 * Draws Pythagoras tree to the specified GraphicsContext.
	 * 
	 * @param width - width of the container or canvas.
	 * @param height - height of the container or canvas.
	 * @param gc - GraphicsContext to use to draw with.
	 */
	public void drawTree(int width, int height,GraphicsContext gc) {
		genTree(gc, (width/2)-50, height, ((width/2)-50)+100, height, 0);
	}
	
	/**
	 * Recursive method to generate the Pythagorean tree. 
	 * This method draws a rectangle using the specified x and y values. 
	 * Then continues by recursively call itself two times to create two new rectangles.
	 * 
	 * @param gc - GraphicsContext to use to draw with.
	 * @param x1 - Start x value.
	 * @param y1 - Start y value.
	 * @param x2 - End x value.
	 * @param y2 - End y value.
	 * @param branch - The current branch that is being generated.
	 */
	private void genTree(GraphicsContext gc, double x1, double y1, double x2, double y2, int branch) {
		
		if(branch >= MAX_BRANCH) {
			return;
		}
		
		double dx = x2 - x1;
		double dy = y1 - y2;
		double x3 = x2 - dy;
		double y3 = y2 - dx;
		double x4 = x1 - dy;
		double y4 = y1 - dx;
		double x5 = x4 + 0.5F * (dx - dy);
		double y5 = y4 - 0.5F * (dx + dy);
		
		//Draw square
		gc.strokeLine(x1, y1, x2, y2);
		gc.strokeLine(x2, y2, x3, y3);
		gc.strokeLine(x3, y3, x4, y4);
		gc.strokeLine(x4, y4, x1, y1);
		
		//Draw triangle
		gc.strokeLine(x4, y4, x5, y5);
		gc.strokeLine(x5, y5, x3, y3);
		
		
		genTree(gc, x4, y4, x5, y5, branch+1);
		genTree(gc, x5, y5, x3, y3, branch+1);
	}
}
