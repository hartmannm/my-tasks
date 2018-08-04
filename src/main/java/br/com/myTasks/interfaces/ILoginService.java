package br.com.myTasks.interfaces;

import br.com.myTasks.exceptions.UserExistenceExcepion;
import br.com.myTasks.models.entityes.User;

public interface ILoginService {

	User login(User user) throws UserExistenceExcepion;

	void logout();
	
}