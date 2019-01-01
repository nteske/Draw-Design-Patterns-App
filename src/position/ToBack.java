package position;

import java.util.Collections;
import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class ToBack implements Command{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5425108811485215268L;
	private DrawingModel model;
	private Shape shape;
	private int oldState;
	private Logger globalLogger = Logger.getLogger("global");
	public ToBack(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	@Override
	public void execute() {
		oldState=model.getAll().indexOf(shape);
		Collections.swap(model.getAll(), oldState-1, oldState);
		globalLogger.info(shape.toString());
	}

	@Override
	public void unexecute() {
		Collections.swap(model.getAll(), oldState-1, oldState);
		globalLogger.info(shape.toString());
	}

}
