package javabean;

public class Manager {
	private String id;
	private String pass;
	public Manager() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Manager(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	
}
