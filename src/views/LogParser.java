package views;



import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class LogParser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5661359792776909287L;
	private JTextPane tpLogPreview;
	private JButton btnNext,btnCancel;
	private boolean conf=false;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LogParser dialog = new LogParser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LogParser() {
		setModal(true);
		setTitle("Parse Log");
		setBounds(100, 100, 741, 407);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{290, 0, 0};
		gridBagLayout.rowHeights = new int[]{336, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridwidth = 2;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			getContentPane().add(scrollPane, gbc_scrollPane);
			{
				tpLogPreview = new JTextPane();
				scrollPane.setViewportView(tpLogPreview);
				tpLogPreview.setEditable(false);
			}
		}
		
		 btnCancel = new JButton("Cancel");
		 btnCancel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		setVisible(false);
		 		conf=false;
		 	}
		 });
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 1;
		getContentPane().add(btnCancel, gbc_btnCancel);
		{
			btnNext = new JButton("Aplay");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					conf=true;
					setVisible(false);
				}
			});
			GridBagConstraints gbc_btnNext = new GridBagConstraints();
			gbc_btnNext.gridx = 1;
			gbc_btnNext.gridy = 1;
			getContentPane().add(btnNext, gbc_btnNext);
		}
	}

	public JTextPane getTpLogPreview() {
		return tpLogPreview;
	}

	public void setTpLogPreview(JTextPane tpLogPreview) {
		this.tpLogPreview = tpLogPreview;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public boolean isConf() {
		return conf;
	}

	public void setConf(boolean conf) {
		this.conf = conf;
	}


}
