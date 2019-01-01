package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import frame.DrawingFrame;
import logging.CommandTransfer;
import model.DrawingModel;
import shapes.Command;
import views.LogParser;

public class LogFileLoader implements AssetLoader {
	private DrawingModel model;
	private DrawingFrame frame;
	public LogFileLoader(DrawingModel model,DrawingFrame frame) {
		this.model=model;
		this.frame=frame;
	}
	@Override
	public void loadFile(File file) {
		 File selectedFile = file;
         if(selectedFile.getName().split("\\.")[1].equals("log"))
         try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
             String line,text="";
        	 LogParser lp=new LogParser();
             while ((line = br.readLine()) != null) {
            	 text=text+line+'\n';
            	 lp.getTpLogPreview().setText(text);
            	 lp.setConf(false);
            	 lp.setVisible(true);
            	 if(lp.isConf()) {
            		 CommandTransfer ct=new CommandTransfer(model,frame);
            		 Command c=ct.toCommand(line);
            		 frame.getView().repaint();
            		 if(c==null) {lp.dispose();break;}
            	 }else {lp.dispose();break;}
             }
         }catch (Exception e2) {
				e2.printStackTrace();
         	JOptionPane.showMessageDialog(frame,
             	    "Error while reading the file.");
			}
         else JOptionPane.showMessageDialog(frame,
         	    "Wrong file format, file extension must be '.log'.");
	}


	@Override
	public void saveFile(File file) {
		try {
			FileWriter fw = new FileWriter(file+".log");
			fw.write(frame.getLogView().getLogPane().getText());
			fw.close();
            JOptionPane.showMessageDialog(null,
            	    "The file was saved successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
            	    "Error while saving the file.");
        }
	}

}
