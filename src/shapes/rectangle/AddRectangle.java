package shapes.rectangle;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class AddRectangle implements Command{

	private static final long serialVersionUID = 7933382380315617476L;
	private DrawingModel model;
	private Rectangle rectangle;
	private Logger globalLogger = Logger.getLogger("global");
	public AddRectangle(DrawingModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.add(rectangle);
		globalLogger.info(rectangle.toString());
	}

	@Override
	public void unexecute() {
		model.remove(rectangle);
		globalLogger.info(rectangle.toString());
	}

}
