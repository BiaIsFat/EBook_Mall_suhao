package javabean;

import java.util.ArrayList;
import java.util.List;

public class Author {
	private String id;
	private String name;
	private String pass;
	private String tel;
	private String addr;
	private double balan;
	private String brief;
	private List<Book> lists;
	public Author() {
		this.lists=new ArrayList<>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public double getBalan() {
		return balan;
	}
	public void setBalan(double balan) {
		this.balan = balan;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public List<Book> getLists() {
		return lists;
	}
	public void setLists(List<Book> lists) {
		this.lists = lists;
	}
	
	public Author(String id, String name, String pass, String tel, String addr, double balan, String brief) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.tel = tel;
		this.addr = addr;
		this.balan = balan;
		this.brief = brief;
	}
	
	
}
