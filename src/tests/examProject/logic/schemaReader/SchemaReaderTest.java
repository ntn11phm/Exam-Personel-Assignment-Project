package tests.examProject.logic.schemaReader;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import examProject.logic.schemaReader.SchemaReader;

public class SchemaReaderTest {
	private SchemaReader sr;
	private File fileData = new File("C:/Users/Pelle/Dropbox/Databas_projekt/SchemaICAL.ics");

	@Before
	public void setUp() throws Exception {
		this.sr = new SchemaReader(fileData.toString());
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void faultyFileNameTest() throws Exception {
		exception.expect(Exception.class);
		fileData = new File("C:/user/fil.txt");
		this.sr = new SchemaReader(fileData.toString());
		sr.readURL();
		assertEquals(null, sr.getOccationList());
	}

}
