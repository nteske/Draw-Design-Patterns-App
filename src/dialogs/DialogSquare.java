package dialogs;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

import shapes.point.Point;
import shapes.square.Square;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogSquare extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5329206238001018465L;
	private JTextField pointX;
	private JTextField pointY;
	private JTextField width;
	private JButton btnInnercolor,btnOutercolor;
	private Color inner,outer;
	private Square square;
	private boolean confirm=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogSquare dialog = new DialogSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogSquare() {
		setModal(true);
		setTitle("Modify Square");
		setBounds(100, 100, 248, 207);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{106, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 27, 27, 33, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblStartPointX = new JLabel("Start Point X:");
			GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
			gbc_lblStartPointX.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointX.gridx = 0;
			gbc_lblStartPointX.gridy = 0;
			getContentPane().add(lblStartPointX, gbc_lblStartPointX);
		}
		{
			pointX = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			getContentPane().add(pointX, gbc_textField);
			pointX.setColumns(10);
		}
		{
			JLabel lblStartPointY = new JLabel("Start Point Y:");
			GridBagConstraints gbc_lblStartPointY = new GridBagConstraints();
			gbc_lblStartPointY.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointY.gridx = 0;
			gbc_lblStartPointY.gridy = 1;
			getContentPane().add(lblStartPointY, gbc_lblStartPointY);
		}
		{
			pointY = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			getContentPane().add(pointY, gbc_textField_1);
			pointY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 2;
			getContentPane().add(lblWidth, gbc_lblWidth);
		}
		{
			width = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			getContentPane().add(width, gbc_textField_2);
			width.setColumns(10);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner Color:");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.anchor = GridBagConstraints.EAST;
			gbc_lblInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerColor.gridx = 0;
			gbc_lblInnerColor.gridy = 3;
			getContentPane().add(lblInnerColor, gbc_lblInnerColor);
		}
		{
			btnInnercolor = new JButton("");
			btnInnercolor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color temp= JColorChooser.showDialog(null, "choose color", inner);
					if(temp!=null){inner=temp;btnInnercolor.setBackground(inner);}
				}
			});
			GridBagConstraints gbc_btnInnercolor = new GridBagConstraints();
			gbc_btnInnercolor.fill = GridBagConstraints.BOTH;
			gbc_btnInnercolor.insets = new Insets(0, 0, 5, 0);
			gbc_btnInnercolor.gridx = 1;
			gbc_btnInnercolor.gridy = 3;
			getContentPane().add(btnInnercolor, gbc_btnInnercolor);
		}
		{
			JLabel lblOuterColor = new JLabel("Outer Color:");
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.anchor = GridBagConstraints.EAST;
			gbc_lblOuterColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterColor.gridx = 0;
			gbc_lblOuterColor.gridy = 4;
			getContentPane().add(lblOuterColor, gbc_lblOuterColor);
		}
		{
			btnOutercolor = new JButton("");
			btnOutercolor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Color temp= JColorChooser.showDialog(null, "choose color", outer);
					if(temp!=null){outer=temp;btnOutercolor.setBackground(outer);}
				}
			});
			GridBagConstraints gbc_btnOutercolor = new GridBagConstraints();
			gbc_btnOutercolor.fill = GridBagConstraints.BOTH;
			gbc_btnOutercolor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOutercolor.gridx = 1;
			gbc_btnOutercolor.gridy = 4;
			getContentPane().add(btnOutercolor, gbc_btnOutercolor);
		}
		{
			JButton btnModify = new JButton("Modify");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					confirm();
				}
			});
			GridBagConstraints gbc_btnModify = new GridBagConstraints();
			gbc_btnModify.insets = new Insets(0, 0, 0, 5);
			gbc_btnModify.gridx = 0;
			gbc_btnModify.gridy = 5;
			getContentPane().add(btnModify, gbc_btnModify);
		}
		{
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancel();
				}
			});
			GridBagConstraints gbc_btnCancel = new GridBagConstraints();
			gbc_btnCancel.gridx = 1;
			gbc_btnCancel.gridy = 5;
			getContentPane().add(btnCancel, gbc_btnCancel);
		}
	}
	public void confirm() {
		try {
		int crdX=Integer.parseInt(pointX.getText());
		int crdY=Integer.parseInt(pointY.getText());
		int wdth=Integer.parseInt(width.getText());
		square=new Square(new Point(crdX,crdY),wdth,outer,inner);
		square.setSelected(true);
		confirm=true;
		setVisible(false);
		dispose();
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please enter a valid Integer.");
		}
	}
	public void cancel() {
		setVisible(false);
		dispose();
	}

	public Color getInner() {
		return inner;
	}

	public void setInner(Color inner) {
		this.inner = inner;
		btnInnercolor.setBackground(inner);
	}

	public Color getOuter() {
		return outer;
	}

	public void setOuter(Color outer) {
		this.outer = outer;
		btnOutercolor.setBackground(outer);
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
		pointX.setText(String.valueOf(square.getUpperLeft().getX()));
		pointY.setText(String.valueOf(square.getUpperLeft().getY()));
		width.setText(String.valueOf(square.getSideLength()));
		setInner(square.getInnerColor());
		setOuter(square.getColor());
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
}
