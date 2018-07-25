package br.com.myTasks.models.repositories;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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

	@SuppressWarnings("unused")
	@Override
	public boolean userExist(User user) {
		try {
			String queryString = "select u from User u where u.email = :email";
			TypedQuery<User> query = manager.createQuery(queryString, User.class);
			query.setParameter("email", user.getEmail());
			User dbUser = query.getSingleResult();	
		} catch (NoResultException e) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public void insert(User user) {
		manager.persist(user);
	}

}