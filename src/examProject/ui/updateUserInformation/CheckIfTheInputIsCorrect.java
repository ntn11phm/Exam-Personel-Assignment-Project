package examProject.ui.updateUserInformation;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * denna klarr kollar metoder för inmatningen
 *
 */
public class CheckIfTheInputIsCorrect {
	public boolean checkSQLCommand(String text) {
		boolean result = false;
		String sqlKommando[] = { "SELECT", "DELETE", "UPDATE", "\"", "'" };
		for (int i = 0; i < sqlKommando.length; i++)
			if (text.equalsIgnoreCase(sqlKommando[i]))
				JOptionPane.showMessageDialog(null,
						"Du får inte skriva SELECT, DELETE, UPDATE,', \"");
		result = false;
		return result;
	}

	// denna metod används i checkIfPoneNrIsCorrect,
	// checkIfMobilNrIsCorrect,checkIfCivicNrISCorrect för att kolla om
	// inmatningen är bara nummer
	public int chekIfNummber(int textFieldLength, String textFieldText) {
		int counter = 0;
		for (int i = 0; i < textFieldLength; i++) {
			if(Character.isDigit(textFieldText.charAt(i)) || textFieldText.contains(" ")){
			
			/*if ((int) textFieldText.charAt(i) > 47
					& (int) textFieldText.charAt(i) < 58) {*/
				
				counter++;
			}
			else 
				counter=0;
			}
		
		return counter;
	}

	public boolean checkFirstName(String textFieldText, int textFieldLength) {
		boolean b= false;
		if (checkSQLCommand(textFieldText) == false) {
			int counter = 0;
			for (int i = 0; i < textFieldLength; i++) {
				if(Character.isLetter(textFieldText.charAt(i)))
				/*if ((int) textFieldText.charAt(i) > 64
						& (int) textFieldText.charAt(i) < 91
						|| (int) textFieldText.charAt(i) > 96
						& (int) textFieldText.charAt(i) < 123)*/
					counter++;
			}
			if (counter == textFieldLength)
				b=true;

			else {
				b=false;
				JOptionPane.showMessageDialog(null,
						"Den inmatade förnamn är inte rätt");
				// använd null för att dialogrutan ska visas i mitte på skärmen
			}
		}
		return b;

	}

	public void checkLastName(String textFieldText, int textFieldLength) {
		if (checkSQLCommand(textFieldText) == false) {
			int counter = 0;
			for (int i = 0; i < textFieldLength; i++) {
				if (Character.isLetter(textFieldText.charAt(i)))
			
				/*if ((int) textFieldText.charAt(i) > 64
						& (int) textFieldText.charAt(i) < 91
						|| (int) textFieldText.charAt(i) > 96
						& (int) textFieldText.charAt(i) < 123)*/
					counter++;
			}
			if (counter != textFieldLength)
				JOptionPane.showMessageDialog(null,
						"Den inmatade efternamn är inte rätt");
			// använd null för att dialogrutan ska visas i mitte på skärmen
		}
	}

	public boolean checkMail(String textFieldText, int textFieldLength) {
		boolean result= false;
		boolean b = false;
		int counter = 0;
		int dotCounter = 0;

		if (textFieldLength > 1) {
			if (textFieldText.contains("@")) {
				b = true;
				result = true;
			} else{
				b=false;
				result = false;
			}
		} else{
			JOptionPane.showMessageDialog(null, "Mata in rätt e-mail");
			result= false;
		}
		if (b== true) {
		for (int i = 0; i < textFieldLength; i++) {
			if ((int) textFieldText.charAt(i) == 45 // - tecken
					|| (int) textFieldText.charAt(i) == 46 // .tecken
					|| (int) textFieldText.charAt(i) == 95 // _ tecken
					|| (int) textFieldText.charAt(i) == 64
					|| Character.isLetter(textFieldText.charAt(i))
					|| Character.isDigit(textFieldText.charAt(i)))
					
					/*|| (int) textFieldText.charAt(i) > 47 // nummer
					& (int) textFieldText.charAt(i) < 58
					|| (int) textFieldText.charAt(i) > 63 // @ och
															// Storabokstäver
					& (int) textFieldText.charAt(i) < 91
					|| (int) textFieldText.charAt(i) > 96 // småbokstäver
					& (int) textFieldText.charAt(i) < 123)
				*/
					counter++;
			if ((int) textFieldText.charAt(i) == 46)
				dotCounter = 1;
		}
		
		if (counter == textFieldLength & dotCounter == 1)
			result= true;
			
		// System.out.println(" done " + textFieldText);
		else {
			result=false;
			JOptionPane
					.showMessageDialog(
							null,
							"Den inmatade e-post är inte rätt. Du får använda bara följande tecken (- , _ , . , nummer, små och stora bokstäver )");
		}}else 
			JOptionPane
			.showMessageDialog(
					null,
					"Den inmatade e-post är inte rätt. Du får använda bara följande tecken (- , _ , . , nummer, små och stora bokstäver )");
			return result;
	}
	

	public boolean compareMail(JTextField retypeEmail, JTextField email) {
		if (email.getText().equals(retypeEmail.getText()) == false){
			JOptionPane.showMessageDialog(null, "Mailet stämmer inte");
		return false;	
		}
		return true;
	}

	// Metod kollar om den inmatade ort namn är rätt dvs att den tar bara
	// bokstäver
	public boolean checkCityName(String textFieldText, int textFieldLength) {
		boolean b = false;
		if (checkSQLCommand(textFieldText) == false) {
			int counter = 0;
			for (int i = 0; i < textFieldLength; i++) {
				if (Character.isLetter(textFieldText.charAt(i)))
						
						/*(int) textFieldText.charAt(i) > 64
						& (int) textFieldText.charAt(i) < 91
						|| (int) textFieldText.charAt(i) > 96
						& (int) textFieldText.charAt(i) < 123
						|| (int) textFieldText.charAt(i) > 131
						& (int) textFieldText.charAt(i) < 135
						|| (int) textFieldText.charAt(i) > 141
						& (int) textFieldText.charAt(i) < 144
						|| (int) textFieldText.charAt(i) == 148
						|| (int) textFieldText.charAt(i) == 153)*/
					counter++;
			}
			if (counter != textFieldLength) {
				JOptionPane.showMessageDialog(null, "Ort namn är inte rätt");
				b = false;

			} else
				b = true;
		}
		return b;
	}
	public int chekIfCivNummber(int textFieldLength, String textFieldText) {
		int counter = 0;
		for (int i = 0; i < textFieldLength; i++) {
			if(Character.isDigit(textFieldText.charAt(i))){
			
			counter++;
			}
			else 
				counter=0;
			}
		
		return counter;
	}


	// Metod kollar om den inmatade personnummer är rätt
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

	// Metod kollar om den inmatade personnummer är rätt
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

	public boolean checkIfAddressIsCorrest(String textFieldText , int textFieldLength) {
		int counter=0;
		int count = 0;
		count = chekIfNummber(textFieldLength, textFieldText);
		if (checkSQLCommand(textFieldText) == false) {
			for (int i = 0; i < textFieldLength; i++) {
				if (Character.isLetter(textFieldText.charAt(i)) || textFieldText.contains(" ")) 
					{								
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