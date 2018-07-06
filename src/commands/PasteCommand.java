package commands;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import collections.CopyHolder;
import collections.ShapeList;
import factorys.ShapeFactory;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;

public class PasteCommand implements ICommand, IUndoable {
	private CopyHolder copyHolder;
	private ShapeList shapeList;
	private ArrayList<IShape> history;

	public PasteCommand(CopyHolder copyHolder, ShapeList shapeList) {
		this.copyHolder = copyHolder;
		this.shapeList = shapeList;
		CommandHistory.add(this);
	}

	@Override
	public void run() throws IOException {
		history = new ArrayList<IShape>();
		Point start = new Point(5, 5);
		Point end;
		for (IShape shape : this.copyHolder) {
			IShape copy = ShapeFactory.CreateCopy(shape, shape.getStartPoint(), shape.getEndPoint());
			int Xchange = (int) copy.getStartPoint().getX();
			int Ychange = (int) copy.getStartPoint().getY();
			int X = (int) (copy.getEndPoint().getX() - Xchange);
			int Y = (int) (copy.getEndPoint().getY() - Ychange);
			end = new Point(X, Y);
			copy.setStartPoint(start);
			copy.setEndPoint(end);
			this.history.add(copy);
			this.shapeList.push(copy);
		}

	}

	@Override
	public void undo() {
		for (IShape shape : this.history) {
			shapeList.pop(shape);

		}
		shapeList.notifyObserver();

	}

	@Override
	public void redo() {
		for (IShape shape : this.history) {
			shapeList.push(shape);

		}

	}

}
