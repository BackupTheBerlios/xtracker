package com.jmonkey.xtracker.auth;

public class RandomPasswordGenerator {

	private static final int	DEFAULT_PASSWORD_LENGTH	= 6;
	private static final char[]	ALPHABET				= "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

	public RandomPasswordGenerator() {
		super();
	}

	public String getNextPassword() {
		char[] passwd = getRandomPassword(DEFAULT_PASSWORD_LENGTH);
		return new String(passwd);
	}

	public char[] getRandomPassword(int digits) {
		char[] result = new char[digits];
		for (int i = 0; i < digits; i++) {
			result[i] = ALPHABET[(int) Math.round(Math.floor(Math.random() * ALPHABET.length))];
		}
		return result;
	}
}
