package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Evaluate;

public interface IEvaluateDao {
	boolean addEvaluate(Connection con,Evaluate evalute); //增加评论
	
	boolean removeEvaluate(Connection con,Evaluate evalute);//删除评论
	
	List<Evaluate> queryEvaluate(Connection con,String book_id);//显示某本书的评论
	
	List<Evaluate> queryAllEvaluate(Connection con);//显示所有评论
	
	List<Evaluate> queryUserEvaluate(Connection con,String user_id);//显示某个用户的评论
	
	boolean  isContainIllegal(Connection con,String context);//是否含有违规的字符

	boolean updateState(Connection con, String evaluate_time);
	
	
	
}
