package com.webapplication.firstWebApplication.todo;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	private int id;
	private String username;
//    @Size(min = 8, message = "Password must be at least 8 characters long")
	private String description;
	private LocalDate targeDate;
	private boolean done;
	
	public Todo(int id, String username, String description, LocalDate targeDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targeDate = targeDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargeDate() {
		return targeDate;
	}

	public void setTargeDate(LocalDate targeDate) {
		this.targeDate = targeDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targeDate=" + targeDate
				+ ", done=" + done + "]";
	}

	public Todo() {
		super();
	}
	
}
