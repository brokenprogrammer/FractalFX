package me.oskarmendel.fractals;

import javafx.scene.canvas.GraphicsContext;

/**
 * The Sierpinski triangle is a fractal constructed from recursively subdivide a
 * triangle into smaller triangles..
 * 
 * More information is available at:
 * https://en.wikipedia.org/wiki/Sierpinski_triangle
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name SierpinskiTriangle.java
 */
public class SierpinskiTriangle {

	private static final int MAX_ITER = 13;

	public void drawTriangle(int width, int height, GraphicsContext gc) {
		genTriangle(gc, (800/4), 600/2, 800/2, 600, (800/2)+800/4, 600/2, 0);
	}

	public void genTriangle(GraphicsContext gc, double x1, double y1, double x2, double y2, double x3, double y3, int iter) {
		
		if(iter >= MAX_ITER) {
			return;
		}
		
		double[] xpoint = {x1, x2, x3};
		double[] ypoint = {y1, y2, y3};
		gc.fillPolygon(xpoint, ypoint, 3);
		
		double X1 = (x1 + x2) / 2 + (x2 - x3) / 2; //x coordinate of first corner
	    double Y1 = (y1 + y2) / 2 + (y2 - y3) / 2; //y coordinate of first corner
	    double X2 = (x1 + x2) / 2 + (x1 - x3) / 2; //x coordinate of second corner
	    double Y2 = (y1 + y2) / 2 + (y1 - y3) / 2; //y coordinate of second corner
	    double X3 = (x1 + x2) / 2; 				   //x coordinate of third corner
	    double Y3 = (y1 + y2) / 2;  			   //y coordinate of third corner
	    genTriangle(gc, X1, Y1, X2, Y2, X3, Y3, (iter+1));
	    
		X1 = (x3 + x2) / 2 + (x2 - x1) / 2; //x coordinate of first corner
		Y1 = (y3 + y2) / 2 + (y2 - y1) / 2; //y coordinate of first corner
		X2 = (x3 + x2) / 2 + (x3 - x1) / 2; //x coordinate of second corner
		Y2 = (y3 + y2) / 2 + (y3 - y1) / 2; //y coordinate of second corner
		X3 = (x3 + x2) / 2; 			    //x coordinate of third corner
		Y3 = (y3 + y2) / 2;  				//y coordinate of third corner
	    genTriangle(gc, X1, Y1, X2, Y2, X3, Y3, (iter+1));
	    
		X1 = (x1 + x3) / 2 + (x3 - x2) / 2; //x coordinate of first corner
	    Y1 = (y1 + y3) / 2 + (y3 - y2) / 2; //y coordinate of first corner
	    X2 = (x1 + x3) / 2 + (x1 - x2) / 2; //x coordinate of second corner
	    Y2 = (y1 + y3) / 2 + (y1 - y2) / 2; //y coordinate of second corner
	    X3 = (x1 + x3) / 2; 			    //x coordinate of third corner
	    Y3 = (y1 + y3) / 2;  				//y coordinate of third corner
	    genTriangle(gc, X1, Y1, X2, Y2, X3, Y3, (iter+1));
	}
}
