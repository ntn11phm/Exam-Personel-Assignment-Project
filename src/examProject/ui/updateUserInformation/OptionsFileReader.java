package examProject.ui.updateUserInformation;
	import java.io.BufferedWriter;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.util.Scanner;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import examProject.transferObjects.ExamOccationTO;

	public class OptionsFileReader {
		private String dataFile = "";

		
		public void readOptionFile() throws NullPointerException {
		System.out.println("Här är det som ska skrivas");	
			
			 try {
		            Scanner scan = new Scanner(System.in);
		            System.out.print("Enter the file name with extention : ");
		              File file = new File("D:/Gitup/Exam-Personel-Assignment-Project/Options.txt");
		              scan = new Scanner(file);

		            
		            //  File file = new File(scan.nextLine());

		          //  scan = new Scanner(file);

		            while (scan.hasNextLine()) {
		                String line = scan.nextLine(); 
		                System.out.println("linenumber " + line);
		                try {
		                	 
		        			String content = "";
		         
		        			File file1 = new File("/users/Rambo/filename.txt");
		         
		        			if (!file1.exists()) {
		        				file1.createNewFile();
		        			}
		         
		        			FileWriter fw = new FileWriter(file1.getAbsoluteFile());
		        			BufferedWriter bw = new BufferedWriter(fw);
		        			bw.write(content);
		        			bw.close();
		         
		        			System.out.println("Done");
		         
		        		} catch (IOException e) {
		        			e.printStackTrace();
		        		}
		        }
		            scan.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }		
	}



