package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

public class LogView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5126944245660252865L;
	/**
	 * Create the panel.
	 */
	private JTextPane logPane;
	public LogView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {150};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		logPane = new JTextPane();
		scrollPane.setViewportView(logPane);
		logPane.setText("");
		logPane.setEditable(false);

	}
	public JTextPane getLogPane() {
		return logPane;
	}
	public void setLogPane(JTextPane logPane) {
		this.logPane = logPane;
	}

}
