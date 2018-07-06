package collections;

import java.awt.List;
import java.util.ArrayList;
import java.util.EmptyStackException;

import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IShapeSubject;
import view.gui.PaintCanvas;

@SuppressWarnings("serial")
public class ShapeList extends ArrayList<IShape> implements IShapeSubject {
	private IShapeObserver observers;

	public void push(IShape shape) {
		if (shape == null)
			throw new IllegalArgumentException();
		this.add(shape);
		notifyObserver();
	}

	public IShape pop(IShape shape) {
		if (this.isEmpty())
			throw new EmptyStackException();
		this.remove(shape);
		notifyObserver();
		return shape;

	}

	@Override
	public void registerObserver(IShapeObserver observer) {
		observers = observer;

	}

	public void notifyObserver() {

		observers.update(this);

	}
}
