package valiaho.caesarcipherer.com;

import javax.swing.JTextArea;

public interface ICiphererRelated {

	public abstract void setPlainText(String plainText);

	public abstract Integer getNumberOfShifts();

	public abstract void setNumberOfShifts(Integer numberOfShifts);

	/* (non-Javadoc)
	 * @see valiaho.caesarcipherer.com.ICiphering#cipher(javax.swing.JTextArea)
	 */
	public abstract void cipher(JTextArea txtrEnterYourCipher);
	public abstract void decipher(JTextArea txtrEnterYourPlainText, JTextArea txtrEnterYourPlain);

}