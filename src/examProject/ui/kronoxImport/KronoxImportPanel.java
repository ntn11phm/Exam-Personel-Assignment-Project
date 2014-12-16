package examProject.ui.kronoxImport;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import examProject.logic.BackendFacade;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KronoxImportPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbPeriod = new JComboBox<String>();
	private JComboBox<String> cbLenght = new JComboBox<String>();
	private JTextField tbDate = new JTextField();
	private JTextField tbTime = new JTextField();
	private JTextField tbLocation = new JTextField();
	private JTextField tbBookingId = new JTextField();
	private JTextArea tbSummary = new JTextArea();
	private JLabel lblLenght = new JLabel("Period längd");
	private JLabel lblPeriod = new JLabel("Period typ");
	private JButton btnGetData = new JButton("Hämta Data");
	private JScrollPane scrollPane = new JScrollPane();
	private JList<String> listExams = new JList<String>();
	private JButton btnRemove = new JButton("Ta bort vald");
	private JButton btnImport = new JButton("Importera");
	private JLabel lblStatus = new JLabel("");
	
	public KronoxImportPanel(BackendFacade backendFacade) {
		setLayout(null);
		setBounds();
		setStates();
		addCtrls();
		fillComboboxes();
		KronoxImportListener kronoxImportListener = new KronoxImportListener(this, backendFacade);
		kronoxImportListener.createListeners();
	}
	
	public KronoxImportPanel() {
		this(new BackendFacade());
	}
	
	public void updateStatusText(String text) {
		lblStatus.setText(text);
	}
	
	public String getPeriodType() {
		int selectedItem = cbPeriod.getSelectedIndex();
		return cbPeriod.getItemAt(selectedItem);
	}
	
	public String getPeriodLenght() {
		int selectedItem = cbLenght.getSelectedIndex();
		return cbLenght.getItemAt(selectedItem);
	}
	
	public JButton getDataBtn() {
		return btnGetData;
	}
	
	public JButton getRemoveBtn() {
		return btnRemove;
	}
	
	public JButton getImportBtn() {
		return btnImport;
	}
	
	public JList<String> getExamList() {
		return listExams;
	}
	
	public JTextField getDateField() {
		return tbDate;
	}
	
	public JTextField getTmeField() {
		return tbTime;
	}
	
	public JTextField getLocationField() {
		return tbLocation;
	}
	
	public JTextField getBookingIdField() {
		return tbBookingId;
	}
	
	public JTextArea getSummaryField() {
		return tbSummary;
	}
	
	private void setBounds() {
		cbPeriod.setBounds(10, 36, 150, 20);
		cbLenght.setBounds(170, 36, 150, 20);
		lblPeriod.setBounds(10, 11, 150, 14);
		lblLenght.setBounds(170, 11, 150, 14);
		btnGetData.setBounds(330, 35, 100, 23);
		scrollPane.setBounds(10, 89, 310, 400);
		listExams.setBounds(10, 89, 310, 400);
		tbDate.setBounds(330, 87, 260, 20);
		tbTime.setBounds(330, 118, 260, 20);
		tbLocation.setBounds(330, 149, 260, 20);
		tbBookingId.setBounds(330, 180, 260, 20);
		tbSummary.setBounds(330, 211, 260, 210);
		btnRemove.setBounds(330, 432, 260, 23);
		btnImport.setBounds(330, 466, 260, 23);
		lblStatus.setBounds(330, 500, 260, 14);
	}
	
	private void setStates() {
		tbDate.setEditable(false);
		tbDate.setColumns(10);
		tbTime.setEditable(false);
		tbTime.setColumns(10);
		tbLocation.setEditable(false);
		tbLocation.setColumns(10);
		tbBookingId.setEditable(false);
		tbBookingId.setColumns(10);
		tbSummary.setLineWrap(true);
		tbSummary.setEditable(false);
		tbSummary.setColumns(10);
	}
	
	private void addCtrls() {
		add(cbPeriod);
		add(cbLenght);
		add(lblPeriod);
		add(lblLenght);
		add(btnGetData);
		scrollPane.setViewportView(listExams);
		add(scrollPane);
		add(tbDate);
		add(tbTime);
		add(tbLocation);
		add(tbBookingId);
		add(tbSummary);
		add(btnRemove);
		add(btnImport);
		add(lblStatus);
	}
	
	private void fillComboboxes() {
		int max_days = 30;
		for (int i = 0; i < max_days; i++)
			cbLenght.addItem(""+(i+1));
		cbLenght.setSelectedIndex(5);
		cbPeriod.addItem("Dagar");
		cbPeriod.addItem("Veckor");
		cbPeriod.addItem("Månader");
		cbPeriod.setSelectedIndex(1);
	}
}
