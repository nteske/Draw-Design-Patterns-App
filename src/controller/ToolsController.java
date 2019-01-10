package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;


import frame.DrawingFrame;
import model.DrawingModel;
import modify.DialogCircle;
import modify.DialogHexagon;
import modify.DialogLine;
import modify.DialogPoint;
import modify.DialogRectangle;
import modify.DialogSquare;
import position.BringToBack;
import position.BringToFront;
import position.ToBack;
import position.ToFront;
import shapes.Command;
import shapes.Shape;
import shapes.circle.Circle;
import shapes.circle.RemoveCircle;
import shapes.circle.UpdateCircle;
import shapes.hexagon.HexagonAdapter;
import shapes.hexagon.RemoveHexagonAdapter;
import shapes.hexagon.UpdateHexagonAdapter;
import shapes.line.Line;
import shapes.line.RemoveLine;
import shapes.line.UpdateLine;
import shapes.point.Point;
import shapes.point.RemovePoint;
import shapes.point.UpdatePoint;
import shapes.rectangle.Rectangle;
import shapes.rectangle.RemoveRectangle;
import shapes.square.RemoveSquare;
import shapes.square.Square;
import shapes.square.UpdateSquare;

public class ToolsController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9180063586684021290L;
	private DrawingModel model;
	private DrawingFrame frame;
	private int selection=1;
	private final Color btnColor=Color.gray;
	private Color inner=Color.WHITE,outer=Color.BLACK;
	private boolean enterSelecting=false;
	public ToolsController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		frame.getSelViews().getBtnInner().setBackground(inner);
		frame.getSelViews().getBtnOutter().setBackground(outer);
		changeButtonCollor();
	}
	public void pointSelected(ActionEvent e) {
		selection=1;
		changeButtonCollor();
	}
	public void lineSelected(ActionEvent e) {
		selection=2;
		changeButtonCollor();
	}
	public void squareSelected(ActionEvent e) {
		selection=3;
		changeButtonCollor();
	}
	public void rectangleSelected(ActionEvent e) {
		selection=4;
		changeButtonCollor();
	}
	public void circleSelected(ActionEvent e) {
		selection=5;
		changeButtonCollor();
	}
	public void hexagonSelected(ActionEvent e) {
		selection=6;	
		changeButtonCollor();
	}
	
	public void changeButtonCollor() {
		frame.getSViews().getBtnPoint().setBackground(null);
		frame.getSViews().getBtnLine().setBackground(null);
		frame.getSViews().getBtnSquare().setBackground(null);
		frame.getSViews().getBtnRectangle().setBackground(null);
		frame.getSViews().getBtnCircle().setBackground(null);
		frame.getSViews().getBtnHexagon().setBackground(null);
		if(selection==1) {
			frame.getSViews().getBtnPoint().setBackground(btnColor);
		}else if(selection==2) {
			frame.getSViews().getBtnLine().setBackground(btnColor);
		}else if(selection==3) {
			frame.getSViews().getBtnSquare().setBackground(btnColor);
		}else if(selection==4) {
			frame.getSViews().getBtnRectangle().setBackground(btnColor);
		}else if(selection==5) {
			frame.getSViews().getBtnCircle().setBackground(btnColor);
		}else if(selection==6) {
			frame.getSViews().getBtnHexagon().setBackground(btnColor);
		}
	}
	//updateButtons();
	public void updateButtons() {
		if(model.getUndoStack().size()==0)frame.getSelViews().getBtnUndo().setEnabled(false);
		else frame.getSelViews().getBtnUndo().setEnabled(true);
		if(model.getRedoStack().size()==0)frame.getSelViews().getBtnRedo().setEnabled(false);
		else frame.getSelViews().getBtnRedo().setEnabled(true);
	}
	
	public void undoCommand() {
		if(model.getUndoStack().size()!=0) {
		do {
		Command old=model.getUndoStack().peek();
		model.doUndo();
		if(!isRemoveCommand(old))break;
		}
		while(!model.getUndoStack().isEmpty()&&isRemoveCommand(model.getUndoStack().peek()));
		
		if(enterSelecting)selectShape(null);
		frame.getView().repaint();
		updateButtons();
		}else JOptionPane.showMessageDialog(null, "List is empty", "Undo command:", JOptionPane.INFORMATION_MESSAGE);
	}
	private boolean isRemoveCommand(Command cmd) {
		if(cmd instanceof RemovePoint||cmd instanceof RemoveLine||cmd instanceof RemoveSquare||cmd instanceof RemoveRectangle||cmd instanceof RemoveCircle||cmd instanceof RemoveHexagonAdapter)
		return true;
		else return false;
	}
	public void redoCommand() {
		if(model.getRedoStack().size()!=0) {
			
		do {
			Command old=model.getRedoStack().peek();
			model.doRedo();
			if(!isRemoveCommand(old))break;
		}
		while(!model.getRedoStack().isEmpty()&&isRemoveCommand(model.getRedoStack().peek()));
		
		if(enterSelecting)selectShape(null);
		frame.getView().repaint();
		updateButtons();
		}else JOptionPane.showMessageDialog(null, "List is empty", "Redo command:", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	public int getSelection() {
		return selection;
	}
	public void setSelection(int selection) {
		this.selection = selection;
	}
	public void changeInnerColor() {
		Color temp= JColorChooser.showDialog(null, "choose collor", inner);
		if(temp!=null){inner=temp;frame.getSelViews().getBtnInner().setBackground(inner);}
	}
	public void changeOuterColor() {
		Color temp= JColorChooser.showDialog(null, "choose collor", outer);
		if(temp!=null){outer=temp;frame.getSelViews().getBtnOutter().setBackground(outer);}
	}
	public Color getInner() {
		return inner;
	}
	public void setInner(Color inner) {
		this.inner = inner;
	}
	public Color getOuter() {
		return outer;
	}
	public void setOuter(Color outer) {
		this.outer = outer;
	}
	public void selectShape(ActionEvent e) {
		if(enterSelecting) {
			enterSelecting=false;
			frame.getSelViews().getBtnSelect().setBackground(null);
			for(int i=model.getAll().size()-1;i>=0;i--)
				model.get(i).setSelected(false);
			frame.getView().repaint();
			}
		else {enterSelecting=true;
		frame.getSelViews().getBtnSelect().setBackground(btnColor);}
	}
	public boolean isEnterSelecting() {
		return enterSelecting;
	}
	public void setEnterSelecting(boolean enterSelecting) {
		this.enterSelecting = enterSelecting;
	}
	public void deleteShapes(ActionEvent e) {
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to delete this shapes?","Warning",JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION)
		for(int i=model.getAll().size()-1;i>=0;i--) {
			Shape s=model.get(i);
			Command cmd;
			if(s.isSelected()) {
				if(s instanceof Point) {
					cmd=new RemovePoint(model, (Point) s);
				} else if(s instanceof Line) {
					cmd=new RemoveLine(model, (Line) s);
				} else if(s instanceof Rectangle) {
					cmd=new RemoveRectangle(model, (Rectangle) s);
				} else if(s instanceof Square) {
					cmd=new RemoveSquare(model, (Square) s);
				} else if(s instanceof Circle) {
					cmd=new RemoveCircle(model, (Circle) s);
				} else if(s instanceof HexagonAdapter) {
					cmd=new RemoveHexagonAdapter(model, (HexagonAdapter) s);
				}
				else continue;
				s.setSelected(false);
				cmd.execute();
				model.addUndo(cmd);
				
			}
		}
		updateButtons();
		frame.getView().repaint();
	}
	public void modifyShape(ActionEvent e) {
		Shape selected=new Point();
		for(int i=model.getAll().size()-1;i>=0;i--) {
			if(model.get(i).isSelected()) {selected=model.get(i);break;}
		}
		if(selected instanceof Point) {
			DialogPoint view=new DialogPoint();
			view.setPoint((Point)selected);
			view.setVisible(true);
			if(view.isConfirm()) {
				UpdatePoint cmd=new UpdatePoint((Point)selected, view.getPoint());
				cmd.execute();
				model.addUndo(cmd);
				updateButtons();
				frame.getView().repaint();
			}
		}
		else if(selected instanceof Line) {
			DialogLine view=new DialogLine();
			view.setLine((Line)selected);
			view.setVisible(true);
			if(view.isConfirm()) {
				UpdateLine cmd=new UpdateLine((Line)selected, view.getLine());
				cmd.execute();
				model.addUndo(cmd);
				updateButtons();
				frame.getView().repaint();
			}
		}
		else if(selected instanceof Rectangle) {
			DialogRectangle view=new DialogRectangle();
			view.setRectangle((Rectangle)selected);
			view.setVisible(true);
			if(view.isConfirm()) {
				UpdateSquare cmd=new UpdateSquare((Rectangle)selected, view.getRectangle());
				cmd.execute();
				model.addUndo(cmd);
				updateButtons();
				frame.getView().repaint();
			}
		}
		else if(selected instanceof Square) {
			DialogSquare view=new DialogSquare();
			view.setSquare((Square)selected);
			view.setVisible(true);
			if(view.isConfirm()) {
				UpdateSquare cmd=new UpdateSquare((Square)selected, view.getSquare());
				cmd.execute();
				model.addUndo(cmd);
				updateButtons();
				frame.getView().repaint();
			}
		}
		else if(selected instanceof Circle) {
			DialogCircle view=new DialogCircle();
			view.setCircle((Circle)selected);
			view.setVisible(true);
			if(view.isConfirm()) {
				UpdateCircle cmd=new UpdateCircle((Circle)selected, view.getCircle());
				cmd.execute();
				model.addUndo(cmd);
				updateButtons();
				frame.getView().repaint();
			}
		}
		else if(selected instanceof HexagonAdapter) {
			DialogHexagon view=new DialogHexagon();
			view.setHexagonAdapter((HexagonAdapter)selected);
			view.setVisible(true);
			if(view.isConfirm()) {
				UpdateHexagonAdapter cmd=new UpdateHexagonAdapter((HexagonAdapter)selected, view.getHexagonAdapter());
				cmd.execute();
				model.addUndo(cmd);
				updateButtons();
				frame.getView().repaint();
			}
		}
	}
	public void bringToFront(ActionEvent e) {
		Shape selected=new Point();
		for(int i=model.getAll().size()-1;i>=0;i--) {
			if(model.get(i).isSelected()) {selected=model.get(i);break;}
		}
		if(model.getAll().indexOf(selected)!=model.getAll().size()-1) {
			BringToFront cmd=new BringToFront(model,selected);
			cmd.execute();
			model.addUndo(cmd);
			updateButtons();
			frame.getView().repaint();
		}else JOptionPane.showMessageDialog(null, "Shape is already on the front.");
	}
	public void toFront(ActionEvent e) {
		Shape selected=new Point();
		for(int i=model.getAll().size()-1;i>=0;i--) {
			if(model.get(i).isSelected()) {selected=model.get(i);break;}
		}
		if(model.getAll().indexOf(selected)!=model.getAll().size()-1) {
			ToFront cmd=new ToFront(model,selected);
			cmd.execute();
			model.addUndo(cmd);
			updateButtons();
			frame.getView().repaint();
		}else JOptionPane.showMessageDialog(null, "Shape is already on the front.");
	}
	public void toBack(ActionEvent e) {
		Shape selected=new Point();
		for(int i=model.getAll().size()-1;i>=0;i--) {
			if(model.get(i).isSelected()) {selected=model.get(i);break;}
		}
		if(model.getAll().indexOf(selected)!=0) {
			ToBack cmd=new ToBack(model,selected);
			cmd.execute();
			model.addUndo(cmd);
			updateButtons();
			frame.getView().repaint();
		}else JOptionPane.showMessageDialog(null, "Shape is already back.");
	}
	public void bringToBack(ActionEvent e) {
		Shape selected=new Point();
		for(int i=model.getAll().size()-1;i>=0;i--) {
			if(model.get(i).isSelected()) {selected=model.get(i);break;}
		}
		if(model.getAll().indexOf(selected)!=0) {
			BringToBack cmd=new BringToBack(model,selected);
			cmd.execute();
			model.addUndo(cmd);
			updateButtons();
			frame.getView().repaint();
		}else JOptionPane.showMessageDialog(null, "Shape is already back.");
	}


}
