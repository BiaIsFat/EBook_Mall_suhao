package javabean;

import java.sql.Timestamp;

public class Chapter {
	private Book book;
	private String id;
	private  String name;
	private double price;
	private Timestamp time;
	private String context;
	public Chapter() {
		
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getId() {
		return id;
	}
	public void setId(String chapter) {
		this.id = chapter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public void setContext(String context) {
		this.context=context;
	}
	public String getContext() {
		return this.context;
	}
	public Chapter(String chapter, String name, double price, Timestamp time) {
		super();
		this.id = chapter;
		this.name = name;
		this.price = price;
		this.time = time;
	}
	
	
}
