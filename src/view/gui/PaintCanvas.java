package view.gui;

import view.interfaces.IPaintCanvas;

import javax.swing.JComponent;

import model.interfaces.IShape;
import model.interfaces.IShapeObserver;

import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas {
	
	public PaintCanvas(){
		
	}

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }



}
