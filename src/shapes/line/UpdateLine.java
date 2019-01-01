package shapes.line;

import java.util.logging.Logger;

import shapes.Command;

public class UpdateLine implements Command{

	private static final long serialVersionUID = 546022047554053818L;
	private Line oldState;
	private Line newState;
	private Line originalState;
	private Logger globalLogger = Logger.getLogger("global");
	public UpdateLine(Line originalState,Line newState) {
		this.originalState=originalState;
		this.newState=newState;
	}
	@Override
	public void execute() {
		oldState=originalState.clone();
		originalState.setPointStart(newState.getPointStart().clone());
		originalState.setPointEnd(newState.getPointEnd().clone());
		originalState.setColor(newState.getColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

	@Override
	public void unexecute() {
		originalState.setPointStart(oldState.getPointStart().clone());
		originalState.setPointEnd(oldState.getPointEnd().clone());
		originalState.setColor(oldState.getColor());
		globalLogger.info(oldState.toString()+"_to_"+originalState.toString());
	}

}
