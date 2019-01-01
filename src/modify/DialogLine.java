package modify;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.line.Line;
import shapes.point.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLine extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7019217754178664290L;
	private final JPanel contentPanel = new JPanel();
	private JTextField startPointX;
	private JTextField startPointY;
	private JTextField endPointX;
	private JTextField endPointY;
	private JButton btnColor,btnModify,btnCancel;
	private Line line;
	private Color lnColor;
	private boolean confirm=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogLine dialog = new DialogLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogLine() {
		setModal(true);
		setTitle("Modify Line");
		setBounds(100, 100, 227, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{88, 180, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 25, 47, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPointX = new JLabel("Start Point X:");
			GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
			gbc_lblStartPointX.anchor = GridBagConstraints.NORTHEAST;
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
			JLabel lblEndPointX = new JLabel("End Point X:");
			GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
			gbc_lblEndPointX.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointX.gridx = 0;
			gbc_lblEndPointX.gridy = 2;
			contentPanel.add(lblEndPointX, gbc_lblEndPointX);
		}
		{
			endPointX = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			contentPanel.add(endPointX, gbc_textField_2);
			endPointX.setColumns(10);
		}
		{
			JLabel lblEndPointY = new JLabel("End Point Y:");
			GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
			gbc_lblEndPointY.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointY.gridx = 0;
			gbc_lblEndPointY.gridy = 3;
			contentPanel.add(lblEndPointY, gbc_lblEndPointY);
		}
		{
			endPointY = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.insets = new Insets(0, 0, 5, 0);
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 1;
			gbc_textField_3.gridy = 3;
			contentPanel.add(endPointY, gbc_textField_3);
			endPointY.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.anchor = GridBagConstraints.EAST;
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 0;
			gbc_lblColor.gridy = 4;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnColor = new JButton("");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color temp= JColorChooser.showDialog(null, "choose color", lnColor);
					if(temp!=null){lnColor=temp;btnColor.setBackground(lnColor);}
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.fill = GridBagConstraints.BOTH;
			gbc_btnColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 4;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			btnModify = new JButton("Modify");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					confirm();
				}
			});
			GridBagConstraints gbc_btnModify = new GridBagConstraints();
			gbc_btnModify.insets = new Insets(0, 0, 0, 5);
			gbc_btnModify.gridx = 0;
			gbc_btnModify.gridy = 5;
			contentPanel.add(btnModify, gbc_btnModify);
		}
		{
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancel();
				}
			});
			GridBagConstraints gbc_btnCancel = new GridBagConstraints();
			gbc_btnCancel.gridx = 1;
			gbc_btnCancel.gridy = 5;
			contentPanel.add(btnCancel, gbc_btnCancel);
		}
	}
	public void confirm() {
		try {
		int stCrdX=Integer.parseInt(startPointX.getText());
		int stCrdY=Integer.parseInt(startPointY.getText());
		int endCrdX=Integer.parseInt(endPointX.getText());
		int endCrdY=Integer.parseInt(endPointY.getText());
		line=new Line(new Point(stCrdX,stCrdY),new Point(endCrdX,endCrdY),lnColor);
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

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
		startPointX.setText(String.valueOf(line.getPointStart().getX()));
		startPointY.setText(String.valueOf(line.getPointStart().getY()));
		
		endPointX.setText(String.valueOf(line.getPointEnd().getX()));
		endPointY.setText(String.valueOf(line.getPointEnd().getY()));
		setLnColor(line.getColor());
	}

	public Color getLnColor() {
		return lnColor;
	}

	public void setLnColor(Color lnColor) {
		this.lnColor = lnColor;
		btnColor.setBackground(lnColor);
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

}
