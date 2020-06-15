package service;

import java.sql.Connection;

import DbUtils.DbUtils;
import dao.BookDaoImpl;
import dao.ChapterDaoImpl;
import dao.IBookDao;
import dao.IChapterDao;
import javabean.Book;
import javabean.Chapter;

public class WorkManagerServiceImpl implements IA_WorkManagerService {
	private IBookDao bookdao=null;
	private IChapterDao chapterdao=null;
	public WorkManagerServiceImpl() {
		bookdao=new BookDaoImpl();
		chapterdao=new ChapterDaoImpl();
	}
	@Override
	public boolean addBook(Book book) {
		Connection con=DbUtils.getConnection();
		boolean flag=bookdao.addBook(con, book);
		DbUtils.close();
		return flag;
	}

	@Override
	public boolean addChapter(Chapter chapter) {
		Connection con=DbUtils.getConnection();
		boolean flag=chapterdao.addChapter(con, chapter);
		DbUtils.close();
		return flag;
	}

	@Override
	public boolean applySoldOut(String book_id) {
		Connection con=DbUtils.getConnection();
		boolean flag=bookdao.applySoldOut(con, book_id);
		DbUtils.close();
		return flag;
	} //作品管理
	@Override
	public Book showBookById(String book_id) {
		Connection con=DbUtils.getConnection();
		Book book=bookdao.queryBookDetail(con, book_id);
		DbUtils.close();
		return book;
	}
	@Override
	public boolean isExistInChapter(String book_id) {
		Connection con=DbUtils.getConnection();
		boolean flag=chapterdao.isExistChapter(con, book_id);
		DbUtils.close();
		return flag;
	}

}
