package examProject;

import javax.swing.JFrame;

import examProject.ui.mainFrame.TabbedPane;

public class StartUp {

	public static void main(String[] args) {
		TabbedPane tp = new TabbedPane();
		if (tp.login()) {
			tp.setTitle("Main Gui");
			tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tp.setSize(1000, 1000);
			tp.setVisible(true);
		}
	}
}

//select session_date, session_time from sessions where session_date between '20141220' and '20150117'
//group by session_date, session_time;

//select host_id from hosts where is_active = true;
