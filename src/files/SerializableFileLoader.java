package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import frame.DrawingFrame;
import model.DrawingModel;
import shapes.Shape;
import shapes.ShapeObserver;

public class SerializableFileLoader implements AssetLoader {
	private DrawingModel model;
	private DrawingFrame frame;
	public SerializableFileLoader(DrawingModel model,DrawingFrame frame) {
		this.model=model;
		this.frame=frame;
	}
	

	
	@Override
	public void loadFile(File file) {
		try {
		FileInputStream files = new FileInputStream(file); 
        ObjectInputStream in = new ObjectInputStream(files); 
		@SuppressWarnings("unchecked")
		ArrayList<Shape> shapes=(ArrayList<Shape>)in.readObject();
        ShapeObserver observer;
        // Method for deserialization of object 
        for (Shape s : shapes) {
        	if(s!=null) {
        		observer=new ShapeObserver(model, frame);
        		s.addObserver(observer);
        		model.add(s);
        	}
			if(s.isSelected()) {
					if(!frame.getToolsController().isEnterSelecting())
					frame.getToolsController().selectShape(null);
					break;}
		}
        
      /* String text=frame.getLogView().getLogPane().getText();
        frame.getLogView().getLogPane().setText(text+(String)in.readUTF());
*/
        

        in.close(); 
        files.close(); 
		}catch(Exception e) {
			e.printStackTrace();
			 System.out.println("Objects are not deserialized");
		}
	}

	@Override
	public void saveFile(File file) {
		try {
		 FileOutputStream files = new FileOutputStream(file+".ser"); 
         ObjectOutputStream out = new ObjectOutputStream(files); 
           
         // Method for serialization of object 
         /*out.writeUTF(frame.getLogView().getLogPane().getText());*/
         out.writeObject(model.getAll()); 
         
         out.close(); 
         files.close(); 
           
         System.out.println("Object has been serialized");
		}catch(Exception e) {
			 System.out.println("Objects are not serialized");
		}
	}

}
