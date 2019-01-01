package shapes.circle;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class AddCircle implements Command{

	private static final long serialVersionUID = 4750085445857983406L;
	private DrawingModel model;
	private Circle circle;
	private Logger globalLogger = Logger.getLogger("global");
	public AddCircle(DrawingModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.add(circle);
		globalLogger.info(circle.toString());
	}

	@Override
	public void unexecute() {
		model.remove(circle);
		globalLogger.info(circle.toString());
	}

}
