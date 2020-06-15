package dao;

import java.sql.Connection;
import java.util.List;

import javabean.User;

public interface IUserDao {
	boolean isExsit(Connection con,String id); //判断用户是否存在
	
	boolean addUser(Connection con,User user);  //增加用户
	
	boolean checkUser(Connection con,User user); //检查用户
	
	User queryUser(Connection con,String id);//查询用户
	
	User queryUserByTel(Connection con,String user_tel);//根据用户电话查询用户
	
	boolean isTelExist(Connection con,String tel);//用户电话是否存在（为注册服务）
	
	boolean UpdateUserInfo(Connection con,String user_id,User user);//修改信息
	
	boolean recharge(Connection con,String user_id,double amount);//充值
	
	boolean rewardBook(Connection con,String user_id,double amount);//打赏
	
	boolean executeUser(Connection con,String user_id);//将用户拉黑
	
	List<User> queryAllIllegalUser(Connection con);//显示所有的违规用户

	boolean privateletter(Connection con, String user_id);//私信读者
	
	
	
}
