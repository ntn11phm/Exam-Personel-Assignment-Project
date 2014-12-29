package examProject.logic.mail;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class Emailto implements Mail_Interface {

	@Override
	public void send(String to, String from, String message, String subject) {
		Desktop desktop = Desktop.getDesktop();
		String txtMessage = "mailto:" + to + "?subject=" + subject + "?body=" + message;
		URI uri = URI.create(txtMessage);
		try {
			desktop.mail(uri);
		} catch (IOException e) {}
	}
	
	@Override
	public void send(String to, String message, String subject) {
		send(to, "", message, subject);
	}
}
