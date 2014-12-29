package examProject.ui.mainFrame;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import e.xamProject.ui.showInformationAboutHosts.ShowHostsInformation;
import examProject.logic.BackendFacade;
import examProject.logic.populateSessions.PopulateSessions;
import examProject.transferObjects.LoggedInUserTO;
import examProject.ui.addUser.AddUserGUI;
import examProject.ui.adminEditInformationAboutHosts.AdminEditHostsInfo;
import examProject.ui.answerInvitations.AnswerInvitationsPanel;
import examProject.ui.changePwd.ChangePwdPanel;
import examProject.ui.createInvitation.CreateInvitationPanel;
import examProject.ui.forgotPwd.ForgotPwdPanel;
import examProject.ui.kronoxImport.KronoxImportPanel;
import examProject.ui.populateSessions.PopulateSessionsPanel;
import examProject.ui.print.PrintPanel;
import examProject.ui.setUpDb.SetUpDbGui;
import examProject.ui.updateUserInformation.SetupIncompleteException;
import examProject.ui.updateUserInformation.UI_LoadUserInformation;

public class TabbedPane extends JFrame {
	private static final long serialVersionUID = -4337086054499823196L;
	private LoggedInUserTO currentUser;
	private BackendFacade backendFacade;

	public TabbedPane() { 
		login();
		JTabbedPane jtp = new JTabbedPane();
		try {
			backendFacade = new BackendFacade(currentUser);
			makeTabs(jtp);
		} catch (SetupIncompleteException e) {
			JPanel setup = new SetUpDbGui();
			JFrame frame = new JFrame("Setup");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(setup);
	        frame.pack();
	        frame.setVisible(true);
		}
	}
	
	public boolean login() {
		boolean result = false;
		currentUser = new LoggedInUserTO("", 6, true, false);
		currentUser.setHost_id(4);
		result = true;
		return result;
	}

	private void makeTabs(JTabbedPane jtp) {
		getContentPane().add(jtp);
		jtp.addTab("Lägg till användare", new AddUserGUI(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_1);
		jtp.addTab("Begär nytt Lösenord", new ChangePwdPanel(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_2);
		jtp.addTab("Glömt Lösenord", new ForgotPwdPanel(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_3);
		jtp.addTab("Uppdatera användare", new UI_LoadUserInformation(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_4);
		jtp.addTab("Importera", new KronoxImportPanel(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_5);
		jtp.addTab("DB Setup", new SetUpDbGui());
		jtp.setMnemonicAt(0, KeyEvent.VK_6);
		jtp.addTab("Inbjudningar", new CreateInvitationPanel(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_7);
		jtp.addTab("Svara på inbjudningar", new AnswerInvitationsPanel(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_8);
		jtp.addTab("Populera sessioner", new PopulateSessionsPanel(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_9);
		jtp.addTab("Skriv ut", new PrintPanel(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_A);
		jtp.addTab("Admin redigerar info om värdar", new AdminEditHostsInfo(backendFacade));
		jtp.setMnemonicAt(0, KeyEvent.VK_B);
		jtp.addTab("Visa info om värdar", new ShowHostsInformation(backendFacade));		
		jtp.setMnemonicAt(0, KeyEvent.VK_0);

	}

}
