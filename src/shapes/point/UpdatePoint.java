package shapes.point;


import shapes.Command;

public class UpdatePoint implements Command{

	private static final long serialVersionUID = 811891398486043319L;
	private Point oldState;
	private Point newState;
	private Point originalState;

	public UpdatePoint(Point originalState, Point newState) {
		this.originalState = originalState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState=originalState.clone();
		originalState.setX(newState.getX());
		originalState.setY(newState.getY());
		originalState.setColor(newState.getColor());
		originalState.setSelected(newState.isSelected());
	}

	@Override
	public void unexecute() {
		originalState.setX(oldState.getX());
		originalState.setY(oldState.getY());
		originalState.setColor(oldState.getColor());
		originalState.setSelected(oldState.isSelected());
	}

}
