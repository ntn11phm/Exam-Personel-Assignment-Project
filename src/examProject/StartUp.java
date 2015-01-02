package examProject;

import javax.swing.JFrame;

import examProject.ui.mainFrame.TabbedPane;

public class StartUp {

	public static void main(String[] args) {
		TabbedPane tp = new TabbedPane();
		while (!tp.isUserLoggedIn()) {
			
		}
		if (tp.isUserLoggedIn()) {
			tp.setTitle("Main Gui");
			tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tp.setSize(1400, 1000);
			tp.repaint();
			tp.setVisible(true);
		}
	}
}