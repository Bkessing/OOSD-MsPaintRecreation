package commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import collections.ShapeList;
import collections.ShapesSelected;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;

public class DeleteCommand implements ICommand, IUndoable {
	private ShapeList list;
	private ShapesSelected shapesSelected;
	private ArrayList<IShape> history;

	public DeleteCommand(ShapeList list, ShapesSelected shapesSelected) {
		this.list = list;
		this.shapesSelected = shapesSelected;

	}

	@Override
	public void run() throws IOException {
		CommandHistory.add(this);
		history = new ArrayList<IShape>();
		for (IShape shape : this.shapesSelected) {
			{
				list.pop(shape);
				this.history.add(shape);
			}

		}
		list.notifyObserver();

	}

	@Override
	public void undo() {
		for (IShape shape : this.history) {
			this.list.push(shape);
		}

	}

	@Override
	public void redo() {
		for (IShape shape : this.history) {
			this.list.pop(shape);
		}

	}
}
