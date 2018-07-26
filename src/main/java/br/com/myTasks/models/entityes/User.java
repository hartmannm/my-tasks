package br.com.myTasks.models.entityes;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@RequestScoped
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Basic(optional=false)
	@Column(nullable = false, length=50)
	private String name;
	
	@Basic(optional=false)
	@Column(nullable = false, length=50, unique=true)
	private String email;
	
	@Basic(optional=false)
	@Column(nullable = false, length=50)
	private String password;
	
	@Transient
	private String passwordConfirm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
