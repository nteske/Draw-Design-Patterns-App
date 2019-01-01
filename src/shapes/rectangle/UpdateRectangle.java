package shapes.rectangle;

import java.util.logging.Logger;

import shapes.Command;

public class UpdateRectangle implements Command{

	private static final long serialVersionUID = -7464460081210689736L;
	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle originalState;
	private Logger globalLogger = Logger.getLogger("global");
	public UpdateRectangle(Rectangle originalState, Rectangle newState) {
		this.originalState = originalState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState=originalState.clone();
		originalState.setUpperLeft(newState.getUpperLeft().clone());
		originalState.setWidth(newState.getWidth());
		originalState.setSideLength(newState.getSideLength());
		originalState.setColor(newState.getColor());
		originalState.setInnerColor(newState.getInnerColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

	@Override
	public void unexecute() {
		originalState.setUpperLeft(oldState.getUpperLeft().clone());
		originalState.setWidth(oldState.getWidth());
		originalState.setSideLength(oldState.getSideLength());
		originalState.setColor(oldState.getColor());
		originalState.setInnerColor(oldState.getInnerColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

}
