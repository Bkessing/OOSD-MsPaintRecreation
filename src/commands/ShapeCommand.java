package commands;

import java.awt.Point;
import java.io.IOException;

import collections.ShapeList;
import factorys.ShapeFactory;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;

public class ShapeCommand implements ICommand, IUndoable {
	private Point startPoint;
	private Point endPoint;
	private IApplicationState appState;
	private ShapeList shapeList;
	private IShape history;

	public ShapeCommand(Point startPoint, Point endPoint, IApplicationState appState, ShapeList list) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
		this.shapeList = list;
		CommandHistory.add(this);
	}

	public void run() throws IOException {
		IShape shape = ShapeFactory.Create(appState, startPoint, endPoint);
		shapeList.push(shape);
		history = shape;

	}

	@Override
	public void undo() {
		shapeList.pop(history);

	}

	@Override
	public void redo() {
		shapeList.push(history);

	}

}
