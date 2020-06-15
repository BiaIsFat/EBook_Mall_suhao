package service;

import java.util.List;

import javabean.User;

public interface IM_UserManagerSerice {
	User showUserInfo(String user_id);//根据用户id显示用户信息
	
	boolean illegalExecute(String user_id);//处理违规人员将其拉黑
	
	List<User> showIllegalUser();//显示所有违规的人员
	
	boolean privateletterUser(String user_id);
}
