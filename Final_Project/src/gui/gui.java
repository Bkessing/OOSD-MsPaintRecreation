package gui;




import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import view.*;
import view.gui.*;
import view.interfaces.*;

public class gui{
    public static void main(String args[]) {
    PaintCanvas paint = new PaintCanvas();
    @SuppressWarnings("unused")
    GuiWindow test = new GuiWindow(paint);
    Gui window = new Gui(test);
    
    
   	window.addEvent(EventName.CHOOSE_SHAPE,new IEventCallback() {

		public void run() {
			System.out.println("Choose Shape Pressed");
			IDialogChoice shapes = new IDialogChoice() {

				public Object getCurrentSelection() {
					// TODO Auto-generated method stub
					return null;
				}

				public Object[] getDialogOptions() {
		
					return enums.Shape.values();
				}

	
				public String getDialogText() {
			
					return "Shapes";
				}

		
				public String getDialogTitle() {
		
					return "Choose Shape";
				}
				
			};
			String answer = window.getDialogResponse(shapes);
			System.out.println(answer);
			
			
			
		}
   	});
   	
    }
}
