package shapes.rectangle;


import model.DrawingModel;
import shapes.Command;

public class RemoveRectangle implements Command{

	private static final long serialVersionUID = -7365095136118738217L;
	private DrawingModel model;
	private Rectangle rectangle;
	public RemoveRectangle(DrawingModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.remove(rectangle);
	}

	@Override
	public void unexecute() {
		model.add(rectangle);
	}

}
