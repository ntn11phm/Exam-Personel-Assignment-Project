package examProject.logic.schemaReader;

import java.io.FileNotFoundException;
import java.util.List;

public class KronoxImporter {
	private String strUrl = "http://schema.hig.se/setup/jsp/SchemaICAL.ics?startDatum=idag&intervallTyp=v&intervallAntal=6&aktivitetstyp=Tentamen&sokMedAND=true&sprak=SV&resurser=";
	private URLConnectionReader ucr;
	private SchemaReader sr;
	
	public KronoxImporter() {
		this.ucr = new URLConnectionReader();
	}
	
	public KronoxImporter(String strUrl) {
		this.strUrl = strUrl;
		this.ucr = new URLConnectionReader();
	}
	
	public void executeImport() {
		try {
			sr = new SchemaReader(ucr.getText(strUrl));
			sr.readURL();
			List<ExamOccationStorer> currentList = sr.getOccationList();
			for (int i = 0; i < currentList.size(); i++)
				System.out.println("Row " + i + " " + currentList.get(i).toString());
		
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		}catch (Exception e) {
		} 
	}
	
}
