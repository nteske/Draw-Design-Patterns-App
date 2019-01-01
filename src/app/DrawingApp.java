

package app;

import java.util.logging.Logger;

import javax.swing.JFrame;

import controller.DrawingController;
import controller.MenuController;
import controller.ToolsController;
import frame.DrawingFrame;
import logging.LogHandler;
import model.DrawingModel;


public class DrawingApp {

	public static void main(String[] args) {		
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setController(controller);
		ToolsController tController=new ToolsController(model, frame);
		MenuController mController=new MenuController(model, frame);
		
		Logger globalLogger = Logger.getLogger("global");
		globalLogger.setUseParentHandlers(false);
		globalLogger.addHandler(new LogHandler(frame));
		frame.setMenuController(mController);
		frame.setToolsController(tController);
		frame.setSize(1200, 700);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
