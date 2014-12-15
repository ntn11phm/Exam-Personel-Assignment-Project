package examProject.ui.answerInvitations;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import examProject.logic.BackendFacade;
import examProject.transferObjects.HsiTO;

public class AnswerInvitationsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private BackendFacade backendFacade;
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private List<HsiTO> hsiList;
	
	public AnswerInvitationsPanel(BackendFacade backendFacade) {
		this.backendFacade = backendFacade;
		hsiList = backendFacade.getHsiList();
		setLayout(null);
		setBounds();
		addCtrls();
	}
	
	private void setBounds() {
		scrollPane.setBounds(39, 40, 401, 526);
		
	}
	
	private void addCtrls() {
		add(scrollPane);
		scrollPane.setViewportView(panel);
	}
}
