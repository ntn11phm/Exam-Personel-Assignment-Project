package examProject.ui.mainFrame;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import examProject.ui.addUser.AddUserGUI;
import examProject.ui.changePwd.ChangePwdPanel;
import examProject.ui.forgotPwd.ForgotPwdPanel;
import examProject.ui.updateUserInformation.UI_LoadUserInformation;

public class TabbedPane extends JFrame {
	private static final long serialVersionUID = -4337086054499823196L;

	public TabbedPane() {
		JTabbedPane jtp = new JTabbedPane();
		makeTabs(jtp);
	}

	private void makeTabs(JTabbedPane jtp) {
		getContentPane().add(jtp);
		jtp.addTab("Lägg till användare", new AddUserGUI());
		jtp.setMnemonicAt(0, KeyEvent.VK_1);
		jtp.addTab("Begär nytt Lösenord", new ChangePwdPanel());
		jtp.setMnemonicAt(0, KeyEvent.VK_2);
		jtp.addTab("Glömt Lösenord", new ForgotPwdPanel());
		jtp.setMnemonicAt(0, KeyEvent.VK_3);
		jtp.addTab("Uppdatera användare", new UI_LoadUserInformation());
		jtp.setMnemonicAt(0, KeyEvent.VK_4);

	}

}
