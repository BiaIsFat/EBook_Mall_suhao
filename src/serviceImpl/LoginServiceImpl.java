package service;

import java.sql.Connection;

import DbUtils.DbUtils;
import dao.AuthorDaoImpl;
import dao.IAuthorDao;
import dao.IManagerDao;
import dao.IUserDao;
import dao.ManagerDaoImpl;
import dao.UserDaoImpl;
import javabean.Author;
import javabean.Manager;
import javabean.User;

public class LoginServiceImpl implements ILoginService {
	private IUserDao ud=null;
	private IAuthorDao ad=null;
	private IManagerDao md=null;
	public LoginServiceImpl() {
		ud=new UserDaoImpl();
		ad=new AuthorDaoImpl();
		md=new ManagerDaoImpl();
	}
	@Override
	public boolean userLogin(User user) { //用户登入
		boolean flag=false;
		Connection con=DbUtils.getConnection();
		boolean isUser=ud.isTelExist(con,user.getTel());
		if(isUser){
			flag=ud.checkUser(con,user);
		}
		DbUtils.close();
		return flag;
	}
	@Override
	public int userSignup(User user) { //用户注册
		Connection con=DbUtils.getConnection();
		boolean isUser=ud.isTelExist(con,user.getTel()); //用户是否存在
		int flag=0;
		if(!isUser) { //如果用户不存在
			boolean success=ud.addUser(con, user); 
			if(success) {
				flag=2; //出册成功
			}else {
				return flag;
			}
		}else {
			flag=1;
		}
		DbUtils.close();
		return flag;
	}
	@Override
	public Author AuthorLogin(Author author) { //作者登入
		Connection con=DbUtils.getConnection();
		boolean flag=false;
		Author author1=null;
		boolean isAuthor=ad.isExistAuthor(con,author.getTel());
		if(isAuthor){
			flag=ad.checkAuthor(con,author);
			if(flag) {
				author1=ad.queryAuthorByTel(con, author.getTel());
			}
		}
		return author1;
	}
	@Override
	public int AuthorSignup(Author author) { //判断作者是否存在
		Connection con=DbUtils.getConnection();
		boolean isAuthor=ad.isExistAuthor(con,author.getTel());
		int flag=0;
		if(!isAuthor) {
			boolean success=ad.checkAuthor(con,author);
			if(success) {
				flag=2;
			}
		}else {
			flag=1;
		}
		DbUtils.close();
		return flag;
	}
	@Override
	public boolean ManagerLogin(Manager manager) { //管理员登入
		Connection con=DbUtils.getConnection();
		boolean flag=md.IsExist(con,manager.getId());
		if(flag) {
			return md.checkManager(con,manager);
		}
		DbUtils.close();
		return false;
	}
	
	
}
