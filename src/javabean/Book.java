package javabean;

import java.sql.Timestamp;

public class Book {
	private String id;
	private Author author;
	private String name;
	private String des;
	private String type;
	private Timestamp date;
	private int state;
	private String img;
	public Book() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Book(String id, Author author, String name, String des, String type, Timestamp date, int state, String img) {
		super();
		this.id = id;
		this.author = author;
		this.name = name;
		this.des = des;
		this.type = type;
		this.date = date;
		this.state = state;
		this.img = img;
	}
	
}
