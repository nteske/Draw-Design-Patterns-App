package shapes.hexagon;


import hexagon.Hexagon;
import shapes.Command;

public class UpdateHexagonAdapter implements Command{
	private static final long serialVersionUID = 1411995325518751712L;
	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter originalState;
	public UpdateHexagonAdapter(HexagonAdapter originalState,HexagonAdapter newState) {
		this.originalState=originalState;
		this.newState=newState;
	}
	@Override
	public void execute() {
		oldState=originalState.clone();
		originalState.setHexagon(new Hexagon(newState.getHexagon().getX(), newState.getHexagon().getY(), newState.getHexagon().getR()));
		originalState.setColor(newState.getColor());
		originalState.setInnerColor(newState.getInnerColor());
		originalState.setSelected(newState.isSelected());
	}
	@Override
	public void unexecute() {
		originalState.setHexagon(new Hexagon(oldState.getHexagon().getX(), oldState.getHexagon().getY(), oldState.getHexagon().getR()));
		originalState.setColor(oldState.getColor());
		originalState.setInnerColor(oldState.getInnerColor());
		originalState.setSelected(oldState.isSelected());
	}

}
