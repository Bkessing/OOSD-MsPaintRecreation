package shapes;

import java.awt.Graphics2D;
import java.awt.Point;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.persistence.ColorHandler;
import view.gui.PaintCanvas;

public class Triangle implements IShape {
	private ShapeType activeShapeType;
	private ShapeColor activePrimaryColor;
	private ShapeColor activeSecondaryColor;
	private ShapeShadingType activeShapeShadingType;
	private IApplicationState state;
	private Point startPoint;
	private Point endPoint;

	public Triangle(IApplicationState appState, Point startPoint, Point endPoint) {
		this.state = appState;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.activeShapeType = ShapeType.TRIANGLE;
		this.activePrimaryColor = state.getActivePrimaryColor();
		this.activeShapeShadingType = state.getActiveShapeShadingType();
		this.activeSecondaryColor = state.getActiveSecondaryColor();

	}

	public Triangle(IShape shape, Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.activeShapeType = ShapeType.TRIANGLE;
		this.activePrimaryColor = shape.getColor();
		this.activeShapeShadingType = shape.getShapeShadingType();
		this.activeSecondaryColor = shape.getSecondaryColor();

	}

	public ShapeColor getColor() {

		return activePrimaryColor;
	}

	@Override
	public ShapeShadingType getShapeShadingType() {

		return activeShapeShadingType;
	}

	public String getString() {
		return "Triangle";
	}

	@Override
	public ShapeType getShapeType() {

		return activeShapeType;
	}

	@Override
	public Point getStartPoint() {
		// TODO Auto-generated method stub
		return startPoint;
	}

	@Override
	public Point getEndPoint() {
		// TODO Auto-generated method stub
		return endPoint;
	}

	@Override
	public ShapeColor getSecondaryColor() {
		return activeSecondaryColor;

	}

	@Override
	public void draw(PaintCanvas paint) {
		Graphics2D g = paint.getGraphics2D();
		int startX = (int) this.getStartPoint().getX();
		int startY = (int) this.getStartPoint().getY();
		int endX = (int) this.getEndPoint().getX();
		int endY = (int) this.getEndPoint().getY();
		int midpoint = (Math.abs(startX + endX)) / 2;
		int[] points = { startX, midpoint, endX };
		int[] widths = { endY, startY, endY };
		ColorHandler handler = new ColorHandler(this.getColor());
		ColorHandler secondHandler = new ColorHandler(this.getSecondaryColor());
		g.setColor(handler.convert());
		if (this.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
			g.fillPolygon(points, widths, 3);
		} else if (this.getShapeShadingType() == ShapeShadingType.OUTLINE) {
			g.drawPolygon(points, widths, 3);
		} else {
			g.fillPolygon(points, widths, 3);
			g.setColor(secondHandler.convert());
			g.drawPolygon(points, widths, 3);

		}
	}

	@Override
	public void setEndPoint(Point end) {
		this.endPoint = end;

	}

	@Override
	public void setStartPoint(Point start) {
		this.startPoint = start;
	}
}
