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

package me.oskarmendel.model;

import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.oskarmendel.fractals.Fractal;
import me.oskarmendel.fractals.JuliaFractal;
import me.oskarmendel.fractals.PythagorasTree;
import me.oskarmendel.fractals.SierpinskiTriangle;

public class FractalModel {
	
	private final JuliaFractal juliaFractal = new JuliaFractal();
	private final PythagorasTree pythagorasTree = new PythagorasTree();
	private final SierpinskiTriangle sierpinskiTriangle = new SierpinskiTriangle();
	
	private final ObservableList<Fractal> fractalList = FXCollections.observableArrayList(
			juliaFractal, pythagorasTree, sierpinskiTriangle);
	
	private final ObjectProperty<Fractal> activeFractal = new SimpleObjectProperty<>();
	
	/**
	 * 
	 * @return
	 */
	public ObjectProperty<Fractal> getActiveFractal() {
		return this.activeFractal;
	}
	
	/**
	 * 
	 * @param fractal
	 */
	public void setActiveFractal(Fractal fractal) {
		this.activeFractal.set(fractal);
	}
	
	/**
	 * 
	 * @return
	 */
	public ObservableList<Fractal> getFractalList() {
		return this.fractalList;
	}
	
	/**
	 * 
	 * @param fractals
	 */
	public void setFractalList(List<Fractal> fractals) {
		this.fractalList.clear();
		this.fractalList.addAll(fractals);
	}
	
	/**
	 * 
	 * @return
	 */
	public final JuliaFractal getJuliaFractal() {
		return this.juliaFractal;
	}
	
	/**
	 * 
	 * @return
	 */
	public final PythagorasTree getPythagorasTree() {
		return this.pythagorasTree;
	}
	
	/**
	 * 
	 * @return
	 */
	public final SierpinskiTriangle getSierpinskiTriangle() {
		return this.sierpinskiTriangle;
	}
}
