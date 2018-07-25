package br.com.myTasks.interfaces;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface IEncrypt {

	String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
}
