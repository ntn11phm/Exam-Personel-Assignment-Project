package examProject.logic;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import examProject.transferObjects.DBConnectionTO;

public class OptionsFileReader {
	private DBConnectionTO dbConnectionTO;
	
	public DBConnectionTO getConnTO() {
		return dbConnectionTO;
	}

	@SuppressWarnings({ "resource", "null" })
	public void readOptionFile() throws NullPointerException {
			
				Scanner scan = new Scanner(System.in);
				try {
					File openedFile = new File("Options.txt");
					scan = new Scanner(openedFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				DBConnectionTO c = new DBConnectionTO();
				
				try {
					while (scan.hasNextLine()) {
						String line = scan.nextLine();
						if (line.startsWith("username")){
							c.setUsernames(line);
						}
						else if (line.startsWith("databaseDriver")){
							c.setDatabaseDriver(line);
						}
						else if(line.startsWith("databasePath")){
							c.setDatabasePath(line);
						}
						else if(line.startsWith("databasePort")){
							c.setDatabasePort(line);
						}
						else if (line.startsWith("databaseName")){
							c.setDatabaseName(line);
						}
						else if (line.startsWith("mailServerPath")){
							c.setMailServerPath(line);
						}
						else if(line.startsWith("firstTimeLaunch")){
							c.setFirstTimeLaunch(true);
						}
				}					
					dbConnectionTO = c;
					scan.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		}




// gammal kod att läsa till filen OptionsReaderFile
/*
public class OptionsFileReader {

@SuppressWarnings("resource")
public void readOptionFile() throws NullPointerException {

	try {
		Scanner scan = new Scanner(System.in);
		File openedFile = new File("Options.txt");
		scan = new Scanner(openedFile);

		try {
			File saveFileTo = new File("OptionsFileReader.txt");

			if (!saveFileTo.exists()) {
				saveFileTo.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(saveFileTo.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scan.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
}
}*/