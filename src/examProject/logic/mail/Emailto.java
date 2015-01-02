package examProject.logic.mail;

import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author http://www.2ality.com/2010/12/simple-way-of-sending-emails-in-java.html
 *
 */

public class Emailto implements Mail_Interface {
	
	public static void mailto(List<String> recipients, String subject, String body) throws IOException, URISyntaxException {
	    String uriStr = String.format("mailto:%s?subject=%s&body=%s",
	            join(",", recipients), // use semicolon ";" for Outlook!
	            urlEncode(subject),
	            urlEncode(body));
	    Desktop.getDesktop().browse(new URI(uriStr));
	}

	private static final String urlEncode(String str) {
	    try {
	        return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException(e);
	    }
	}

	public static final String join(String sep, Iterable<?> objs) {
	    StringBuilder sb = new StringBuilder();
	    for(Object obj : objs) {
	        if (sb.length() > 0) sb.append(sep);
	        sb.append(obj);
	    }
	    return sb.toString();
	}

	@Override
	public void send(List<String> to, String from, String message, String subject) {
			try {
				mailto(to, subject, message);
			} catch (URISyntaxException e) {
				
			} catch (IOException e) {}
	}

	@Override
	public void send(String to, String from, String message, String subject) {
		List<String> toList = new ArrayList<String>();
		toList.add(to);
		send(toList, from, message, subject);
	}
	
	@Override
	public void send(String to, String message, String subject) {
		send(to, "", message, subject);
	}
}
