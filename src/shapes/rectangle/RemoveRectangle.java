package shapes.rectangle;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class RemoveRectangle implements Command{

	private static final long serialVersionUID = -7365095136118738217L;
	private DrawingModel model;
	private Rectangle rectangle;
	private Logger globalLogger = Logger.getLogger("global");
	public RemoveRectangle(DrawingModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.remove(rectangle);
		globalLogger.info(rectangle.toString());
	}

	@Override
	public void unexecute() {
		model.add(rectangle);
		globalLogger.info(rectangle.toString());
	}

}
