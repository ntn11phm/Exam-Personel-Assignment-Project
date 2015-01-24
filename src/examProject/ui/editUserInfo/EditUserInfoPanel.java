package examProject.ui.editUserInfo;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import examProject.logic.BackendFacade;
import examProject.transferObjects.HostTO;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditUserInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel innerPanel = new JPanel();
	private JList<String> hostList = new JList<String>();
	private JLabel lblFirstName = new JLabel("Förnamn");
	private JLabel lblLastName = new JLabel("Efternamn");
	private JLabel lblHosts = new JLabel("Värdar");
	private JLabel lblAddress = new JLabel("Adress");
	private JLabel lblZip = new JLabel("Postnr");
	private JLabel lblCity = new JLabel("Ort");
	private JLabel lblPhone = new JLabel("Telenr");
	private JLabel lblMobile = new JLabel("Mobilnr");
	private JLabel lblEmail = new JLabel("E-post");
	private JLabel lblVerEmail = new JLabel("Validera E-post");
	private JLabel lblCivic = new JLabel("Person nr");
	private JLabel lblStatus = new JLabel();
	private JTextField tbFirstName = new JTextField();
	private JTextField tbLastName = new JTextField();
	private JTextField tbAddress = new JTextField();
	private JTextField tbZip = new JTextField();
	private JTextField tbCity = new JTextField();
	private JTextField tbPhone = new JTextField();
	private JTextField tbMobile = new JTextField();
	private JTextField tbEmail = new JTextField();
	private JTextField tbVerEmail = new JTextField();
	private JTextField tbCivic = new JTextField();
	private JButton btnUpdate = new JButton("Spara");
	private JCheckBox cbIsActive = new JCheckBox("Aktiv");
	private JCheckBox cbIsAdmin = new JCheckBox("Administratör");

	public EditUserInfoPanel(BackendFacade backendFacade) {
		setLayout(null);
		setBounds();
		addCtrls();
		EditUserInfoListener eu = new EditUserInfoListener(backendFacade, this);
		eu.createButtonListeners();
	}
	
	public void setAdminMode() {
		lblCivic.setVisible(true);
		tbCivic.setVisible(true);
		lblVerEmail.setVisible(true);
		tbVerEmail.setVisible(true);
		cbIsAdmin.setVisible(true);
		cbIsActive.setVisible(true);
		btnUpdate.setVisible(true);
		tbFirstName.setEditable(true);
		tbLastName.setEditable(true);
		tbAddress.setEditable(true);
		tbZip.setEditable(true);
		tbCity.setEditable(true);
		tbPhone.setEditable(true);
		tbMobile.setEditable(true);
		tbEmail.setEditable(true);
	}
	
	public void setHostMode(){
		lblCivic.setVisible(false);
		tbCivic.setVisible(false);
		lblVerEmail.setVisible(false);
		tbVerEmail.setVisible(false);
		cbIsAdmin.setVisible(false);
		cbIsActive.setVisible(false);
		btnUpdate.setVisible(false);
		tbFirstName.setEditable(false);
		tbLastName.setEditable(false);
		tbAddress.setEditable(false);
		tbZip.setEditable(false);
		tbCity.setEditable(false);
		tbPhone.setEditable(false);
		tbMobile.setEditable(false);
		tbEmail.setEditable(false);
	}
	
	public JList<String> getHostList() {
		return hostList;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}

	public JTextField getTbFirstName() {
		return tbFirstName;
	}

	public JTextField getTbLastName() {
		return tbLastName;
	}

	public JTextField getTbAddress() {
		return tbAddress;
	}

	public JTextField getTbZip() {
		return tbZip;
	}

	public JTextField getTbCity() {
		return tbCity;
	}

	public JTextField getTbPhone() {
		return tbPhone;
	}

	public JTextField getTbMobile() {
		return tbMobile;
	}

	public JTextField getTbEmail() {
		return tbEmail;
	}

	public JTextField getTbVerEmail() {
		return tbVerEmail;
	}

	public JTextField getTbCivic() {
		return tbCivic;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	
	public JCheckBox getCbIsActive() {
		return cbIsActive;
	}
	
	public JCheckBox getCbIsAdmin() {
		return cbIsAdmin;
	}

	private void setBounds() {
		lblHosts.setBounds(10, 10, 200, 20);
		scrollPane.setBounds(10, 40, 200, 600);
		lblFirstName.setBounds(220, 10, 150, 20);
		tbFirstName.setBounds(220, 40, 150, 20);
		lblLastName.setBounds(380, 10, 150, 20);
		tbLastName.setBounds(380, 40, 150, 20);
		lblAddress.setBounds(220, 70, 310, 20);
		tbAddress.setBounds(220, 100, 310, 20);
		lblZip.setBounds(220, 130, 100, 20);
		tbZip.setBounds(220, 160, 100, 20);
		lblCity.setBounds(330, 130, 200, 20);
		tbCity.setBounds(330, 160, 200, 20);
		lblPhone.setBounds(220, 190, 150, 20);
		tbPhone.setBounds(220, 220, 150, 20);
		lblMobile.setBounds(380, 190, 150, 20);
		tbMobile.setBounds(380, 220, 150, 20);
		lblEmail.setBounds(220, 250, 310, 20);
		tbEmail.setBounds(220, 280, 310, 20);
		lblVerEmail.setBounds(220, 310, 310, 20);
		tbVerEmail.setBounds(220, 340, 310, 20);
		lblCivic.setBounds(220, 370, 200, 20);
		tbCivic.setBounds(220, 400, 200, 20);
		cbIsActive.setBounds(220, 430, 310, 20);
		cbIsAdmin.setBounds(220, 460, 310, 20);
		btnUpdate.setBounds(220, 490, 100, 25);
		lblStatus.setBounds(220, 620, 310, 20);
	}
	
	private void addCtrls() {
		innerPanel.setLayout(null);
		hostList.setBounds(0,0, 200, 600);
		innerPanel.add(hostList);
		scrollPane.setViewportView(innerPanel);
		add(scrollPane);
		add(lblHosts);
		add(lblFirstName);
		add(tbFirstName);
		add(lblLastName);
		add(tbLastName);
		add(lblAddress);
		add(tbAddress);
		add(lblZip);
		add(tbZip);
		add(lblCity);
		add(tbCity);
		add(lblPhone);
		add(tbPhone);
		add(lblMobile);
		add(tbMobile);
		add(lblEmail);
		add(tbEmail);
		add(lblVerEmail);
		add(tbVerEmail);
		add(lblCivic);
		add(tbCivic);
		add(cbIsActive);
		add(cbIsAdmin);
		add(btnUpdate);
		add(lblStatus);
	}
}
