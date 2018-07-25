package br.com.myTasks.interceptors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.myTasks.annotations.DataBaseAccess;

@AcceptsWithAnnotations(DataBaseAccess.class)
@RequestScoped
@Intercepts
public class TransactionInterceptor {

	private EntityManager manager;
	
	@Deprecated
	public TransactionInterceptor() {
		this(null);
	}
	
	@Inject
    public TransactionInterceptor(EntityManager manager) {
		this.manager = manager;
	}
    
    @AroundCall
    public void manageTransaction(SimpleInterceptorStack stack) {
    	try {
    		manager.getTransaction().begin();
        	stack.next();
        	manager.getTransaction().commit();
    	} finally {
    		if(manager.getTransaction().isActive()) {
    			manager.getTransaction().rollback();
    		}
    	}
    	
    }
    
    
}





