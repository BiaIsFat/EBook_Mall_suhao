package service;

import java.sql.Connection;
import java.sql.SQLException;

import DbUtils.DbUtils;
import DbUtils.Utils;
import dao.IRechargeDao;
import dao.IUserDao;
import dao.RechargeDaoImpl;
import dao.UserDaoImpl;
import javabean.Recharge;
import javabean.User;

public class InfoManagerServiceImpl implements IInfoManagerService {
	private IUserDao ud=null;
	private IRechargeDao rd=null;
	public InfoManagerServiceImpl() {
		ud=new UserDaoImpl();
		rd=new RechargeDaoImpl();
	}
	@Override
	public boolean updateUserInfo(String user_id,User user) {
		Connection con=DbUtils.getConnection();
		boolean flag=ud.UpdateUserInfo(con,user_id, user);
		DbUtils.close();
		return flag;
	}

	@Override
	public User showUserInfo(String user_id) {
		Connection con=DbUtils.getConnection();
		User user= ud.queryUser(con,user_id);
		DbUtils.close();
		return user;
	}

	@Override
	public boolean recharge(String user_id,double amount) {
		Connection con=DbUtils.getConnection();
		boolean result=false;
		try {
			con.setAutoCommit(false);
			boolean flag=ud.recharge(con,user_id, amount);
			if(flag) {
				User user=ud.queryUser(con,user_id);
				Recharge recharge=new Recharge();
				recharge.setAmount(amount);
				recharge.setUser(user);
				recharge.setTime(Utils.getNowTime());
				result=rd.addRecharge(con, recharge);
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
		
		
		
		
	}
	@Override
	public User getUserInfo(String user_tel) {
		Connection con=DbUtils.getConnection();
		User user=ud.queryUserByTel(con, user_tel);
		DbUtils.close();
		return user;
	}

}
