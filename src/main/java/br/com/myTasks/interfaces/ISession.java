package br.com.myTasks.interfaces;

import br.com.myTasks.models.entityes.User;

public interface ISession {

	void login(User user);
	
	void logout();
	
	User getUser();
	
	boolean isLogged();
	
}
