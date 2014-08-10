package valiaho.caesarcipherer.com;

import javax.swing.JTextArea;

public class CaesarCipherActionObject implements ICiphererRelated {
	private String plainText;
	private Integer numberOfShifts;
	public CaesarCipherActionObject(String shitToCipher, Integer numberOfShifts) {
		plainText = shitToCipher;
		this.numberOfShifts = numberOfShifts;
	}
	
	/**
	 * 
	 */
	public CaesarCipherActionObject() {
		// TODO Auto-generated constructor stub
	}

	public String getPlainText() {
		return plainText;
	}
	/* (non-Javadoc)
	 * @see valiaho.caesarcipherer.com.ICiphererRelated#setPlainText(java.lang.String)
	 */
	@Override
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	/* (non-Javadoc)
	 * @see valiaho.caesarcipherer.com.ICiphererRelated#getNumberOfShifts()
	 */
	@Override
	public Integer getNumberOfShifts() {
		return numberOfShifts;
	}
	/* (non-Javadoc)
	 * @see valiaho.caesarcipherer.com.ICiphererRelated#setNumberOfShifts(java.lang.Integer)
	 */
	@Override
	public void setNumberOfShifts(Integer numberOfShifts) {
		this.numberOfShifts = numberOfShifts;
	}
	private char returnRotatedChar(Character testCharacter) {
		if (Character.toUpperCase(testCharacter)+numberOfShifts > 90) {			
				return (char) (Character.toUpperCase(testCharacter)+numberOfShifts-90 +64);
			}
			return (char) (Character.toUpperCase(testCharacter)+numberOfShifts);
	}
	/* (non-Javadoc)
	 * @see valiaho.caesarcipherer.com.ICiphering#cipher(javax.swing.JTextArea)
	 */
	 /* (non-Javadoc)
	 * @see valiaho.caesarcipherer.com.ICiphererRelated#cipher(javax.swing.JTextArea)
	 */
	@Override
	public void cipher(JTextArea txtrEnterYourCipher) {
		StringBuilder cipheredText = new StringBuilder();
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) == 32) {
				continue;
			}
			cipheredText.append(returnRotatedChar(plainText.charAt(i)));
		}
		txtrEnterYourCipher.setText(cipheredText.toString()); 
	}

	@Override
	public void decipher(JTextArea txtrEnterYourPlainText,JTextArea txtrEnterYoutCipher) {
		// TODO Auto-generated method stub
		
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
