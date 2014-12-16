package examProject.ui.answerInvitations;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import examProject.logic.BackendFacade;
import examProject.transferObjects.HsiTO;
import javax.swing.JLabel;

public class AnswerInvitationsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private List<HsiTO> hsiList;
	private JButton btnCommitAnswers = new JButton("Spara svar!");
	private JLabel lblStatusText = new JLabel("");
	private JButton btnLoadInv = new JButton("Ladda inbjudningar");
	
	public AnswerInvitationsPanel(BackendFacade backendFacade) {
		hsiList = backendFacade.getHsiList();
		DisplayInvitationsPanel dip = new DisplayInvitationsPanel(hsiList);
		this.panel = dip.getPanel();
		setLayout(null);
		setBounds();
		addCtrls();
	}
	
	private void setBounds() {
		scrollPane.setBounds(10, 11, 250, 500);
		btnCommitAnswers.setBounds(10, 558, 150, 32);
		lblStatusText.setBounds(10, 601, 250, 28);
		btnLoadInv.setBounds(10, 522, 150, 25);
	}
	
	private void addCtrls() {
		add(scrollPane);
		scrollPane.setViewportView(panel);
		add(btnCommitAnswers);
		add(lblStatusText);
		add(btnLoadInv);
	}
}
