package com.ismailsamirusta.todoapp.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Todo {

	@Id
	@Field
	private String id;
	
	@Field
	@NotNull
	private String title;
	
	@Field
	@NotNull
	private String description;
	
	@Field
	private boolean complete;

	@Field
	@NotNull
	private Date created;
	
	@Field
	private Date updated;
	
	@Field
	private Date due;
	
	@Field
	@NotNull
	private String user;
	
	public Todo() {}
	
	public Todo(String title, String description, boolean complete,Date due) {
		this.title = title;
		this.description = description;
		this.complete = complete;
		this.due = due;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
}
