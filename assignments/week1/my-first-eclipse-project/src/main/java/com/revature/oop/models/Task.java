package com.revature.oop.models;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

	private String description;
	private boolean completed;
	private LocalDate dueDate;

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

	@Override
	public String toString() {
		return "Task [description=" + description + ", completed=" + completed + ", dueDate=" + dueDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(completed, description, dueDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return completed == other.completed && Objects.equals(description, other.description)
				&& Objects.equals(dueDate, other.dueDate);
	}
}