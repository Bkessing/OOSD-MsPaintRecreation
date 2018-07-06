package commands;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import collections.ShapeList;
import collections.ShapesSelected;
import factorys.ShapeFactory;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;

public class MoveCommand implements ICommand, IUndoable {
	private ShapeList shapeList;
	private ShapesSelected shapesSelected;
	private Point startPoint;
	private Point endPoint;
	private ArrayList<IShape> history;
	private ArrayList<IShape> copyHistory;

	public MoveCommand(ShapeList shapeList, ShapesSelected shapesSelected, Point startPoint, Point endPoint) {
		this.shapeList = shapeList;
		this.shapesSelected = shapesSelected;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		CommandHistory.add(this);

	}

	@Override
	public void run() throws IOException {
		this.history = new ArrayList<IShape>();
		this.copyHistory = new ArrayList<IShape>();
		for (IShape shape : this.shapesSelected) {
			history.add(shape);
			this.shapeList.pop(shape);
			double Xchange = (this.startPoint.getX() - this.endPoint.getX()) * -1;
			double Ychange = (this.startPoint.getY() - this.endPoint.getY()) * -1;
			int StartX = (int) (shape.getStartPoint().getX() + Xchange);
			int StartY = (int) (shape.getStartPoint().getY() + Ychange);
			int EndX = (int) (shape.getEndPoint().getX() + Xchange);
			int EndY = (int) (shape.getEndPoint().getY() + Ychange);
			Point Start = new Point(StartX, StartY);
			Point End = new Point(EndX, EndY);
			IShape copy = ShapeFactory.CreateCopy(shape, Start, End);
			copyHistory.add(copy);
			this.shapeList.push(copy);

		}
		shapesSelected.clear();
		for (IShape shape : copyHistory) {
			shapesSelected.add(shape);
		}

	}

	@Override
	public void undo() {
		for (IShape shape : this.history) {
			this.shapeList.push(shape);

		}
		for (IShape shape : this.copyHistory) {
			this.shapeList.pop(shape);

		}
		this.shapeList.notifyObserver();
		shapesSelected.clear();

	}

	@Override
	public void redo() {
		for (IShape shape : this.history) {
			this.shapeList.pop(shape);

		}
		for (IShape shape : this.copyHistory) {
			this.shapeList.push(shape);

		}
		this.shapeList.notifyObserver();
		shapesSelected.clear();

	}
}
