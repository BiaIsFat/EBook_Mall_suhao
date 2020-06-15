package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DbUtils.Utils;
import javabean.User;
import service.IInfoManagerService;
import service.ILoginService;
import service.InfoManagerServiceImpl;
import service.LoginServiceImpl;
import service.MessageServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends baseservlet {
	private static final long serialVersionUID = 1L;
   
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_tel=request.getParameter("user_tel");
		String user_pass=request.getParameter("user_pass");
		User user=new User();
		user.setTel(user_tel);
		user.setPass(user_pass);
		ILoginService ls=new LoginServiceImpl();
		IInfoManagerService ims=new InfoManagerServiceImpl();
		boolean flag=ls.userLogin(user);
		if(flag) {
			HttpSession session=request.getSession();
			User user1=ims.getUserInfo(user_tel);
			session.setAttribute("user", user1);
			response.sendRedirect("user_index.jsp"); //测试登入
		}else {
			request.setAttribute("login_error","登入失败");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
    
    
    public void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_tel=request.getParameter("user_tel");
		String user_pass=request.getParameter("user_pass");
		String user_id=Utils.getTimeId();
		User user=new User();
		user.setId(user_id);
		user.setTel(user_tel);
		user.setPass(user_pass);
		ILoginService ls=new LoginServiceImpl();
		int flag=ls.userSignup(user);
		if(flag==2) {
			response.sendRedirect("login.jsp");
		}
		else{
			if(flag==1) {
				request.setAttribute("signup_error","该号码已被注册");
			}else if(flag==0){
				request.setAttribute("signup_error", "注册失败");
			}
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}
    
    public void UpdateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String user_id=request.getParameter("user_id");//获取yonghu信息
    	String user_name=request.getParameter("user_name");
    	String user_tel=request.getParameter("user_tel");
		String user_addr=request.getParameter("user_addr");
		User user=new User();
		user.setName(user_name);
		user.setTel(user_tel);
		user.setAddr(user_addr);
		user.setId(user_id);
		InfoManagerServiceImpl a=new InfoManagerServiceImpl();
		//HttpSession session=request.getSession(false);
		//User _user=(User) session.getAttribute("user");
		//String user_id=_user.getId();
		boolean flag = a.updateUserInfo(user_id,user);
		if(flag) {
			request.setAttribute("info_error", "修改成功");
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}else {
			request.setAttribute("info_error", "修改失败");
			request.getRequestDispatcher("./modify.jsp").forward(request, response);
		}
		
	}
    
    public void queryUserMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { //获取用户信息
		String user_id = request.getParameter("user_id");
		MessageServiceImpl ms = new MessageServiceImpl();
		List<Message> list = ms.queryUserMessage(user_id);
		request.setAttribute("list", list);
		request.getRequestDispatcher("show1.jsp").forward(request, response);

	}

}
