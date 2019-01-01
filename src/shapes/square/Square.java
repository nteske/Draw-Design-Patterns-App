package shapes.square;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Movable;
import shapes.Shape;
import shapes.SurfaceShape;
import shapes.line.Line;
import shapes.point.Point;

public class Square extends SurfaceShape implements Movable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -470783193023037920L;
	protected  Point upperLeft;
	protected  int sideLength;
	
	public Square() {
		
	}
	public Square(Point upperLeft,int sideLength) {
		this.upperLeft=upperLeft;
		this.sideLength=sideLength;
	}
	
	public Square(Point upperLeft, int sideLength, Color outer) {
		this(upperLeft, sideLength);
		setColor(outer);
	}
	
	public Square(Point upperLeft, int sideLength, Color outer, Color inner) {
		this(upperLeft, sideLength, outer);
		setInnerColor(inner);
	}
	
	public Line diagonal() {
		return new Line(upperLeft, new Point(upperLeft.getX() + sideLength, upperLeft.getY() + sideLength));
	}
	
	public Point center() {
		return diagonal().lineCenter();
	}
	
	public int surfaceArea() {
		return sideLength * sideLength;
	}

	public int volume() {
		return 4 * sideLength;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Square) {
			Square castedObj = (Square) obj;
			return upperLeft.equals(castedObj.getUpperLeft()) && sideLength == castedObj.getSideLength();
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Square(UpperX=%d,UpperY=%d,a=%d,outercolor=[%d-%d-%d],innercolor=[%d-%d-%d])",
				upperLeft.getX(), upperLeft.getY(), sideLength, getColor().getRed(), getColor().getGreen(),
				getColor().getBlue(), getInnerColor().getRed(), getInnerColor().getGreen(), getInnerColor().getBlue());
	}

	@Override
	public int compareTo(Shape o) {
		if (o instanceof Square) {
			Square castedObj = (Square) o;
			return surfaceArea() - castedObj.surfaceArea();
		}
		return 0;
	}
	

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, sideLength - 1, sideLength - 1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), sideLength, sideLength);
		fill(g);
		if (isSelected())
			selected(g);
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(upperLeft, new Point(upperLeft.getX() + sideLength, upperLeft.getY())).selected(g);
		new Line(upperLeft, new Point(upperLeft.getX(), upperLeft.getY() + sideLength)).selected(g);
		new Line(new Point(upperLeft.getX() + sideLength, upperLeft.getY()), diagonal().getPointEnd()).selected(g);
		new Line(new Point(upperLeft.getX(), upperLeft.getY() + sideLength), diagonal().getPointEnd()).selected(g);
	}

	@Override
	public boolean contains(int x, int y) {
		return upperLeft.getX() <= x && x <= (upperLeft.getX() + sideLength) && upperLeft.getY() <= y
				&& y <= (upperLeft.getY() + sideLength);
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeft.setX(x);
		upperLeft.setY(y);
	}

	@Override
	public void moveFor(int x, int y) {
		upperLeft.setX(upperLeft.getX() + x);
		upperLeft.setY(upperLeft.getY() + y);
	}


	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getSideLength() {
		return sideLength;
	}
	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}
	
	public Square clone() {
		return new Square(upperLeft.clone(),
				sideLength, this.getColor(), this.getInnerColor());
	}
}
