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

	@SuppressWarnings({ "resource" })
	public void readOptionFile() throws SetupIncompleteException {

		Scanner scan = new Scanner(System.in);
		try {
			File openedFile = new File("Options.txt");
			scan = new Scanner(openedFile);
		} catch (FileNotFoundException e) {}
		DBConnectionTO dbConnection = new DBConnectionTO();
		try {
			while (scan.hasNextLine()) {
				String[] split = new String[2];
				String line = scan.nextLine();
				split = line.split("=");
				if (split.length != 2)
					throw new SetupIncompleteException();
				else {
					if (split[0].equalsIgnoreCase("databaseDriver")) {
						dbConnection.setDatabaseDriver(split[1]);
					} else if (split[0].equalsIgnoreCase("databasePath")) {
						dbConnection.setDatabasePath(split[1]);
					} else if (split[0].equalsIgnoreCase("databasePort")) {
						dbConnection.setDatabasePort(split[1]);
					} else if (split[0].equalsIgnoreCase("databaseName")) {
						dbConnection.setDatabaseName(split[1]);
					} else if (split[0].equalsIgnoreCase("firstTimeLaunch")) {
						dbConnection.setFirstTimeLaunch(true);
					}
				}
			}  
			dbConnectionTO = dbConnection;
			scan.close();
		} catch (Exception ex) {
//			System.out.println(ex +" "+ ex.getCause() +" "+  ex.getMessage());
			throw new SetupIncompleteException();
		}
	}
}