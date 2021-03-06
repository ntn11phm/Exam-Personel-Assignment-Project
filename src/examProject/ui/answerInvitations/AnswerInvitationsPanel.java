package examProject.ui.answerInvitations;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import examProject.logic.BackendFacade;

import javax.swing.JLabel;

public class AnswerInvitationsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane = new JScrollPane();
	private JButton btnCommitAnswers = new JButton("Spara svar!");
	private JLabel lblStatusText = new JLabel("");
	private JButton btnLoadInv = new JButton("Ladda inbjudningar");
	
	public AnswerInvitationsPanel(BackendFacade backendFacade) {
		setLayout(null);
		setBounds();
		addCtrls();
		AnswerInvitationsListener ail = new AnswerInvitationsListener(this, backendFacade);
		ail.createButtonListeners();
	}
	
	private void setBounds() {
		scrollPane.setBounds(10, 11, 250, 500);
		btnCommitAnswers.setBounds(10, 558, 150, 32);
		lblStatusText.setBounds(10, 601, 250, 28);
		btnLoadInv.setBounds(10, 522, 150, 25);
	}
	
	private void addCtrls() {
		scrollPane.setPreferredSize(new Dimension(240,500));
		add(scrollPane);
		add(btnCommitAnswers);
		add(lblStatusText);
		add(btnLoadInv);
	}
	
	public JButton getLoadInvBtn() {
		return btnLoadInv;
	}
	
	public JButton getCommitAnswerBtn() {
		return btnCommitAnswers;
	}
	
	public JScrollPane getScollPane() {
		return scrollPane;
	}
	
	public JLabel getStatusTextCtrl() {
		return lblStatusText;
	}
}
