package views;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import model.DrawingModel;
import shapes.Shape;

public class DrawingView extends JPanel {
	public DrawingView() {
	}

	private static final long serialVersionUID = 8957212343807043677L;
	private DrawingModel model;
	public void setModel(DrawingModel model) {
		this.model=model;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (model != null) {
			Iterator<Shape> it = model.getAll().iterator();
			while (it.hasNext()) {
				it.next().draw(g);
			}
		}
	}
	

}
