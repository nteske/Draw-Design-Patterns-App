package shapes.point;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class RemovePoint implements Command {
	private static final long serialVersionUID = 4212765520295523052L;
	private DrawingModel model;
	private Point point;
	private Logger globalLogger = Logger.getLogger("global");
	

	public RemovePoint(DrawingModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.remove(point);
		globalLogger.info(point.toString());
	}

	@Override
	public void unexecute() {
		model.add(point);
		globalLogger.info(point.toString());
	}

}
