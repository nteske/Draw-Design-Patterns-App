package shapes.point;

import java.util.logging.Logger;

import shapes.Command;

public class UpdatePoint implements Command{

	private static final long serialVersionUID = 811891398486043319L;
	private Point oldState;
	private Point newState;
	private Point originalState;
	private Logger globalLogger = Logger.getLogger("global");

	public UpdatePoint(Point originalState, Point newState) {
		this.originalState = originalState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState=originalState.clone();
		originalState.setX(newState.getX());
		originalState.setY(newState.getY());
		originalState.setColor(newState.getColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

	@Override
	public void unexecute() {
		originalState.setX(oldState.getX());
		originalState.setY(oldState.getY());
		originalState.setColor(oldState.getColor());
		globalLogger.info(originalState.toString());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

}
