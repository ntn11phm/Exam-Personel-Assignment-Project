package examProject;

import javax.swing.JFrame;
import examProject.ui.mainFrame.TabbedPane;

public class StartUp {

	public static void main(String[] args) {
		TabbedPane tp = new TabbedPane();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setSize(1000, 1000);
		tp.setVisible(true);

	}
}
