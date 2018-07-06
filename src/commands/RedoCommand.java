package commands;

import java.io.IOException;

import model.interfaces.ICommand;
import model.persistence.CommandHistory;

public class RedoCommand implements ICommand {

	@Override
	public void run() throws IOException {
		CommandHistory.redo();

	}

}
