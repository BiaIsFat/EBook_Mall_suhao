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
import javabean.Author;
import javabean.Book;
import javabean.Chapter;
import javabean.Message;
import service.IA_WorkManagerService;
import service.ILoginService;
import service.IMessageService;
import service.IU_ReadManagerService;
import service.LoginServiceImpl;
import service.MessageServiceImpl;
import service.ReadManagerServiceImpl;
import service.WorkManagerServiceImpl;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends baseservlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see baseservlet#baseservlet()
     */
    public AuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Author author=(Author) session.getAttribute("auhtor");
		String book_id=Utils.getTimeId();
		String book_name=request.getParameter("book_name");
		String book_des=request.getParameter("book_des");
		String book_type=request.getParameter("book_type");
		Timestamp book_time=Utils.getNowTime();
		String book_img=Utils.getBookImg(book_type);
		Book book=new Book();
		System.out.println(session);
		System.out.println(author);
		book.setAuthor(author);
		book.setId(book_id);
		book.setName(book_name);
		book.setDes(book_des);
		book.setType(book_type);
		book.setImg(book_img);
		book.setDate(book_time);
		IA_WorkManagerService wms=new WorkManagerServiceImpl();
		boolean flag=wms.addBook(book);
		if(flag) { //判断是否成功
			session.setAttribute("optionbook", book);
			response.sendRedirect("addworksuccess.jsp");
		}else {
			request.setAttribute("error_message", "faild");
			request.getRequestDispatcher("creatework").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void addChapter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chapter_context=request.getParameter("chapter_context");
		String chapter_name=request.getParameter("chapter_name");
		HttpSession session=request.getSession(false);
		Book book=(Book)session.getAttribute("optionbook");
		String book_id=book.getId();
		IA_WorkManagerService wm=new WorkManagerServiceImpl();
		
		
		Timestamp chapter_time=Utils.getNowTime();
		//String chapter_name=request.getParameter("chapter_name");
		String chapter_type=request.getParameter("chapter_type");
		double chapter_price=0;
		if("vip".equals(chapter_type)) {
			chapter_price=5;
		}else{
			chapter_price=0;
		}
		//String chapter_context=request.getParameter("chapter_context"); //这里传的是地址
		Chapter chapter=new Chapter();
		IU_ReadManagerService rms=new ReadManagerServiceImpl();
		String chapter_id=null;
		chapter_id=String.valueOf(Utils.getChapterId(book_id));
		System.out.println(chapter_id);
		chapter.setId(chapter_id);
		chapter.setBook(rms.showBookDetail(null, book_id));
		chapter.setTime(chapter_time);
		chapter.setName(chapter_name);
		chapter.setPrice(chapter_price);
		chapter.setContext(chapter_context);
		IA_WorkManagerService wms=new WorkManagerServiceImpl();
		boolean flag=wms.addChapter(chapter);
		if(flag){
			response.sendRedirect("addchaptersuccess.jsp");
		}
	}
	
	public void queryAuthorMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String author_id = request.getParameter("author_id");
		IMessageService ms = new MessageServiceImpl();
		List<Message> list = ms.queryAuthorMessage(author_id);
		request.setAttribute("list", list);
		request.getRequestDispatcher("show1.jsp").forward(request, response);
	}
	
	public void updateWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
	}
	
	public void u(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
	}
	
	public void upda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
	}
	public void authorLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String author_tel=request.getParameter("author_tel");
		String author_pass=request.getParameter("author_pass");
		Author author=new Author();
		author.setTel(author_tel);
		author.setPass(author_pass);
		ILoginService ls=new LoginServiceImpl();
		Author author1=ls.AuthorLogin(author);
		if(author1!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("auhtor",author1);
			System.out.println(session);
			response.sendRedirect("author_index.jsp");
		}else {
			response.sendRedirect("authorlogin.jsp");
		}
		
	}
	
	public void authorSignup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
