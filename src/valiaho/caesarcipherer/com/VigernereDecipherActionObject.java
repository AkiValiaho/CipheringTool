package valiaho.caesarcipherer.com;

import javax.swing.JTextArea;

public class VigernereDecipherActionObject implements ICiphererRelated {
	private String cipherText;
	private String keyWord;
	@Override
	public void setPlainText(String plainText) {
		// TODO Auto-generated method stub

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

	}

	@Override
	public void decipher(JTextArea txtrEnterYourPlainText,
			JTextArea txtrEnterYourPlain) {
		//First lets build a matching length keyword
				StringBuilder keyWordMatchedToPlainTextSize = new StringBuilder();
				int localPosition = 0;
				for (CharacterIterator iterator = new CharacterIterator(cipherText); iterator.hasNext();) {
					if (localPosition >= keyWord.length()) {
						localPosition = 0;
					}
					char keyWordChar = Character.toUpperCase(keyWord.charAt(localPosition));
					keyWordMatchedToPlainTextSize.append(keyWordChar);
					localPosition+=1;
					iterator.next();
				}
				//Allright, time to do the caesar shifts backwards
				StringBuilder cipheredString = new StringBuilder();
				for (CharacterIterator iterator = new CharacterIterator(cipherText); iterator.hasNext();) {
					Character currentChar = Character.toUpperCase(iterator.getCurrent());
					if (currentChar - (keyWordMatchedToPlainTextSize.charAt(iterator.getPosition())-64) < 65) {
						cipheredString.append((char)(currentChar-(keyWordMatchedToPlainTextSize.charAt(iterator.getPosition())-90)));
					}
					else {
						cipheredString.append((char)(currentChar - (keyWordMatchedToPlainTextSize.charAt(iterator.getPosition())-64)));
					}

					iterator.next();
					
				}
				txtrEnterYourPlainText.setText(cipheredString.toString());
		

	}

	@Override
	public void setPossibleKeyword(String keyword) {
		this.keyWord = keyword;
	}

	@Override
	public void setCipherText(String cipherText) {
		//Lets build the cipherText without spaces in uppercase
		StringBuilder cipherTextFormatted = new StringBuilder();
		for (CharacterIterator iterator = new CharacterIterator(cipherText); iterator.hasNext();) {
			char nextChar = iterator.getCurrent();
			if (nextChar == 32) {
				iterator.next();
				continue;
			};
			cipherTextFormatted.append(Character.toUpperCase(nextChar));
			iterator.next();
		}
		this.cipherText = cipherTextFormatted.toString();
		
	}

}
