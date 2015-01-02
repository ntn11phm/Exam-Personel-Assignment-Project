package examProject.logic.mail;

import java.util.List;

public interface Mail_Interface {

	public void send(String to, String from, String message, String subject);
	public void send(String to, String message, String subject);
	void send(List<String> to, String from, String message, String subject);
}
