package examProject.logic.importSchemaData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import examProject.dao.DbManipulator;
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
		String selectCommand = "SELECT exam_date, exam_time, booking_id, exam_location, summary FROM exam_occasion WHERE booking_id='"
				+ bookingId + "';";
		ResultSet rs = dbm.select(selectCommand);
		List<ExamOccationTO> dbList = new ArrayList<ExamOccationTO>();
		try {
			while (rs.next()) {
				dbList.add(new ExamOccationTO(rs.getString("exam_date"), rs.getString("exam_time"),
						rs.getString("booking_id"),	rs.getString("exam_location"), rs.getString("summary")));
			}
		} catch (SQLException e) {}
		if (dbList.size() > 0) {
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
				currentList.remove(Integer.parseInt(removeFromCurrentList.get(y).toString()));
				dbList.remove(Integer.parseInt(removeFromDbList.get(y).toString()));
			}
			if (dbList.size() > 0)
				for (int z = 0; z < dbList.size(); z++) {
					removeOccasionFromDb(dbList.get(z));
					checkMoreWithSameDateAndLocation(dbList.get(z));
				}
			if (currentList.size() > 0)
				for (int n = 0; n < currentList.size(); n++) {
					createExamOccations(currentList.get(n));
					checkIfSessionExists(currentList.get(n));
				}
		} else {
			if (currentList.size() > 0)
				for (int n = 0; n < currentList.size(); n++) {
					createExamOccations(currentList.get(n));
					checkIfSessionExists(currentList.get(n));
				}
		}
	}
	
	private void removeOccasionFromDb(ExamOccationTO currentTO) {
		int session_id = 0;
		String sqlCommand = "SELECT session_id FROM sessions WHERE session_date='" + currentTO.getExamDate() 
				+ "' AND session_time='" + currentTO.getExamStartTime() 
				+ "' AND session_location='" + currentTO.getExamRoom() + "';";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next())
				session_id = rs.getInt("session_id");
		} catch (SQLException e) {}
		sqlCommand = "DELETE FROM exam_occasion WHERE booking_id ='" + currentTO.getBookingId() 
				+ "' AND exam_time = '" + currentTO.getExamStartTime() + "' AND exam_location = '" 
				+ currentTO.getExamRoom() +"';";
		dbm.delete(sqlCommand);
		sqlCommand = "DELETE FROM host_sessions WHERE session_id=" + session_id + ";";
		dbm.delete(sqlCommand);
		sqlCommand = "DELETE FROM sessions WHERE session_id=" + session_id + ";";
		dbm.delete(sqlCommand);
	}
	
	private boolean checkMoreWithSameDateAndLocation(ExamOccationTO currentTO) {
		boolean result = false;
		boolean matchesFound = false;
		String sqlCommand = "SELECT occasion_id FROM exam_occasion WHERE exam_date ='" + currentTO.getExamDate() 
				+ "' AND exam_time = '" + currentTO.getExamStartTime() + "' AND exam_location = '" 
				+ currentTO.getExamRoom() +"';";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next()) {
				matchesFound = true;
			}
			rs.close();
		} catch (SQLException e) {}
		if (!matchesFound)
			deleteFromSessions(currentTO);
		return result;
	}
	
	private void deleteFromSessions(ExamOccationTO currentTO) {
		String sqlCommand = "DELETE FROM sessions WHERE session_location = '" + currentTO.getExamRoom() 
				+ "' AND session_date = '" + currentTO.getExamDate() + "' AND session_time ='" + currentTO.getExamStartTime() + "';";
		dbm.delete(sqlCommand);
	}
	
	private void createExamOccations(ExamOccationTO currentTO) {
		String sqlCommand = "INSERT INTO exam_occasion (exam_date, exam_time, exam_location, booking_id, summary) VALUES ('" +
			currentTO.getExamDate() + "', '" + currentTO.getExamStartTime()+ "', '"+ currentTO.getExamRoom() + "', '" 
				+ currentTO.getBookingId() + "', '" + currentTO.getSummary() + "');";
		dbm.insert(sqlCommand);
	}
	private void checkIfSessionExists(ExamOccationTO currentTO) {
		boolean matchesFound = false;
		String sqlCommand = "SELECT session_id FROM sessions WHERE session_location = '" + currentTO.getExamRoom() + "' AND session_date = '" 
				+ currentTO.getExamDate() + "' AND session_time = '" + currentTO.getExamStartTime() + "';";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next()) {
				matchesFound = true;
			}
			rs.close();
		} catch (SQLException e) {}
		if (!matchesFound)
			createNewSessions(currentTO);
	}

	private void createNewSessions(ExamOccationTO currentTO) {
		String sqlCommand = "INSERT INTO sessions (session_date, session_time, session_location) VALUES ('" 
				+ currentTO.getExamDate() + "', '" + currentTO.getExamStartTime() 
				+ "', '" + currentTO.getExamRoom() + "');";
		dbm.insert(sqlCommand);
	}

	@Override
	public boolean execute() {
		boolean result = false;
		if (arrExams != null) {
			dbm.openDb();
			validateExamOccasions();
			result = true;
			dbm.closeDb();
		}
		return result;
	}
}
