package examProject.dao;

public class InsertExamOccation {
	private String strCommand = "INSERT INTO examoccations (exam_date, exam_time, exam_location, booking_id) VALUES ('";
	
	public String insertExamOccationCommand(String exam_date, String exam_time, String exam_location, String booking_id) {
		strCommand += exam_date + "', '";
		strCommand += exam_time + "', '";
		strCommand += exam_location + "', '";
		strCommand += booking_id + "');";
		return strCommand;
	}
}
