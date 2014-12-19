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
				DBConnectionTO dbConnection = new DBConnectionTO();
				
				try {
					while (scan.hasNextLine()) {
						String [] split= new String [2]; 
						String line = scan.nextLine();
						split = line.split("= ");
						if (split[0].equalsIgnoreCase("username")){
							//split[1] = "jj";
							dbConnection.setUsernames(split[1]);
						}
						else if (split[0].equalsIgnoreCase("databaseDriver")){
							//split[1] = "postgresql";
							dbConnection.setDatabaseDriver(split[1]);
						}
						else if(split[0].equalsIgnoreCase("databasePath")){
							//split[1] = "localhost";
							dbConnection.setDatabasePath(split[1]);
						}
						else if(split[0].equalsIgnoreCase("databasePort")){
							//split[1] = "5432";
							dbConnection.setDatabasePort(split[1]);
						}
						else if (split[0].equalsIgnoreCase("databaseName")){
							//split[1] = "Tentamensprojekt";
							dbConnection.setDatabaseName(split[1]);
						}
						else if (split[0].equalsIgnoreCase("mailServerPath")){
							//split[1] = "";
							dbConnection.setMailServerPath(split[1]);
						}
						else if(split[0].equalsIgnoreCase("firstTimeLaunch")){
							dbConnection.setFirstTimeLaunch(true);
						}		
					}
					
					dbConnectionTO = dbConnection;
					scan.close();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			/*} catch (IndexOutOfBoundsException e) {
	        	System.out.println(e +" "+ e.getCause() +" "+  e.getMessage());
	        } catch (NullPointerException e) {
	            throw new NullPointerException();
	        } catch (Exception e) {
	        	System.out.println(e +" "+ e.getCause() +" "+  e.getMessage());
	        } catch (Throwable e) {
	        	System.out.println(e +" "+ e.getCause() +" "+  e.getMessage());
	        } finally {
	        	scan.close();
	        	scan = null;
	        }*/
		}
		}



















/*package examProject.logic;

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
*/



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