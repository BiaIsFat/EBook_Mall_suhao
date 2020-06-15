package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Reward;

public interface IRewardDao {
	boolean addReward(Connection con,Reward reward);//增加打赏记录
	
	List<Reward> queryUserReward(Connection con,String user_id);//查询某用户的打赏记录
	
	List<Reward> queryAuthorReward(Connection con,String user_id);//查询某作家的打赏记录
	
	List<Reward> queryAllReward(Connection con);
	
	
}
