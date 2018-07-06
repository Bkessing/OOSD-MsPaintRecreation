package factorys;

import collections.CopyHolder;
import collections.ShapeList;
import collections.ShapesSelected;
import commands.CopyCommand;
import commands.DeleteCommand;
import commands.PasteCommand;
import commands.RedoCommand;
import commands.UndoCommand;
import model.ClickType;
import model.interfaces.ICommand;

public class CommandFactory {

	public static ICommand Create(ClickType type, ShapesSelected shapesSelected, CopyHolder copyHolder,
			ShapeList shapeList) {
		if (type == ClickType.COPY) {

			return new CopyCommand(shapesSelected, copyHolder);
		} else if (type == ClickType.DELETE) {

			return new DeleteCommand(shapeList, shapesSelected);

		} else if (type == ClickType.UNDO) {

			return new UndoCommand();
		}

		else if (type == ClickType.REDO) {
			return new RedoCommand();

		}

		else {
			return new PasteCommand(copyHolder, shapeList);

		}

	}

}
