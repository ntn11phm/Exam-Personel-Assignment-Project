package examProject.ui.answerInvitations;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;

public class AnswerInvitationsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	
	public AnswerInvitationsPanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 40, 401, 526);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDate = new JLabel("Date 1");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		panel.add(lblDate, gbc_lblDate);
		
		JCheckBox chckbxTime = new JCheckBox("Time 1");
		GridBagConstraints gbc_chckbxTime = new GridBagConstraints();
		gbc_chckbxTime.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxTime.gridx = 1;
		gbc_chckbxTime.gridy = 0;
		panel.add(chckbxTime, gbc_chckbxTime);
		
		JLabel lblDate_1 = new JLabel("Date 1");
		GridBagConstraints gbc_lblDate_1 = new GridBagConstraints();
		gbc_lblDate_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblDate_1.gridx = 0;
		gbc_lblDate_1.gridy = 1;
		panel.add(lblDate_1, gbc_lblDate_1);
		
		JCheckBox chckbxTime_1 = new JCheckBox("Time 2");
		GridBagConstraints gbc_chckbxTime_1 = new GridBagConstraints();
		gbc_chckbxTime_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxTime_1.gridx = 1;
		gbc_chckbxTime_1.gridy = 1;
		panel.add(chckbxTime_1, gbc_chckbxTime_1);
		
	}
}
