package shapes.square;


import model.DrawingModel;
import shapes.Command;

public class AddSquare implements Command{

	private static final long serialVersionUID = -6536140814651176606L;
	private DrawingModel model;
	private Square square;
	public AddSquare(DrawingModel model, Square square) {
		this.model = model;
		this.square = square;
	}

	@Override
	public void execute() {
		model.add(square);
	}

	@Override
	public void unexecute() {
		model.remove(square);
	}

}
