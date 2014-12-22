package examProject.ui.answerInvitations;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import examProject.logic.BackendFacade;
import examProject.transferObjects.HsiTO;

public class AnswerInvitationsListener {
	private AnswerInvitationsPanel answerPanel;
	private BackendFacade backendFacade;
	private List<HsiTO> hsiList;
	private JPanel panel;
	
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
		this.panel = dip.getPanel();
		answerPanel.getScollPane().setViewportView(panel);
		answerPanel.repaint();
	}
	
	private void commitAnswers() {
		List<HsiTO> answerList = new ArrayList<HsiTO>();
		boolean result = false;
		for (Component c: panel.getComponents()) {
			boolean answer;
			if (c instanceof JCheckBox) {
				String componentName = c.getName();
				String[] parts = componentName.split("_");
				answer = ((JCheckBox) c).isSelected();
				if (parts.length==2)
					answerList.add(new HsiTO(parts[1], parts[0], answer));
			}
			
		}
		if (answerList.size()>0)
			result = backendFacade.commitInvitationAnswers(answerList);
		if (result)
			answerPanel.getStatusTextCtrl().setText("Dina svar har sparats!");
		else
			answerPanel.getStatusTextCtrl().setText("Något gick fel!");
	}
}
