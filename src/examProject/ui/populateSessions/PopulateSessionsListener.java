package examProject.ui.populateSessions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import examProject.logic.BackendFacade;
import examProject.transferObjects.HostSessionTO;
import examProject.transferObjects.HostTO;
import examProject.transferObjects.SessionLocationTO;

public class PopulateSessionsListener {
	private PopulateSessionsPanel psPanel;
	private JList<String> hostListCtrl;
	private BackendFacade backendFacade;
	private List<HostTO> hostList;
	private List<HostTO> inUseHostList;
	private HostTO tmpHost;
	private List<SessionLocationTO> sessionList;
	private List<HostSessionTO> toStoreList;
	private final String timeAM = "08:00";
	private final String timePM = "15:00";
	private boolean isSaved = true;
	
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
		psPanel.getHost1_cb().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {isSaved=false;}});
		psPanel.getHost2_cb().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {isSaved=false;}});
		psPanel.getHost3_cb().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {isSaved=false;}});
		psPanel.getHost4_cb().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {isSaved=false;}});
		
	}
	
	private void addHost1() {
		if (hostListCtrl.getSelectedIndex() != -1) {
			isSaved = false;
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
			if (target != -1) {
				hostList.add(tmpHost);
				backendFacade.removeHostSessionPost(tmpHost.getHost_id(), getSessionId());
			}
			loadHostListCtrl();
		}
	}
	
	private void addHost2() {
		if (hostListCtrl.getSelectedIndex() != -1) {
			isSaved = false;
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
			psPanel.getHost2_tb().setText(hostListCtrl.getSelectedValue());
			inUseHostList.add(hostList.get(hostListCtrl.getSelectedIndex()));
			hostList.remove(hostListCtrl.getSelectedIndex());
			if (target != -1) {
				hostList.add(tmpHost);
				backendFacade.removeHostSessionPost(tmpHost.getHost_id(), getSessionId());
			}
			loadHostListCtrl();
		}
	}
	
	private void addHost3() {
		if (hostListCtrl.getSelectedIndex() != -1) {
			isSaved = false;
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
			psPanel.getHost3_tb().setText(hostListCtrl.getSelectedValue());
			inUseHostList.add(hostList.get(hostListCtrl.getSelectedIndex()));
			hostList.remove(hostListCtrl.getSelectedIndex());
			if (target != -1) {
				hostList.add(tmpHost);
				backendFacade.removeHostSessionPost(tmpHost.getHost_id(), getSessionId());
			}
			loadHostListCtrl();
		}
	}
	
	private void addHost4() {
		if (hostListCtrl.getSelectedIndex() != -1) {
			isSaved = false;
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
			psPanel.getHost4_tb().setText(hostListCtrl.getSelectedValue());
			inUseHostList.add(hostList.get(hostListCtrl.getSelectedIndex()));
			hostList.remove(hostListCtrl.getSelectedIndex());
			if (target != -1) {
				hostList.add(tmpHost);
				backendFacade.removeHostSessionPost(tmpHost.getHost_id(), getSessionId());
			}
			loadHostListCtrl();
		}
	}
	
	private void clearHost1() {
		isSaved = false;
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
		psPanel.getHost1_tb().setText("");
		if (target != -1) {
			hostList.add(tmpHost);
			backendFacade.removeHostSessionPost(tmpHost.getHost_id(), getSessionId());
		}
		loadHostListCtrl();
	}
	
	private void clearHost2() {
		isSaved = false;
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
		psPanel.getHost2_tb().setText("");
		if (target != -1)
			hostList.add(tmpHost);
		loadHostListCtrl();
	}
	
	private void clearHost3() {
		isSaved = false;
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
		psPanel.getHost3_tb().setText("");
		if (target != -1)
			hostList.add(tmpHost);
		loadHostListCtrl();
	}
	
	private void clearHost4() {
		isSaved = false;
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
		psPanel.getHost4_tb().setText("");
		if (target != -1)
			hostList.add(tmpHost);
		loadHostListCtrl();
	}
	
	private void commitCurrentSession() {
		if(!isSaved) {
			if(hasHeadHost()) {
				toStoreList = new ArrayList<HostSessionTO>();
				boolean isResponsible = false;
				for (int x = 0; x < 4; x++) {
					String [] parts = {"a", "b", "-1"};
					if (x==0 && !psPanel.getHost1_tb().getText().equals("")) {
						parts = psPanel.getHost1_tb().getText().split(" ");
						isResponsible = psPanel.getHost1_cb().isSelected();
					}
					if (x==1 && !psPanel.getHost2_tb().getText().equals("")) {
						parts = psPanel.getHost2_tb().getText().split(" ");
						isResponsible = psPanel.getHost2_cb().isSelected();
					} else if (x==2 && !psPanel.getHost3_tb().getText().equals("")) {
						parts = psPanel.getHost3_tb().getText().split(" ");
						isResponsible = psPanel.getHost3_cb().isSelected();
					} else if (x==3 && !psPanel.getHost4_tb().getText().equals("")) {
						parts = psPanel.getHost4_tb().getText().split(" ");
						isResponsible = psPanel.getHost4_cb().isSelected();
					}
					if (!parts[2].equals("-1"))
						toStoreList.add(new HostSessionTO(getSessionId(), Integer.parseInt(parts[2]), isResponsible));
				}
				if (toStoreList.size()>0)
					backendFacade.storeToSessionHost(toStoreList);
				isSaved = true;
			} else
				JOptionPane.showMessageDialog(null, "Endast 1 huvudvärd ska vara vald!", "Huvudvärds-fel", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private int getSessionId() {
		int result = -1;
		for (int i = 0; i < sessionList.size(); i++)
			if (sessionList.get(i).getDate().equals(psPanel.getTbDate().getText()) && sessionList.get(i).getTime().equals(getTime()) && sessionList.get(i).getLocation().equals(psPanel.getSessionCb().getSelectedItem().toString()))
				result = sessionList.get(i).getSession_id();
		return result;
	}
	
	private boolean hasHeadHost() {
		boolean result = false;
		int counter = 0;
		if (psPanel.getHost1_cb().isSelected())
			counter++;
		if (psPanel.getHost2_cb().isSelected())
			counter++;
		if (psPanel.getHost3_cb().isSelected())
			counter++;
		if (psPanel.getHost4_cb().isSelected())
			counter++;
		if (counter == 1)
			result = true;
		return result;
	}
	
	private void cbSessionsChanged() {
		if(noSaveCheck()) {
			clearHosts();
			List<HostTO> hostList = backendFacade.getHostsForSession(getSessionId());
			for (int i = 0; i < hostList.size(); i++) {
				if (i==0) {
					psPanel.getHost1_tb().setText(hostList.get(i).toString());
					psPanel.getHost1_cb().setSelected(hostList.get(i).isResponsible());
				} else if (i==1) {
					psPanel.getHost2_tb().setText(hostList.get(i).toString());
					psPanel.getHost2_cb().setSelected(hostList.get(i).isResponsible());
				} else if (i==2) {
					psPanel.getHost3_tb().setText(hostList.get(i).toString());
					psPanel.getHost3_cb().setSelected(hostList.get(i).isResponsible());
				} else if (i==3) {
					psPanel.getHost4_tb().setText(hostList.get(i).toString());
					psPanel.getHost4_cb().setSelected(hostList.get(i).isResponsible());
				}
			}
		}
	}
	
	private void clearHosts() {
		psPanel.getHost1_cb().setSelected(false);
		psPanel.getHost2_cb().setSelected(false);
		psPanel.getHost3_cb().setSelected(false);
		psPanel.getHost4_cb().setSelected(false);
		psPanel.getHost1_tb().setText("");
		psPanel.getHost2_tb().setText("");
		psPanel.getHost3_tb().setText("");
		psPanel.getHost4_tb().setText("");
	}
	
	private boolean noSaveCheck(){
		if (isSaved)
			return true;
		else
			if(JOptionPane.showConfirmDialog(null, "Fortsätta utan att spara?", "Data ej sparat", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
				commitCurrentSession();
				return true;
			}
		clearCtrls();
		isSaved = true;
		return true;
	}
	
	private void clearCtrls() {
		psPanel.getHost1_cb().setSelected(false);
		psPanel.getHost2_cb().setSelected(false);
		psPanel.getHost3_cb().setSelected(false);
		psPanel.getHost4_cb().setSelected(false);
		psPanel.getHost1_tb().setText("");
		psPanel.getHost2_tb().setText("");
		psPanel.getHost3_tb().setText("");
		psPanel.getHost4_tb().setText("");
		
	}

	private void loadCtrls() {
		if(noSaveCheck()) {
			if (validateDate(psPanel.getTbDate().getText())) {
				loadSessionComboBox();
				loadHostList();
			} else
				JOptionPane.showMessageDialog(null, "Felaktigt datumformat!\n(yyyy-MM-dd)");
		} 
	}
	
	private void loadSessionComboBox() {
		sessionList = backendFacade.loadLocations(psPanel.getTbDate().getText(), getTime());
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
		inUseHostList = new ArrayList<HostTO>();
		if (hostList.size() > 0)
			for (int i = (hostList.size() - 1); i > -1; i--)
				if (!backendFacade.checkHostSessionAvailabillity(psPanel.getTbDate().getText(), getTime(), hostList.get(i).getHost_id())) {
					inUseHostList.add(hostList.get(i));
					hostList.remove(i);
				}
	}
	
	private void loadHostListCtrl() {
		int lenght = hostList.size();
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
