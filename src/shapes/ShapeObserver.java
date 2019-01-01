package shapes;

import java.util.Observable;
import java.util.Observer;

import frame.DrawingFrame;
import model.DrawingModel;

public class ShapeObserver implements Observer {
	private DrawingModel model;
	private DrawingFrame frame;
	public ShapeObserver(DrawingModel model,DrawingFrame frame) {
		this.model=model;
		this.frame=frame;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		int count=0;
		for(Shape s:model.getAll()) {
			if(s.isSelected())count++;
		}
		if(count==0) {
			if(frame.isActModify()) {
				frame.getSelViews().getBtnModify().setEnabled(false);
				frame.setActModify(false);
			}
			if(frame.isActDelete()) {
				frame.getSelViews().getBtnDelete().setEnabled(false);
				frame.setActDelete(false);
			}
			
			if(frame.isActPosition()) {
				frame.getPosView().getBtnBringtoback().setEnabled(false);
				frame.getPosView().getBtnToBack().setEnabled(false);
				frame.getPosView().getBtnToFront().setEnabled(false);
				frame.getPosView().getBtnBringToFront().setEnabled(false);
				frame.setActPosition(false);
			}
			
		}else if(count==1) {
			if(!frame.isActModify()) {
				frame.getSelViews().getBtnModify().setEnabled(true);
				frame.setActModify(true);
			}
			if(!frame.isActDelete()) {
				frame.getSelViews().getBtnDelete().setEnabled(true);
				frame.setActDelete(true);
			}
			if(!frame.isActPosition()) {
				frame.getPosView().getBtnBringtoback().setEnabled(true);
				frame.getPosView().getBtnToBack().setEnabled(true);
				frame.getPosView().getBtnToFront().setEnabled(true);
				frame.getPosView().getBtnBringToFront().setEnabled(true);
				frame.setActPosition(true);
			}
		}else if(count>1) {
			if(frame.isActModify()) {
				frame.getSelViews().getBtnModify().setEnabled(false);
				frame.setActModify(false);
			}
			if(!frame.isActDelete()) {
				frame.getSelViews().getBtnDelete().setEnabled(true);
				frame.setActDelete(true);
			}
			if(frame.isActPosition()) {
				frame.getPosView().getBtnBringtoback().setEnabled(false);
				frame.getPosView().getBtnToBack().setEnabled(false);
				frame.getPosView().getBtnToFront().setEnabled(false);
				frame.getPosView().getBtnBringToFront().setEnabled(false);
				frame.setActPosition(false);
			}
		}
	}

}
