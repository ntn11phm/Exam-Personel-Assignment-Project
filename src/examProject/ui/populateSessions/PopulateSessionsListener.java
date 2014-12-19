package examProject.ui.populateSessions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import examProject.logic.BackendFacade;
import examProject.transferObjects.CreateInvitationTO;
import examProject.transferObjects.HostTO;
import examProject.transferObjects.HsiTO;

public class PopulateSessionsListener {
	private PopulateSessionsPanel psPanel;
	private BackendFacade backendFacade;
	private List<HostTO> hostList;
	private List<HostTO> inUseHostList;
	private List<HsiTO> sessionList;
	
	public PopulateSessionsListener(PopulateSessionsPanel psPanel, BackendFacade backendFacade) {
		this.psPanel = psPanel;
		this.backendFacade = backendFacade;
	}
	
	public void createListeners() {
		psPanel.getBtnLoadSessions().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {loadCtrls();}});
		psPanel.getBtnCommitSession();
		psPanel.getHost1_btn();
		psPanel.getHost2_btn();
		psPanel.getHost2_btn();
		psPanel.getHost2_btn();
		psPanel.getSessionCb().addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent arg0) {cbSessionsChanged();}});
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
		hostList = backendFacade.getAvailableHostsList(psPanel.getTbDate().getText());
		checkHostList();
		loadHostListCtrl();
	}
	
	private void checkHostList() {
		if (hostList.size() > 0)
			for (int i = (hostList.size() - 1); i > -1; i--)
				if (backendFacade.checkHostSessionAvailabillity(psPanel.getTbDate().getText(), hostList.get(i).getHost_id())) {
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
