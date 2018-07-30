package br.com.myTasks.models.entityes;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@RequestScoped
@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	@Basic(optional = false)
	@Column(nullable = false, length = 50)
	private String name;

	@Basic(optional = false)
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate date;

	@Basic(optional = true)
	@Column(nullable = true, columnDefinition = "TIME")
	private LocalTime hour;

	@Basic(optional = true)
	@Column(nullable = true, length = 100)
	private String details;

	@Basic(optional = false)
	@Column(nullable = false)
	private boolean finished = false;

	@Basic(optional = false)
	@ManyToOne
	private User user;

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
