package com.jmonkey.xtracker.auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class Digest {
	public static final String	DEFAULT_CHARSET		= "US-ASCII";
	public static final String	DEFAULT_ALGORITHM	= "MD5";

	private String				charset				= DEFAULT_CHARSET;
	private String				algorithm			= DEFAULT_ALGORITHM;

	public Digest() {
		super();
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public byte[] digest(byte[] data) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.update(data);
		return digest.digest();
	}

	public String digest(String plain) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		byte[] data = plain.getBytes(charset);
		byte[] result = digest(data);
		return new String(Hex.encodeHex(result));
	}
}
