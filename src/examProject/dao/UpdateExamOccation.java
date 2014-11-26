package examProject.dao;

public class UpdateExamOccation {
	private String strCommand = "UPDATE examoccations SET(exam_date='";
	
	public String updateExamOccationCommand(String exam_date, String exam_time, String exam_location, String booking_id) {
		strCommand += exam_date + "', exam_time='";
		strCommand += exam_time + "', exam_location='";
		strCommand += exam_location + "' WHERE booking_id='";
		strCommand += booking_id + "');";
		return strCommand;
	}
}
