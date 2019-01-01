package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PositionView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1836790590752423577L;
	/**
	 * Create the panel.
	 */
	private JButton btnBringtoback,btnToBack,btnToFront,btnBringToFront;
	public PositionView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnBringtoback = new JButton("Bring To Back");
		btnBringtoback.setEnabled(false);
		GridBagConstraints gbc_btnBringtoback = new GridBagConstraints();
		gbc_btnBringtoback.fill = GridBagConstraints.BOTH;
		gbc_btnBringtoback.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringtoback.gridx = 0;
		gbc_btnBringtoback.gridy = 0;
		add(btnBringtoback, gbc_btnBringtoback);
		
	    btnToBack = new JButton("To Back");
	    btnToBack.setEnabled(false);
		GridBagConstraints gbc_btnToBack = new GridBagConstraints();
		gbc_btnToBack.fill = GridBagConstraints.BOTH;
		gbc_btnToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnToBack.gridx = 0;
		gbc_btnToBack.gridy = 1;
		add(btnToBack, gbc_btnToBack);
		
		btnToFront = new JButton("To Front");
		btnToFront.setEnabled(false);
		GridBagConstraints gbc_btnToFront = new GridBagConstraints();
		gbc_btnToFront.fill = GridBagConstraints.BOTH;
		gbc_btnToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnToFront.gridx = 0;
		gbc_btnToFront.gridy = 2;
		add(btnToFront, gbc_btnToFront);
		
		btnBringToFront = new JButton("Bring to Front");
		btnBringToFront.setEnabled(false);
		GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
		gbc_btnBringToFront.fill = GridBagConstraints.BOTH;
		gbc_btnBringToFront.gridx = 0;
		gbc_btnBringToFront.gridy = 3;
		add(btnBringToFront, gbc_btnBringToFront);

	}
	public JButton getBtnBringtoback() {
		return btnBringtoback;
	}
	public void setBtnBringtoback(JButton btnBringtoback) {
		this.btnBringtoback = btnBringtoback;
	}
	public JButton getBtnToBack() {
		return btnToBack;
	}
	public void setBtnToBack(JButton btnToBack) {
		this.btnToBack = btnToBack;
	}
	public JButton getBtnToFront() {
		return btnToFront;
	}
	public void setBtnToFront(JButton btnToFront) {
		this.btnToFront = btnToFront;
	}
	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}
	public void setBtnBringToFront(JButton btnBringToFront) {
		this.btnBringToFront = btnBringToFront;
	}

}
