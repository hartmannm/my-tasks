package br.com.myTasks.exceptions;

public class NoTasksException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoTasksException(String message) {
		super(message);
	}
	
}