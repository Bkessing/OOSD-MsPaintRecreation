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

public class Rectangle implements IShape {
	private ShapeType activeShapeType;
	private ShapeColor activePrimaryColor;
	private ShapeColor activeSecondaryColor;
	private ShapeShadingType activeShapeShadingType;
	private IApplicationState state;
	private Point startPoint;
	private Point endPoint;

	public Rectangle(IApplicationState appState, Point startPoint, Point endPoint) {
		this.state = appState;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.activeShapeType = ShapeType.RECTANGLE;
		this.activePrimaryColor = state.getActivePrimaryColor();
		this.activeShapeShadingType = state.getActiveShapeShadingType();
		this.activeSecondaryColor = state.getActiveSecondaryColor();

	}

	public Rectangle(IShape shape, Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.activeShapeType = ShapeType.RECTANGLE;
		this.activePrimaryColor = shape.getColor();
		this.activeShapeShadingType = shape.getShapeShadingType();
		this.activeSecondaryColor = shape.getSecondaryColor();

	}

	@Override
	public ShapeColor getColor() {

		return activePrimaryColor;
	}

	@Override
	public ShapeShadingType getShapeShadingType() {

		return activeShapeShadingType;
	}

	public String getString() {
		return "Rectangle";
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
		ColorHandler handler = new ColorHandler(this.getColor());
		ColorHandler secondHandler = new ColorHandler(this.getSecondaryColor());
		g.setColor(handler.convert());
		if (this.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
			g.fillRect(startX, startY, Math.abs(startX - endX), Math.abs(startY - endY));
		} else if (this.getShapeShadingType() == ShapeShadingType.OUTLINE) {
			g.drawRect(startX, startY, Math.abs(startX - endX), Math.abs(startY - endY));
		} else {
			g.fillRect(startX, startY, Math.abs(startX - endX), Math.abs(startY - endY));
			g.setColor(secondHandler.convert());
			g.drawRect(startX, startY, Math.abs(startX - endX), Math.abs(startY - endY));
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
