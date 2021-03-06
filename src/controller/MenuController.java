package controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import files.AssetLoader;
import files.FileLoader;
import files.LogFileLoader;
import files.SerializableFileLoader;
import frame.DrawingFrame;
import model.DrawingModel;
import shapes.Command;

public class MenuController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5158203942344909976L;
	private DrawingModel model;
	private DrawingFrame frame;
	private Stack<Command> undoStack=new Stack<Command>();
	private Stack<Command> redoStack=new Stack<Command>();
	
	private Stack<String> undoStackLog=new Stack<String>();
	private Stack<String> redoStackLog=new Stack<String>();
	public MenuController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}
	
	public void clearDrawing(ActionEvent e) {
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this drawing?","Warning",JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION) {
			if(frame.getToolsController().isEnterSelecting())
				frame.getToolsController().selectShape(null);
			model.getAll().clear();
			getUndoStack().clear();
			getRedoStack().clear();
			frame.getLogView().getLogPane().setText("");
			frame.getToolsController().updateButtons();
			frame.getView().repaint();
			}
	}
	public void saveFiles(ActionEvent e) {
		JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        f.setFileFilter(new FileNameExtensionFilter("serialized file (.ser)", "ser"));
        f.setFileFilter(new FileNameExtensionFilter("log file (.log)", "log"));
        f.setDialogTitle("Save log file");
        int retrival =f.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
        	AssetLoader fileLoad;
        	if(f.getFileFilter().getDescription().equals("serialized file (.ser)")){
        		fileLoad=new SerializableFileLoader(model,frame);
        	}else {
        		fileLoad=new LogFileLoader(model,frame);
        	}
        	
        	FileLoader fileLoader=new FileLoader(fileLoad);
        	fileLoader.saveFile(f.getSelectedFile());
        
        }
	}

	public void openFiles(ActionEvent e)  {
		JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        f.setFileFilter(new FileNameExtensionFilter("serialized file (.ser)", "ser"));
        f.setFileFilter(new FileNameExtensionFilter("log file (.log)", "log"));
        f.setDialogTitle("Save log file");
        int retrival =f.showOpenDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
        	AssetLoader fileLoad;
        	if(f.getFileFilter().getDescription().equals("serialized file (.ser)")){
        		fileLoad=new SerializableFileLoader(model,frame);
        	}else {
        		fileLoad=new LogFileLoader(model,frame);
        	}
        	
        	FileLoader fileLoader=new FileLoader(fileLoad);
        	fileLoader.loadFile(f.getSelectedFile());
        	frame.getView().repaint();
        
        }
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
