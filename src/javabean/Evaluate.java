package javabean;
import java.sql.Timestamp;
public class Evaluate {
	private User user;
	private Book book;
	private String context;
	private Timestamp time;
	private int state;
	public Evaluate(){
		
	}
	public Evaluate(User user, Book book, String context, Timestamp time, int state) {
		super();
		this.user = user;
		this.book = book;
		this.context = context;
		this.time = time;
		this.state = state;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
