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

package me.oskarmendel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import me.oskarmendel.controller.FractalViewController;
import me.oskarmendel.fractals.Fractal;
import me.oskarmendel.model.FractalModel;
import me.oskarmendel.view.FractalView;

/**
 * Main entry point of the application.
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name FractalFX.java
 */
public class FractalFX extends Application {

	private Stage mainStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		mainStage.setTitle("FractalFX");

		BorderPane root = new BorderPane();

		// Initiate MVC pattern for fractals.
		FractalModel model = new FractalModel();
		FractalViewController controller = new FractalViewController();
		FractalView view = new FractalView(controller, model);

		// Initiate the list of fractals
		ListView<Fractal> fractalList = new ListView<Fractal>();
		fractalList.setItems(model.getFractalList());

		// Action listener for the fractal list. Double click changes the active fractal.
		fractalList.setOnMouseClicked(e -> {
			if (e.getClickCount() >= 2) {
				model.setActiveFractal(fractalList.getSelectionModel().getSelectedItem());
			}
		});

		// Populate root view.
		root.setCenter(view.getView());
		root.setLeft(fractalList);

		Scene mainScene = new Scene(root);
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
		mainStage.show();
	}

}
// Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
// GraphicsContext gc = canvas.getGraphicsContext2D();
// PythagorasTree pt = new PythagorasTree();
// pt.drawTree(SCREEN_WIDTH, SCREEN_HEIGHT, gc);
// SierpinskiTriangle sp = new SierpinskiTriangle();
// sp.drawTriangle(SCREEN_WIDTH, SCREEN_HEIGHT, gc);

// ImageView imgView = new ImageView();
//
// JuliaFractal f = new JuliaFractal();
// Image img = SwingFXUtils.toFXImage(f.generateFractal(SCREEN_WIDTH,
// SCREEN_HEIGHT, 0.285, 0.01), null);

// ScrollBar sc = new ScrollBar();
// sc.setMin(-1);
// sc.setMax(1);
//
// sc.valueProperty().addListener(new ChangeListener<Number>() {
// @Override
// public void changed(ObservableValue<? extends Number> obs, Number old_val,
// Number new_val) {
//// Image nwImg = SwingFXUtils.toFXImage(f.generateFractal(SCREEN_WIDTH,
// SCREEN_HEIGHT, new_val.doubleValue(), 0.27015), null);
//// imgView.setImage(nwImg);
// }
// });

// imgView.setImage(img);
// root.setCenter(imgView);
// root.setCenter(canvas);
// root.setBottom(sc);