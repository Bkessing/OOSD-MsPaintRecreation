package factorys;

import java.awt.Point;

import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import shapes.Ellipse;
import shapes.Rectangle;
import shapes.Triangle;

public class ShapeFactory {

	public static IShape Create(IApplicationState appState, Point startPoint, Point endPoint) {
		IShape current = null;
		ShapeType ShapeType = appState.getActiveShapeType();
		if (ShapeType == model.ShapeType.ELLIPSE) {
			current = new Ellipse(appState, startPoint, endPoint);
		} else if (ShapeType == model.ShapeType.RECTANGLE) {
			current = new Rectangle(appState, startPoint, endPoint);
		} else if (ShapeType == model.ShapeType.TRIANGLE) {
			current = new Triangle(appState, startPoint, endPoint);
		}
		return current;

	}

	public static IShape CreateCopy(IShape shape, Point startPoint, Point endPoint) {
		IShape current = null;
		ShapeType ShapeType = shape.getShapeType();
		if (ShapeType == model.ShapeType.ELLIPSE) {
			current = new Ellipse(shape, startPoint, endPoint);
		} else if (ShapeType == model.ShapeType.RECTANGLE) {
			current = new Rectangle(shape, startPoint, endPoint);
		} else if (ShapeType == model.ShapeType.TRIANGLE) {
			current = new Triangle(shape, startPoint, endPoint);
		}
		return current;

	}

}
