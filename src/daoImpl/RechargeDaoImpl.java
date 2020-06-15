package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Recharge;
import javabean.User;

public class RechargeDaoImpl implements IRechargeDao {

	@Override
	public boolean addRecharge(Connection con,Recharge recharge) {
		boolean flag=false;
		String sql="insert into recharge values(?,?,?)";
		Object[] param= {recharge.getUser().getId(),recharge.getTime(),recharge.getAmount()};
		flag=DbUtils.executeUpdate(con,sql,param);
		return flag;
	}

	@Override
	public List<Recharge> queryRechrge(Connection con,String id) {
		ResultSet rs=null;
		List<Recharge> list=new ArrayList<>();
		IUserDao userdao=new UserDaoImpl();
		try {
			String sql="select * from recharge where user_id=?";
			Object[] param={id};
			rs=DbUtils.executeQuery(con,sql,param);
			while(rs.next())
			{
				//通过查询获得用户id充值时间充值金额
				String user_id=rs.getString("user_id");
				Timestamp recharge_time=rs.getTimestamp("recharge_time");
				double recharge_amount=rs.getDouble("recharge_amount");
				//实例化一个UserDao对象，返回一个User对象
				User user=userdao.queryUser(con,user_id);
				//实例化一个Rechargerecord对象
				Recharge recharge=new Recharge();
				recharge.setUser(user);
				recharge.setAmount(recharge_amount);
				recharge.setTime(recharge_time);
				//插入到数组中
				list.add(recharge);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//返回list数组
		return list;
	}

	@Override
	public List<Recharge> queryRechargeAll(Connection con) {
		ResultSet rs=null;
		List<Recharge> list=new ArrayList<>();
		IUserDao userdao=new UserDaoImpl();
		try {
			String sql="select * from recharge";
			rs=DbUtils.executeQuery(con,sql,null);
			while(rs.next())
			{
				//通过查询获得用户id充值时间充值金额
				String user_id=rs.getString("user_id");
				Timestamp recharge_time=rs.getTimestamp("recharge_time");
				double recharge_amount=rs.getDouble("recharge_amount");
				//实例化一个UserDao对象，返回一个User对象
				User user=userdao.queryUser(con,user_id);
				//实例化一个Rechargerecord对象
				Recharge recharge=new Recharge();
				recharge.setUser(user);
				recharge.setAmount(recharge_amount);
				recharge.setTime(recharge_time);
				//插入到数组中
				list.add(recharge);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//返回list数组
		return list;
	}

}
