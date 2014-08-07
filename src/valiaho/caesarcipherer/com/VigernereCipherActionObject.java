package valiaho.caesarcipherer.com;

import javax.swing.JTextArea;

public class VigernereCipherActionObject implements ICiphererRelated {
	private String plainText;
	private Integer numberOfShifts;
	private String keyWord;
	@Override
	public void setPlainText(String plainText) {
		//Lets build the plaintext without spaces in uppercase
		StringBuilder cipheredText = new StringBuilder();
		for (CharacterIterator iterator = new CharacterIterator(plainText); iterator.hasNext();) {
			char nextChar = iterator.getCurrent();
			if (nextChar == 32) {
				iterator.next();
				continue;
			};
			cipheredText.append(Character.toUpperCase(nextChar));
			iterator.next();
		}
		this.plainText = cipheredText.toString();
	}

	@Override
	public Integer getNumberOfShifts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNumberOfShifts(Integer numberOfShifts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cipher(JTextArea txtrEnterYourCipher) {
		// TODO Auto-generated method stub
		//First lets build a matching length keyword
		StringBuilder keyWordMatchedToPlainTextSize = new StringBuilder();
		int localPosition = 0;
		for (CharacterIterator iterator = new CharacterIterator(plainText); iterator.hasNext();) {
			if (localPosition >= keyWord.length()) {
				localPosition = 0;
			}
			char keyWordChar = Character.toUpperCase(keyWord.charAt(localPosition));
			keyWordMatchedToPlainTextSize.append(keyWordChar);
			localPosition+=1;
			iterator.next();
		}
		//Allright, time to do the caesar shifts
		StringBuilder cipheredString = new StringBuilder();
		for (CharacterIterator iterator = new CharacterIterator(plainText); iterator.hasNext();) {
			Character currentChar = Character.toUpperCase(iterator.getCurrent());
			if (currentChar + (keyWordMatchedToPlainTextSize.charAt(iterator.getPosition())-64) > 90) {
				cipheredString.append((char)(currentChar+(keyWordMatchedToPlainTextSize.charAt(iterator.getPosition()))-90));
			}
			else {
				cipheredString.append((char)(currentChar + (keyWordMatchedToPlainTextSize.charAt(iterator.getPosition())-64)));
			}

			iterator.next();
			
		}
		txtrEnterYourCipher.setText(cipheredString.toString());
	}

	@Override
	public void decipher(JTextArea txtrEnterYourPlainText,
			JTextArea txtrEnterYourPlain) {
		// TODO Auto-generated method stub

	}


	@Override
	public void setPossibleKeyword(String keyword) {
		// TODO Auto-generated method stub
		this.keyWord = keyword.toUpperCase();
	}

	@Override
	public void setCipherText(String cipherText) {
		// TODO Auto-generated method stub
		
	}

}
