package examProject.ui.changePwd;

import java.awt.Dimension;
import javax.swing.JFrame;

public class ChangePwdFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public void showCPPWindow(ChangePwdPanel cpp) {
		setSize(new Dimension(250, 300));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setContentPane(cpp);
        setVisible(true);
	}
}
