package examProject.logic;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

import examProject.transferObjects.DBConnectionTO;
import examProject.ui.updateUserInformation.SetupIncompleteException;

public class OptionsFileReader {
	private DBConnectionTO dbConnectionTO;

	public DBConnectionTO getConnTO() {
		return dbConnectionTO;
	}

	@SuppressWarnings({ "resource", "null" })
	public void readOptionFile() throws SetupIncompleteException {

		Scanner scan = new Scanner(System.in);
		try {
			File openedFile = new File("Options.txt");
			scan = new Scanner(openedFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		DBConnectionTO dbConnection = new DBConnectionTO();

		try {
			while (scan.hasNextLine()) {
				String[] split = new String[2];
				String line = scan.nextLine();
				split = line.split("=");
					if (split.length != 2)
						throw new SetupIncompleteException();
					else {
					if (split[0].equalsIgnoreCase("username")) {
						dbConnection.setUsernames(split[1]);
					} else if (split[0].equalsIgnoreCase("databaseDriver")) {
						dbConnection.setDatabaseDriver(split[1]);
					} else if (split[0].equalsIgnoreCase("databasePath")) {
						dbConnection.setDatabasePath(split[1]);
					} else if (split[0].equalsIgnoreCase("databasePort")) {
						dbConnection.setDatabasePort(split[1]);
					} else if (split[0].equalsIgnoreCase("databaseName")) {
						dbConnection.setDatabaseName(split[1]);
					} else if (split[0].equalsIgnoreCase("mailServerPath")) {
						dbConnection.setMailServerPath(split[1]);
					} else if (split[0].equalsIgnoreCase("firstTimeLaunch")) {
						dbConnection.setFirstTimeLaunch(true);
					}
					}
				}  
			dbConnectionTO = dbConnection;
			scan.close();

		
		} catch (Exception ex) {
			System.out.println(ex +" "+ ex.getCause() +" "+  ex.getMessage());
			throw new SetupIncompleteException();
		}
	}
}



// gammal kod att läsa till filen OptionsReaderFile
/*
 * public class OptionsFileReader {
 * 
 * @SuppressWarnings("resource") public void readOptionFile() throws
 * NullPointerException {
 * 
 * try { Scanner scan = new Scanner(System.in); File openedFile = new
 * File("Options.txt"); scan = new Scanner(openedFile);
 * 
 * try { File saveFileTo = new File("OptionsFileReader.txt");
 * 
 * if (!saveFileTo.exists()) { saveFileTo.createNewFile(); } FileWriter
 * fileWriter = new FileWriter(saveFileTo.getAbsoluteFile()); BufferedWriter
 * bufferedWriter = new BufferedWriter(fileWriter);
 * 
 * while (scan.hasNextLine()) { String line = scan.nextLine();
 * bufferedWriter.write(line); bufferedWriter.newLine(); }
 * bufferedWriter.close(); } catch (IOException e) { e.printStackTrace(); }
 * scan.close(); } catch (Exception ex) { ex.printStackTrace(); } } }
 */