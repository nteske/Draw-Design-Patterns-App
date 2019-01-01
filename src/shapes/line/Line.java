package shapes.line;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Shape;
import shapes.point.Point;

public class Line extends Shape{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7166307640106360873L;
	private Point pointStart;
	private Point pointEnd;

	public Line() {

	}
	
	public Line(Point pointStart, Point pointEnd) {
		this.pointStart = pointStart;
		this.pointEnd = pointEnd;
	}
	
	public Line(Point pointStart, Point pointEnd,Color color) {
		this(pointStart,pointEnd);
		setColor(color);
	}

	public double length() {
		return pointStart.distance(pointEnd);
	}

	@Override
	public String toString() {
		return String.format("Line(startX=%d,startY=%d,endX=%d,endY=%d,color=[%d-%d-%d])", pointStart.getX(),
				pointStart.getY(), pointEnd.getX(), pointEnd.getY(), getColor().getRed(), getColor().getGreen(),
				getColor().getBlue());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line castedObj = (Line) obj;
			return pointStart.equals(castedObj.getPointStart()) && pointEnd.equals(castedObj.getPointEnd());
		}
		return false;
	}

	@Override
	public int compareTo(Shape shape) {
		if (shape instanceof Line) {
			Line castedShape = (Line) shape;
			return (int) this.length() - (int) castedShape.length();
		}
		return 0;
	}

	public void moveFor(int x, int y) {
		pointStart.setX(pointStart.getX() + x);
		pointStart.setY(pointStart.getY() + y);
		pointEnd.setX(pointEnd.getX() + x);
		pointEnd.setY(pointEnd.getY() + y);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(pointStart.getX(), pointStart.getY(), pointEnd.getX(), pointEnd.getY());
		if (isSelected())
			selected(g);
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		pointStart.selected(g);
		pointEnd.selected(g);
		lineCenter().selected(g);
	}

	@Override
	public boolean contains(int x, int y) {
		Point testPt = new Point(x, y);
		return (testPt.distance(pointStart) + testPt.distance(pointEnd) - length()) <= 0.5;
	}
	
	public Point lineCenter() {
		int centerX = (pointStart.getX() + pointEnd.getX()) / 2;
		int centerY = (pointStart.getY() + pointEnd.getY()) / 2;
		return new Point(centerX, centerY);
	}

	
	public Point getPointStart() {
		return pointStart;
	}

	public void setPointStart(Point pointStart) {
		this.pointStart = pointStart;
	}

	public Point getPointEnd() {
		return pointEnd;
	}

	public void setPointEnd(Point pointEnd) {
		this.pointEnd = pointEnd;
	}

	public Line clone() {
		return new Line(pointStart.clone(),pointEnd.clone(),this.getColor());
	}

}
