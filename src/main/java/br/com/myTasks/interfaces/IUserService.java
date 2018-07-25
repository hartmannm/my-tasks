package br.com.myTasks.interfaces;

import br.com.myTasks.exceptions.EncryptionException;
import br.com.myTasks.exceptions.UserExistenceExcepion;
import br.com.myTasks.models.entityes.User;

public interface IUserService {

	void createUser(User user) throws UserExistenceExcepion, EncryptionException ;
	
}
