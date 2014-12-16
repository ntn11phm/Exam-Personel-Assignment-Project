package examProject.ui.answerInvitations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import examProject.logic.BackendFacade;
import examProject.transferObjects.HsiTO;

public class AnswerInvitationsListener {
	private AnswerInvitationsPanel answerPanel;
	private BackendFacade backendFacade;
	private List<HsiTO> hsiList;
	
	public AnswerInvitationsListener(AnswerInvitationsPanel answerPanel, BackendFacade backendFacade) {
		this.answerPanel = answerPanel;
		this.backendFacade = backendFacade;
	}
	
	public void createButtonListeners() {
		answerPanel.getLoadInvBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {loadInv();}});
		answerPanel.getCommitAnswerBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {commitAnswers();}});
	}
	
	private void loadInv() {
		hsiList = backendFacade.getHsiList();
		DisplayInvitationsPanel dip = new DisplayInvitationsPanel(hsiList);
		answerPanel.getScollPane().setViewportView(dip.getPanel());
		answerPanel.repaint();
	}
	
	private void commitAnswers() {
		
	}
}
