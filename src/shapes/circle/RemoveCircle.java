package shapes.circle;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class RemoveCircle implements Command {

	private static final long serialVersionUID = 2718465074191333778L;
	private DrawingModel model;
	private Circle circle;
	private Logger globalLogger = Logger.getLogger("global");
	public RemoveCircle(DrawingModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}
	@Override
	public void execute() {
		model.remove(circle);
		globalLogger.info(circle.toString());
	}

	@Override
	public void unexecute() {
		model.add(circle);
		globalLogger.info(circle.toString());
	}

}
