package br.com.myTasks.models.repositories;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.myTasks.interfaces.ILoginRepository;
import br.com.myTasks.models.entityes.User;

@RequestScoped
public class LoginRepository implements ILoginRepository{

	private EntityManager manager;
	
	@Deprecated
	public LoginRepository() {
		this(null);
	}
	
	@Inject
	public LoginRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public User getUser(User user) throws NoResultException{
		User dbuser = null;
		
		String queryString = "select u from User u where u.email = :email and u.password = :password";
		TypedQuery<User> query = manager.createQuery(queryString, User.class);
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		dbuser = query.getSingleResult();
		
		return dbuser;
	}

}