package service;

import java.sql.Connection;
import java.util.List;

import DbUtils.DbUtils;
import dao.IUserDao;
import dao.UserDaoImpl;
import javabean.User;

public class UserServiceImpl implements IM_UserManagerSerice {
	private IUserDao ud=null;
	public UserServiceImpl() {
		ud=new UserDaoImpl();
	}
	@Override
	public User showUserInfo(String user_id) {
		Connection con=DbUtils.getConnection();
		User user= ud.queryUser(con,user_id);
		DbUtils.close();
		return user;
	}

	@Override
	public boolean illegalExecute(String user_id) {
		Connection con=DbUtils.getConnection();
		boolean flag=ud.executeUser(con, user_id);
		DbUtils.close();
		return flag;
	}

	@Override
	public List<User> showIllegalUser() {
		Connection con=DbUtils.getConnection();
		List<User> lists=ud.queryAllIllegalUser(con);
		DbUtils.close();
		return lists;
		
	}
	@Override
	public boolean privateletterUser(String user_id) {
		Connection con=DbUtils.getConnection();
		boolean flag=ud.privateletter(con,user_id);
		DbUtils.close();
		return flag;
	}

}
