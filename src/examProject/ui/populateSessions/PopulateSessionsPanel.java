package examProject.ui.populateSessions;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class PopulateSessionsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblInformation = new JLabel("Välj datum att knyta ihop värdar och sessioner mellan!");
	private JLabel lblFromDate = new JLabel("Från datum:");
	private JTextField tbFromDate = new JTextField();
	private JButton btnLoadSessions = new JButton("Ladda sessioner");
	private JLabel lblSessionList = new JLabel("Sessioner");
	private JScrollPane scrollPane = new JScrollPane();
	private JList<String> hostList = new JList<String>();
	private JComboBox<String> cbHosts = new JComboBox<String>();
	private JButton btnCommitSession = new JButton("Spara knytning!");
	private JLabel host1_lbl = new JLabel("Värd 1");
	private JTextField host1_tb = new JTextField();
	private JCheckBox host1_cb = new JCheckBox("Huvudvärd");
	private JButton host1_btn = new JButton("Lägg till vald...");
	private JLabel host2_lbl = new JLabel("Värd 2");
	private JTextField host2_tb = new JTextField();
	private JCheckBox host2_cb = new JCheckBox("Huvudvärd");
	private JButton host2_btn = new JButton("Lägg till vald...");
	private JLabel host3_lbl = new JLabel("Värd 3");
	private JTextField host3_tb = new JTextField();
	private JCheckBox host3_cb = new JCheckBox("Huvudvärd");
	private JButton host3_btn = new JButton("Lägg till vald...");
	private JLabel host4_lbl = new JLabel("Värd 4");
	private JTextField host4_tb = new JTextField();
	private JCheckBox host4_cb = new JCheckBox("Huvudvärd");
	private JButton host4_btn = new JButton("Lägg till vald...");
	private JLabel lblTllgngligaVrdar = new JLabel("Tillgängliga värdar");

	public PopulateSessionsPanel() {
		setLayout(null);
		setBounds();
		createCtrls();
	}
	
	private void setBounds() {
		lblInformation.setBounds(10, 10, 350, 20);
		lblFromDate.setBounds(10, 30, 150, 20);
		tbFromDate.setBounds(10, 50, 150, 25);
		btnLoadSessions.setBounds(170, 47, 150, 30);
		lblSessionList.setBounds(330, 30, 200, 20);
		scrollPane.setBounds(10, 145, 250, 400);
		cbHosts.setBounds(330, 50, 200, 25);
		btnCommitSession.setBounds(390, 529, 150, 30);
		host1_lbl.setBounds(270, 147, 260, 14);
		host1_tb.setBounds(270, 172, 260, 20);
		host1_cb.setBounds(266, 199, 125, 23);
		host1_btn.setBounds(397, 199, 133, 30);
		host2_lbl.setBounds(270, 229, 260, 14);
		host2_tb.setBounds(270, 254, 260, 20);
		host2_cb.setBounds(270, 281, 125, 23);
		host2_btn.setBounds(401, 281, 133, 30);
		host3_lbl.setBounds(270, 311, 260, 14);
		host3_tb.setBounds(270, 336, 260, 20);
		host3_cb.setBounds(270, 363, 125, 23);
		host3_btn.setBounds(401, 363, 133, 30);
		host4_lbl.setBounds(270, 393, 260, 14);
		host4_tb.setBounds(270, 422, 260, 20);
		host4_cb.setBounds(270, 449, 125, 23);
		host4_btn.setBounds(405, 445, 133, 30);
		lblTllgngligaVrdar.setBounds(10, 120, 250, 20);
	}
	
	private void createCtrls() {
		add(lblInformation);
		add(lblFromDate);
		add(tbFromDate);
		add(btnLoadSessions);
		add(lblSessionList);
		scrollPane.setViewportView(hostList);
		add(scrollPane);
		add(cbHosts);
		add(btnCommitSession);
		add(host1_lbl);
		host1_tb.setEditable(false);
		add(host1_tb);
		add(host1_cb);
		add(host1_btn);
		add(host2_lbl);
		host2_tb.setEditable(false);
		add(host2_tb);
		add(host2_cb);
		add(host2_btn);
		add(host3_lbl);
		host3_tb.setEditable(false);
		add(host3_tb);
		add(host3_cb);
		add(host3_btn);
		add(host4_lbl);
		host4_tb.setEditable(false);
		add(host4_tb);
		add(host4_cb);
		add(host4_btn);
		add(lblTllgngligaVrdar);
	}
}