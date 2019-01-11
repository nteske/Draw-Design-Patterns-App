package shapes.hexagon;


import model.DrawingModel;
import shapes.Command;

public class AddHexagonAdapter implements Command {

	private static final long serialVersionUID = -7937406830078929649L;
	private HexagonAdapter hexagon;
	private DrawingModel model;
	 public AddHexagonAdapter(DrawingModel model,HexagonAdapter hexagon) {
		this.model=model;
		this.hexagon=hexagon;
	}
	@Override
	public void execute() {
		model.add(hexagon);
		
	}

	@Override
	public void unexecute() {
		model.remove(hexagon);
	}

}
