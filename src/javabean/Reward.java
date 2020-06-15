package javabean;

import java.sql.Timestamp;

public class Reward {
	private User user;
	private Book book;
	private Timestamp time;
	private double amount;
	public Reward() {
		
	}
	public Reward(User user, Book book, Timestamp time, double amount) {
		super();
		this.user = user;
		this.book = book;
		this.time = time;
		this.amount = amount;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
