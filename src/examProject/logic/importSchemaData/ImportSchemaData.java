package examProject.logic.importSchemaData;

import java.util.List;

import examProject.dao.SelectSessionIds;
import examProject.logic.LogicStrategy;
import examProject.transferObjects.ExamOccationTO;

public class ImportSchemaData implements LogicStrategy {
	private List<ExamOccationTO> arrExams;
	
	public ImportSchemaData(List<ExamOccationTO> arrExams) {
		this.arrExams = arrExams;
	}
	
	private void insertOrUpdateOccations() {
		
	}
	
	private void createSessions() {
		SelectSessionIds sqlCommand = new SelectSessionIds(); 
		for (int i = 0; i < arrExams.size(); i++) {
			sqlCommand.buildSqlCommand(arrExams.get(i));
		}
	}

	@Override
	public boolean execute() {
		boolean result = false;
		if (arrExams!=null) {
			insertOrUpdateOccations();
			createSessions();
			
		}
		return result;
	}

}
