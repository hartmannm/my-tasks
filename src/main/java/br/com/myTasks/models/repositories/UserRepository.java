package br.com.myTasks.models.repositories;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.myTasks.interfaces.IUserRepository;
import br.com.myTasks.models.entityes.User;

@RequestScoped
public class UserRepository implements IUserRepository{

	private EntityManager em;
	
	@Deprecated
	public UserRepository() {
		this(null);
	}
	
	@Inject
	public UserRepository(EntityManager em) {
		this.em = em;
		
	}
	
	@Override
	public void createUser(User user) {
		System.out.println("repositorio");
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
		
	}

}
