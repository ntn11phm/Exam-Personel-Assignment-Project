package examProject.ui.populateSessions;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PopulateSessionsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblInformation = new JLabel("Välj datum att knyta ihop värdar och sessioner mellan!");
	private JLabel lblFromDate = new JLabel("Från datum:");
	private JTextField tbFromDate = new JTextField();
	private JLabel lblToDate = new JLabel("Till datum:");
	private JTextField tbToDate = new JTextField();
	private JButton btnLoadSessions = new JButton("Ladda sessioner");
	private JLabel lblSessionList = new JLabel("Sessioner");
	private JScrollPane scrollPane = new JScrollPane();
	private JList<String> sessionList = new JList<String>();
	private JComboBox<String> cbHosts = new JComboBox<String>();
	private JButton btnCommitSession = new JButton("");

	public PopulateSessionsPanel() {
		setLayout(null);
		setBounds();
		createCtrls();
	}
	
	private void setBounds() {
		lblInformation.setBounds(10, 10, 350, 20);
		lblFromDate.setBounds(10, 30, 150, 20);
		lblToDate.setBounds(170, 30, 150, 20);
		tbFromDate.setBounds(10, 50, 150, 25);
		tbToDate.setBounds(170, 50, 150, 25);
		btnLoadSessions.setBounds(10, 85, 150, 30);
		lblSessionList.setBounds(10, 120, 350, 20);
		scrollPane.setBounds(10, 145, 250, 400);
		cbHosts.setBounds(330, 50, 200, 25);
		btnCommitSession.setBounds(330, 500, 150, 30);
	}
	
	private void createCtrls() {
		add(lblInformation);
		add(lblFromDate);
		add(tbFromDate);
		add(lblToDate);
		add(tbToDate);
		add(btnLoadSessions);
		add(lblSessionList);
		scrollPane.setViewportView(sessionList);
		add(scrollPane);
		add(cbHosts);
		add(btnCommitSession);
	}
}
