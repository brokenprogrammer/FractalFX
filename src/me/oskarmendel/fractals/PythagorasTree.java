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
	
	public void drawTree(int width, int height,GraphicsContext gc) {
		genTree(gc, (width/2)-50, height, ((width/2)-50)+100, height, 0, 0);
	}
	
	public void genTree(GraphicsContext gc, double x1, double y1, double x2, double y2, double a, int branch) {
		
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
		
		
		System.out.println("X: " + x1);
		System.out.println("Y: " + y1);
		System.out.println("Branch: " + branch);
		
		genTree(gc, x4, y4, x5, y5, 0, branch+1);
		genTree(gc, x5, y5, x3, y3, 0, branch+1);
	}
}
