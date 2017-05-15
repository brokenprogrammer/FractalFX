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

package me.oskarmendel.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import me.oskarmendel.controller.FractalViewController;
import me.oskarmendel.fractals.Fractal;
import me.oskarmendel.fractals.JuliaFractal;
import me.oskarmendel.fractals.PythagorasTree;
import me.oskarmendel.fractals.SierpinskiTriangle;
import me.oskarmendel.model.FractalModel;

public class FractalView {
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 600;
	
	private AnchorPane view;
	
	private FractalViewController controller;
	private FractalModel model;
	
	/**
	 * 
	 * @param controller
	 * @param model
	 */
	public FractalView(FractalViewController controller, FractalModel model) {
		this.controller = controller;
		this.model = model;
		
		view = new AnchorPane();
		
		model.getActiveFractal().addListener((ChangeListener<Fractal>) (observable, oldValue, newValue) -> {
			view.getChildren().clear();
			
			if (newValue.getClass() == JuliaFractal.class) {
				System.out.println("Julia Fractal");
			} else if (newValue.getClass() == PythagorasTree.class) {
				System.out.println("Pythagoras Tree");
			} else if (newValue.getClass() == SierpinskiTriangle.class) {
				System.out.println("Sierpinski Triangle");
			}
		});
		
		Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		PythagorasTree pt = new PythagorasTree();
		pt.drawTree(SCREEN_WIDTH, SCREEN_HEIGHT, gc);
		view.getChildren().add(canvas);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Parent getView() {
		return view;
	}
}
