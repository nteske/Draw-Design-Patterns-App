package shapes.line;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class RemoveLine implements Command {
	private static final long serialVersionUID = 2029882472633343785L;
	private DrawingModel model;
	private Line line;
	private Logger globalLogger = Logger.getLogger("global");
	public RemoveLine(DrawingModel model,Line line) {
		this.model=model;
		this.line=line;
	}
	@Override
	public void execute() {
		model.remove(line);
		globalLogger.info(line.toString());
	}

	@Override
	public void unexecute() {
		model.add(line);
		globalLogger.info(line.toString());
	}

}
