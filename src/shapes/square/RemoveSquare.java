package shapes.square;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class RemoveSquare implements Command {

	private static final long serialVersionUID = -5425139054028197342L;
	private DrawingModel model;
	private Square square;
	private Logger globalLogger = Logger.getLogger("global");
	public RemoveSquare(DrawingModel model, Square square) {
		this.model = model;
		this.square = square;
	}
	@Override
	public void execute() {
		model.remove(square);
		globalLogger.info(square.toString());
	}

	@Override
	public void unexecute() {
		model.add(square);
		globalLogger.info(square.toString());
	}

}
