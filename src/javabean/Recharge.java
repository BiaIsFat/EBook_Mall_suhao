package javabean;

import java.sql.Timestamp;

public class Recharge {
	private User user;
	private double amount;
	private Timestamp time;
	public Recharge() {
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Recharge(User user, double amount, Timestamp time) {
		super();
		this.user = user;
		this.amount = amount;
		this.time = time;
	}
	
	
}
