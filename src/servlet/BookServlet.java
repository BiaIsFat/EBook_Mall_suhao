package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DbUtils.Utils;
import javabean.Book;
import javabean.BookShelf;
import javabean.Chapter;
import javabean.Evaluate;
import javabean.User;
import service.IU_ReadManagerService;
import service.IU_SearchMangerService;
import service.IU_ShelfManagerService;
import service.ReadManagerServiceImpl;
import service.SearchManagerServiceImpl;
import service.ShlefManagerServiceImpl;


@WebServlet("/BookServlet")
public class BookServlet extends baseservlet {
	private static final long serialVersionUID = 1L;
	private ReadManagerServiceImpl IU_s;
       
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //显示图书信息 准备阅读
    public void readBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession(false);
		String book_id=request.getParameter("book_id");
		Book book=new Book();
		IU_ReadManagerService rs=new ReadManagerServiceImpl();
		IU_ShelfManagerService sm=new ShlefManagerServiceImpl();
		Chapter chapter=null;
		if(session!=null) { //判断用户是否存在
			User user=(User) session.getAttribute("user");
			if(user!=null) {
				//System.out.println("sss");
				String user_id=user.getId(); //获得用户id
				book=rs.showBookDetail(user_id, book_id);//显示图书的具体信息
				System.out.println(book.getType());
				chapter=rs.isExistRead(user_id, book_id);//显示你之前读过的章节
				if(chapter!=null) {
					request.setAttribute("chapter_id",chapter.getId());
				}else {
					request.setAttribute("chapter_id","1");
					//Chapter chapterfirst=rs.queryfirstChapter(book_id);
					//session.setAttribute("chapterfirst",chapterfirst);
				}
				boolean flag=sm.isExistInShlef(user_id, book_id); //判断这本书是否存在于书架
				if(flag) {
					request.setAttribute("isInShelf",0); 
				}else {
					request.setAttribute("isInShelf",1);
				}
			}else {
				request.setAttribute("isInShelf",1);
			}
			session.setAttribute("book", book);
		}else {
			HttpSession session2=request.getSession();
			book=rs.showBookDetail(null, book_id);
			session2.setAttribute("book", book);
			session2.setAttribute("isInShelf",1);
			session2.setAttribute("book", book);
		}
		Book bt=(Book) session.getAttribute("book");
		String currentlink=request.getParameter("currentlink");
		
		request.getRequestDispatcher("bookinfo.jsp").forward(request,response);
	}
    
    //收藏图书
    public void collectBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getMethod().equals("get")) {
    		String book_id=request.getParameter("book_id");
        	HttpSession session=request.getSession(false);
        	IU_SearchMangerService sm=new SearchManagerServiceImpl();
        	IU_ShelfManagerService ss=new ShlefManagerServiceImpl();
        	if(session!=null) {
        		if(session.getAttribute("user")==null) {
        			response.sendRedirect("login.jsp");
        		}else {
        			Timestamp time=Utils.getNowTime();
        			Book book=sm.queryBookById(book_id);
        			User user=(User) session.getAttribute("user");
        			BookShelf  bookshelf=new BookShelf();
        			bookshelf.setUser(user);
        			bookshelf.setBook(book);
        			bookshelf.setDate(Utils.getNowTime());
        			ss.addShelf(bookshelf);
        			response.sendRedirect("BookServlet?option=readBook&book_id="+book_id);
        			
        		
        		}
        	}else {
        		
        		response.sendRedirect("login.jsp");
        	}
    	}else {
    		String book_id=request.getParameter("book_id");
        	HttpSession session=request.getSession(false);
        	IU_SearchMangerService sm=new SearchManagerServiceImpl();
        	IU_ShelfManagerService ss=new ShlefManagerServiceImpl();
    		Timestamp time=Utils.getNowTime();
			Book book=sm.queryBookById(book_id);
			User user=(User) session.getAttribute("user");
			BookShelf  bookshelf=new BookShelf();
			bookshelf.setUser(user);
			bookshelf.setBook(book);
			bookshelf.setDate(Utils.getNowTime());
			boolean result=ss.addShelf(bookshelf);
    		response.getWriter().print(result);
    	}
    	
	}
    
    //阅读章节
    public void readChapter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession(false);
    	if(session!=null) {
    		User user=(User)session.getAttribute("user");
    		if(user!=null) {
    			String chapter_id=request.getParameter("chapter_id");
    			Book book=(Book) session.getAttribute("book");
    			String book_id=book.getId();
    			String user_id=user.getId();
    			 IU_ReadManagerService rms= new ReadManagerServiceImpl();
    			 Chapter chapter=rms.readChapter(user_id, chapter_id, book_id);
    			 if(chapter==null) {
    				 request.getRequestDispatcher("bookinfo.jsp").forward(request, response);
    			 }
    			 request.setAttribute("currentchapter", chapter);
    			 request.getRequestDispatcher("showchapter.jsp").forward(request, response);
    			 //将章节内容传递给jsp
    		}else {
    			response.sendRedirect("login.jsp");
    		}
    	}else {
    		response.sendRedirect("login.jsp");
    	}	
	}
  
    //按类型搜索图书
    public void searchBookByType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		SearchManagerServiceImpl sc = new SearchManagerServiceImpl();
		List<Book> list = sc.searchBookByType(type);
		request.setAttribute("list", list);
		request.getRequestDispatcher("修该.jsp").forward(request, response);
	}
    
    //按名字搜索图书
    public void searchBookByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String book_name = request.getParameter("book_name");
		SearchManagerServiceImpl sc = new SearchManagerServiceImpl();
		List<Book> list = sc.searchBookByName(book_name);
		request.setAttribute("list", list);
		request.getRequestDispatcher("修改.jsp").forward(request, response);

	}
    
    //按排名搜索图书
    public void searchBookByRank(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookrank = request.getParameter("bookrank");
		SearchManagerServiceImpl sc = new SearchManagerServiceImpl();
		List<Book> list = sc.searchBookByRank(bookrank);
		request.setAttribute("list", list);
		request.getRequestDispatcher("show1.jsp").forward(request, response);

	}
     
    //打赏
    public void reward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String user_id=request.getParameter("user_id");
		 String book_id=request.getParameter("book_id");
		 double reward_amount=Double.parseDouble(request.getParameter("reward_amount"));
		 ReadManagerServiceImpl a=new ReadManagerServiceImpl();
		 boolean flag=a.rewardBook(user_id,book_id,reward_amount);
		 if(flag) {
			request.setAttribute("recharge_success","打赏成功");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		 }
		 else {
			request.setAttribute("recharge_fail","打赏失败");
			request.getRequestDispatcher("reward.jsp").forward(request, response);
		 }
   }
    //查看某本书的评价
    public void showBookEvaluate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String book_id=request.getParameter("book_id");
		 ReadManagerServiceImpl a=new ReadManagerServiceImpl();
		 //List<Evaluate> lists=a.showBookEvaluate(book_id);
		/// request.setAttribute("list", lists);
		 request.getRequestDispatcher("show1.jsp").forward(request, response);		 
    }
	
    //查看某人的书架里的书籍
    public void showShelf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String user_id=request.getParameter("user_id");
		 ShlefManagerServiceImpl a=new ShlefManagerServiceImpl();
		 List<Book> lists=a.showShelf(user_id);
		 request.setAttribute("list", lists);
		 request.getRequestDispatcher("booksheft.jsp").forward(request, response);		 
    }
    //删除书架
    public void removeInShlef(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String user_id=request.getParameter("user_id");
		 String book_id=request.getParameter("book_id");
		 ShlefManagerServiceImpl a=new ShlefManagerServiceImpl();
		 boolean flag=a.removeFromShelf(user_id,book_id);
		 if(flag) {
			request.setAttribute("remove_success","删除成功");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		 }
		 else {
			request.setAttribute("remove_fail","删除失败");
			request.getRequestDispatcher("remove.jsp").forward(request, response);
		 }
    }
    //显示作者信息
    public void showAuthorIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String author_name=request.getParameter("author_name");
		 IU_ReadManagerService a=new ReadManagerServiceImpl();
		 request.setAttribute("authorin", a.showAuthor(author_name));
		 List<Book> lists=a.showBook(author_name);
		 request.setAttribute("list", lists);
		 request.getRequestDispatcher("show3.jsp").forward(request, response);
    }
    //显示某作者的所有作品
    public void showAuthorBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String author_name=request.getParameter("author_name");
		 IU_ReadManagerService a=new ReadManagerServiceImpl();
		 List<Book> lists=a.showBook(author_name);
		 request.setAttribute("list", lists);
		 request.getRequestDispatcher("show3.jsp").forward(request, response);
    }
}
