package examProject.ui.firstTimeSetup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstTimeLaunchListener {
	private FirstTimeLaunchPanel panel;
	
	public FirstTimeLaunchListener(FirstTimeLaunchPanel panel) {
		this.panel = panel;
	}
	
	public void createButtonListeners() {
		panel.getStoreButton().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {store();}});
	}
	
	private void store() {
		boolean result = false;
		if (panel.getUsername().equals(""))
			panel.setStatusText("Fyll i användarnamnet!");
		else if (panel.getPwd().equals(""))
			panel.setStatusText("Fyll i lösenordet!");
		else {
			FirstTimeLaunchLogic logic = new FirstTimeLaunchLogic();
			result = logic.save(panel.getUsername(), panel.getPwd());
			if (result)
				panel.setStatusText("Data sparat till fil!");
			else
				panel.setStatusText("Något gick fel vid sparningnen!");
		}
	}
}
