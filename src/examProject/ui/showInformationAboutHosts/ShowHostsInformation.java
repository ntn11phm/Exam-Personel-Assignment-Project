package examProject.ui.showInformationAboutHosts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import examProject.logic.BackendFacade;
import examProject.ui.updateUserInformation.UI_LoadUserInformation;

	@SuppressWarnings("serial")
	public class ShowHostsInformation extends JPanel {
		
			private String	listData[] = { "Item 1", "Item 2", "Item 3", "Item 4"};
			@SuppressWarnings("unchecked")
			private	JList listbox = new JList(listData);
			private BackendFacade facade;
			private JScrollPane scrollPanel = new JScrollPane(listbox);
		    private JLabel firstNameLabel = new JLabel("Förnamn: ");
		    private JLabel lastNameLabel = new JLabel("EfterNamn: ");
		    private JLabel phoneNumberLabel = new JLabel("Telefonnummer: ");
		    private JLabel mobilNumberLabel = new JLabel("Mobilnummer: ");
		    private JLabel postLabel = new JLabel("Epost: ");

			private UI_LoadUserInformation updateUserInfo;

			
			public ShowHostsInformation(BackendFacade facade) {
				this.facade = facade;
				updateUserInfo = new UI_LoadUserInformation(facade);
				setLayout(null);
				setBounds();
				addCtrls();
				guiButtonListener();
			}
			
			private void setBounds() {
				 
				scrollPanel.setBounds(29, 27, 300, 600);
				firstNameLabel.setBounds(400, 27, 130, 25);
				lastNameLabel.setBounds(400, 52, 130, 25);
				phoneNumberLabel.setBounds(400, 77, 130, 25);
				mobilNumberLabel.setBounds(400, 102, 130, 25);
				postLabel.setBounds(400, 127, 130, 25);

				

				
			}
				private void addCtrls() {
					add(scrollPanel);
					add(firstNameLabel);
					add(lastNameLabel);
					add(phoneNumberLabel);
					add(mobilNumberLabel);
					add(postLabel);

				
				
			}
		  
			private class ButtonListener implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent event) { 

					Object source = event.getSource();
					if (source == "") {
						
							update();
						
					} else if (source == "")
						System.out.println();

				}
			}

			private void guiButtonListener() {
				
				 ListSelectionListener listSelectionListener = new ListSelectionListener() {
						@Override
						public void valueChanged(ListSelectionEvent listSelectionEvent) {
				        System.out.println("First index: " + listSelectionEvent.getFirstIndex());
				        System.out.println(", Last index: " + listSelectionEvent.getLastIndex());
				        boolean adjust = listSelectionEvent.getValueIsAdjusting();
				        System.out.println(", Adjusting? " + adjust);
				        if (!adjust) {
				              System.out.println(" Selections: ");
				        }
				      }				
				    };
				    listbox.addListSelectionListener(listSelectionListener);

				
			}

			private void update() {   
				
				
			}
			
			public void buttonClickedMethod() {

			}
			
			
			
			
			
	}

