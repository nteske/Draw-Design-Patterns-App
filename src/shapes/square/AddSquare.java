package shapes.square;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class AddSquare implements Command{

	private static final long serialVersionUID = -6536140814651176606L;
	private DrawingModel model;
	private Square square;
	private Logger globalLogger = Logger.getLogger("global");
	public AddSquare(DrawingModel model, Square square) {
		this.model = model;
		this.square = square;
	}

	@Override
	public void execute() {
		model.add(square);
		globalLogger.info(square.toString());
	}

	@Override
	public void unexecute() {
		model.remove(square);
		globalLogger.info(square.toString());
	}

}
