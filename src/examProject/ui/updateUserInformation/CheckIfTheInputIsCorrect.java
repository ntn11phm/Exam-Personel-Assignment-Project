package examProject.ui.updateUserInformation;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckIfTheInputIsCorrect {
	public boolean checkSQLCommand(String text) {
		boolean result = false;
		String sqlKommando[] = { "SELECT", "DELETE", "UPDATE","INSERT", "\"", "'" };
		for (int i = 0; i < sqlKommando.length; i++)
			if (text.equalsIgnoreCase(sqlKommando[i])){
				JOptionPane.showMessageDialog(null,
						"Du får inte skriva SELECT, DELETE, UPDATE,INSERT,', \"");
						result = true;}
		return result;
	}

	public int chekIfNummber(int textFieldLength, String textFieldText) {
		int counter = 0;
		for (int i = 0; i < textFieldLength; i++) {
			if (Character.isDigit(textFieldText.charAt(i))
					|| textFieldText.contains(" ")) {
				counter++;
			} else
				counter = 0;
		}
		return counter;
	}

	public boolean checkFirstName(String textFieldText, int textFieldLength) {
		boolean result = false;
		if (checkSQLCommand(textFieldText) == false) {
			int counter = 0;
			for (int i = 0; i < textFieldLength; i++) {
				if (Character.isLetter(textFieldText.charAt(i)))
					counter++;
			}
			if (counter == textFieldLength)
				result = true;
			else {
				result = false;
				JOptionPane.showMessageDialog(null,
						"Den inmatade förnamn är inte rätt");
			}
		}
		return result;
	}

	public void checkLastName(String textFieldText, int textFieldLength) {
		if (checkSQLCommand(textFieldText) == false) {
			int counter = 0;
			for (int i = 0; i < textFieldLength; i++) {
				if (Character.isLetter(textFieldText.charAt(i)))
					counter++;
			}
			if (counter != textFieldLength)
				JOptionPane.showMessageDialog(null,
						"Den inmatade efternamn är inte rätt");
		}
	}

	public boolean checkMail(String textFieldText, int textFieldLength) {
		boolean result = false;
		boolean result2 = false;
		int counter = 0;
		int dotCounter = 0;
		if (textFieldLength > 1) {
			if (textFieldText.contains("@")) {
				result2 = true;
				result = true;
			} else {
				result2 = false;
				result = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Mata in rätt e-mail");
			result = false;
		}
		if (result2 == true) {
			for (int i = 0; i < textFieldLength; i++) {
				if ((int) textFieldText.charAt(i) == 45
						|| (int) textFieldText.charAt(i) == 46
						|| (int) textFieldText.charAt(i) == 95
						|| (int) textFieldText.charAt(i) == 64
						|| Character.isLetter(textFieldText.charAt(i))
						|| Character.isDigit(textFieldText.charAt(i)))
					counter++;
				if ((int) textFieldText.charAt(i) == 46)
					dotCounter = 1;
			}
			if (counter == textFieldLength & dotCounter == 1)
				result = true;
			else {
				result = false;
				JOptionPane.showMessageDialog(null,
								"Den inmatade e-post är inte rätt. Du får använda bara följande tecken (- , _ , . , nummer, små och stora bokstäver )");
			}
		} else
			JOptionPane.showMessageDialog(null,
							"Den inmatade e-post är inte rätt. Du får använda bara följande tecken (- , _ , . , nummer, små och stora bokstäver )");
		return result;
	}

	public boolean compareMail(JTextField retypeEmail, JTextField email) {
		if (email.getText().equalsIgnoreCase(retypeEmail.getText()) == false) {
			JOptionPane.showMessageDialog(null, "Mailet stämmer inte");
			return false;
		}
		return true;
	}

	public boolean checkCityName(String textFieldText, int textFieldLength) {
		boolean result = false;
		if (checkSQLCommand(textFieldText) == false) {
			int counter = 0;
			for (int i = 0; i < textFieldLength; i++) {
				if (Character.isLetter(textFieldText.charAt(i)))
					counter++;
			}
			if (counter != textFieldLength) {
				JOptionPane.showMessageDialog(null, "Ort namn är inte rätt");
				result = false;

			} else
				result = true;
		}
		return result;
	}

	public int chekIfCivNummber(int textFieldLength, String textFieldText) {
		int counter = 0;
		for (int i = 0; i < textFieldLength; i++) {
			if (Character.isDigit(textFieldText.charAt(i))) {
				counter++;
			} else
				counter = 0;
		}
		return counter;
	}

	public boolean checkCivicNr(String textFieldText, int textFieldLength) {
		int counter = 0;
		counter = chekIfCivNummber(textFieldLength, textFieldText);
		if (counter != 10) {
			JOptionPane.showMessageDialog(null, "civicNr är incorrect");
			return false;
		}
		return true;
	}

	public boolean checkPhoneNr(String textFieldText, int textFieldLength) {
		int counter = 0;
		counter = chekIfNummber(textFieldLength, textFieldText);
		if (counter != textFieldLength) {
			JOptionPane.showMessageDialog(null, "Phonnummer är inte rätt");
			return false;
		}
		return true;
	}

	public boolean checkMobilNr(String textFieldText, int textFieldLength) {
		int counter = 0;
		counter = chekIfNummber(textFieldLength, textFieldText);
		if (counter != textFieldLength) {
			JOptionPane.showMessageDialog(null, "Mobilnumret är inte rätt");
			return false;
		}
		return true;
	}

	public boolean checkZipCode(String textFieldText, int textFieldLength) {
		int counter = 0;
		counter = chekIfNummber(textFieldLength, textFieldText);
		if (counter != textFieldLength) {
			JOptionPane.showMessageDialog(null, "Postnummer är inte rätt");
			return false;
		}
		return true;
	}

	public boolean checkIfAddressIsCorrest(String textFieldText,
			int textFieldLength) {
		int counter = 0;
		if (checkSQLCommand(textFieldText) == false) {
			for (int i = 0; i < textFieldLength; i++) {
				if (Character.isLetter(textFieldText.charAt(i))
						|| textFieldText.contains(" ")) {
					counter++;
				}
			}
			if (counter != textFieldLength) {
				JOptionPane.showMessageDialog(null, "Adressen är inte rätt");
				return false;
			}
		}
		return true;
	}
}