package com.revature.oop.models;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

	private int id;
	private String description;
	private boolean completed;
	private LocalDate dueDate;
	private User userAssigned; //oop way has A relationship
//	private int userIdAssigned; not the "OOP way"
	
	public Task() {
		//super() => to the Object class constructor
		dueDate = LocalDate.now().plusDays(5);
		description = "None provided";
	}

	public Task(String description) {
		this(); // example of constructor chaining, this one invokes the no-args constructor
				// before executing this constructor's logic
		this.description = description;
	}

	public void doTask() {
		System.out.println("Doing a task.");
	}

	public void doTask(String speed) {
		System.out.println("Doing a task.");
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		if (dueDate.isBefore(LocalDate.now())) {
			System.out.println("Date cannot be before now.");
		} else {
			this.dueDate = dueDate;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserAssigned() {
		return userAssigned;
	}

	public void setUserAssigned(User userAssigned) {
		this.userAssigned = userAssigned;
	}


}