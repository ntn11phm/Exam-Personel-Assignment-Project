package examProject;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class StartUp {

	public static void main(String[] args) {
		// Frame mainFrame = new Frame();
		JFrame GuiMainFrame = new JFrame();
		GuiMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		String titles[] = { "General", "Security", "Content", "Connection",
				"Programs", "Advanced" };
//		for (int i = 0, n = titles.length; i < n; i++) {
//			add(tabbedPane, titles[i]);
//		}

		GuiMainFrame.add(tabbedPane, BorderLayout.CENTER);
		GuiMainFrame.setSize(400, 150);
		GuiMainFrame.setVisible(true);
	}
}
