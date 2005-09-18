package com.jmonkey.xtracker.cipher;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Hex;

public class PersonCipher {
	private byte[]	salt			= { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c, (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };
	private int		iterationCount	= 2;
	private String	username		= null;
	private String	password		= null;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public int getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(int iterationCount) {
		this.iterationCount = iterationCount;
	}

	public String encrypt(String cleartext) throws Exception {
		byte[] raw = encrypt(cleartext.getBytes());
		char[] hex = Hex.encodeHex(raw);
		return new String(hex);
	}

	public byte[] encrypt(byte[] cleartext) throws Exception {
		Cipher cipher = createCipher(Cipher.ENCRYPT_MODE);
		byte[] ciphertext = cipher.doFinal(cleartext);
		return ciphertext;
	}

	private Cipher createCipher(int mode) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
		PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, iterationCount);
		PBEKeySpec pbeKeySpec = new PBEKeySpec((password + username).toCharArray());
		SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		cipher.init(mode, pbeKey, pbeParamSpec);
		return cipher;
	}

	public String decrypt(String cipherText) throws Exception {
		byte[] raw = Hex.decodeHex(cipherText.toCharArray());
		byte[] clearText = decrypt(raw);
		return new String(clearText);
	}

	public byte[] decrypt(byte[] ciphertext) throws Exception {
		Cipher cipher = createCipher(Cipher.DECRYPT_MODE);
		byte[] raw = cipher.doFinal(ciphertext);
		return raw;
	}

}
