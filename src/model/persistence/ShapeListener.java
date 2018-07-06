package model.persistence;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import collections.ShapeList;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IShapeSubject;
import view.gui.PaintCanvas;
import view.interfaces.IPaintCanvas;

public class ShapeListener implements IShapeObserver {
	private PaintCanvas paint;
	private IShapeSubject stack;

	public ShapeListener(PaintCanvas paint, IShapeSubject list) {
		this.paint = paint;
		this.stack = list;
		stack.registerObserver(this);

	}

	@Override
	public void update(ShapeList shapeList) {
		// this.paint.repaint();
		Graphics2D g = paint.getGraphics2D();
		g.setColor(Color.white);
		g.fillRect(0, 0, 10000, 10000);
		for (IShape shape : shapeList) {
			shape.draw(this.paint);

		}

	}
	
	
	
	
	
	



}
