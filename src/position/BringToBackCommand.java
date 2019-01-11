package position;

import java.util.Collections;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class BringToBackCommand implements Command{

	private static final long serialVersionUID = -4600648609473600067L;
	private DrawingModel model;
	private Shape shape;
	private int oldState;
	public BringToBackCommand(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	@Override
	public void execute() {
		oldState=model.getAll().indexOf(shape);
		Collections.swap(model.getAll(), 0, oldState);
	}

	@Override
	public void unexecute() {
		Collections.swap(model.getAll(), 0, oldState);
	}

}
