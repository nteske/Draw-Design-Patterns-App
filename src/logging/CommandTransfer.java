package logging;


import java.awt.Color;

import frame.DrawingFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.Command;
import shapes.Shape;
import shapes.ShapeObserver;
import shapes.hexagon.HexagonAdapter;
import shapes.line.*;
import shapes.point.*;
import shapes.circle.*;
import shapes.square.*;
import shapes.rectangle.*;

import shapes.hexagon.*;
import position.*;

import shapes.rectangle.Rectangle;
import shapes.square.Square;

public class CommandTransfer {
	private DrawingModel model;
	private DrawingFrame frame;
	public CommandTransfer(DrawingModel model,DrawingFrame frame) {
		this.model=model;
		this.frame=frame;
	}
	
	public Command toCommand(String line) {
		String className,doneIt,shape,shape2;
		try {
		String[] lineSplit=line.split("_");
   	 	className=lineSplit[0];
   	 	doneIt=lineSplit[1];
   	 	shape=lineSplit[2];
   	 	shape2="no";
   	 	if(lineSplit.length>3)
   	 	{
   	 		shape2=lineSplit[4];
   	 	}
		}catch (Exception e) {
			return null;
		}
   	 	
   	 	
   	 	
   		Command cmd=null;
   		//shape = shape.substring(0, shape.length() - 1);
   		
   		//shape2 = shape.substring(0, shape2.length() - 1);
   		//AddHexagonAdapter_execute_Hexagon(X=216,Y=153,r=27,outercolor=[0-0-0],innercolor=[255-255-255])
   		//Point
   		if(!shape2.equals("no")) {
   			shape2=shape2.split("\\(")[1];
   			shape2 = shape2.substring(0, shape2.length() - 1);
   		}

   		Shape sp=null;
   		ShapeObserver observer=new ShapeObserver(model, frame);
   	 	if(shape.split("\\(")[0].equals("Point")) {
   	 	shape = shape.substring(0, shape.length() - 1);
   	 		Point p=toPoint(shape);
   	 		sp=p;
   	 		int i=model.getAll().indexOf(p);
   			if(className.equals("AddPoint"))cmd=new AddPoint(model,p);
   			else if(className.equals("RemovePoint"))cmd=new RemovePoint(model,p);
   			else if(className.equals("UpdatePoint"))cmd=new UpdatePoint((Point)model.get(i),toPoint(shape2));
   	 		
   	 	}
   	 	
   	 	//Line
   	 	else if(shape.split("\\(")[0].equals("Line")) {
   	 	shape = shape.substring(0, shape.length() - 1);
   	 		Line l=toLine(shape);
   	 		sp=l;
   	 		int i=model.getAll().indexOf(l);
   			if(className.equals("AddLine"))cmd=new AddLine(model,l);
   			else if(className.equals("UpdateLine"))cmd=new UpdateLine((Line)model.get(i),toLine(shape2));
   			else if(className.equals("RemoveLine"))cmd=new RemoveLine(model,l);
   	 		}
   	 	
   	 	//Square
   	 	else if(shape.split("\\(")[0].equals("Square")) {
   	 	shape = shape.substring(0, shape.length() - 1);
   	 		Square s=toSquare(shape);
   	 		sp=s;
   	 		int i=model.getAll().indexOf(s);
   			if(className.equals("AddSquare"))cmd=new AddSquare(model,s);
   			else if(className.equals("RemoveSquare"))cmd=new RemoveSquare(model,s);
   			else if(className.equals("UpdateSquare"))cmd=new UpdateSquare((Square)model.get(i),toSquare(shape2));
   	 		}
   	 	
   	 	
   	 	else if(shape.split("\\(")[0].equals("Rectangle")) {
   	 	shape = shape.substring(0, shape.length() - 1);
   	 		Rectangle r=toRectangle(shape);
   	 		sp=r;
   	 		int i=model.getAll().indexOf(r);
   			if(className.equals("AddRectangle"))cmd=new AddRectangle(model,r);
   			else if(className.equals("UpdateRectangle"))cmd=new UpdateRectangle((Rectangle)model.get(i),toRectangle(shape2));
   			else if(className.equals("RemoveRectangle"))cmd=new RemoveRectangle(model,r);
   	 		}
   	 	
   	 	else if(shape.split("\\(")[0].equals("Circle")) {
   	 	shape = shape.substring(0, shape.length() - 1);
   	 		Circle c=toCircle(shape);
   	 		sp=c;
   	 		int i=model.getAll().indexOf(c);
   			if(className.equals("AddCircle"))cmd=new AddCircle(model,c);
   			else if(className.equals("UpdateCircle"))cmd=new UpdateCircle((Circle)model.get(i),toCircle(shape2));
   			else if(className.equals("RemoveCircle"))cmd=new RemoveCircle(model,c);
   			
   	 		}
   	 	else if(shape.split("\\(")[0].equals("Hexagon")) {
   	 	shape = shape.substring(0, shape.length() - 1);
   	 		HexagonAdapter h=toHexagonAdapter(shape);
   	 		sp=h;
   	 		int i=model.getAll().indexOf(h);
   			if(className.equals("AddHexagonAdapter"))cmd=new AddHexagonAdapter(model,h);
   			else if(className.equals("RemoveHexagonAdapter"))cmd=new RemoveHexagonAdapter(model,h);
   			else if(className.equals("UpdateHexagonAdapter"))cmd=new UpdateHexagonAdapter((HexagonAdapter)model.get(i),toHexagonAdapter(shape2));
   	 		}else return null;
   	 	
   	 	
   	 	if(cmd==null) {
   	 		if(className.equals("BringToBack"))cmd=new BringToBack(model,sp);
   	 		else if(className.equals("BringToFront"))cmd=new BringToFront(model,sp);
   	 		else if(className.equals("ToBack"))cmd=new ToBack(model,sp);
   	 		else if(className.equals("ToFront"))cmd=new ToFront(model,sp);
   	 	}
   	 	
   	 	if(cmd!=null)
   	 	{
   	 		sp.addObserver(observer);
   	 		if(doneIt.equals("execute")) {
   	 			cmd.execute();
   	 			model.addUndo(cmd);
   	 		}
   	 		else {
   	 			model.doUndo();
   	 		}
   	 	frame.getToolsController().updateButtons();
   	 	}
   	 	
		return cmd;
	}
	
	private Color getColor(String tekst) {
		tekst=tekst.substring(1);
		tekst = tekst.substring(0, tekst.length() - 1);
		String[] flow=tekst.split("-");
		int red=Integer.parseInt(flow[0]);
		int green=Integer.parseInt(flow[1]);
		int blue=Integer.parseInt(flow[2]);
		Color col=new Color(red, green, blue);
		return col;
	}
	private Point toPoint(String tekst) {
		//x=%d,y=%d,color=[%d-%d-%d]x=%d,y=%d,color=[%d-%d-%d]
		String[] flow=tekst.split(",");
		int x=Integer.parseInt(flow[0].split("=")[1]);
		int y=Integer.parseInt(flow[1].split("=")[1]);
		Color color=getColor(flow[2].split("=")[1]);
		return new Point(x,y,color);
	}
	
	private Line toLine(String tekst) {
		String[] flow=tekst.split(",");
		int startX=Integer.parseInt(flow[0].split("=")[1]);
		int startY=Integer.parseInt(flow[1].split("=")[1]);
		int endX=Integer.parseInt(flow[2].split("=")[1]);
		int endY=Integer.parseInt(flow[3].split("=")[1]);
		Color color=getColor(flow[4].split("=")[1]);
		return new Line(new Point(startX,startY),new Point(endX,endY),color);
	}
	
	private Square toSquare(String tekst) {
		String[] flow=tekst.split(",");
		//Square(UpperX=%d,UpperY=%d,a=%d,outercolor=[%d-%d-%d],innercolor=[%d-%d-%d])
		int upperX=Integer.parseInt(flow[0].split("=")[1]);
		int upperY=Integer.parseInt(flow[1].split("=")[1]);
		int width=Integer.parseInt(flow[2].split("=")[1]);
		Color outerColor=getColor(flow[3].split("=")[1]);
		Color innerColor=getColor(flow[4].split("=")[1]);
		return new Square(new Point(upperX,upperY), width, outerColor, innerColor);
	}
	
	private Rectangle toRectangle(String tekst) {
		String[] flow=tekst.split(",");
		int upperX=Integer.parseInt(flow[0].split("=")[1]);
		int upperY=Integer.parseInt(flow[1].split("=")[1]);
		int height=Integer.parseInt(flow[2].split("=")[1]);
		int width=Integer.parseInt(flow[3].split("=")[1]);
		Color outerColor=getColor(flow[4].split("=")[1]);
		Color innerColor=getColor(flow[5].split("=")[1]);
		return new Rectangle(new Point(upperX,upperY), height, width, outerColor, innerColor);
	}
	
	private Circle toCircle(String tekst) {
		//Circle(X=%d,Y=%d,r=%d,outercolor=[%d-%d-%d],innercolor=[%d-%d-%d])
		String[] flow=tekst.split(",");
		int crX=Integer.parseInt(flow[0].split("=")[1]);
		int crY=Integer.parseInt(flow[1].split("=")[1]);
		int r=Integer.parseInt(flow[2].split("=")[1]);
		Color outerColor=getColor(flow[3].split("=")[1]);
		Color innerColor=getColor(flow[4].split("=")[1]);
		return new Circle(new Point(crX,crY), r, outerColor, innerColor);
	}
	
	private HexagonAdapter toHexagonAdapter(String tekst) {
		//Hexagon(X=%d,Y=%d,r=%d,outercolor=[%d-%d-%d],innercolor=[%d-%d-%d])
		String[] flow=tekst.split(",");
		int crX=Integer.parseInt(flow[0].split("=")[1]);
		int crY=Integer.parseInt(flow[1].split("=")[1]);
		int r=Integer.parseInt(flow[2].split("=")[1]);
		Color outerColor=getColor(flow[3].split("=")[1]);
		Color innerColor=getColor(flow[4].split("=")[1]);
		return new HexagonAdapter(new Hexagon(crX, crY, r), outerColor, innerColor);
	}

}
