package examProject.dao;

import examProject.transferObjects.ExamOccationTO;

public class InsertExamOccation {
	private String strCommand = "INSERT INTO examoccations (exam_date, exam_time, exam_location, booking_id, summary) VALUES ('";

	public String insertExamOccationCommand(String exam_date, String exam_time,	String exam_location, String booking_id, String summary) {
			strCommand += exam_date 	+ "', '" 
					+ exam_time 		+ "', '" 
					+ exam_location		+ "', '" 
					+ booking_id 		+ "', '" 
					+ summary 			+ "');";
		return strCommand;
	}

	public String insertExamOccationCommand(ExamOccationTO currentTO) {
		return insertExamOccationCommand(currentTO.getExamDate(),
				currentTO.getExamStartTime(), currentTO.getExamRoom(),
				currentTO.getBookingId(), currentTO.getSummary());
	}
}
