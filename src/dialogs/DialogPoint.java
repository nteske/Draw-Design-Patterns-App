package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.point.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogPoint extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5822510784913765295L;
	private final JPanel contentPanel = new JPanel();
	private JTextField cordinateX;
	private JTextField cordinateY;
	private JButton btnColor,btnModify,btnCancel;
	private Point point;
	private Color pntColor;
	private boolean confirm=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogPoint dialog = new DialogPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogPoint() {
		setModal(true);
		setBounds(100, 100, 283, 174);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Modify Point");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{133, 137, 0};
		gbl_contentPanel.rowHeights = new int[]{31, 33, 27, 36, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCordinateX = new JLabel("Coordinate X:");
			GridBagConstraints gbc_lblCordinateX = new GridBagConstraints();
			gbc_lblCordinateX.anchor = GridBagConstraints.EAST;
			gbc_lblCordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCordinateX.gridx = 0;
			gbc_lblCordinateX.gridy = 0;
			contentPanel.add(lblCordinateX, gbc_lblCordinateX);
		}
		{
			cordinateX = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(cordinateX, gbc_textField);
			cordinateX.setColumns(10);
		}
		{
			JLabel lblCordinateY = new JLabel("Coordinate Y:");
			GridBagConstraints gbc_lblCordinateY = new GridBagConstraints();
			gbc_lblCordinateY.anchor = GridBagConstraints.EAST;
			gbc_lblCordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCordinateY.gridx = 0;
			gbc_lblCordinateY.gridy = 1;
			contentPanel.add(lblCordinateY, gbc_lblCordinateY);
		}
		{
			cordinateY = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			contentPanel.add(cordinateY, gbc_textField_1);
			cordinateY.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.anchor = GridBagConstraints.EAST;
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 0;
			gbc_lblColor.gridy = 2;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnColor = new JButton("");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color temp= JColorChooser.showDialog(null, "choose color", pntColor);
					if(temp!=null){pntColor=temp;btnColor.setBackground(pntColor);}
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.fill = GridBagConstraints.BOTH;
			gbc_btnColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 2;
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
			gbc_btnModify.gridy = 3;
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
			gbc_btnCancel.gridy = 3;
			contentPanel.add(btnCancel, gbc_btnCancel);
		}
	}
	public void confirm() {
		try {
		int crdX=Integer.parseInt(cordinateX.getText());
		int crdY=Integer.parseInt(cordinateY.getText());
		point=new Point(crdX,crdY,pntColor);
		point.setSelected(true);
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

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
		cordinateX.setText(String.valueOf(point.getX()));
		cordinateY.setText(String.valueOf(point.getY()));
		setPntColor(point.getColor());
	}

	public Color getPntColor() {
		return pntColor;
	}

	public void setPntColor(Color pntColor) {
		this.pntColor = pntColor;
		btnColor.setBackground(pntColor);
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

}
