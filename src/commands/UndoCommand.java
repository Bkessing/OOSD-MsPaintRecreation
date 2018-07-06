package commands;

import java.io.IOException;

import model.interfaces.ICommand;
import model.persistence.CommandHistory;

public class UndoCommand implements ICommand {

	@Override
	public void run() throws IOException {
		CommandHistory.undo();

	}

}
