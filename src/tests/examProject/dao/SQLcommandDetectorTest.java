package tests.examProject.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import examProject.dao.SQLcommandDetector;

public class SQLcommandDetectorTest {
	private SQLcommandDetector detector;
	String result;
	boolean containsBannedWords;
	
	@Before
	public void setUp() throws Exception {
		detector = new SQLcommandDetector();
		result = "";
		containsBannedWords = false;
	}

	@Test
	public void correctTextTest() {
		result = detector.checkString("Adam");
		containsBannedWords = detector.checkStringBool("Adam");
		assertEquals("", result);
		assertFalse(containsBannedWords);
	}
	
	@Test
	public void incorrectTextTest() {
		result = detector.checkString("update");
		containsBannedWords = detector.checkStringBool("UPDATE");
		assertEquals("UPDATE", result);
		assertTrue(containsBannedWords);
	}
	
	@Test
	public void sqlCommandSelectTest() {
		result = detector.checkString("SELECT * FROM users WHERE uid=1");
		containsBannedWords = detector.checkStringBool("SELECT * FROM users WHERE uid=1");
		assertEquals("WHERE", result);
		assertTrue(containsBannedWords);
	}
	
	@Test
	public void sqlCommandInsertTest() {
		result = detector.checkString("insert into users values ('hackerboi', 'passw')");
		containsBannedWords = detector.checkStringBool("insert into users values ('hackerboi', 'passw')");
		assertEquals("INSERT", result);
		assertTrue(containsBannedWords);
	}

}
