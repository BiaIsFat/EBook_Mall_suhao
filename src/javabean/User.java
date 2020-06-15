package javabean;


public class User {
	private String id;
	private String name;
	private String pass;
	private String tel;
	private String addr;
	private double balan;
	private int IsVip;
	private int state;
	public User() {
		
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
	public int getIsVip() {
		return IsVip;
	}
	public void setIsVip(int isVip) {
		IsVip = isVip;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User(String id, String name, String pass, String tel, String addr, double balan, int isVip, int state) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.tel = tel;
		this.addr = addr;
		this.balan = balan;
		IsVip = isVip;
		this.state = state;
	}
	
	
}
