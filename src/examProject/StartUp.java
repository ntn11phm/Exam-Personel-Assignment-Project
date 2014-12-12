package examProject;

import javax.swing.JFrame;

import examProject.ui.mainFrame.TabbedPane;
import examProject.ui.setUpDb.SetUpDbGui;

public class StartUp {

	public static void main(String[] args) {
		TabbedPane tp = new TabbedPane();
		JFrame frame = new JFrame();
		SetUpDbGui setup = new SetUpDbGui();
		if (tp.login()) {
			tp.setTitle("Main Gui");
			tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tp.setSize(1000, 1000);
			tp.setVisible(true);
			frame.setTitle("Setup GUI");
			frame.setSize(500, 500);
			frame.add(setup);
			frame.setVisible(true);
			
		}
	}
}
