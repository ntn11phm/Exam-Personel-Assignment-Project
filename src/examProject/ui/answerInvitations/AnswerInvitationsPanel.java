package examProject.ui.answerInvitations;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import examProject.logic.BackendFacade;
import examProject.transferObjects.HsiTO;

public class AnswerInvitationsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private List<HsiTO> hsiList;
	
	public AnswerInvitationsPanel(BackendFacade backendFacade) {
		hsiList = backendFacade.getHsiList();
		DisplayInvitationsPanel dip = new DisplayInvitationsPanel(hsiList);
		this.panel = dip.getPanel();
		setLayout(null);
		setBounds();
		addCtrls();
	}
	
	private void setBounds() {
		scrollPane.setBounds(40, 40, 400, 500);
		
	}
	
	private void addCtrls() {
		add(scrollPane);
		scrollPane.setViewportView(panel);
	}
}
