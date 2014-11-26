package tests.examProject.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import examProject.dao.UpdateExamOccation;

public class UpdateExamOccationTest {
	private UpdateExamOccation ueo;
	private String updateCommand;
	
	@Before
	public void setUp() throws Exception {
		ueo = new UpdateExamOccation();
		updateCommand = "";
	}

	@Test
	public void blankUpdateTest() {
		updateCommand = ueo.updateExamOccationCommand("", "", "", "");
		assertEquals("UPDATE examoccations SET(exam_date='', exam_time='', exam_location='' WHERE booking_id='');", updateCommand);
	}
	
	@Test
	public void updateTest() {
		updateCommand = ueo.updateExamOccationCommand("20150112", "08:00", "99613", "BokningsId_20140616_000000139");
		assertEquals("UPDATE examoccations SET(exam_date='20150112', exam_time='08:00', exam_location='99613' WHERE booking_id='BokningsId_20140616_000000139');", updateCommand);
	}
}
