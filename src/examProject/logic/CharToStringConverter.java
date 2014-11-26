package examProject.logic;

public class CharToStringConverter {

	public String charToString(char[] data) {
		String currentPwd = "";
		for (int i = 0; i < data.length; i++)
			currentPwd += data[i];
		return currentPwd;
	}
	
}