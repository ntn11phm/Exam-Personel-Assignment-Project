package examProject.logic.mail;
/**
 * Email interface for the Exam-Personel-Assignment-Project.
 * @author Per Hedblom
 */
import java.util.List;

public interface Mail_Interface {
	/**
	 * Send-function.
	 * @param to {@link String} a valid email-address.
	 * @param from {@link String} a valid email-address.
	 * @param message {@link String} body-text.
	 * @param subject {@link String} 
	 */
	public void send(String to, String from, String message, String subject);
	/**
	 * Send-function.
	 * @param to {@link String} a valid email-address.
	 * @param message {@link String} body-text.
	 * @param subject {@link String}
	 */
	public void send(String to, String message, String subject);
	/**
	 * Send-function.
	 * @param to {@link List} of {@link String} a valid email-addresses.
	 * @param from {@link String} a valid email-address.
	 * @param message {@link String} body-text.
	 * @param subject {@link String}
	 */
	void send(List<String> to, String from, String message, String subject);
}
