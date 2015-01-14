package examProject.ui.showInformationAboutHosts;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import examProject.dao.DbManipulator;
import examProject.logic.BackendFacade;
import examProject.transferObjects.DBConnectionTO;
import examProject.transferObjects.ShowHostsInfoTransfere;

	@SuppressWarnings("serial")
	public class ShowHostsInformation extends JPanel {
		
			private String	listData[] = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
			private String sqlKommand = "SELECT host_id FORM hosts;";
			@SuppressWarnings("unchecked")
			private	JList listbox = new JList(listData);
			private BackendFacade backendFacade;
			private JScrollPane scrollPanel = new JScrollPane(listbox);
		    private JLabel firstNameLabel = new JLabel("Förnamn: ");
		    private JLabel lastNameLabel = new JLabel("EfterNamn: ");
		    private JLabel phoneNumberLabel = new JLabel("Telefonnummer: ");
		    private JLabel mobilNumberLabel = new JLabel("Mobilnummer: ");
		    private JLabel postLabel = new JLabel("Epost: ");
		    
		    private JLabel showFirstNameLabel = new JLabel("hh");
		    private JLabel showLastNameLabel = new JLabel("hh");
		    private JLabel showPhoneNumberLabel = new JLabel("hh");
		    private JLabel showMobilNumberLabel = new JLabel("hh");
		    private JLabel showPostLabel = new JLabel("hh");
		    
		    DBConnectionTO dbConnectionTo = null;
			DbManipulator dbManipulator = new DbManipulator(dbConnectionTo);
			
			public ShowHostsInformation(BackendFacade backendFacade) {
				this.backendFacade = backendFacade;
				setLayout(null);
				setBounds();
				addCtrls();
				guiButtonListener();
				loadTextFields();
			}
			
			private void loadTextFields() {
			}

			private void setBounds() {
				scrollPanel.setBounds(29, 27, 300, 600);
				firstNameLabel.setBounds(400, 27, 130, 25);
				showFirstNameLabel.setBounds(550, 27, 130, 25);
				lastNameLabel.setBounds(400, 52, 130, 25);
				showLastNameLabel.setBounds(550, 52, 130, 25);
				phoneNumberLabel.setBounds(400, 77, 130, 25);
				showPhoneNumberLabel.setBounds(550, 77, 130, 25);		
				mobilNumberLabel.setBounds(400, 102, 130, 25);
				showMobilNumberLabel.setBounds(550, 102, 130, 25);
				postLabel.setBounds(400, 127, 130, 25);			
				showPostLabel.setBounds(550, 127, 130, 25);
			}
				private void addCtrls() {
					add(scrollPanel);
					add(firstNameLabel);
					add(showFirstNameLabel);
					add(lastNameLabel);
					add(showLastNameLabel);
					add(phoneNumberLabel);
					add(showPhoneNumberLabel);
					add(mobilNumberLabel);
					add(showMobilNumberLabel);
					add(postLabel);				
					add(showPostLabel);
			}

			private void guiButtonListener() {
				
				 ListSelectionListener listSelectionListener = new ListSelectionListener() {
						@Override
						public void valueChanged(ListSelectionEvent listSelectionEvent) {
						        boolean adjust = listSelectionEvent.getValueIsAdjusting();
				        if (!adjust) {
				              ShowHostsInfoTransfere showHostsInfo= new ShowHostsInfoTransfere("SELECT frist_name FROM hosts;", "SELECT lastst_name FROM hosts;");
				        }
				        else
				        	showInfo();
				      }				
				    };
				    listbox.addListSelectionListener(listSelectionListener);
			}

			private void showInfo(){   
				ShowHostsInfoTransfere showHostInfo = new ShowHostsInfoTransfere(listData[0], listData[1]);
					backendFacade.showHostsInfo(showHostInfo);
				
			}
			
			public void buttonClickedMethod() {
			}			
	}