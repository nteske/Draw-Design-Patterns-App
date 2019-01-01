package position;

import java.util.Collections;
import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class BringToBack implements Command{

	private static final long serialVersionUID = -4600648609473600067L;
	private DrawingModel model;
	private Shape shape;
	private int oldState;
	private Logger globalLogger = Logger.getLogger("global");
	public BringToBack(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	@Override
	public void execute() {
		oldState=model.getAll().indexOf(shape);
		Collections.swap(model.getAll(), 0, oldState);
		globalLogger.info(shape.toString());
	}

	@Override
	public void unexecute() {
		Collections.swap(model.getAll(), 0, oldState);
		globalLogger.info(shape.toString());
	}

}
