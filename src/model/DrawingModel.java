package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import shapes.Command;
import shapes.Shape;

public class DrawingModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7861597306348577488L;
	private ArrayList<Shape> shapes=new ArrayList<Shape>();
	private Stack<Command> undoStack=new Stack<Command>();
	private Stack<Command> redoStack=new Stack<Command>();
	
	private Stack<String> undoStackLog=new Stack<String>();
	private Stack<String> redoStackLog=new Stack<String>();
	public ArrayList<Shape> getAll() {
		return shapes;
	}

	public Shape get(int i) {
		return shapes.get(i);
	}

	public void add(Shape s) {
		shapes.add(s);
	}
	
	public void remove(Shape s) {
		shapes.remove(s);
	}


	public Stack<Command> getUndoStack(){
		return undoStack;
	}
	public Stack<Command> getRedoStack(){
		return redoStack;
	}

	public Stack<String> getUndoStackLog() {
		return undoStackLog;
	}

	public void setUndoStackLog(Stack<String> undoStackLog) {
		this.undoStackLog = undoStackLog;
	}

	public Stack<String> getRedoStackLog() {
		return redoStackLog;
	}

	public void setRedoStackLog(Stack<String> redoStackLog) {
		this.redoStackLog = redoStackLog;
	}

}
