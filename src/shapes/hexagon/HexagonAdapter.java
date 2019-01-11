package shapes.hexagon;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import shapes.Movable;
import shapes.Shape;
import shapes.SurfaceShape;

public class HexagonAdapter extends SurfaceShape implements Movable{

	private static final long serialVersionUID = 1L;
	private Hexagon hexagon;


	public HexagonAdapter(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public HexagonAdapter(Hexagon hexagon,Color color) {
		this(hexagon);
		setColor(color);
	}
	
	public HexagonAdapter(Hexagon hexagon,Color outerColor, Color innerColor) {
		this(hexagon, outerColor);
		setInnerColor(innerColor);
	}
	
	public void setColor(Color color) {
		super.setColor(color);
		hexagon.setBorderColor(color);
		
	}
	public void setInnerColor(Color color) {
		super.setInnerColor(color);
		hexagon.setAreaColor(color);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			Hexagon hexaFromObj = ((HexagonAdapter) obj).getHexagon();
			return hexagon.getX() == hexaFromObj.getX() && hexagon.getY() == hexaFromObj.getY()
					&& hexagon.getR() == hexaFromObj.getR();
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Hexagon(X=%d,Y=%d,r=%d,outercolor=[%d-%d-%d],innercolor=[%d-%d-%d],selected=%b)", hexagon.getX(),
				hexagon.getY(), hexagon.getR(), getColor().getRed(), getColor().getGreen(), getColor().getBlue(),
				getInnerColor().getRed(), getInnerColor().getGreen(), getInnerColor().getBlue(),isSelected());
	}
	
	@Override
	public int compareTo(Shape arg0) {
		if (arg0 instanceof HexagonAdapter) {
			return hexagon.getR() - ((HexagonAdapter) arg0).getHexagon().getR();
		}
		return 0;
	}
	@Override
	public boolean isSelected() {
		return hexagon.isSelected();
	}

	@Override
	public void setSelected(boolean selected) {
		hexagon.setSelected(selected);
		super.setSelected(selected);
	}

	@Override
	public void moveTo(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);
		
	}

	@Override
	public void moveFor(int x, int y) {
		hexagon.setX(hexagon.getX() + x);
		hexagon.setY(hexagon.getY() + y);
		
	}

	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
		
	}

	@Override
	public void selected(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}
	
	
	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}

	public HexagonAdapter clone() {
		HexagonAdapter h=new HexagonAdapter(new Hexagon(hexagon.getX(),hexagon.getY(), hexagon.getR()), this.getColor(), this.getInnerColor());
		h.setSelected(isSelected());
		return h;	}
}
