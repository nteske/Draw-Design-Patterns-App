package shapes.square;

import java.util.logging.Logger;

import shapes.Command;

public class UpdateSquare implements Command{

	private static final long serialVersionUID = 8703943595953072018L;
	private Square oldState;
	private Square newState;
	private Square originalState;
	private Logger globalLogger = Logger.getLogger("global");
	public UpdateSquare(Square originalState, Square newState) {
		this.originalState = originalState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState=originalState.clone();
		originalState.setUpperLeft(newState.getUpperLeft().clone());
		originalState.setSideLength(newState.getSideLength());
		originalState.setColor(newState.getColor());
		originalState.setInnerColor(newState.getInnerColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

	@Override
	public void unexecute() {
		originalState.setUpperLeft(oldState.getUpperLeft().clone());
		originalState.setSideLength(oldState.getSideLength());
		originalState.setColor(oldState.getColor());
		originalState.setInnerColor(oldState.getInnerColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

}
