package examProject.ui.exportSessions;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import examProject.logic.BackendFacade;

import javax.swing.JScrollPane;

public class ExportSessionsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField tbPath = new JTextField();
	private JTextField tbFromDate = new JTextField();
	private JTextField tbToDate = new JTextField();
	private JLabel lblPath = new JLabel("Sökväg:");
	private JLabel lblFromDate = new JLabel("Datum från:");
	private JLabel lblToDate = new JLabel("Datum till:");
	private JLabel lblDescr = new JLabel("Sätt datum och få alla tentamenstillfällen inom perioden exporterade till en .csv fil.");
	private JLabel lblStatus = new JLabel();
	private JButton btnExport = new JButton("Exportera!");
	private JButton btnSetPath = new JButton("Välj sökväg");
	private JButton btnLoadPeriod = new JButton("Ladda period");
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel innerPanel = new JPanel();
	private JTextArea outputArea = new JTextArea();
	
	public ExportSessionsPanel(BackendFacade backendFacade) {
		setLayout(null);
		setBounds();
		addCtrls();
		ExportSessionsListener es = new ExportSessionsListener(backendFacade, this);
		es.createButtonListeners();
	}
	
	private void addCtrls() {
		add(lblDescr);
		add(lblFromDate);
		add(lblToDate);
		tbFromDate.setToolTipText("Datumformat: yyyy-MM-dd");
		add(tbFromDate);
		tbToDate.setToolTipText("Datumformat: yyyy-MM-dd");
		add(tbToDate);
		add(lblPath);
		add(tbPath);
		tbPath.setEditable(false);
		add(btnExport);
		add(lblStatus);
		add(btnSetPath);
		add(btnLoadPeriod);
		outputArea.setEditable(false);
		outputArea.setColumns(150);
		innerPanel.add(outputArea);
		scrollPane.setViewportView(innerPanel);
		add(scrollPane);
	}

	private void setBounds() {
		lblDescr.setBounds(10, 10, 480, 20);
		lblFromDate.setBounds(10, 41, 150, 20);
		lblToDate.setBounds(170, 41, 150, 20);
		tbFromDate.setBounds(10, 72, 150, 25);
		tbToDate.setBounds(170, 72, 150, 25);
		lblPath.setBounds(10, 108, 150, 20);
		tbPath.setBounds(10, 139, 480, 25);
		btnExport.setBounds(10, 175, 150, 25);
		lblStatus.setBounds(170, 175, 320, 25);
		btnSetPath.setBounds(170, 108, 150, 23);
		btnLoadPeriod.setBounds(330, 73, 160, 23);
		scrollPane.setBounds(10, 211, 480, 353);
	}

	public JTextField getTbPath() {
		return tbPath;
	}

	public JTextField getTbFromDate() {
		return tbFromDate;
	}

	public JTextField getTbToDate() {
		return tbToDate;
	}

	public JLabel getLblToDate() {
		return lblToDate;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}

	public JButton getBtnExport() {
		return btnExport;
	}
	
	public JButton getBtnSetPath() {
		return btnSetPath;
	}
	
	public JButton getBtnLoadPeriod() {
		return btnLoadPeriod;
	}
	
	public JTextArea getOutputArea() {
		return outputArea;
	}
	
	public void setOutputArea(JTextArea outputArea) {
		this.outputArea = outputArea;
	}
}
