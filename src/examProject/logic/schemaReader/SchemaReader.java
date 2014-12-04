package examProject.logic.schemaReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import examProject.transferObjects.ExamOccationTO;

public class SchemaReader {
	private String dataFile = "";
	private ExamOccationTO currentOccation = new ExamOccationTO();
	private List<ExamOccationTO> occationList = new ArrayList<ExamOccationTO>();
	private List<ExamOccationTO> multiLocaionList;
	
	public SchemaReader(String dataUrl) {
		dataFile = dataUrl;
	}
	
	public void readURL() throws NullPointerException {
		Scanner fScan = new Scanner(System.in);
        try {
        	String rebuildParts = "";
            fScan = new Scanner(dataFile);
            while (fScan.hasNextLine()) {
                String row = fScan.nextLine();
                String[] parts = row.split(":");
                if (parts[0].equalsIgnoreCase("DTSTART")) {
                	dateTimeStatement(parts);
                } else if (parts[0].equalsIgnoreCase("UID"))
                	currentOccation.setBookingId(parts[1]);
                else if (parts[0].equalsIgnoreCase("LOCATION")){
                	locationStatement(parts);
                } else if (parts[0].equalsIgnoreCase("SUMMARY"))
					rebuildParts = summaryStatement(rebuildParts, parts);
				else if (parts[0].equalsIgnoreCase("END"))
					endStatement();
            }
        } catch (IndexOutOfBoundsException e) {
        	System.out.println(e +" "+ e.getCause() +" "+  e.getMessage());
        } catch (NullPointerException e) {
            throw new NullPointerException();
        } catch (Exception e) {
        	System.out.println(e +" "+ e.getCause() +" "+  e.getMessage());
        } catch (Throwable e) {
        	System.out.println(e +" "+ e.getCause() +" "+  e.getMessage());
        } finally {
        	fScan.close();
        	fScan = null;
        }
    }

	private void dateTimeStatement(String[] parts) {
		String[] subparts = parts[1].split("T");
		currentOccation.setExamDate(subparts[0]);
		if (subparts[1].startsWith("0"))
			currentOccation.setExamStartTime("08:00");
		else 
			currentOccation.setExamStartTime("15:00");
	}

	private void locationStatement(String[] parts) {
		if (parts.length==1)
			currentOccation.setExamRoom("tbd");
		else {
			String[] subParts = parts[1].split(" ");
			if (subParts.length > 1) {
				multiLocaionList = new ArrayList<ExamOccationTO>();
				for (int i = 0; i < subParts.length; i++)
					multiLocaionList.add(new ExamOccationTO(currentOccation.getExamDate(), currentOccation.getExamStartTime(), currentOccation.getBookingId(), subParts[i], currentOccation.getSummary()));
			} else
				currentOccation.setExamRoom(parts[1]);
		}
	}

	private String summaryStatement(String rebuildParts, String[] parts) {
		try {
			if (parts.length > 1) {
				for (int y = 0; y < parts.length; y++)
					if (y != 0)
						rebuildParts = rebuildParts + parts[y] + ":";
				if (multiLocaionList==null)
					currentOccation.setSummary(rebuildParts);
				else
					for (int c = 0; c < multiLocaionList.size(); c++)
						multiLocaionList.get(c).setSummary(rebuildParts);
				rebuildParts = "";
			}
		} catch (IndexOutOfBoundsException e ){}
		return rebuildParts;
	}

	private void endStatement() {
		if (multiLocaionList != null){
			for (ExamOccationTO eos : multiLocaionList)
				occationList.add(eos);
			multiLocaionList = null;
			currentOccation = new ExamOccationTO();
		} else {
			if (currentOccation.getBookingId() != null)
				occationList.add(currentOccation);
			currentOccation = new ExamOccationTO();
		}
	}
	
	public List<ExamOccationTO> getOccationList() {
		return this.occationList;
	}
}
