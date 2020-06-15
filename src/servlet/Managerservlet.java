package servlet;

import java.io.IOException;
import java.sql.*;
import java.text.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbUtils.Utils;
import javabean.Board;
import javabean.Manager;
import javabean.User;
import service.BoardManagerServiceImpl;
import service.BookManagerServiceImpl;
import service.LoginServiceImpl;
import service.RecordManagerServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class Managerservlet
 */
@WebServlet("/Managerservlet")
public class Managerservlet extends baseservlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see baseservlet#baseservlet()
     */
    public Managerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //所有阅读记录
	public void allreadrecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String option =request.getParameter("option");
		 RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		 request.setAttribute("alllist",rmsi.showReadRecord());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./readrecord.jsp").forward(request, response);
			
		 
	}
	//某个用户的阅读记录
	public void readrecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String user_id=request.getParameter("user_id");
		RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		if(user_id=="")
    	{
    	    option="allreadrecord";
    		request.setAttribute("alllist",rmsi.showReadRecord());
    		request.setAttribute("option",option);
    		
    	}
		else
    	{
    	    if(rmsi.showReadRecord(user_id).size()<=0)
            {
          	  String m="该用户不存在或该用户暂且没有阅读记录";
          	  request.setAttribute("m", m);
          	  
            }
    		request.setAttribute("list", rmsi.showReadRecord(user_id));
			request.setAttribute("option",option);
			
    	}
		request.getRequestDispatcher("./readrecord.jsp").forward(request, response);
	}
	//所有用户的充值记录
	public void allrechargerecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String option=request.getParameter("option");
		RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		request.setAttribute("alllist",rmsi.showReChargeRecord());
		request.setAttribute("option",option);
		request.getRequestDispatcher("./rechargerecord.jsp").forward(request, response);
	}
	//某个用户的充值记录
	public void rechargerecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String user_id=request.getParameter("user_id");
		RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		if(user_id=="")
    	{
    	    option="allrechargerecord";
    		request.setAttribute("alllist",rmsi.showReChargeRecord());
    		request.setAttribute("option",option);
    		
    	}
		else
    	{
    	    if(rmsi.showReChargeRecord(user_id).size()<=0)
            {
          	  String m="该用户不存在或该用户暂且没有充值记录";
          	  request.setAttribute("m", m);
          	  
            }
    		request.setAttribute("list", rmsi.showReChargeRecord(user_id));
			request.setAttribute("option",option);
			
    	}
		request.getRequestDispatcher("./rechargerecord.jsp").forward(request, response);
	}
	//所有的打赏记录
	public void allrewardrecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String option =request.getParameter("option");
		 RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		 request.setAttribute("alllist",rmsi.showRewardRecord());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./rewardrecord.jsp").forward(request, response);
	}
	//某个用户的打赏记录
	public void rewardrecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String user_id=request.getParameter("user_id");
		RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		if(user_id=="")
    	{
    	    option="allrewardrecord";
    		request.setAttribute("alllist",rmsi.showRewardRecord());
    		request.setAttribute("option",option);
    		
    	}
		else
    	{
    	    if(rmsi.showRewardRecord(user_id).size()<=0)
            {
          	  String m="该用户不存在或该用户暂且没有打赏记录";
          	  request.setAttribute("m", m);
          	  
            }
    		request.setAttribute("list", rmsi.showRewardRecord(user_id));
			request.setAttribute("option",option);
			
    	}
		request.getRequestDispatcher("./rewardrecord.jsp").forward(request, response);
	}
	//查找所有的评论记录
	public void allevaluaterecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String option =request.getParameter("option");
		 RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		 request.setAttribute("alllist",rmsi.showEvaluateRecord());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./evaluaterecord.jsp").forward(request, response);
	}
	//某个用户的评论记录
	public void evaluaterecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String user_id=request.getParameter("user_id");
		RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		if(user_id=="")
    	{
    	    option="allevaluaterecord";
    		request.setAttribute("alllist",rmsi.showEvaluateRecord());
    		request.setAttribute("option",option);
    		
    	}
		else
    	{
    	    if(rmsi.showEvaluateRecord(user_id).size()<=0)
            {
          	  String m="该用户不存在或该用户暂且没有评论记录";
          	  request.setAttribute("m", m);
          	  
            }
    		request.setAttribute("list", rmsi.showEvaluateRecord(user_id));
			request.setAttribute("option",option);
			
    	}
		request.getRequestDispatcher("./evaluaterecord.jsp").forward(request, response);
	}
	public void allchapterrecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String option =request.getParameter("option");
		 RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		 request.setAttribute("alllist",rmsi.showChapterRecord());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./chapterrecord.jsp").forward(request, response);
	}
	public void chapterrecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String book_id=request.getParameter("book_id");
		RecordManagerServiceImpl rmsi=new RecordManagerServiceImpl();
		if(book_id=="")
    	{
    	    option="allchapterrecord";
    		request.setAttribute("alllist",rmsi.showChapterRecord());
    		request.setAttribute("option",option);
    		
    	}
		else
    	{
    	    if(rmsi.showChapterRecord(book_id).size()<=0)
            {
          	  String m="该图书不存在";
          	  request.setAttribute("m", m);
          	  
            }
    		request.setAttribute("list", rmsi.showChapterRecord(book_id));
			request.setAttribute("option",option);
			
    	}
		request.getRequestDispatcher("./chapterrecord.jsp").forward(request, response);
	}
	//增加公告
	public void addboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String board_context=request.getParameter("context");
		 String board_id=Utils.getTimeId();
		 Timestamp timestamp=Utils.getNowTime();
		 System.out.println(board_context+" "+board_id+" "+timestamp);
		 Board board=new Board();
		 board.setId(board_id);
		 board.setContext(board_context);
		 board.setDate(timestamp);
		 BoardManagerServiceImpl bmsi=new BoardManagerServiceImpl();
		 boolean flag=bmsi.addBoard(board);
		 if(flag==true)
		 {
			 String m="发布成功";
			 request.setAttribute("m",m);
		 }
		 else
		 {
			 String m="发布失败";
			 request.setAttribute("m",m);
		 }
		 String option="allsearchboard";
		 request.setAttribute("alllist",bmsi.queryAllBoard());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./board.jsp").forward(request, response);
	 
	}
	//删除公告
	public void deleteboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_id=request.getParameter("board_id");
		BoardManagerServiceImpl bmsi=new BoardManagerServiceImpl();
		boolean flag=bmsi.removeBoard(board_id);
		 if(flag==true)
		 {
			 String m="删除成功";
			 request.setAttribute("m",m);
		 }
		 else
		 {
			 String m="删除失败";
			 request.setAttribute("m",m);
		 }
		 String option="allsearchboard";
		 request.setAttribute("alllist",bmsi.queryAllBoard());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./board.jsp").forward(request, response);
	}
	//修改公告
	public void modifyboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_id=request.getParameter("board_id");
		String board_context=request.getParameter("context");
		System.out.println(board_id+" "+board_context);
		Timestamp timestamp=Utils.getNowTime();
		 Board board=new Board();
		 board.setId(board_id);
		 board.setContext(board_context);
		 board.setDate(timestamp);
		 BoardManagerServiceImpl bmsi=new BoardManagerServiceImpl();
		 boolean flag=bmsi.motifyBoard(board_id, board);
		 if(flag==true)
		 {
			 String m="修改成功";
			 request.setAttribute("m",m);
		 }
		 else
		 {
			 String m="修改失败";
			 request.setAttribute("m",m);
		 }
		 String option="allsearchboard";
		 request.setAttribute("alllist",bmsi.queryAllBoard());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./board.jsp").forward(request, response);
	}
	//查询公告
	public void allsearchboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String option =request.getParameter("option");
		 BoardManagerServiceImpl bmsi=new BoardManagerServiceImpl();
		 request.setAttribute("alllist",bmsi.queryAllBoard());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./board.jsp").forward(request, response);
	}
	public void searchboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String board_id=request.getParameter("board_id");
		BoardManagerServiceImpl bmsi=new BoardManagerServiceImpl();
		if(board_id=="")
    	{
    	    option="allsearchboard";
    		request.setAttribute("alllist",bmsi.queryAllBoard());
    		request.setAttribute("option",option);
    		
    	}
		else
    	{
    	    if(bmsi.queryBoard(board_id)==null)
            {
          	 String m="输入的公告id有误";
          	 request.setAttribute("m", m);
          	 option="alllist";
     		 request.setAttribute("alllist",bmsi.queryAllBoard()); 
            }
    		request.setAttribute("board", bmsi.queryBoard(board_id));
			request.setAttribute("option",option);
			
    	}
		request.getRequestDispatcher("./board.jsp").forward(request, response);
	}
	//显示所有申请下架的图书
	public void allsoldoutbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String option =request.getParameter("option");
		 BookManagerServiceImpl book=new BookManagerServiceImpl();
		 request.setAttribute("alllist",book.queryAllBookApply());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./soldoutbook.jsp").forward(request, response);
	}
	//下架图书
	public void soldoutbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String book_id=request.getParameter("book_id");
		 BookManagerServiceImpl book=new BookManagerServiceImpl();
		 boolean flag=book.SoldOutBook(book_id);
		 if(flag==true)
		 {
			 String m="下架成功";
			 request.setAttribute("m",m);
		 }
		 else
		 {
			 String m="下架失败";
			 request.setAttribute("m",m);
		 }
		 String option="allsoldoutbook";
		 request.setAttribute("alllist",book.queryAllBookApply());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./soldoutbook.jsp").forward(request, response);
	}
	//显示所有违规用户
	public void allillegaluser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String option =request.getParameter("option");
		 UserServiceImpl user=new UserServiceImpl();
		 request.setAttribute("alllist",user.showIllegalUser());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./blockuser.jsp").forward(request, response);
	}
	//拉黑用户
	public void excuteuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String user_id=request.getParameter("user_id");
	     UserServiceImpl user=new UserServiceImpl();
	     boolean flag=user.illegalExecute(user_id);
	     if(flag==true)
		 {
			 String m="拉黑成功";
			 request.setAttribute("m",m);
		 }
		 else
		 {
			 String m="拉黑失败";
			 request.setAttribute("m",m);
		 }
		 String option="allillegaluser";
		 request.setAttribute("alllist",user.showIllegalUser());
		 request.setAttribute("option",option);
		 request.getRequestDispatcher("./blockuser.jsp").forward(request, response);
	}
	//管理员登陆
	public void checkmanager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String manager_id=request.getParameter("manager_id");
	    String manager_password=request.getParameter("manager_password");
	    LoginServiceImpl login=new LoginServiceImpl();
	    Manager manager=new Manager();
	    manager.setId(manager_id);
	    manager.setPass(manager_password);
	    boolean flag=login.ManagerLogin(manager);
	    if(flag==true)
	    {
	    	request.getRequestDispatcher("./index.jsp").forward(request, response);
	    }
	    if(flag==false)
	    {
	    	String m="登陆失败，用户名或密码错误";
	    	request.setAttribute("m",m);
	    	request.getRequestDispatcher("./managerlogin.jsp").forward(request, response);
	    }
	}
	//私信读者
	public void privateletteruser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String user_id=request.getParameter("user_id");
	    
	}
}
