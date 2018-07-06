package main;

import collections.CopyHolder;
import collections.ShapeList;
import collections.ShapesSelected;
import controller.IJPaintController;
import controller.JPaintController;

import model.persistence.ApplicationState;
import model.persistence.MouseHandler;
import model.persistence.ShapeListener;

import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
	public static void main(String[] args) {
		PaintCanvas paint = new PaintCanvas();
		ShapeList shapeList = new ShapeList();
		ShapesSelected shapesSelected = new ShapesSelected();
		CopyHolder copyHolder = new CopyHolder();
		@SuppressWarnings("unused")
		ShapeListener listen = new ShapeListener(paint, shapeList);
		IGuiWindow guiWindow = new GuiWindow(paint);
		IUiModule uiModule = new Gui(guiWindow);
		ApplicationState appState = new ApplicationState(uiModule);
		IJPaintController controller = new JPaintController(uiModule, appState, shapeList, shapesSelected, copyHolder);
		MouseHandler mouse = new MouseHandler(appState, shapeList, shapesSelected);
		paint.addMouseListener(mouse);
		paint.setFocusable(true);
		paint.requestFocusInWindow();
		controller.setup();

	}
}
