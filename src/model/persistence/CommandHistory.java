package model.persistence;

import java.util.Stack;

import model.interfaces.IUndoable;

public class CommandHistory {
	private static final Stack<IUndoable> undoStack = new Stack<IUndoable>();
	private static final Stack<IUndoable> redoStack = new Stack<IUndoable>();

	public static void add(IUndoable command) {
		undoStack.push(command);
		redoStack.clear();
	}

	public static void undo() {
		boolean result = !undoStack.empty();
		if (result) {
			IUndoable x = undoStack.pop();
			redoStack.push(x);
			x.undo();
		}
	}

	public static void redo() {
		boolean result = !redoStack.empty();
		if (result) {
			IUndoable x = redoStack.pop();
			undoStack.push(x);
			x.redo();
		}
	}
}
