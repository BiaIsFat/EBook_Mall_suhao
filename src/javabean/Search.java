package javabean;

import java.sql.Timestamp;

public class Search {
	private User user;
	private Book book;
	private Timestamp time;
	public Search() {
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Search(User user, Book book, Timestamp time) {
		super();
		this.user = user;
		this.book = book;
		this.time = time;
	}
	
	
}
