package javabean;

import java.sql.Timestamp;

public class Read {
	private Timestamp time;
	private User user;
	private Chapter chapter;
	public Read() {
	
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public Read(Timestamp time, User user, Chapter chapter) {
		super();
		this.time = time;
		this.user = user;
		this.chapter = chapter;
	}
	
}
