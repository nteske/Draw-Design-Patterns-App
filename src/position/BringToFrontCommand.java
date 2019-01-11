package position;


import java.util.Collections;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class BringToFrontCommand implements Command {

	private static final long serialVersionUID = -5639011122262095118L;
	private DrawingModel model;
	private Shape shape;
	private int oldState;
	public BringToFrontCommand(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	@Override
	public void execute() {
		oldState=model.getAll().indexOf(shape);
		Collections.swap(model.getAll(), model.getAll().size()-1, oldState);
	}

	@Override
	public void unexecute() {
		Collections.swap(model.getAll(), model.getAll().size()-1, oldState);
	}
}
