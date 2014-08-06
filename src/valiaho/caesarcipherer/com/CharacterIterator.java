package valiaho.caesarcipherer.com;

import java.util.Iterator;

public class CharacterIterator implements Iterator<Character> {
	private final String str;
	private int position = 0;
	public CharacterIterator(String str) {
		// TODO Auto-generated constructor stub
		this.str = str;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return getPosition() < str.length();
	}

	@Override
	public Character next() {
		// TODO Auto-generated method stub
		return str.charAt(position++);
	}
	public char getCurrent() {
		return str.charAt(position);
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}

}
