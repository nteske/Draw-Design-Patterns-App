package model;

import java.io.Serializable;
import java.util.ArrayList;
import shapes.Shape;

public class DrawingModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7861597306348577488L;
	private ArrayList<Shape> shapes=new ArrayList<Shape>();
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


}
