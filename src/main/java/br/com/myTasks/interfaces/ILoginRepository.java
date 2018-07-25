package br.com.myTasks.interfaces;

import br.com.myTasks.models.entityes.User;

public interface ILoginRepository {

	User getUser(User user);
	
}
