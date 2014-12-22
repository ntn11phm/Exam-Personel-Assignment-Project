package examProject.ui.populateSessions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import examProject.logic.BackendFacade;
import examProject.transferObjects.CreateInvitationTO;
import examProject.transferObjects.HostTO;
import examProject.transferObjects.HsiTO;

public class PopulateSessionsListener {
	private PopulateSessionsPanel psPanel;
	private JList<String> hostListCtrl;
	private BackendFacade backendFacade;
	private List<HostTO> hostList;
	private List<HostTO> inUseHostList;
	private HostTO tmpHost;
	private List<HsiTO> sessionList;
	private final String timeAM = "08:00";
	private final String timePM = "14:00";
	
	public PopulateSessionsListener(PopulateSessionsPanel psPanel, BackendFacade backendFacade) {
		this.psPanel = psPanel;
		this.hostListCtrl = psPanel.getHostList();
		this.backendFacade = backendFacade;
	}
	
	public void createListeners() {
		psPanel.getBtnLoadSessions().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {loadCtrls();}});
		psPanel.getBtnCommitSession().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {commitCurrentSession();}});
		psPanel.getHost1_btn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addHost1();}});
		psPanel.getHost2_btn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addHost2();}});
		psPanel.getHost3_btn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addHost3();}});
		psPanel.getHost4_btn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addHost4();}});
		psPanel.getSessionCb().addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent arg0) {cbSessionsChanged();}});
		psPanel.gethost1_btnClear().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {clearHost1();}});
		psPanel.gethost2_btnClear().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {clearHost2();}});
		psPanel.gethost3_btnClear().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {clearHost3();}});
		psPanel.gethost4_btnClear().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {clearHost4();}});
		
	}
	
	private void addHost1() {
		if (hostListCtrl.getSelectedIndex() != -1) {
			int target = -1;
			if (!psPanel.getHost1_tb().getText().equals("")) {
				String [] parts = psPanel.getHost1_tb().getText().split(" ");
				for (int i = 0; i < inUseHostList.size(); i++)
					if (inUseHostList.get(i).getLastName().equals(parts[1])) 
						if (inUseHostList.get(i).getFirstName().equals(parts[0]))
							target = i;
				tmpHost = inUseHostList.get(target);
				inUseHostList.remove(target);
			}
			psPanel.getHost1_tb().setText(hostListCtrl.getSelectedValue());
			inUseHostList.add(hostList.get(hostListCtrl.getSelectedIndex()));
			hostList.remove(hostListCtrl.getSelectedIndex());
			if (target != -1)
				hostList.add(tmpHost);
			loadHostListCtrl();
		}
	}
	
	private void addHost2() {
		if (hostListCtrl.getSelectedIndex() != -1) {
			int target = -1;
			if (!psPanel.getHost2_tb().getText().equals("")) {
				String [] parts = psPanel.getHost2_tb().getText().split(" ");
				for (int i = 0; i < inUseHostList.size(); i++)
					if (inUseHostList.get(i).getLastName().equals(parts[1])) 
						if (inUseHostList.get(i).getFirstName().equals(parts[0]))
							target = i;
				tmpHost = inUseHostList.get(target);
				inUseHostList.remove(target);
			}
			psPanel.getHost1_tb().setText(hostListCtrl.getSelectedValue());
			inUseHostList.add(hostList.get(hostListCtrl.getSelectedIndex()));
			hostList.remove(hostListCtrl.getSelectedIndex());
			if (target != -1)
				hostList.add(tmpHost);
			loadHostListCtrl();
		}
	}
	
	private void addHost3() {
		if (hostListCtrl.getSelectedIndex() != -1) {
			int target = -1;
			if (!psPanel.getHost3_tb().getText().equals("")) {
				String [] parts = psPanel.getHost3_tb().getText().split(" ");
				for (int i = 0; i < inUseHostList.size(); i++)
					if (inUseHostList.get(i).getLastName().equals(parts[1])) 
						if (inUseHostList.get(i).getFirstName().equals(parts[0]))
							target = i;
				tmpHost = inUseHostList.get(target);
				inUseHostList.remove(target);
			}
			psPanel.getHost1_tb().setText(hostListCtrl.getSelectedValue());
			inUseHostList.add(hostList.get(hostListCtrl.getSelectedIndex()));
			hostList.remove(hostListCtrl.getSelectedIndex());
			if (target != -1)
				hostList.add(tmpHost);
			loadHostListCtrl();
		}
	}
	
	private void addHost4() {
		if (hostListCtrl.getSelectedIndex() != -1) {
			int target = -1;
			if (!psPanel.getHost4_tb().getText().equals("")) {
				String [] parts = psPanel.getHost4_tb().getText().split(" ");
				for (int i = 0; i < inUseHostList.size(); i++)
					if (inUseHostList.get(i).getLastName().equals(parts[1])) 
						if (inUseHostList.get(i).getFirstName().equals(parts[0]))
							target = i;
				tmpHost = inUseHostList.get(target);
				inUseHostList.remove(target);
			}
			psPanel.getHost1_tb().setText(hostListCtrl.getSelectedValue());
			inUseHostList.add(hostList.get(hostListCtrl.getSelectedIndex()));
			hostList.remove(hostListCtrl.getSelectedIndex());
			if (target != -1)
				hostList.add(tmpHost);
			loadHostListCtrl();
		}
	}
	
	private void clearHost1() {
		
	}
	
	private void clearHost2() {
		
	}
	
	private void clearHost3() {
		
	}
	
	private void clearHost4() {
		
	}
	
	private void commitCurrentSession() {
		
	}
	
	private void cbSessionsChanged() {
		
	}
	
	private void loadCtrls() {
		if (validateDate(psPanel.getTbDate().getText())) {
			loadSessionComboBox();
			loadHostList();
		} else
			JOptionPane.showMessageDialog(null, "Felaktigt datumformat!\n(yyyy-MM-dd)");
		
	}
	
	private void loadSessionComboBox() {
		sessionList = backendFacade.getSessions(new CreateInvitationTO(psPanel.getTbDate().getText(), psPanel.getTbDate().getText()));
		psPanel.getSessionCb().setModel(new DefaultComboBoxModel<String>());
		for (int i = 0; i < sessionList.size(); i++)
			psPanel.getSessionCb().addItem(sessionList.get(i).toString());
	}

	private void loadHostList() {
		hostList = backendFacade.getAvailableHostsList(psPanel.getTbDate().getText(), getTime());
		checkHostList();
		loadHostListCtrl();
	}
	
	private String getTime() {
		String result = "";
		if (psPanel.getRbAM().isSelected())
			result = timeAM;
		else
			result = timePM;
		return result;
	}
	
	private void checkHostList() {
		if (hostList.size() > 0)
			for (int i = (hostList.size() - 1); i > -1; i--)
				if (backendFacade.checkHostSessionAvailabillity(psPanel.getTbDate().getText(), getTime(), hostList.get(i).getHost_id())) {
					inUseHostList.add(hostList.get(i));
					hostList.remove(i);
				}
	}
	
	private void loadHostListCtrl() {
		int lenght = hostList.size()-1;
		String [] arrString = new String[lenght];
		for (int i = 0; i < lenght; i++)
			arrString[i] = hostList.get(i).toString();
		psPanel.getHostList().setListData(arrString);
	}
	
	private boolean validateDate(String date) {
		boolean result = true;
		if (!(date.length() == 10))
			return false;
		else if (!date.substring(4, 5).equals("-"))
			return false;
		else if (!date.substring(7, 8).equals("-"))
			return false;
		for (int i = 0; i < date.length(); i++)
			switch (date.substring(i, i + 1).toLowerCase()) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
			case "-":
				if (date.substring(i, i + 1).equals("-"))
					switch (i){
					case 7:
					case 4:
						break;
					default : 
						return false;
					}
				break;
			default:
				return false;
			}
		return result;
	}
}
