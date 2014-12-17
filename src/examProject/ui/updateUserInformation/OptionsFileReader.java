package examProject.ui.updateUserInformation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import examProject.logic.BackendFacade;
import examProject.transferObjects.DBConnectionTO;

public class OptionsFileReader {

	@SuppressWarnings("resource")
	public void readOptionFile() throws NullPointerException {
		String[] string = null;
		try {
			Scanner scan = new Scanner(System.in);
			File openedFile = new File("Options.txt");
			scan = new Scanner(openedFile);

			try {
			  for (int i = 0; i <5; i++ ){
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					
					string[i] = line;		
					  System.out.println(string[i] );

				}
			}
			  

			//	new DBConnectionTO(string[0], string[1], string[2], string[3], string[4], b );
			//	System.out.println("jhfhfh " + string);

			scan.close();
			//new BackendFacade().createDbObjects(); 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} catch (IOException e) {
		e.printStackTrace();
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