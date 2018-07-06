package controller;

import java.io.IOException;

import collections.CopyHolder;
import collections.ShapeList;
import collections.ShapesSelected;
import commands.RedoCommand;
import commands.UndoCommand;
import factorys.CommandFactory;
import model.ClickType;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private ShapeList list;
    private ShapesSelected list2;
    private CopyHolder copyHolder;
  

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList list, ShapesSelected list2, CopyHolder copyHolder) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.list = list;
        this.list2 = list2;
        this.copyHolder = copyHolder;
        
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> {ICommand copyCommand = CommandFactory.Create(ClickType.COPY, list2,copyHolder,list); try {
			copyCommand.run();
		} catch (IOException e) {
			e.printStackTrace();
		} });
    uiModule.addEvent(EventName.PASTE, () -> {ICommand pasteCommand = CommandFactory.Create(ClickType.PASTE, list2,copyHolder,list); try {
		pasteCommand.run();
	} catch (IOException e) {
		e.printStackTrace();
	} });
    
    uiModule.addEvent(EventName.DELETE, () -> {ICommand deleteCommand = CommandFactory.Create(ClickType.DELETE, list2,copyHolder,list); try {
		deleteCommand.run();
	} catch (IOException e) {
		e.printStackTrace();
	} });
    uiModule.addEvent(EventName.UNDO, () -> {ICommand undoCommand = CommandFactory.Create(ClickType.UNDO, list2,copyHolder,list); try {
		undoCommand.run();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}});
    
    uiModule.addEvent(EventName.REDO, () -> {ICommand redoCommand = CommandFactory.Create(ClickType.REDO, list2,copyHolder,list); try {
		redoCommand.run();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}});
}
}
