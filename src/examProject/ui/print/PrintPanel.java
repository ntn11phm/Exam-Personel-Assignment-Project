package examProject.ui.print;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PrintPanel extends JPanel {
	private static final long serialVersionUID = -3121763534904494306L;
	private JScrollPane listPane = new JScrollPane();
	private JList<String> sessionsList = new JList<String>();
	private JLabel dateLabel = new JLabel("Välj datum");
	private JTextField dateField = new JTextField();
	private JButton printButton = new JButton("Skriv ut");

	public PrintPanel() {
		setLayout(null);
		setBounds();
		addCtrls();
		
	}
	private void setBounds(){
		listPane.setBounds(23, 82, 130, 156);
		dateLabel.setBounds(23, 11, 130, 29);
		dateField.setBounds(23, 42, 130, 29);
		printButton.setBounds(23, 268, 130, 29);
	}
	private void addCtrls(){
		add(listPane);
		add(dateLabel);
		add(dateField);
		add(printButton);
	}
	

}
