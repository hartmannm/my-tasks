package br.com.myTasks.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;;

public class EntityManagerProducer{

	@Produces
	@ApplicationScoped
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("my_tasks");
	}

	@RequestScoped
	@Produces
	public EntityManager getEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	public void closeFactory(@Disposes EntityManagerFactory factory) {
		factory.close();
	}

	public void closeManager(@Disposes EntityManager manager) {
		manager.close();	
	}
	
}