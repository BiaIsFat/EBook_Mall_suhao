package service;

import javabean.Recharge;
import javabean.User;

public interface IInfoManagerService {
	boolean updateUserInfo(String user_id,User user);//修改信息
	
	User showUserInfo(String user_id);//显示读者信息
	
	boolean recharge(String user_id,double amount);//充值
	
	User getUserInfo(String user_tel);//根据电话号码找用户
	
}
