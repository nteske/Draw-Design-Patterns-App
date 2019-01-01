package shapes.hexagon;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class RemoveHexagonAdapter implements Command {

	private static final long serialVersionUID = 1769297719121082915L;
	private  HexagonAdapter hexagon;
	private	 DrawingModel model;
	private Logger globalLogger = Logger.getLogger("global");
	public RemoveHexagonAdapter(DrawingModel model,HexagonAdapter hexagon) {
		this.model=model;
		this.hexagon=hexagon;
	}
	@Override
	public void execute() {
		model.remove(hexagon);
		globalLogger.info(hexagon.toString());
		
	}

	@Override
	public void unexecute() {
		model.add(hexagon);
		globalLogger.info(hexagon.toString());
	}

}
