package examProject.ui.login;

import java.awt.Dimension;
import javax.swing.JFrame;

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public LoginFrame() {
		
    }
	
	public void showLoginWindow(LoginPanel lp) {
		setSize(new Dimension(250, 300));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setContentPane(lp);
        setVisible(true);
	}
}