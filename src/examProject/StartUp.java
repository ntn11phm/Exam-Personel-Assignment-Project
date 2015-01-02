package examProject;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import examProject.ui.mainFrame.TabbedPane;

public class StartUp {
	private static TabbedPane tp;

	public static void main(String[] args) {
		
		  SwingUtilities.invokeLater(new Runnable()
		    {
		        @Override
		        public void run()
		        {
		        	tp = new TabbedPane();
		    		while (!tp.isUserLoggedIn()) {
		    			
		    		}
		        }
		    });
		
		if (tp.isUserLoggedIn()) {
			tp.setTitle("Main Gui");
			tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tp.setSize(1400, 1000);
			tp.repaint();
			tp.setVisible(true);
		}
	}
}