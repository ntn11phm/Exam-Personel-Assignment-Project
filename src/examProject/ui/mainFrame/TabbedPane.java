package examProject.ui.mainFrame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import examProject.logic.BackendFacade;
import examProject.logic.OptionsFileReader;
import examProject.transferObjects.DBConnectionTO;
import examProject.transferObjects.LoggedInUserTO;
import examProject.ui.addUser.AddUserGUI;
import examProject.ui.adminEditInformationAboutHosts.AdminEditHostsInfo;
import examProject.ui.answerInvitations.AnswerInvitationsPanel;
import examProject.ui.changePwd.ChangePwdFrame;
import examProject.ui.changePwd.ChangePwdPanel;
import examProject.ui.createInvitation.CreateInvitationPanel;
import examProject.ui.firstTimeSetup.FirstTimeLaunchPanel;
import examProject.ui.kronoxImport.KronoxImportPanel;
import examProject.ui.login.LoginFrame;
import examProject.ui.login.LoginPanel;
import examProject.ui.populateSessions.PopulateSessionsPanel;
import examProject.ui.print.HostsPrintPanel;
import examProject.ui.print.SessionsPrintPanel;
import examProject.ui.setUpDb.SetUpDbGui;
import examProject.ui.showInformationAboutHosts.ShowHostsInformation;
import examProject.ui.updateUserInformation.SetupIncompleteException;
import examProject.ui.updateUserInformation.UI_LoadUserInformation;

public class TabbedPane extends JFrame {
	private static final long serialVersionUID = -4337086054499823196L;
	private LoggedInUserTO currentUser;
	private BackendFacade backendFacade;

	public TabbedPane() {
		setup();
		login();
		changedPwd();
		JTabbedPane jtp = new JTabbedPane();
		try {
			backendFacade = new BackendFacade(currentUser);
			makeTabs(jtp);
		} catch (SetupIncompleteException e) {
			showSetFrames();
		}
	}
	
	private void setup() {
		OptionsFileReader ofr = new OptionsFileReader();
		try {
			ofr.readOptionFile();
		} catch (SetupIncompleteException e) {}
		DBConnectionTO dbTo = ofr.getConnTO();
		if(dbTo.isFirstTimeLaunch()) {
			showSetFrames();
		}
	}
	
	private void showSetFrames() {
		SetUpDbGui setup = new SetUpDbGui();
		JFrame frame = new JFrame("Setup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FirstTimeLaunchPanel setup2 = new FirstTimeLaunchPanel();
		frame.add(setup2);
		frame.pack();
		frame.setSize(new Dimension(400, 235));
		frame.setVisible(true);
		while (setup2.getSavedStatus()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				Thread.currentThread().interrupt();
			}
		}
		
		frame.setVisible(false);
		frame.remove(setup2);
		frame.add(setup);
		frame.pack();
		frame.setSize(new Dimension(300, 260));
		frame.setVisible(true);
		while (setup.getSavedStatus()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				Thread.currentThread().interrupt();
			}
		}
		frame.dispose();
	}
	
	private boolean changedPwd() {
		boolean result = false;
		if (currentUser.isHas_tmp_pwd()) {
			final ChangePwdFrame frame = new ChangePwdFrame();
			frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
			final ChangePwdPanel changePwdPanel = new ChangePwdPanel(backendFacade, frame);
			frame.showCPPWindow(changePwdPanel);
			while (currentUser.isHas_tmp_pwd()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				int host_id = currentUser.getHost_id();
				currentUser = new LoggedInUserTO(currentUser.getUsername(), currentUser.getUser_id(), currentUser.isIs_admin(), changePwdPanel.getChangedPwdResult());
				currentUser.setHost_id(host_id);
			}
		}
		return result;
	}

	public boolean isUserLoggedIn() {
		boolean result = false;
		if (currentUser != null)
			if (!currentUser.getUsername().equals("nouser"))
				result = true;
		return result;
	}

	private boolean login() {
		boolean result = false;
		try {
			this.backendFacade = new BackendFacade(new LoggedInUserTO("nouser",	1, true, false));
		} catch (SetupIncompleteException e) {}
		final LoginFrame modalWindow = new LoginFrame();
		final LoginPanel lp = new LoginPanel(backendFacade, modalWindow);
		modalWindow.showLoginWindow(lp);
		while (currentUser == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			currentUser = lp.getUser();
		}
		if (isUserLoggedIn()) {
			result = true;
		}
		return result;
	}

	private void makeTabs(JTabbedPane jtp) {
		getContentPane().add(jtp);
		if (currentUser.isIs_admin()) {
			jtp.addTab("Lägg till användare", new AddUserGUI(backendFacade));
			jtp.addTab("Importera", new KronoxImportPanel(backendFacade));
			jtp.addTab("Inbjudningar", new CreateInvitationPanel(backendFacade));
			jtp.addTab("Populera sessioner", new PopulateSessionsPanel(backendFacade));
			jtp.addTab("Admin redigerar info om värdar", new AdminEditHostsInfo(backendFacade));
		}
		jtp.addTab("Skriv ut", new SessionsPrintPanel(backendFacade));
		jtp.addTab("Uppdatera användare", new UI_LoadUserInformation(backendFacade));
		jtp.addTab("Svara på inbjudningar", new AnswerInvitationsPanel(backendFacade));
		jtp.addTab("Visa info om värdar", new ShowHostsInformation(backendFacade));
		jtp.addTab("Skriv ut Värdinfo", new HostsPrintPanel(backendFacade));
	}
}
