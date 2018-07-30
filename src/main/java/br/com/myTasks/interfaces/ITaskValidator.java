package br.com.myTasks.interfaces;

import br.com.myTasks.models.entityes.Task;

public interface ITaskValidator {

	public void validate(Task task);
	
	<T> T onErrorRedirectTo(T controller);
	
}
