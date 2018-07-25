package br.com.myTasks.exceptions;

public class UserExistenceExcepion extends Exception {

	private static final long serialVersionUID = 1L;

	public UserExistenceExcepion(String message) {
		super(message);
	}
	
}
