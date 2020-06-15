package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DbUtils.DbUtils;
import DbUtils.Utils;
import dao.AuthorDaoImpl;
import dao.BookDaoImpl;
import dao.ChapterDaoImpl;
import dao.EvaluateDaoImpl;
import dao.IAuthorDao;
import dao.IBookDao;
import dao.IChapterDao;
import dao.IEvaluateDao;
import dao.IIllegalDao;
import dao.IReadDao;
import dao.IRewardDao;
import dao.ISearchDao;
import dao.IUserDao;
import dao.IllegalDaoImpl;
import dao.ReadDaoImpl;
import dao.RewardDaoImpl;
import dao.SearchDaoImpl;
import dao.UserDaoImpl;
import javabean.Author;
import javabean.Book;
import javabean.Chapter;
import javabean.Evaluate;
import javabean.Illegal;
import javabean.Read;
import javabean.Reward;
import javabean.Search;
import javabean.User;

public class ReadManagerServiceImpl implements IU_ReadManagerService {
	private IAuthorDao authordao=null;
	private IUserDao userdao=null;
	private IChapterDao chapterdao=null;
	private IReadDao readdao=null;
	private IRewardDao rewarddao=null;
	private IBookDao bookdao=null;
	private IEvaluateDao evaluatedao=null;
	private IIllegalDao illegaldao=null;
	private ISearchDao searchdao=null;
	
	public ReadManagerServiceImpl() {
		searchdao=new SearchDaoImpl();
		authordao=new AuthorDaoImpl();
		userdao=new UserDaoImpl();
		chapterdao=new ChapterDaoImpl();
		readdao=new ReadDaoImpl();
		rewarddao=new RewardDaoImpl();
		bookdao=new BookDaoImpl();
		evaluatedao=new EvaluateDaoImpl();
		illegaldao=new IllegalDaoImpl();
	}
	@Override
	public boolean evaluateBook(Evaluate evaluate) { //评论图书 如果有违规则插入违规记录
		Connection con=DbUtils.getConnection();
		boolean flag=false;
		try {
			con.setAutoCommit(false);
			flag=evaluatedao.addEvaluate(con, evaluate);
			if(evaluatedao.isContainIllegal(con,evaluate.getContext())){
				evaluatedao.updateState(con, evaluate.getTime().toString());
				Illegal illegal=new Illegal();
				illegal.setUser(evaluate.getUser());
				illegal.setTime(evaluate.getTime());
				String illegalcontext="评论违规";
				illegal.setContext(illegalcontext);
				illegaldao.addIllegal(con, illegal);
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		DbUtils.close();
		return flag;
	}
	
	@Override
	public Chapter readChapter(String user_id, String chapter_id, String book_id) {//阅读章节
		Connection con=DbUtils.getConnection();                                   //还需判断用户钱够不够
		Chapter chapter=null;
		try {
			con.setAutoCommit(false);
			chapter=chapterdao.queryChapterById(con, book_id, chapter_id);
			User user=userdao.queryUser(con, user_id);
				if(chapter.getPrice()==0||user.getBalan()>=chapter.getPrice()) {
					Read read=new Read();
					read.setUser(user);
					read.setChapter(chapter);
					read.setTime(Utils.getNowTime());
					boolean flag=readdao.addreadRecord(con, read);
					if(flag) {
						System.out.println("ss");
					}
				}else {
					return null;
				}
				
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		DbUtils.close();
		return chapter;
	}
	@Override
	public boolean rewardBook(String user_id, String book_id, double amount) { //打赏图书
		Connection con=DbUtils.getConnection();
		boolean flag=false;
		try {
			con.setAutoCommit(false);
			User user=userdao.queryUser(con, user_id);
			if(user.getBalan()>amount) {
				Book book=bookdao.queryBookDetail(con, book_id);
				userdao.rewardBook(con, user_id, amount);
				authordao.rewarded(con, book.getAuthor().getId(), amount);
				Reward reward=new Reward();
				reward.setAmount(amount);;
				reward.setBook(book);
				reward.setUser(user);
				reward.setTime(Utils.getNowTime());
				flag=rewarddao.addReward(con, reward);
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		DbUtils.close();
		return flag;
		
	}
	@Override
	public Chapter isExistRead(String user_id, String book_id) {//判断用户是否已经阅读了这本书
		Connection con=DbUtils.getConnection();
		Chapter chapter=new Chapter();
		chapter=readdao.alreadyChapter(con, user_id, book_id);
		DbUtils.close();
		return chapter;
	}
	@Override
	public Book showBookDetail(String user_id,String book_id) {
			Connection con=DbUtils.getConnection();
			Book book=new Book();
			try {
				con.setAutoCommit(false);
				book=bookdao.queryBookDetail(con, book_id);
				if(user_id!=null) {
					Search search=new Search();
					User user=userdao.queryUser(con, user_id);
					search.setUser(user);
					search.setBook(book);
					search.setTime(Utils.getNowTime());
					searchdao.addSearch(con, search);
				}
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			DbUtils.close();
			return book;
	}
	@Override
	public Chapter queryfirstChapter(String book_id) {
		Connection con=DbUtils.getConnection();
		Chapter chapter=chapterdao.queryfirstChpater(con, book_id);
		DbUtils.close();
		return chapter;
	}
	@Override
	public List<Book> showBook(String author_name) {//
		Connection con=DbUtils.getConnection();
		List<Book> lists=bookdao.queryBookByAuthorName(con, author_name);
		DbUtils.close();
		return lists;
	}
	@Override
	public Author showAuthor(String author_name) {
		Connection con=DbUtils.getConnection();
		Author author=authordao.queryBookByAuthorName(con, author_name);
		DbUtils.close();
		return author;
	}
	@Override
	public List<Evaluate> queryBookEvaluate(String book_id) {
		Connection con=DbUtils.getConnection();
		List<Evaluate> lists=evaluatedao.queryEvaluate(con, book_id);
		DbUtils.close();
		return lists;
	}

}
