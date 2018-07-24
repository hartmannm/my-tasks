package br.com.myTasks.interfaces;

import br.com.myTasks.models.entityes.User;

public interface ILoginValidator {

	void validate(User user);
	
	<T> T onErrorRedirectTo(T controller);
	
}
