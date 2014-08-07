package valiaho.caesarcipherer.com;

import javax.swing.JTextArea;

/**
 * @author Aki
 * This class contains necessary methods implemented from ICiphererRelated interface to deciphering
 * 
 */
public class CaesarDecipheringActionObject implements ICiphererRelated {
	private String cipherText;
	private Integer numberOfShifts;
	
	public CaesarDecipheringActionObject() {
		
	}
	@Override
	public void setPlainText(String plainText) {
		// TODO Auto-generated method stub
		this.cipherText = plainText;
		
	}
	@Override
	public Integer getNumberOfShifts() {
		// TODO Auto-generated method stub
		return numberOfShifts;
	}

	@Override
	public void setNumberOfShifts(Integer numberOfShifts) {
		// TODO Auto-generated method stub
		this.numberOfShifts = numberOfShifts;

	}

	@Override
	public void cipher(JTextArea txtrEnterYourCipher) {
		// TODO Auto-generated method stub

	}
	private char returnRotatedChar(Character testCharacter) {
		if (Character.toUpperCase(testCharacter)-numberOfShifts < 65) {			
				return (char) (Character.toUpperCase(testCharacter)-numberOfShifts+90-64);
			}
			return (char) (Character.toUpperCase(testCharacter)-numberOfShifts);
	}

	@Override
	public void decipher(JTextArea txtrEnterYourPlainText,JTextArea realArea) {
		
			StringBuilder decipheredText = new StringBuilder();
			String txt = txtrEnterYourPlainText.getText();
			for (int i = 0; i < txt.length(); i++) {
				if (txt.charAt(i) == 32) {
					continue;
				}
				decipheredText.append(returnRotatedChar(txt.charAt(i)));
			}
			realArea.setText(decipheredText.toString()); 
		}
	@Override
	public void setPossibleKeyword(String keyword) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCipherText(String cipherText) {
		// TODO Auto-generated method stub
		
	}
	}
