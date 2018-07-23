package br.com.myTasks.interfaces;

import br.com.myTasks.models.entityes.User;

public interface IUserRepository {

	boolean userExist(User user);
	
	void insert(User user);
	
}
