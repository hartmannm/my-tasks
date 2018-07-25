package br.com.myTasks.models.entityes;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;

@SessionScoped
@Named("userLogged")
public class LoggedUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private User user;

	public void setUser(User user) {
		this.user = user;
	}
	
	public Long getId() {
		return this.user.getId();
	}
	
	public String getName() {
		return this.user.getName();
	}
	
	public boolean isLogged() {
		return user == null;
	}
	
}
