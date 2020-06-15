package javabean;
import java.sql.*;
public class BookShelf {
	private User user;
	private Book book;
	private Timestamp date;
	public BookShelf() {
		
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
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public BookShelf(User user, Book book, Timestamp date) {
		super();
		this.user = user;
		this.book = book;
		this.date = date;
	}
	
	
}
