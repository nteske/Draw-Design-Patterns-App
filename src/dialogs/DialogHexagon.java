package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hexagon.Hexagon;
import shapes.hexagon.HexagonAdapter;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogHexagon extends JDialog {

	private static final long serialVersionUID = -5997628659156166180L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfPointX;
	private JTextField tfPointY;
	private JTextField tfRadius;
	private JButton btnOutercolor,btnInnercolor;
	
	private Color inner,outer;
	private HexagonAdapter hexagonAdapter;
	private boolean confirm=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogHexagon dialog = new DialogHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogHexagon() {
		setModal(true);
		setTitle("Modify Hexagon");
		setBounds(100, 100, 230, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{106, 74, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 27, 29, 39, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterPointX = new JLabel("Center Point X:");
			GridBagConstraints gbc_lblCenterPointX = new GridBagConstraints();
			gbc_lblCenterPointX.anchor = GridBagConstraints.EAST;
			gbc_lblCenterPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterPointX.gridx = 0;
			gbc_lblCenterPointX.gridy = 0;
			contentPanel.add(lblCenterPointX, gbc_lblCenterPointX);
		}
		{
			tfPointX = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(tfPointX, gbc_textField);
			tfPointX.setColumns(10);
		}
		{
			JLabel lblCenterPointY = new JLabel("Center Point Y:");
			GridBagConstraints gbc_lblCenterPointY = new GridBagConstraints();
			gbc_lblCenterPointY.anchor = GridBagConstraints.EAST;
			gbc_lblCenterPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterPointY.gridx = 0;
			gbc_lblCenterPointY.gridy = 1;
			contentPanel.add(lblCenterPointY, gbc_lblCenterPointY);
		}
		{
			tfPointY = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			contentPanel.add(tfPointY, gbc_textField_1);
			tfPointY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			tfRadius = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			contentPanel.add(tfRadius, gbc_textField_2);
			tfRadius.setColumns(10);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner Color:");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.anchor = GridBagConstraints.EAST;
			gbc_lblInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerColor.gridx = 0;
			gbc_lblInnerColor.gridy = 3;
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
			gbc_btnInnercolor.gridy = 3;
			contentPanel.add(btnInnercolor, gbc_btnInnercolor);
		}
		{
			JLabel lblOuterColor = new JLabel("Outer Color:");
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.anchor = GridBagConstraints.EAST;
			gbc_lblOuterColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterColor.gridx = 0;
			gbc_lblOuterColor.gridy = 4;
			contentPanel.add(lblOuterColor, gbc_lblOuterColor);
		}
		{
			btnOutercolor = new JButton("");
			btnOutercolor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color temp= JColorChooser.showDialog(null, "choose color", outer);
					if(temp!=null){outer=temp;btnOutercolor.setBackground(outer);}
				}
			});
			GridBagConstraints gbc_btnOutercolor = new GridBagConstraints();
			gbc_btnOutercolor.fill = GridBagConstraints.BOTH;
			gbc_btnOutercolor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOutercolor.gridx = 1;
			gbc_btnOutercolor.gridy = 4;
			contentPanel.add(btnOutercolor, gbc_btnOutercolor);
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
			gbc_btnCancel.gridy = 5;
			contentPanel.add(btnCancel, gbc_btnCancel);
		}
	}
	public void confirm() {
		try {
			int crdX=Integer.parseInt(tfPointX.getText());
			int crdY=Integer.parseInt(tfPointY.getText());
			int radius=Integer.parseInt(tfRadius.getText());
			hexagonAdapter=new HexagonAdapter(new Hexagon(crdX, crdY, radius), outer, inner);
			hexagonAdapter.setSelected(true);
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

	public HexagonAdapter getHexagonAdapter() {
		return hexagonAdapter;
	}

	public void setHexagonAdapter(HexagonAdapter hexagonAdapter) {
		this.hexagonAdapter = hexagonAdapter;
		tfPointX.setText(String.valueOf(hexagonAdapter.getHexagon().getX()));
		tfPointY.setText(String.valueOf(hexagonAdapter.getHexagon().getY()));
		tfRadius.setText(String.valueOf(hexagonAdapter.getHexagon().getR()));
		setOuter(hexagonAdapter.getColor());
		setInner(hexagonAdapter.getInnerColor());
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

}
