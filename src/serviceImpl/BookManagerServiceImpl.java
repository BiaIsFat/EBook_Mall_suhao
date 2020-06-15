package service;

import java.sql.Connection;
import java.util.List;

import DbUtils.DbUtils;
import dao.BookDaoImpl;
import dao.IBookDao;
import javabean.Book;

public class BookManagerServiceImpl implements IM_BookManagerSerive {
	private IBookDao dao;
	public BookManagerServiceImpl() {
		dao=new BookDaoImpl();
	}
	@Override
	public boolean SoldOutBook(String book_id) {
		Connection con=DbUtils.getConnection();
		boolean flag=dao.soldOutBook(con,book_id);
		DbUtils.close();
		return flag;
	}

	@Override
	public List<Book> queryAllBookApply() {
		Connection con=DbUtils.getConnection();
		List<Book> lists=dao.queryAllApplyBook(con);
		DbUtils.close();
		return lists;
	}

}
