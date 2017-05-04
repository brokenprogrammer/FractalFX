package me.oskarmendel;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import me.oskarmendel.fractals.JuliaFractal;

/**
 * Main entry point of the application.
 * 
 * @author Oskar Mendel
 * @version 0.00.00
 * @name FractalFX.java
 */
public class FractalFX extends Application {

	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 600;

	private Stage mainStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		mainStage.setTitle("FractalFX");

		BorderPane root = new BorderPane();
//		Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
//		GraphicsContext gc = canvas.getGraphicsContext2D();
//		PythagorasTree pt = new PythagorasTree();
//		pt.drawTree(SCREEN_WIDTH, SCREEN_HEIGHT, gc);
		
		ImageView imgView = new ImageView();

		JuliaFractal f = new JuliaFractal();
		Image img = SwingFXUtils.toFXImage(f.generateFractal(SCREEN_WIDTH, SCREEN_HEIGHT, 0.285, 0.01), null);
		
		ScrollBar sc = new ScrollBar();
		sc.setMin(-1);
		sc.setMax(1);
		
		sc.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> obs, Number old_val, Number new_val) {
				Image nwImg = SwingFXUtils.toFXImage(f.generateFractal(SCREEN_WIDTH, SCREEN_HEIGHT, new_val.doubleValue(), 0.27015), null);
				imgView.setImage(nwImg);
			}
		});
		
		imgView.setImage(img);
		root.setCenter(imgView);
		root.setBottom(sc);

		Scene mainScene = new Scene(root);

		mainStage.setScene(mainScene);
		mainStage.setMinWidth(SCREEN_WIDTH);
		mainStage.setMinHeight(SCREEN_HEIGHT);
		mainStage.show();
	}

}
