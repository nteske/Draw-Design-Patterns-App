package shapes.hexagon;

import java.util.logging.Logger;

import model.DrawingModel;
import shapes.Command;

public class AddHexagonAdapter implements Command {

	private static final long serialVersionUID = -7937406830078929649L;
	private HexagonAdapter hexagon;
	private DrawingModel model;
	private Logger globalLogger = Logger.getLogger("global");
	 public AddHexagonAdapter(DrawingModel model,HexagonAdapter hexagon) {
		this.model=model;
		this.hexagon=hexagon;
	}
	@Override
	public void execute() {
		model.add(hexagon);
		globalLogger.info(hexagon.toString());
		
	}

	@Override
	public void unexecute() {
		model.remove(hexagon);
		globalLogger.info(hexagon.toString());
	}

}
