package examProject.logic.importSchemaData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import examProject.dao.DbManipulator;
import examProject.dao.SelectSessionIds;
import examProject.logic.LogicStrategy;
import examProject.transferObjects.ExamOccationTO;

public class ImportSchemaData implements LogicStrategy {
	private List<ExamOccationTO> arrExams;
	private DbManipulator dbm;

	public ImportSchemaData(DbManipulator dbm,  List<ExamOccationTO> arrExams) {
		this.arrExams = arrExams;
		this.dbm = dbm;
	}
	
	private void validateExamOccasions() {
		CreateSubList createSubList = new CreateSubList();
		String bookingId = "";
		List<ExamOccationTO> subList = new ArrayList<ExamOccationTO>();
		for (ExamOccationTO currentTO : arrExams) {
			bookingId = currentTO.getBookingId();
			subList = createSubList.extractSubList(bookingId, arrExams);
			getStoredOccasions(bookingId, subList);
		}
		
	}
	
	private void getStoredOccasions(String bookingId, List<ExamOccationTO> subList) {
		List<ExamOccationTO> currentList = subList;
		String selectCommand = "SELECT exam_date, exam_time, booking_id, exam_location, summary FROM examoccasions WHERE booking_id='"
				+ bookingId + "';";
		ResultSet rs = dbm.select(selectCommand);
		List<ExamOccationTO> dbList = new ArrayList<ExamOccationTO>();
		try {
			while (rs.next()) {
				dbList.add(new ExamOccationTO(rs.getString("exam_date"), rs.getString("exam_time"), rs.getString("booking_id"),
						rs.getString("exam_location"), rs.getString("summary")));
			}
		} catch (SQLException e) {}
		if (dbList.size()>0) {
			List<Integer> removeFromDbList = new ArrayList<Integer>();
			List<Integer> removeFromCurrentList = new ArrayList<Integer>();
			for (int i = 0; i < dbList.size(); i++) 
				for (int x = 0; x < currentList.size(); x++)
					if (currentList.get(x).getExamRoom().equals(dbList.get(i).getExamRoom())) {
						removeFromDbList.add(i);
						removeFromCurrentList.add(x);
					}
			Collections.sort(removeFromCurrentList, Collections.reverseOrder());
			Collections.sort(removeFromDbList, Collections.reverseOrder());
			for (int y = 0; y < removeFromCurrentList.size(); y++) {
				currentList.remove(removeFromCurrentList.get(y));
				dbList.remove(removeFromDbList.get(y));
			}
			if (currentList.size() > 0) {
				//insert into examoccasions
				// if (check if same date and location in sessions != true)
				// insert into sessions
			}
			if (dbList.size() > 0) {
				// if (check if more with same date and location in examoccasions = true) 
				// remove from examoccasions
				// else
				// remove from sessions and examoccasions
			}
		} else {
			
		}
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
		if (arrExams != null) {
			validateExamOccasions();
			// insertOrUpdateOccations();
			createSessions();

		}
		return result;
	}

}
