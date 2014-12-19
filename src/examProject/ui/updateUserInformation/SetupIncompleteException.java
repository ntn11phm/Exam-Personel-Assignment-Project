package examProject.ui.updateUserInformation;

public class SetupIncompleteException extends Exception {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SetupIncompleteException() { 
		 super();
		 }
	  public SetupIncompleteException(String message) { 
		  super(message);
		  }
	  public SetupIncompleteException(String message, Throwable cause) {
		  super(message, cause); 
		  }
	  public SetupIncompleteException (Throwable cause) { 
		  super(cause); 
		  }
	}
