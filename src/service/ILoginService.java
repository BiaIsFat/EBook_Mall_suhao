package service;

import javabean.Author;
import javabean.Manager;
import javabean.User;

public interface ILoginService {
	boolean userLogin(User user);//用户登入
	
	int userSignup(User user);//用户注册
	
	Author AuthorLogin(Author author);//作者登入
	
	int AuthorSignup(Author author);//作者注册
	
	boolean ManagerLogin(Manager manager);//管理员登入
	
}
