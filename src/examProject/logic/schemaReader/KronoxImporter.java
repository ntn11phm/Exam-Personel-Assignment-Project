package examProject.logic.schemaReader;

import java.util.List;

import examProject.transferObjects.ExamImportSelectionTO;
import examProject.transferObjects.ExamOccationStorer;

public class KronoxImporter {
	private String strUrl = "http://schema.hig.se/setup/jsp/SchemaICAL.ics?startDatum=idag&intervallTyp=v&intervallAntal=6&aktivitetstyp=Tentamen&sokMedAND=true&sprak=SV&resurser=";
	private URLConnectionReader ucr;
	private SchemaReader sr;
	private List<ExamOccationStorer> currentList;
	
	public KronoxImporter() {
		this.ucr = new URLConnectionReader();
	}
	
	public KronoxImporter(ExamImportSelectionTO selectionParameters) {
		KronoxStringBuilder strBuilder = new KronoxStringBuilder(selectionParameters.getPeriod_type(), selectionParameters.getPeriod_lenght());
		this.strUrl = strBuilder.getKronoxURL();
		this.ucr = new URLConnectionReader();
	}
	
	public void executeImport() {
		try {
			sr = new SchemaReader(ucr.getText(strUrl));
			sr.readURL();
			currentList = sr.getOccationList();
		}catch (Exception e) {} 
	}
	
	public List<ExamOccationStorer> getImportedData() {
		return currentList;
	}
}
