package examProject.logic.mail;

public interface Mail_Interface {

	public void send(String to, String from, String message, String subject);
	public void send(String to, String message, String subject);
}
