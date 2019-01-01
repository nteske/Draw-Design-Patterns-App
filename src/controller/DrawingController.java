package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import frame.DrawingFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.Shape;
import shapes.ShapeObserver;
import shapes.circle.AddCircle;
import shapes.circle.Circle;
import shapes.hexagon.AddHexagonAdapter;
import shapes.hexagon.HexagonAdapter;
import shapes.line.AddLine;
import shapes.line.Line;
import shapes.point.AddPoint;
import shapes.point.Point;
import shapes.rectangle.AddRectangle;
import shapes.rectangle.Rectangle;
import shapes.square.AddSquare;
import shapes.square.Square;

public class DrawingController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2852398182430110027L;
	private DrawingModel model;
	private DrawingFrame frame;
	private Point start;
	private Square startSquare;
	private Line drag;
	private boolean draw=false;
	private Point stop;
	
	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent arg0) {
		if(!frame.getToolsController().isEnterSelecting()) {
			if(frame.getToolsController().getSelection()==1) {
				Point p = new Point(arg0.getX(), arg0.getY(), frame.getToolsController().getOuter());
				p.addObserver(new ShapeObserver(model, frame));
				AddPoint cmdAddPoint = new AddPoint(model, p); 
				cmdAddPoint.execute(); 
				model.addUndo(cmdAddPoint);
				frame.getView().repaint();
				frame.getToolsController().updateButtons();
			}
		}else {
			for(int i=model.getAll().size()-1;i>=0;i--){
				Shape s=model.get(i);
				if(s.contains(arg0.getX(), arg0.getY())) {
					s.setSelected(!s.isSelected());
					break;
				}
			}
			
			frame.getView().repaint();
		}
	}

	public void moveLines(MouseEvent arg0) {
		if(draw) {
			if(stop!=null)
			model.remove(stop);
			if(drag!=null)
			model.remove(drag);
			stop=new Point(arg0.getX(),arg0.getY());
			drag=new Line(start,stop);
			model.add(drag);
			model.add(stop);
			frame.getView().repaint();
		}
	}
	
	public void mousePressed(MouseEvent arg0) {
		if(frame.getToolsController().getSelection()>1&&!frame.getToolsController().isEnterSelecting()) {
			if(start==null) {
				start=new Point(arg0.getX(),arg0.getY(),frame.getToolsController().getOuter());
				startSquare=new Square(new Point(start.getX()-3,start.getY()-3),6);
				model.add(startSquare);
				model.add(start);
				draw=true;
				frame.getView().repaint();
			}
		}
	}
	
	
	public void mouseReleased(MouseEvent arg0) {
		draw=false;
		model.remove(start);
		model.remove(startSquare);
		model.remove(stop);
		model.remove(drag);
		stop=null; drag=null;startSquare=null;
		ShapeObserver observer=new ShapeObserver(model, frame);
		Color inner=frame.getToolsController().getInner();
		Color outer=frame.getToolsController().getOuter();
		if(start!=null) {
			if(frame.getToolsController().getSelection()==2) {
			Line l=new Line(start,new Point(arg0.getX(),arg0.getY(),outer),outer);
			l.addObserver(observer);
			if(l.length()>3) {
				AddLine cmd=new AddLine(model,l);
				cmd.execute();
				model.addUndo(cmd);
			}
			}
			if(frame.getToolsController().getSelection()==3) {
			Point end=new Point(arg0.getX(),arg0.getY(),Color.RED);
			directionAssitant(start, end);
			int distance=(int)(start.distance(new Point(end.getX(),end.getY(),outer))/Math.sqrt(2));
			Square s=new Square(start,distance, outer, inner);
			s.addObserver(observer);
			if(s.surfaceArea()>3) {
				AddSquare cmd=new AddSquare(model, s);
				cmd.execute();
				model.addUndo(cmd);
			}
			}
			
			if(frame.getToolsController().getSelection()==4) {
			Point end=new Point(arg0.getX(),arg0.getY(),Color.RED);
			directionAssitant(start, end);
			Rectangle r=new Rectangle(start, Math.abs(start.getY()-end.getY()), Math.abs(start.getX()-end.getX()), outer, inner);
			r.addObserver(observer);
			if(r.surfaceArea()>3) {
				AddRectangle cmd=new AddRectangle(model, r);
				cmd.execute();
				model.addUndo(cmd);
			}
			}			
			
			
			if(frame.getToolsController().getSelection()==5) {
			Circle c=new Circle(start, (int)start.distance(new Point(arg0.getX(),arg0.getY(),outer)), outer, inner);
			c.addObserver(observer);
			if(c.getRadius()>3) {
				AddCircle cmd=new AddCircle(model, c);
				cmd.execute();
				model.addUndo(cmd);
			}
			}
			
			
			if(frame.getToolsController().getSelection()==6) {
			HexagonAdapter h=new HexagonAdapter(new Hexagon(start.getX(), start.getY(),
					(int)start.distance(new Point(arg0.getX(),arg0.getY(),outer))), outer, inner);
			h.addObserver(observer);
			if(h.getHexagon().getR()>3) {
				AddHexagonAdapter cmd=new AddHexagonAdapter(model, h);
				cmd.execute();
				model.addUndo(cmd);
			}
			}
			
			start=null;
			frame.getView().repaint();
			frame.getToolsController().updateButtons();
		}
	}

	public void directionAssitant(Point start, Point end) {
		if(end.getX()<start.getX()&&end.getY()>start.getY()) {
			int temp;
			temp=start.getX();start.setX(end.getX());end.setX(temp);
		}	
		
		if(end.getX()>start.getX()&&end.getY()<start.getY()) {
			int temp;
			temp=start.getY();start.setY(end.getY());end.setY(temp);
		}	
		if(end.getX()<start.getX()&&end.getY()<start.getY()) {
			int temp;
			temp=start.getX();start.setX(end.getX());end.setX(temp);
			temp=start.getY();start.setY(end.getY());end.setY(temp);
		}	
	}


	
}
