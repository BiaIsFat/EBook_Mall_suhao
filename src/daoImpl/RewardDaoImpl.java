package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Book;
import javabean.Reward;
import javabean.User;

public class RewardDaoImpl implements IRewardDao {

	@Override
	public boolean addReward(Connection con,Reward reward) {//新增
		boolean flag=false;
		String sql="insert into reward(user_id,book_id,reward_time,reward_amount) values(?,?,?,?)";
		Object[] param= {reward.getUser().getId(),reward.getBook().getId(),reward.getTime(),reward.getAmount()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public List<Reward> queryUserReward(Connection con,String user_id) {
		IUserDao userdao=new UserDaoImpl();
		IBookDao bookdao=new BookDaoImpl();
		List<Reward> list=new ArrayList<>();
		try {
			ResultSet rs=null;
			String sql="select * from reward where user_id=?";
			Object[] param= {user_id};
			rs=DbUtils.executeQuery(con, sql, param);
			while(rs.next())
			{
				String userid=rs.getString("user_id");
				String book_id=rs.getString("book_id");
				Timestamp reward_time=rs.getTimestamp("reward_time");
				double reward_amount=rs.getDouble("reward_amount");
					
				User user=userdao.queryUser(con,userid);
					
				Book book=bookdao.queryBookDetail(con,book_id);
				Reward reward=new Reward();
				reward.setUser(user);
				reward.setBook(book);
				reward.setAmount(reward_amount);
				reward.setTime(reward_time);
				list.add(reward);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Reward> queryAuthorReward(Connection con,String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reward> queryAllReward(Connection con){
		IUserDao userdao=new UserDaoImpl();
		IBookDao bookdao=new BookDaoImpl();
		List<Reward> list=new ArrayList<>();
		try {
			ResultSet rs=null;
			String sql="select * from reward";
			rs=DbUtils.executeQuery(con, sql, null);
			while(rs.next())
			{
				String user_id=rs.getString("user_id");
				String book_id=rs.getString("book_id");
				Timestamp reward_time=rs.getTimestamp("reward_time");
				double reward_amount=rs.getDouble("reward_amount");
					
				User user=userdao.queryUser(con,user_id);
					
				Book book=bookdao.queryBookDetail(con,book_id);
				Reward reward=new Reward();
				reward.setUser(user);
				reward.setBook(book);
				reward.setAmount(reward_amount);
				reward.setTime(reward_time);
				list.add(reward);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

}
