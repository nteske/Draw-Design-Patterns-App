package shapes.circle;


import model.DrawingModel;
import shapes.Command;

public class AddCircle implements Command{

	private static final long serialVersionUID = 4750085445857983406L;
	private DrawingModel model;
	private Circle circle;
	public AddCircle(DrawingModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.add(circle);
	}

	@Override
	public void unexecute() {
		model.remove(circle);
	}

}
