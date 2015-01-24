package examProject.ui.editUserInfo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JList;
import examProject.logic.BackendFacade;
import examProject.transferObjects.HostTO;
import examProject.transferObjects.UpdateUserTransfere;

public class EditUserInfoListener {
	private EditUserInfoPanel editUserPanel;
	private BackendFacade backendFacade;
	private List<HostTO> hostArray;
	
	public EditUserInfoListener(BackendFacade backendFacade, EditUserInfoPanel editUserPanel) {
		this.backendFacade = backendFacade;
		this.editUserPanel = editUserPanel;
		setUserMode();
		loadHostList();
	}
	
	public void createButtonListeners() {
		editUserPanel.getBtnUpdate().addKeyListener(new KeyAdapter() {public void keyReleased(KeyEvent e) {updateHost();}});
		editUserPanel.getHostList().addKeyListener(new KeyAdapter() {public void keyReleased(KeyEvent e) {loadSelectedPost();}});
		editUserPanel.getHostList().addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent mouseEvent) {listClick(mouseEvent);}});
	}
	private void updateHost() {
		
	}
	
	private void loadSelectedPost(){
		loadSelectedPostRow(editUserPanel.getHostList().getSelectedIndex());
	}
	
	private void listClick(MouseEvent mouseEvent) {
		JList<String> tmpList = editUserPanel.getHostList();
		tmpList = (JList<String>) mouseEvent.getSource();
		if (mouseEvent.getClickCount() > 0) {
			int index = editUserPanel.getHostList().locationToIndex(mouseEvent.getPoint());
			loadSelectedPostRow(index);
		}
	}
	
	private void loadSelectedPostRow(int index) {
		clearData();
		UpdateUserTransfere host = backendFacade.getHost(hostArray.get(index).getHost_id());
		editUserPanel.getTbAddress().setText(host.getAddress());
		editUserPanel.getTbCity().setText(host.getCity());
		editUserPanel.getTbCivic().setText(host.getCivic());
		editUserPanel.getTbEmail().setText(host.getEmail());
		editUserPanel.getTbFirstName().setText(host.getFirstName());
		editUserPanel.getTbLastName().setText(host.getLastName());
		editUserPanel.getTbMobile().setText(host.getMobileNr());
		editUserPanel.getTbPhone().setText(host.getPhoneNr());
		editUserPanel.getTbZip().setText(host.getZipCode());
		editUserPanel.getTbVerEmail().setText(host.getEmail());
		editUserPanel.getCbIsActive().setSelected(host.isActive());
		editUserPanel.getCbIsAdmin().setSelected(host.isAdmin());
	}
	
	private void clearData() {
		editUserPanel.getTbAddress().setText("");
		editUserPanel.getTbCity().setText("");
		editUserPanel.getTbCivic().setText("");
		editUserPanel.getTbEmail().setText("");
		editUserPanel.getTbFirstName().setText("");
		editUserPanel.getTbLastName().setText("");
		editUserPanel.getTbMobile().setText("");
		editUserPanel.getTbPhone().setText("");
		editUserPanel.getTbZip().setText("");
		editUserPanel.getTbVerEmail().setText("");
		editUserPanel.getCbIsActive().setSelected(false);
		editUserPanel.getCbIsAdmin().setSelected(false);
	}
	
	private void setUserMode() {
		if (backendFacade.getCurrentUserRole())
			editUserPanel.setAdminMode();
		else
			editUserPanel.setHostMode();
	}
	
	private void loadHostList() {
		hostArray = backendFacade.getHosts();
		int lenght = hostArray.size()-1;
		String [] arrString = new String[lenght];
		for (int i = 0; i < lenght; i++)
			arrString[i] = "" + hostArray.get(i).getLastName() + ", " + hostArray.get(i).getFirstName();
		editUserPanel.getHostList().setListData(arrString);
	}
}
