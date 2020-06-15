package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtils.DbUtils;
import javabean.Manager;

public class ManagerDaoImpl implements IManagerDao {

	@Override
	public boolean IsExist(Connection con,String manager_id) {
		boolean flag=false;
		try {
			String sql="select * from Manager where manager_id=?";
			Object[] param= {manager_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean addManager(Connection con,Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkManager(Connection con,Manager manager) {
		boolean flag=false;
		try {
			String sql="select * from Manager where manager_id=? and manager_pass=?";
			Object[] param= {manager.getId(),manager.getPass()};
			ResultSet rs=DbUtils.executeQuery(con, sql, param);
			if(rs!=null){
				if(rs.next()){
					flag=true;
				}
			}
			
		}catch(Exception e)
		{
			// TODO Auto-generated catch block
		    e.printStackTrace();
		}
		return flag;
	}
}
