package examProject.ui.answerInvitations;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import examProject.transferObjects.HsiTO;

public class DisplayInvitationsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private List<HsiTO> hsiList;
	
	public DisplayInvitationsPanel(List<HsiTO> hsiList) {
		setLayout(null);
		this.hsiList = hsiList;
		createCtrls();
	}
	
	private void createCtrls() {
		int xPos = 5;
		int yPos = 0;
		int componentSizeX = 100;
		int componentSizeY = 25;
		int componentSpacing = 5;
		JLabel lblTmp;
		JCheckBox cbTmp;
		for (int i = 0; i < hsiList.size(); i++) {
			yPos += componentSpacing;
			lblTmp = new JLabel(hsiList.get(i).getDate());
			lblTmp.setName(hsiList.get(i).getDate() + "_" + hsiList.get(i).getTime());
			lblTmp.setBounds(xPos, yPos, componentSizeX, componentSizeY);
			add(lblTmp);
			cbTmp = new JCheckBox(hsiList.get(i).getTime());
			cbTmp.setSelected(hsiList.get(i).getAnswer());
			cbTmp.setName(hsiList.get(i).getTime() + "_" + hsiList.get(i).getDate());
			cbTmp.setBounds((xPos + componentSizeX + componentSpacing), yPos, componentSizeX, componentSizeY);
			add(cbTmp);
			yPos += componentSizeY;
		}
	}
	
	public JPanel getPanel() {
		return this;
	}
}
