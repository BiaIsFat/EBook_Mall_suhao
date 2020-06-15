package javabean;

import java.sql.Timestamp;

public class Message {
	private User user;
	private Author author;
	private String context;
	private Timestamp time;
	public Message() {
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Message(User user, Author author, String context, Timestamp time) {
		super();
		this.user = user;
		this.author = author;
		this.context = context;
		this.time = time;
	}
	
}
