package examProject.logic.importSchemaData;

import java.sql.ResultSet;
import java.util.List;
import examProject.dao.DbSelect;
import examProject.dao.SelectSessionIds;
import examProject.logic.LogicStrategy;
import examProject.transferObjects.ExamOccationTO;

public class ImportSchemaData implements LogicStrategy {
	private List<ExamOccationTO> arrExams;
	private DbSelect dbSelect;
	
	public ImportSchemaData(DbSelect dbSelect, List<ExamOccationTO> arrExams) {
		this.arrExams = arrExams;
		this.dbSelect = dbSelect;
	}
	
	private void insertOrUpdateOccations() {
		ExamOccationTO currentExamOccasion;
		String selectCommand = "SELECT exam_date, exam_time, exam_location, booking_id, summary FROM examoccasions WHERE booking_id='" + arrExams.get(0).getBookingId() + "';";
		ResultSet rs = dbSelect.select(selectCommand);
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
