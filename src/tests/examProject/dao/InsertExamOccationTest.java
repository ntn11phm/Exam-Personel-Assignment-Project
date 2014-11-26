package tests.examProject.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import examProject.dao.InsertExamOccation;

public class InsertExamOccationTest {
	private InsertExamOccation insertEO;
	private String insertCommand;
	
	@Before
	public void setUp() throws Exception {
		insertEO = new InsertExamOccation();
		insertCommand = "";
	}

	@Test
	public void blankInsertTest() {
		insertCommand = insertEO.insertExamOccationCommand("", "", "", "");
		assertEquals("INSERT INTO examoccations (exam_date, exam_time, exam_location, booking_id) VALUES ('', '', '', '');", insertCommand);
	}
	
	@Test
	public void insertTest() {
		insertCommand = insertEO.insertExamOccationCommand("20150112", "08:00", "99613", "BokningsId_20140616_000000139");
		assertEquals("INSERT INTO examoccations (exam_date, exam_time, exam_location, booking_id) VALUES ('20150112', '08:00', '99613', 'BokningsId_20140616_000000139');", insertCommand);
	}
}
