package javabean;

import java.sql.Timestamp;

public class Board {
	private String id;
	private Timestamp date;
	private String context;
	public Board() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Board(String id, Timestamp date, String context) {
		super();
		this.id = id;
		this.date = date;
		this.context = context;
	}
	
	
}
