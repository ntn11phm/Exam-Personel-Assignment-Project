package examProject.dao;

import examProject.transferObjects.ExamOccationTO;

public class SelectSessionIds {

	public String buildSqlCommand(ExamOccationTO currentTO) {
		String selectCommand = "SELECT session_id FROM sessions WHERE exam_date='";
		selectCommand += currentTO.getExamDate() + "' AND room='" + currentTO.getExamRoom() + "';";
		return selectCommand;
	}
}
