package examProject.dao;

public class SQLcommandDetector {
	private String[] bannedWords = {"SELECT", "UPDATE", "INSERT", "DELETE", "WHERE", "ALTER", "TABLE", "DROP", "GRANT", "CREATE"};
	
	public boolean checkStringBool(String str) {
		boolean containsBannedWords = false;
		for (int i = 0; i < bannedWords.length; i++)
			if (str.toUpperCase().contains(bannedWords[i]))
				containsBannedWords = true;
		return containsBannedWords;
	}
	
	public String checkString(String str) {
		String result = "";
		for (int i = 0; i < bannedWords.length; i++)
			if (str.toUpperCase().contains(bannedWords[i]))
				result = bannedWords[i];
		return result;
	}
}
