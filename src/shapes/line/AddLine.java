package shapes.line;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class AddLine implements Command {

	private static final long serialVersionUID = 453513436433583837L;
	private DrawingModel model;
	private Line line;
	private Logger globalLogger = Logger.getLogger("global");
	public AddLine(DrawingModel model,Line line) {
		this.model=model;
		this.line=line;
	}
	@Override
	public void execute() {
		model.add(line);
		globalLogger.info(line.toString());
	}

	@Override
	public void unexecute() {
		model.remove(line);
		globalLogger.info(line.toString());
	}

}
