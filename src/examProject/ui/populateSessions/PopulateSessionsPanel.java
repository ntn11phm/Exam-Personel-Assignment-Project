package examProject.ui.populateSessions;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import examProject.logic.BackendFacade;

import java.awt.Color;
import java.awt.Font;

public class PopulateSessionsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblInformation = new JLabel("Välj datum och tid att knyta ihop värdar och sessioner mellan!");
	private JTextField tbDate = new JTextField();
	private JButton btnLoadSessions = new JButton("Ladda sessioner");
	private JLabel lblSessionList = new JLabel("Sessioner");
	private JScrollPane scrollPane = new JScrollPane();
	private JList<String> hostList = new JList<String>();
	private JComboBox<String> cbSessions = new JComboBox<String>();
	private JButton btnCommitSession = new JButton("Spara knytning!");
	private JLabel host1_lbl = new JLabel("Värd 1");
	private JTextField host1_tb = new JTextField();
	private JCheckBox host1_cb = new JCheckBox("Huvudvärd");
	private JButton host1_btn = new JButton("Lägg till vald...");
	private JButton host1_btnClear = new JButton("X");
	private JLabel host2_lbl = new JLabel("Värd 2");
	private JTextField host2_tb = new JTextField();
	private JCheckBox host2_cb = new JCheckBox("Huvudvärd");
	private JButton host2_btn = new JButton("Lägg till vald...");
	private JButton host2_btnClear = new JButton("X");
	private JLabel host3_lbl = new JLabel("Värd 3");
	private JTextField host3_tb = new JTextField();
	private JCheckBox host3_cb = new JCheckBox("Huvudvärd");
	private JButton host3_btn = new JButton("Lägg till vald...");
	private JButton host3_btnClear = new JButton("X");
	private JLabel host4_lbl = new JLabel("Värd 4");
	private JTextField host4_tb = new JTextField();
	private JCheckBox host4_cb = new JCheckBox("Huvudvärd");
	private JButton host4_btn = new JButton("Lägg till vald...");
	private JButton host4_btnClear = new JButton("X");
	private JLabel lblAvailableHosts = new JLabel("Tillgängliga värdar");
	private ButtonGroup timeGrp = new ButtonGroup();
	private JRadioButton rbAM = new JRadioButton("08:00");
	private JRadioButton rbPM = new JRadioButton("14:00");
	private JPanel dateBorder = new JPanel();

	public PopulateSessionsPanel(BackendFacade backendFacade) {
		setLayout(null);
		setBounds();
		createCtrls();
		PopulateSessionsListener psl = new PopulateSessionsListener(this, backendFacade);
		psl.createListeners();
	}
	
	public JButton getBtnLoadSessions() {
		return btnLoadSessions;
	}

	public JButton getBtnCommitSession() {
		return btnCommitSession;
	}

	public JTextField getTbDate() {
		return tbDate;
	}

	public JRadioButton getRbAM() {
		return rbAM;
	}

	public JRadioButton getRbPM() {
		return rbPM;
	}

	public JButton getHost1_btn() {
		return host1_btn;
	}

	public JButton getHost2_btn() {
		return host2_btn;
	}

	public JButton getHost3_btn() {
		return host3_btn;
	}

	public JButton getHost4_btn() {
		return host4_btn;
	}
	
	public JButton gethost1_btnClear() {
		return host1_btnClear;
	}
	
	public JButton gethost2_btnClear() {
		return host2_btnClear;
	}
	
	public JButton gethost3_btnClear() {
		return host3_btnClear;
	}
	
	public JButton gethost4_btnClear() {
		return host4_btnClear;
	}
	
	public JList<String> getHostList() {
		return hostList;
	}

	public JCheckBox getHost1_cb() {
		return host1_cb;
	}

	public JCheckBox getHost2_cb() {
		return host2_cb;
	}

	public JCheckBox getHost3_cb() {
		return host3_cb;
	}

	public JCheckBox getHost4_cb() {
		return host4_cb;
	}
	
	public JTextField getHost1_tb() {
		return host1_tb;
	}

	public JTextField getHost2_tb() {
		return host2_tb;
	}

	public JTextField getHost3_tb() {
		return host3_tb;
	}

	public JTextField getHost4_tb() {
		return host4_tb;
	}
	
	public JComboBox<String> getSessionCb() {
		return cbSessions;
	}

	private void setBounds() {
		dateBorder.setBounds(10, 33, 157, 81);
		lblInformation.setBounds(10, 10, 350, 20);
		tbDate.setBounds(10, 20, 137, 25);
		rbAM.setBounds(10, 52, 69, 20);
		rbPM.setBounds(78, 52, 69, 20);
		btnLoadSessions.setBounds(170, 47, 150, 30);
		lblSessionList.setBounds(330, 30, 200, 20);
		scrollPane.setBounds(10, 145, 250, 400);
		cbSessions.setBounds(330, 50, 258, 25);
		btnCommitSession.setBounds(390, 529, 150, 30);
		host1_lbl.setBounds(270, 147, 260, 14);
		host1_tb.setBounds(270, 172, 260, 20);
		host1_cb.setBounds(266, 199, 125, 23);
		host1_btn.setBounds(401, 203, 129, 30);
		host1_btnClear.setBounds(536, 172, 52, 61);
		host2_lbl.setBounds(270, 229, 260, 14);
		host2_tb.setBounds(270, 254, 260, 20);
		host2_cb.setBounds(270, 281, 125, 23);
		host2_btn.setBounds(401, 285, 129, 30);
		host2_btnClear.setBounds(536, 253, 52, 61);
		host3_lbl.setBounds(270, 311, 260, 14);
		host3_tb.setBounds(270, 336, 260, 20);
		host3_cb.setBounds(270, 363, 125, 23);
		host3_btn.setBounds(401, 367, 129, 30);
		host3_btnClear.setBounds(536, 335, 52, 61);
		host4_lbl.setBounds(270, 393, 260, 14);
		host4_tb.setBounds(270, 422, 260, 20);
		host4_cb.setBounds(270, 449, 125, 23);
		host4_btn.setBounds(401, 453, 129, 30);
		host4_btnClear.setBounds(536, 421, 52, 61);
		lblAvailableHosts.setBounds(10, 120, 250, 20);
	}
	
	private void createCtrls() {
		dateBorder.setLayout(null);
		add(dateBorder);
		dateBorder.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datum", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(lblInformation);
		tbDate.setToolTipText("Datumformat: yyyy-MM-dd");
		dateBorder.add(tbDate);
		dateBorder.add(rbAM);
		dateBorder.add(rbPM);
		timeGrp.add(rbAM);
		timeGrp.add(rbPM);
		rbAM.setSelected(true);
		add(btnLoadSessions);
		add(lblSessionList);
		scrollPane.setViewportView(hostList);
		add(scrollPane);
		add(cbSessions);
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
		add(lblAvailableHosts);
		host1_btnClear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(host1_btnClear);
		host2_btnClear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(host2_btnClear);
		host3_btnClear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(host3_btnClear);
		host4_btnClear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(host4_btnClear);
	}
}
