package model.interfaces;

import java.awt.Point;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.gui.PaintCanvas;

public interface IShape {


	    ShapeColor getColor();

	    ShapeShadingType getShapeShadingType();
	    
	    Point getStartPoint();
	    
	    Point getEndPoint();
	    
	    ShapeType getShapeType();
	    
	    String getString();
	    
	    ShapeColor getSecondaryColor();
	    
	    void draw(PaintCanvas paint);
	    
	    void setEndPoint(Point end);
	    
	    void setStartPoint(Point start);
}

