package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.point.Point;
import shapes.rectangle.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogRectangle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1158990492967747260L;
	private final JPanel contentPanel = new JPanel();
	private JTextField startPointX;
	private JTextField startPointY;
	private JTextField width;
	private JTextField height;
	private Color inner,outer;
	private Rectangle rectangle;
	private JButton btnOuterColor,btnInnercolor;
	private boolean confirm=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRectangle dialog = new DialogRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogRectangle() {
		setModal(true);
		setTitle("Modify Rectangle");
		setBounds(100, 100, 235, 238);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{103, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 26, 26, 38, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPointX = new JLabel("Start Point X:");
			GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
			gbc_lblStartPointX.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointX.gridx = 0;
			gbc_lblStartPointX.gridy = 0;
			contentPanel.add(lblStartPointX, gbc_lblStartPointX);
		}
		{
			startPointX = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(startPointX, gbc_textField);
			startPointX.setColumns(10);
		}
		{
			JLabel lblStartPointY = new JLabel("Start Point Y:");
			GridBagConstraints gbc_lblStartPointY = new GridBagConstraints();
			gbc_lblStartPointY.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointY.gridx = 0;
			gbc_lblStartPointY.gridy = 1;
			contentPanel.add(lblStartPointY, gbc_lblStartPointY);
		}
		{
			startPointY = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			contentPanel.add(startPointY, gbc_textField_1);
			startPointY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 2;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			width = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			contentPanel.add(width, gbc_textField_2);
			width.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 3;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			height = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.insets = new Insets(0, 0, 5, 0);
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 1;
			gbc_textField_3.gridy = 3;
			contentPanel.add(height, gbc_textField_3);
			height.setColumns(10);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner Color:");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.anchor = GridBagConstraints.EAST;
			gbc_lblInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerColor.gridx = 0;
			gbc_lblInnerColor.gridy = 4;
			contentPanel.add(lblInnerColor, gbc_lblInnerColor);
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
			gbc_btnInnercolor.gridy = 4;
			contentPanel.add(btnInnercolor, gbc_btnInnercolor);
		}
		{
			JLabel lblOuterColor = new JLabel("Outer Color:");
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.anchor = GridBagConstraints.EAST;
			gbc_lblOuterColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterColor.gridx = 0;
			gbc_lblOuterColor.gridy = 5;
			contentPanel.add(lblOuterColor, gbc_lblOuterColor);
		}
		{
			btnOuterColor = new JButton("");
			btnOuterColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color temp= JColorChooser.showDialog(null, "choose color", outer);
					if(temp!=null){outer=temp;btnOuterColor.setBackground(outer);}
				}
			});
			GridBagConstraints gbc_btnOuterColor = new GridBagConstraints();
			gbc_btnOuterColor.fill = GridBagConstraints.BOTH;
			gbc_btnOuterColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOuterColor.gridx = 1;
			gbc_btnOuterColor.gridy = 5;
			contentPanel.add(btnOuterColor, gbc_btnOuterColor);
		}
		{
			JButton btnModify = new JButton("Modify");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					confirm();
				}
			});
			GridBagConstraints gbc_btnModify = new GridBagConstraints();
			gbc_btnModify.insets = new Insets(0, 0, 0, 5);
			gbc_btnModify.gridx = 0;
			gbc_btnModify.gridy = 6;
			contentPanel.add(btnModify, gbc_btnModify);
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
			gbc_btnCancel.gridy = 6;
			contentPanel.add(btnCancel, gbc_btnCancel);
		}
	}

	public void confirm() {
		try {
		int crdX=Integer.parseInt(startPointX.getText());
		int crdY=Integer.parseInt(startPointY.getText());
		int wdth=Integer.parseInt(width.getText());
		int heiht=Integer.parseInt(height.getText());
		rectangle=new Rectangle(new Point(crdX,crdY), heiht, wdth, outer, inner);
		rectangle.setSelected(true);
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
		btnOuterColor.setBackground(outer);
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
		startPointX.setText(String.valueOf(rectangle.getUpperLeft().getX()));
		startPointY.setText(String.valueOf(rectangle.getUpperLeft().getY()));
		width.setText(String.valueOf(rectangle.getWidth()));
		height.setText(String.valueOf(rectangle.getSideLength()));
		setInner(rectangle.getInnerColor());
		setOuter(rectangle.getColor());
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

}
