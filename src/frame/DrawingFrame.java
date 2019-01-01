package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import controller.DrawingController;
import controller.MenuController;
import controller.ToolsController;
import views.DrawingView;
import views.LogView;
import views.PositionView;
import views.SelectionView;
import views.ShapesView;


import java.awt.Color;

public class DrawingFrame extends JFrame {
	private static final long serialVersionUID = 7934396975388164057L;
	private DrawingView view = new DrawingView();
	private ShapesView sViews=new ShapesView();
	private SelectionView selViews=new SelectionView();
	private PositionView posView=new PositionView();
	private ToolsController toolsController;
	private MenuController menuController;
	private LogView logView=new LogView();
	private boolean actModify=false,actDelete=false,actPosition=false;
	
	private DrawingController controller;
	

	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}
	public void setToolsController(ToolsController toolsController) {
		this.toolsController=toolsController;
	}

	public DrawingFrame() {
		setTitle("Nemanja Tesic IT23-2016");
		view.setBackground(Color.WHITE);
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.mouseClicked(arg0);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				controller.mousePressed(arg0);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				controller.mouseReleased(e);
			}
		});
		view.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				controller.moveLines(arg0);
			}
		});
		sViews.getBtnPoint().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.pointSelected(e);
			}
		});
		sViews.getBtnLine().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.lineSelected(e);
			}
		});
		sViews.getBtnSquare().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.squareSelected(e);
			}
		});
		sViews.getBtnRectangle().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.rectangleSelected(e);
			}
		});
		sViews.getBtnCircle().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.circleSelected(e);
			}
		});
		sViews.getBtnHexagon().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.hexagonSelected(e);
			}
		});
		selViews.getBtnInner().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.changeInnerColor();
			}
		} );
		selViews.getBtnOutter().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.changeOuterColor();
			}
		});
		selViews.getBtnUndo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.undoCommand();
			}
		});
		
		selViews.getBtnRedo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.redoCommand();
			}
		});
		selViews.getBtnSelect().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.selectShape(e);
			}
		});
		selViews.getBtnDelete().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.deleteShapes(e);
			}
		});
		selViews.getBtnModify().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.modifyShape(e);
			}
		});
		
		posView.getBtnBringtoback().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.bringToBack(e);
			}
		});
		
		posView.getBtnToBack().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.toBack(e);
			}
		});
		
		posView.getBtnToFront().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.toFront(e);
			}
		});
		
		posView.getBtnBringToFront().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.bringToFront(e);
			}
		});
		
		selViews.getBtnNew().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuController.clearDrawing(e);
			}
		});
		selViews.getBtnOpen().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuController.openFiles(e);
			}
		});
		selViews.getBtnSave().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuController.saveFiles(e);
			}
		});
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(view);
		

		getContentPane().add(sViews, BorderLayout.WEST);
		

		getContentPane().add(selViews, BorderLayout.NORTH);
		
		getContentPane().add(posView, BorderLayout.EAST);
		getContentPane().add(logView, BorderLayout.SOUTH);
	}

	public ShapesView getSViews() {
		return sViews;
	}

	public void setSViews(ShapesView sviews) {
		this.sViews = sviews;
	}

	public ToolsController getToolsController() {
		return toolsController;
	}

	public SelectionView getSelViews() {
		return selViews;
	}

	public void setSelViews(SelectionView selViews) {
		this.selViews = selViews;
	}

	public DrawingController getController() {
		return controller;
	}

	public PositionView getPosView() {
		return posView;
	}

	public void setPosView(PositionView posView) {
		this.posView = posView;
	}

	public boolean isActModify() {
		return actModify;
	}

	public void setActModify(boolean actModify) {
		this.actModify = actModify;
	}

	public boolean isActDelete() {
		return actDelete;
	}

	public void setActDelete(boolean actDelete) {
		this.actDelete = actDelete;
	}

	public boolean isActPosition() {
		return actPosition;
	}

	public void setActPosition(boolean actPosition) {
		this.actPosition = actPosition;
	}

	public LogView getLogView() {
		return logView;
	}

	public void setLogView(LogView logView) {
		this.logView = logView;
	}

	public MenuController getMenuController() {
		return menuController;
	}

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}

}
