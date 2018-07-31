package br.com.myTasks.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.myTasks.interfaces.ISession;
import br.com.myTasks.models.entityes.User;

@SessionScoped
@Named("session")
public class Session implements Serializable, ISession {

	private static final long serialVersionUID = 1L;
	private User user;
	
	@Override
	public void login(User user) {
		this.user = user;
	}
	
	@Override
	public void logout() {
		user = null;
	}
	
	@Override
	public User getUser() {
		return user;
	}

	@Override
	public boolean isLogged() {
		return this.user != null;
	}
	
}
