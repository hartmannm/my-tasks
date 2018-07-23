package br.com.myTasks.models.repositories;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.myTasks.annotations.DataBaseAccess;
import br.com.myTasks.interfaces.IUserRepository;
import br.com.myTasks.models.entityes.User;

@RequestScoped
public class UserRepository implements IUserRepository{
	
	private EntityManager manager;
	
	@Deprecated
	public UserRepository() {
		this(null);
	}
	
	@Inject
	public UserRepository(EntityManager manager) {
		this.manager = manager;
	}

	@DataBaseAccess
	@Override
	public boolean userExist(User user) {
		// TODO implementar método para verificar existencia de usuario
		return false;
	}
	
	@DataBaseAccess
	@Override
	public void insert(User user) {
		manager.persist(user);
	}

}