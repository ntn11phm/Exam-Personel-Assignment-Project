package examProject;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import examProject.ui.mainFrame.TabbedPane;

public class StartUp {

	public static void main(String[] args) {
		// Frame mainFrame = new Frame();
		TabbedPane tp = new TabbedPane();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setSize(500, 500);
		// tp.pack();
		tp.setVisible(true);

	}
}