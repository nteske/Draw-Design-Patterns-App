package shapes.hexagon;


import model.DrawingModel;
import shapes.Command;

public class RemoveHexagonAdapter implements Command {

	private static final long serialVersionUID = 1769297719121082915L;
	private  HexagonAdapter hexagon;
	private	 DrawingModel model;
	public RemoveHexagonAdapter(DrawingModel model,HexagonAdapter hexagon) {
		this.model=model;
		this.hexagon=hexagon;
	}
	@Override
	public void execute() {
		model.remove(hexagon);
		
	}

	@Override
	public void unexecute() {
		model.add(hexagon);
	}

}
