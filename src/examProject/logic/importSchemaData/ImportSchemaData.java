package examProject.logic.importSchemaData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.dao.InsertExamOccation;
import examProject.dao.SelectSessionIds;
import examProject.logic.LogicStrategy;
import examProject.transferObjects.ExamOccationTO;

public class ImportSchemaData implements LogicStrategy {
	private List<ExamOccationTO> arrExams;
	private DbManipulator dbm;
	private int rowsFound = 0;

	public ImportSchemaData(DbManipulator dbm,  List<ExamOccationTO> arrExams) {
		this.arrExams = arrExams;
		this.dbm = dbm;
	}

	private void insertOrUpdateOccations(ExamOccationTO currentExamOccasion) {
		ExamOccationTO tmpExamOccasion;
		boolean foundMatch = false;
		boolean result = false;
		rowsFound = 0;
		String selectCommand = "SELECT exam_date, exam_time, booking_id, exam_location, summary FROM examoccasions WHERE booking_id='"
				+ currentExamOccasion.getBookingId() + "';";
		ResultSet rs = dbm.select(selectCommand);
		try {
			while (rs.next()) {
				tmpExamOccasion = new ExamOccationTO(rs.getString(0),
						rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4));
				if (currentExamOccasion.getExamRoom().equals(
						tmpExamOccasion.getExamRoom()))
					foundMatch = true;
			}
			rs.close();
			if (!foundMatch) {
				InsertExamOccation insertCommand = new InsertExamOccation();
				result = dbm.insert(insertCommand.insertExamOccationCommand(currentExamOccasion));
			}
		} catch (SQLException e) {
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
			// insertOrUpdateOccations();
			createSessions();

		}
		return result;
	}

}
