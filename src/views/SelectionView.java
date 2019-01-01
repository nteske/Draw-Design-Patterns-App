package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SelectionView extends JPanel {

	private static final long serialVersionUID = 1514183278122814841L;
	private JButton btnUndo,btnRedo,btnInner,btnOutter;
	private JButton btnSelect;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnNew;
	private JButton btnOpen;
	private JButton btnSave;
	/**
	 * Create the panel.
	 */
	public SelectionView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 31, 45, 46, 67, 63, 61, 62, 59, 52, 46, 0};
		gridBagLayout.rowHeights = new int[]{26, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnNew = new JButton("new");
		btnNew.setIcon(new ImageIcon(SelectionView.class.getResource("/images/new.png")));
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.insets = new Insets(0, 0, 0, 5);
		gbc_btnNew.gridx = 0;
		gbc_btnNew.gridy = 0;
		add(btnNew, gbc_btnNew);
		
		btnOpen = new JButton("open");
		btnOpen.setIcon(new ImageIcon(SelectionView.class.getResource("/images/open.png")));
		GridBagConstraints gbc_btnOpen = new GridBagConstraints();
		gbc_btnOpen.insets = new Insets(0, 0, 0, 5);
		gbc_btnOpen.gridx = 1;
		gbc_btnOpen.gridy = 0;
		add(btnOpen, gbc_btnOpen);
		
		btnSave = new JButton("save");
		btnSave.setIcon(new ImageIcon(SelectionView.class.getResource("/images/save.png")));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 0;
		add(btnSave, gbc_btnSave);
		
		btnUndo = new JButton(new ImageIcon(SelectionView.class.getResource("/images/pok4.png")));
		btnUndo.setEnabled(false);
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.fill = GridBagConstraints.BOTH;
		gbc_btnUndo.insets = new Insets(0, 0, 0, 5);
		gbc_btnUndo.gridx = 4;
		gbc_btnUndo.gridy = 0;
		add(btnUndo, gbc_btnUndo);
		
		btnRedo = new JButton(new ImageIcon(SelectionView.class.getResource("/images/pok42.png")));
		btnRedo.setEnabled(false);
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.fill = GridBagConstraints.BOTH;
		gbc_btnRedo.insets = new Insets(0, 0, 0, 5);
		gbc_btnRedo.gridx = 5;
		gbc_btnRedo.gridy = 0;
		add(btnRedo, gbc_btnRedo);
		
		JLabel lblColors = new JLabel("Colors:");
		GridBagConstraints gbc_lblColors = new GridBagConstraints();
		gbc_lblColors.anchor = GridBagConstraints.EAST;
		gbc_lblColors.insets = new Insets(0, 0, 0, 5);
		gbc_lblColors.gridx = 6;
		gbc_lblColors.gridy = 0;
		add(lblColors, gbc_lblColors);
		
		btnOutter = new JButton("");
		GridBagConstraints gbc_btnOutter = new GridBagConstraints();
		gbc_btnOutter.fill = GridBagConstraints.BOTH;
		gbc_btnOutter.insets = new Insets(0, 0, 0, 5);
		gbc_btnOutter.gridx = 7;
		gbc_btnOutter.gridy = 0;
		add(btnOutter, gbc_btnOutter);
		
		btnInner = new JButton("");
		GridBagConstraints gbc_btnInner = new GridBagConstraints();
		gbc_btnInner.insets = new Insets(0, 0, 0, 5);
		gbc_btnInner.fill = GridBagConstraints.BOTH;
		gbc_btnInner.gridx = 8;
		gbc_btnInner.gridy = 0;
		add(btnInner, gbc_btnInner);
		
		btnSelect = new JButton("Select");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 10;
		gbc_btnSelect.gridy = 0;
		add(btnSelect, gbc_btnSelect);
		
		btnModify = new JButton("Modify");
		btnModify.setEnabled(false);
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 0, 5);
		gbc_btnModify.gridx = 11;
		gbc_btnModify.gridy = 0;
		add(btnModify, gbc_btnModify);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 12;
		gbc_btnDelete.gridy = 0;
		add(btnDelete, gbc_btnDelete);

	}
	public JButton getBtnUndo() {
		return btnUndo;
	}
	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}
	public JButton getBtnRedo() {
		return btnRedo;
	}
	public void setBtnRedo(JButton btnRedo) {
		this.btnRedo = btnRedo;
	}
	public JButton getBtnInner() {
		return btnInner;
	}
	public void setBtnInner(JButton btnInner) {
		this.btnInner = btnInner;
	}
	public JButton getBtnOutter() {
		return btnOutter;
	}
	public void setBtnOutter(JButton btnOutter) {
		this.btnOutter = btnOutter;
	}
	public JButton getBtnSelect() {
		return btnSelect;
	}
	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}
	public JButton getBtnModify() {
		return btnModify;
	}
	public void setBtnModify(JButton btnModify) {
		this.btnModify = btnModify;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
	public JButton getBtnNew() {
		return btnNew;
	}
	public void setBtnNew(JButton btnNew) {
		this.btnNew = btnNew;
	}
	public JButton getBtnOpen() {
		return btnOpen;
	}
	public void setBtnOpen(JButton btnOpen) {
		this.btnOpen = btnOpen;
	}
	public JButton getBtnSave() {
		return btnSave;
	}
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

}
