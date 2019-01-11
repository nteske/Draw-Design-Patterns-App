package shapes.point;


import model.DrawingModel;
import shapes.Command;

public class AddPoint implements Command{

	private static final long serialVersionUID = -6915180535847086968L;
    private DrawingModel model;
    private Point point;
    
	public AddPoint(DrawingModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.add(point);
	}

	@Override
	public void unexecute() {
		model.remove(point);
	}

}
