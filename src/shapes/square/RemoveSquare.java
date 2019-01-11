package shapes.square;


import model.DrawingModel;
import shapes.Command;

public class RemoveSquare implements Command {

	private static final long serialVersionUID = -5425139054028197342L;
	private DrawingModel model;
	private Square square;
	public RemoveSquare(DrawingModel model, Square square) {
		this.model = model;
		this.square = square;
	}
	@Override
	public void execute() {
		model.remove(square);
	}

	@Override
	public void unexecute() {
		model.add(square);
	}

}
