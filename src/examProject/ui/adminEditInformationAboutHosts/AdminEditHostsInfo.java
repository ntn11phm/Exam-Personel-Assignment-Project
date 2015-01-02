package examProject.ui.adminEditInformationAboutHosts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import examProject.logic.BackendFacade;
import examProject.ui.updateUserInformation.UI_LoadUserInformation;

public class AdminEditHostsInfo extends JPanel {
	
	private static final long serialVersionUID = 1L;
		private String	listData[] = { "Item 1", "Item 2", "Item 3", "Item 4"};
		private	JList<Object> listbox = new JList<Object>(listData);
		private BackendFacade facade;
	    JScrollPane scrollPanel = new JScrollPane(listbox);


		private UI_LoadUserInformation updateUserInfo;

		
		public AdminEditHostsInfo(BackendFacade facade) {
			this.facade = facade;
			updateUserInfo = new UI_LoadUserInformation(facade);
			setLayout(null);
			setBounds();
			addCtrls();
			guiButtonListener();
		}
		
		private void setBounds() {
			 
			scrollPanel.setBounds(29, 27, 300, 600);
			updateUserInfo.setBounds(400, 27, 600, 600);

			
		}
			private void addCtrls() {
				this.add(scrollPanel);
				this.add(updateUserInfo);			
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
		
		public String selectedItem(){
			return "";
			
		}
		
		

		private void update() {   
			
			
		}
		
		public void buttonClickedMethod() {

		}
		
		
		
		
		
}
