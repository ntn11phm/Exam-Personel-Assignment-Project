package examProject.ui.kronoxImport;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import examProject.logic.BackendFacade;

public class KronoxImportPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbPeriod = new JComboBox<String>();
	private JComboBox<String> cbLenght = new JComboBox<String>();
	
	public KronoxImportPanel(BackendFacade backendFacade) {
		setLayout(null);
		setBounds();
		addCtrls();
		fillComboboxes();
	}
	
	public KronoxImportPanel() {
		this(new BackendFacade());
	}
	
	private void setBounds() {
		cbPeriod.setBounds(10, 10, 120, 20);
		cbLenght.setBounds(10, 50, 120, 20);
	}
	
	private void addCtrls() {
		add(cbPeriod);
		add(cbLenght);
	}
	
	private void fillComboboxes() {
		int max_days = 30;
		for (int i = 0; i < max_days; i++)
			cbLenght.addItem(""+(i+1));
		cbPeriod.addItem("Dagar");
		cbPeriod.addItem("Veckor");
		cbPeriod.addItem("Månader");
	}
}
