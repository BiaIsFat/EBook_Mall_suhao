package javabean;

import java.sql.Timestamp;

public class Illegal {
	private User user;
	private String context;
	private Timestamp time;
	public Illegal() {
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Illegal(User user, String context, Timestamp time) {
		super();
		this.user = user;
		this.context = context;
		this.time = time;
	}
	
	
	
}
