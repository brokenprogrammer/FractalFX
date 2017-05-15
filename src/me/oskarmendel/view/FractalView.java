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
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private Canvas canvas;
	private ImageView imageView;

	private GraphicsContext gc;
	private Image img;
	private ScrollBar sc;

	private FractalViewController controller;
	private FractalModel model;

	/**
	 * Initialze and build the FractalView for the application.
	 * 
	 * @param controller
	 * @param model - Model to ask for data and changes happening to the fractal view.
	 */
	public FractalView(FractalViewController controller, FractalModel model) {
		this.controller = controller;
		this.model = model;

		view = new AnchorPane();
		view.setMinSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		imageView = new ImageView();
		sc = new ScrollBar();
		canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
		gc = canvas.getGraphicsContext2D();

		// Listener for changes in the active fractal
		model.getActiveFractal().addListener((ChangeListener<Fractal>) (observable, oldValue, newValue) -> {
			view.getChildren().clear();

			if (newValue.getClass() == JuliaFractal.class) {
				img = SwingFXUtils.toFXImage(
						((JuliaFractal) newValue).generateFractal(SCREEN_WIDTH, SCREEN_HEIGHT, 0.285, 0.01), null);
				imageView.setImage(img);
				sc.setMin(-1);
				sc.setMax(1);
				
				sc.valueProperty().addListener(new ChangeListener<Number>() {
					 @Override
					 public void changed(ObservableValue<? extends Number> obs, Number old_val,
					 Number new_val) {
					 img = SwingFXUtils.toFXImage(((JuliaFractal) newValue).generateFractal(SCREEN_WIDTH,
					 SCREEN_HEIGHT, new_val.doubleValue(), 0.27015), null);
					 imageView.setImage(img);
					 }
					 });
				
				view.getChildren().add(imageView);
				view.getChildren().add(sc);
				
			} else if (newValue.getClass() == PythagorasTree.class) {
				gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
				((PythagorasTree) newValue).drawTree(SCREEN_WIDTH, SCREEN_HEIGHT, gc);
				view.getChildren().add(canvas);
			} else if (newValue.getClass() == SierpinskiTriangle.class) {
				gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
				((SierpinskiTriangle) newValue).drawTriangle(SCREEN_WIDTH, SCREEN_HEIGHT, gc);
				view.getChildren().add(canvas);
			}
		});
	}

	/**
	 * Gets the parent pane of this view.
	 * 
	 * @return the pane with all the content for this view.
	 */
	public Parent getView() {
		return view;
	}
}
