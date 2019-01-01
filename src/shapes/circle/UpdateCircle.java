package shapes.circle;

import java.util.logging.Logger;

import shapes.Command;

public class UpdateCircle implements Command {

	private static final long serialVersionUID = 8264407501688477834L;
	private Circle oldState;
	private Circle newState;
	private Circle originalState;
	private Logger globalLogger = Logger.getLogger("global");
	public UpdateCircle(Circle originalState, Circle newState) {
		this.originalState = originalState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState=originalState.clone();
		originalState.setCenter(newState.getCenter().clone());
		originalState.setRadius(newState.getRadius());
		originalState.setColor(newState.getColor());
		originalState.setInnerColor(newState.getInnerColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

	@Override
	public void unexecute() {
		originalState.setCenter(oldState.getCenter().clone());
		originalState.setRadius(oldState.getRadius());
		originalState.setColor(oldState.getColor());
		originalState.setInnerColor(oldState.getInnerColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

}
