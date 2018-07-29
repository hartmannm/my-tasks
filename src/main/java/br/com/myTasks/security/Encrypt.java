package br.com.myTasks.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.Dependent;

import br.com.myTasks.interfaces.IEncrypt;

@Dependent
public class Encrypt implements IEncrypt{

	@Override
	public String encryptPassword(String password) {
		String encryptedPassword = "";

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = md.digest(password.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();

			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));

				encryptedPassword = hexString.toString();
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new RuntimeException();
		}
		
		return encryptedPassword;
	}

}
