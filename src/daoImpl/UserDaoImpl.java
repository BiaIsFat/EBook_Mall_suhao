package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public boolean isExsit(Connection con,String user_id) {
		boolean flag=false;
		try {
			String sql="select * from User where user_id=user_id";
			Object[] param= {user_id};
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
	public boolean isTelExist(Connection con,String user_tel) {
		boolean flag=false;
		try {
			String sql="select * from User where user_tel=?";
			Object[] param= {user_tel};
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
	public boolean addUser(Connection con,User user) {
		boolean flag=false;
		String sql="insert into user(user_id,user_pass,user_tel) values(?,?,?)";
		Object[] param={user.getId(),user.getPass(),user.getTel()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}


	@Override
	/*public boolean checkUser(User user) {
		boolean flag=false;
		Connection con=null;
		try {
			con=DbUtils.getConnection();
			String sql="select * from User where user_id=? and user_pass=?";
			Object[] param={user.getId(),user.getPass()};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.close(con, null, null);
		}
		return flag;
	}*/
	public boolean checkUser(Connection con,User user) {
		boolean flag=false;
		try {
			String sql="select * from User where user_tel=? and user_pass=?";
			Object[] param={user.getTel(),user.getPass()};
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
	public User queryUser(Connection con,String id) {
		User user=null;
		try {
			String sql="select * from user where user_id=?";
			Object[] param={id};
			ResultSet res=DbUtils.executeQuery(con, sql, param);
			if(res!=null){
				while(res.next()){
					user=new User();
					user.setId(res.getString("user_id"));
					user.setName(res.getString("user_name"));
					user.setPass(res.getString("user_pass"));
					user.setTel(res.getString("user_tel"));
					user.setAddr(res.getString("user_addr"));
					user.setBalan(res.getDouble("user_balan"));
					user.setIsVip(res.getInt("IsVip"));
					user.setState(res.getInt("state"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public User queryUserByTel(Connection con,String user_tel) {
		User user=null;
		try {
			String sql="select * from user where user_tel=?";
			Object[] param={user_tel};
			ResultSet res=DbUtils.executeQuery(con, sql, param);
			if(res!=null){
				while(res.next()){
					user=new User();
					user.setId(res.getString("user_id"));
					user.setName(res.getString("user_name"));
					user.setPass(res.getString("user_pass"));
					user.setTel(res.getString("user_tel"));
					user.setAddr(res.getString("user_addr"));
					user.setBalan(res.getDouble("user_balan"));
					user.setIsVip(res.getInt("IsVip"));
					user.setState(res.getInt("state"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean UpdateUserInfo(Connection con,String user_id, User user) {
		boolean flag=false;
			String sql="update user set user_name=?,user_tel=?,user_addr=?where user_id=?";
			Object[] param= {user.getName(),user.getTel(),user.getAddr(),user_id};
			flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public boolean recharge(Connection con,String user_id, double amount) {
		boolean flag=false;
		String sql="update user set user_balan=user_balan+? where user_id=?;";
		Object[] param= {amount,user_id};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public boolean rewardBook(Connection con, String user_id,double amount) {
		boolean flag=false;
		String sql="update user set user_balan=user_balan-? where user_id=?;";
		Object[] param= {amount,user_id};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public boolean executeUser(Connection con,String user_id) {
		boolean flag=false;
		String sql="update user set state=0 where user_id=?";
		Object[] param= {user_id};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public List<User> queryAllIllegalUser(Connection con) {
		String sql="select * from illegaluser";
		ResultSet res=DbUtils.executeQuery(con, sql, null);
		User user=null;
		List<User> lists=new ArrayList<User>();
		try {
			while(res.next()) {
				user=new User();
				user.setId(res.getString("user_id"));
				user.setName(res.getString("user_name"));
				user.setPass(res.getString("user_pass"));
				user.setTel(res.getString("user_tel"));
				user.setAddr(res.getString("user_addr"));
				user.setBalan(res.getDouble("user_balan"));
				user.setIsVip(res.getInt("IsVip"));
				user.setState(res.getInt("state"));
				lists.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	

}
