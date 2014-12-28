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
				JOptionPane.showMessageDialog(null, "Du får inte skriva SELECT, DELETE, UPDATE,', \"");
		result = false;
		return result;
	}
	
	//denna metod används i checkIfPoneNrIsCorrect, checkIfMobilNrIsCorrect,checkIfCivicNrISCorrect för att kolla om inmatningen är bara nummer
			public int chekIfNummber(int textFieldLength, String textFieldText) {
				int counter = 0;
				for (int i = 0; i < textFieldLength; i++) {
					if ((int) textFieldText.charAt(i) > 47 & (int) textFieldText.charAt(i) < 58) {
						counter++;
					}
				}
				return counter;
			}
			
			public void checkFirstName(String textFieldText, int textFieldLength) {
				if (checkSQLCommand(textFieldText)== false) {
					int counter = 0;
					for (int i = 0; i < textFieldLength; i++) {
						if ((int) textFieldText.charAt(i) > 64
								& (int) textFieldText.charAt(i) < 91
								|| (int) textFieldText.charAt(i) > 96
								& (int) textFieldText.charAt(i) < 123)
							counter++;
					}
					if (counter == textFieldLength)
						System.out.println(" done " + textFieldText);
					else {
						System.out.println(" nej " + textFieldText);
						JOptionPane.showMessageDialog(null,
								"Den inmatade förnamn är inte rätt");
						// använd null för att dialogrutan ska visas i mitte på skärmen
					}
				}
			}
			public void checkLastName(String textFieldText, int textFieldLength) {
				if (checkSQLCommand(textFieldText)== false) {
					int counter = 0;
					for (int i = 0; i < textFieldLength; i++) {
						if ((int) textFieldText.charAt(i) > 64
								& (int) textFieldText.charAt(i) < 91
								|| (int) textFieldText.charAt(i) > 96
								& (int) textFieldText.charAt(i) < 123)
							counter++;
					}
					if (counter != textFieldLength)
						JOptionPane.showMessageDialog(null,
								"Den inmatade efternamn är inte rätt");
					// använd null för att dialogrutan ska visas i mitte på skärmen
				}
			}
			public static void checkMail(String textFieldText, int textFieldLength) {
				boolean b = false;
				int counter = 0;
				int dotCounter =0;

				if (textFieldLength > 1) {
					if (textFieldText.contains("@")) {
						b = true;
						System.out.println("det finns @ " + b);

					} else
						System.out.println("det finns inte @ " + b);
				} else
					JOptionPane.showMessageDialog(null, "Mata in rätt e-mail");
				for (int i = 0; i < textFieldLength; i++) {
					if ((int) textFieldText.charAt(i) == 45 // - tecken
							|| (int) textFieldText.charAt(i) == 46 // .tecken
							|| (int) textFieldText.charAt(i) == 95 // _ tecken
							|| (int) textFieldText.charAt(i) > 47 // nummer
							& (int) textFieldText.charAt(i) < 58
							|| (int) textFieldText.charAt(i) > 63 // @ och Storabokstäver
							& (int) textFieldText.charAt(i) < 91
							|| (int) textFieldText.charAt(i) > 96 // småbokstäver
							& (int) textFieldText.charAt(i) < 123)
						counter++;
					
					if((int) textFieldText.charAt(i)== 46 )
						dotCounter = 1 ;
				}
				if (counter == textFieldLength & dotCounter == 1)
					System.out.println(" done " + textFieldText);
				else {
					JOptionPane.showMessageDialog(null, "Du får använda bara följande tecken (- , _ , . , nummer, små och stora bokstäver )");
				}
			}
			public static void compareMail(JTextField retypeEmail, JTextField email) {
				if (email.getText().equals(retypeEmail.getText()) == false)
					JOptionPane.showMessageDialog(null, "Mailet stämmer inte");
			}
			// Metod kollar om den inmatade ort namn är rätt dvs att den tar bara
			// bokstäver
			public void checkCityName(String textFieldText, int textFieldLength) {
				if (checkSQLCommand(textFieldText)== false) {
					int counter = 0;
					for (int i = 0; i < textFieldLength; i++) {
					/*	if ((int) textFieldText.charAt(i) > 64
								& (int) textFieldText.charAt(i) < 91
								|| (int) textFieldText.charAt(i) > 96
								& (int) textFieldText.charAt(i) < 123
								||(int) textFieldText.charAt(i) == 32)*/
							counter++;
					}
					if (counter != textFieldLength){
						JOptionPane.showMessageDialog(null, "Ort är inte rätt");}
				}
			}
			// Metod kollar om den inmatade personnummer är rätt
			public void checkCivicNr(String textFieldText, int textFieldLength) {
				int counter = 0;
				counter = chekIfNummber(textFieldLength, textFieldText);
						if (counter != 10 )
							JOptionPane.showMessageDialog(null, "civicNr är incorrect");
			}
			public void checkPhoneNr(String textFieldText, int textFieldLength) {
				int counter = 0;
				counter = chekIfNummber(textFieldLength, textFieldText);
				if (counter != textFieldLength)
						JOptionPane.showMessageDialog(null, "phonenummer är inte rätt");
			}
			// Metod kollar om den inmatade personnummer är rätt
			public void checkMobilNr(String textFieldText, int textFieldLength) {
				int counter = 0;
				counter = chekIfNummber(textFieldLength, textFieldText);
				if (counter != textFieldLength )
						JOptionPane.showMessageDialog(null, "Mobilnumret är inte rätt");
			}

			public void checkZipCode(String textFieldText, int textFieldLength){
				int counter = 0;
				counter = chekIfNummber(textFieldLength, textFieldText);
				if (counter != textFieldLength)
						JOptionPane.showMessageDialog(null, "Postnummer är inte rätt");
			}
			public void checkIfAddressIsCorrest(String textFieldText){
				if (checkSQLCommand(textFieldText)== false) {
					return;
				}
			} 

}
