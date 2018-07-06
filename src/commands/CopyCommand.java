package commands;

import java.io.IOException;

import collections.CopyHolder;
import collections.ShapesSelected;
import model.interfaces.ICommand;
import model.interfaces.IShape;

public class CopyCommand implements ICommand {
	private ShapesSelected shapesSelected;
	private CopyHolder copyHolder;

	public CopyCommand(ShapesSelected shapesSelected, CopyHolder copyHolder) {
		this.shapesSelected = shapesSelected;
		this.copyHolder = copyHolder;
	}

	@Override
	public void run() throws IOException {
		this.copyHolder.clear();

		for (IShape shape : this.shapesSelected) {
			copyHolder.add(shape);
		}

	}

}
