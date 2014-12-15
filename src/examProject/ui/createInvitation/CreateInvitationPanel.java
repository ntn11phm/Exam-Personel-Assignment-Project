package examProject.ui.createInvitation;

import javax.swing.JPanel;

import java.util.Date;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CreateInvitationPanel extends JPanel {
	private static final long serialVersionUID = -1887688398933276294L;
	private UtilDateModel dateModel = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, null);
	private JDatePicker fromDate = new JDatePickerImpl(datePanel, null);
	private JDatePicker toDate = new JDatePickerImpl(datePanel, null);
	

}
