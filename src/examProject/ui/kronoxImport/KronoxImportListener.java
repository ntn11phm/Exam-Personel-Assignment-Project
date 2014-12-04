package examProject.ui.kronoxImport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import examProject.transferObjects.ExamImportSelectionTO;
import examProject.transferObjects.ExamOccationStorer;
import javax.swing.JList;
import examProject.logic.BackendFacade;

public class KronoxImportListener {
	private KronoxImportPanel kronoxImportPanel;
	private BackendFacade backendFacade;
	private List<ExamOccationStorer> arrExamOccations;
	
	public KronoxImportListener(KronoxImportPanel kronoxImportPanel, BackendFacade backendFacade) {
		this.kronoxImportPanel = kronoxImportPanel;
		this.backendFacade = backendFacade;
	}
	
	public void createListeners() {
		kronoxImportPanel.getDataBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {readDataFromKronox();}});
		kronoxImportPanel.getRemoveBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {removePostFromList();}});
		kronoxImportPanel.getImportBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {importPostsFromList();}});
		kronoxImportPanel.getExamList().addKeyListener(new KeyAdapter() {public void keyReleased(KeyEvent e) {loadSelectedPost();}});
		kronoxImportPanel.getExamList().addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent mouseEvent) {listClick(mouseEvent);}});
	}
	
	private void loadSelectedPost(){
		loadSelectedPostRow(kronoxImportPanel.getExamList().getSelectedIndex());
	}
	
	private void listClick(MouseEvent mouseEvent) {
		JList<String> tmpList = kronoxImportPanel.getExamList();
		tmpList = (JList<String>) mouseEvent.getSource();
		if (mouseEvent.getClickCount() > 0) {
			int index = kronoxImportPanel.getExamList().locationToIndex(mouseEvent.getPoint());
			loadSelectedPostRow(index);
		}
	}
	
	private void loadSelectedPostRow(int index) {
		try {
			ExamOccationStorer eo = arrExamOccations.get(index);
			kronoxImportPanel.getDateField().setText(eo.getExamDate());
			kronoxImportPanel.getTmeField().setText(eo.getExamStartTime());
			kronoxImportPanel.getLocationField().setText(eo.getExamRoom());
			kronoxImportPanel.getBookingIdField().setText(eo.getBookingId());
			kronoxImportPanel.getSummaryField().setText(eo.getSummary());
		} catch (Exception e){}
	}
	
	private void loadList() {
		String [] arrString = new String[arrExamOccations.size()];
		for (int i = 0; i < arrExamOccations.size(); i++) {
			arrString[i] = arrExamOccations.get(i).toString();
		}
		kronoxImportPanel.getExamList().setListData(arrString);
	}
	
	private void readDataFromKronox() {
		String type = "";
		if (kronoxImportPanel.getPeriodType().toLowerCase().equals("veckor"))
			type = "v";
		else if (kronoxImportPanel.getPeriodType().toLowerCase().equals("månader"))
			type = "m";
		else
			type = "d";
		arrExamOccations = backendFacade.readSchemaFromKronox(new ExamImportSelectionTO(type, kronoxImportPanel.getPeriodLenght()));
		loadList();
	}
	
	private void removePostFromList() {
		
	}
	
	private void importPostsFromList() {
		
	}
}
