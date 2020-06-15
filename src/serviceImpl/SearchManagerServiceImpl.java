package service;

import java.sql.Connection;
import java.util.List;

import DbUtils.DbUtils;
import dao.BookDaoImpl;
import dao.IBookDao;
import javabean.Book;

public class SearchManagerServiceImpl implements IU_SearchMangerService {
	private IBookDao bookdao=null;
	public SearchManagerServiceImpl() {
		bookdao=new BookDaoImpl();
	}
	@Override
	public List<Book> searchBookByType(String type) {
		Connection con=DbUtils.getConnection();
		List<Book> lists=bookdao.queryBookByType(con, type);
		DbUtils.close();
		return lists;
	}

	@Override
	public List<Book> searchBookByName(String book_name) {
		Connection con=DbUtils.getConnection();
		List<Book> lists=bookdao.queryBookByName(con, book_name);
		DbUtils.close();
		return lists;
	}

	@Override
	public List<Book> searchBookByRank(String rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchBookByIsfree() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Book queryBookById(String book_id) {
		Connection con=DbUtils.getConnection();
		Book book=bookdao.queryBookDetail(con, book_id);
		DbUtils.close();
		return book;
	}
	
	
}
