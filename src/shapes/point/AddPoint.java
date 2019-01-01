package shapes.point;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class AddPoint implements Command{

	private static final long serialVersionUID = -6915180535847086968L;
    private DrawingModel model;
    private Point point;
    private Logger globalLogger = Logger.getLogger("global");
    
	public AddPoint(DrawingModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.add(point);
		globalLogger.info(point.toString());
	}

	@Override
	public void unexecute() {
		model.remove(point);
		globalLogger.info(point.toString());
	}

}
