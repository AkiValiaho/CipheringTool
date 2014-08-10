package valiaho.caesarcipherer.com;

import javax.swing.JTextArea;

public interface ICiphererRelated {

	/**
	 * T‰m‰n metodin tarkoitus on asettaa plainTexti luokkaan.
	 * 	 * @param plainText
	 */
	public abstract void setPlainText(String plainText);

	/**
	 * Luokka palauttaa privateksi s‰‰detyn NumberOfShifts integerin, joka kertoo
	 * kuinka monta kertaa yksitt‰inen kirjain tulee siirt‰‰ CaesarShiftill‰
	 * @return Integer
	 */
	public abstract Integer getNumberOfShifts();

	/**
	 * Metodi asettaa caesarshiftien lukum‰‰r‰n.
	 * @param numberOfShifts CaesarShiftien lukum‰‰r‰
	 */
	public abstract void setNumberOfShifts(Integer numberOfShifts);

	/* (non-Javadoc)
	 * @see valiaho.caesarcipherer.com.ICiphering#cipher(javax.swing.JTextArea)
	 */
	/**
	 * Salakirjoituksen toteuttava metodi
	 * @param txtrEnterYourCipher GUI:hin kirjoitettava salakirjoitusTextArea.
	 */
	public abstract void cipher(JTextArea txtrEnterYourCipher);
	/**
	 * Metodi toteuttaa salakirjoituksen purkamisen.
	 * @param txtrEnterYourPlainText TextArea johon plaintext alunperin kirjoitettiin.
	 * @param txtrEnterYourPlain TextArea johon cipherText alunperin kirjoitettiin.
	 */
	public abstract void decipher(JTextArea txtrEnterYourPlainText, JTextArea txtrEnterYourPlain);
	/**
	 * Asettaa privateksi m‰‰ritellyn keyword-stringin. Vigenere-cipheriss‰ tarvittava avainsana.
	 * @param keyword
	 */
	public abstract void setPossibleKeyword(String keyword);
	/**
	 * Asettaa privateksi s‰‰detyn cipherText Stringin.
	 * @param cipherText Koodattu plaintext stringi
	 */
	public abstract void setCipherText(String cipherText);
	

}