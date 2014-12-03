package examProject.ui.mainFrame;

import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import examProject.ui.addUser.AddUserGUI;
import examProject.ui.changePwd.ChangePwdPanel;

public class TabbedPane extends JFrame {

	public TabbedPane() {
		JTabbedPane jtp = new JTabbedPane();
		makeTabs(jtp);
	}

	private void makeTabs(JTabbedPane jtp) {
		getContentPane().add(jtp);
		jtp.addTab("Add User", new AddUserGUI());
		jtp.setMnemonicAt(0, KeyEvent.VK_1);
		jtp.addTab("Lösenord", new ChangePwdPanel());
		jtp.setMnemonicAt(0, KeyEvent.VK_2);

	}

	private static void createGui() {
		TabbedPane tp = new TabbedPane();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setSize(500, 500);
		// tp.pack();
		tp.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGui();

			}
		});

	}

}
