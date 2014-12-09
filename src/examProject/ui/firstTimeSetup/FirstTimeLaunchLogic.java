package examProject.ui.firstTimeSetup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FirstTimeLaunchLogic {
	private String defaultFileName;
	private String usernameTag = "";
	private String pwdTag = "";
	private String username = "";
	private String pwd = "";
	
	public FirstTimeLaunchLogic() {
		this("remoteSetting.txt");
	}
	
	public FirstTimeLaunchLogic(String fileName) {
		this.defaultFileName = fileName;
	}

	public boolean save(String username, String pwd) {
		boolean result = false;
          try {
              FileWriter fOut = new FileWriter(defaultFileName, false);
              PrintWriter fWriter = new PrintWriter(fOut, true);
              fWriter.println(usernameTag+ "=" + username);
              fWriter.println(pwdTag + "=" + pwd);
              fWriter.close();
              result = true;
          } catch (IOException e) {}
          return result;
	}

	  public boolean openFile() {
		  boolean result = false;
	      Scanner fScan = new Scanner(System.in);
	      try {
	    	  fScan = new Scanner(new File(defaultFileName));
	    	  while (fScan.hasNextLine()) {
              String row = fScan.nextLine();
	              String[] parts = row.split("=");
	          if (parts[0].equalsIgnoreCase(usernameTag)) {
	              if (parts.length > 1 && !parts[1].isEmpty())
	                  this.username = parts[1];
	          } else if (parts[0].equalsIgnoreCase(pwdTag))
	        	  if (parts.length > 1 && !parts[1].isEmpty())
	                  this.pwd = parts[1];
	          }
	    	  result = true;
	      } catch (FileNotFoundException fnfe) {
	    	  System.out.println("Fel i loadFromFile: " + fnfe);
	      } finally {
	    	  fScan.close();
	      }
	      return result;
	  }
	  
	  public String getUsername() {
		  return username;
	  }
	  
	  public String getPwd() {
		  return pwd;
	  }
}
