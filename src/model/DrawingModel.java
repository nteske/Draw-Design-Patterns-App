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

	public void addUndo(Command c) {
		undoStack.add(c);
		redoStack.clear();
	}
	public void doUndo() {
		undoStack.peek().unexecute();
		redoStack.push(undoStack.pop());
	}
	public void doRedo() {
		redoStack.peek().execute();
		undoStack.push(redoStack.pop());
	}
	public Stack<Command> getUndoStack(){
		return undoStack;
	}
	public Stack<Command> getRedoStack(){
		return redoStack;
	}

}
