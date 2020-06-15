package dao;

import java.sql.Connection;

import javabean.Manager;

public interface IManagerDao {
	boolean IsExist(Connection con,String Manager_id);
	
	boolean addManager(Connection con,Manager manager);
	
	boolean checkManager(Connection con,Manager manager);
}
