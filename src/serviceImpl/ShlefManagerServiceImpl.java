package service;

import java.sql.Connection;
import java.util.List;

import DbUtils.DbUtils;
import dao.BookDaoImpl;
import dao.BookShlefDaoImpl;
import dao.IBookDao;
import dao.IBookShlefDao;
import javabean.Book;
import javabean.BookShelf;

public class ShlefManagerServiceImpl implements IU_ShelfManagerService {
	private IBookShlefDao shelfdao;
	public ShlefManagerServiceImpl() {
		shelfdao=new BookShlefDaoImpl();
	}
	@Override
	public List<Book> showShelf(String user_id) {
		Connection con=DbUtils.getConnection();
		List<Book> lists=shelfdao.showUserShlef(con,user_id);
		DbUtils.close();
		return lists;
	}

	@Override
	public boolean removeFromShelf(String user_id,String book_id) {
		Connection con=DbUtils.getConnection();
		boolean flag=shelfdao.removeInShlef(con, user_id, book_id);
		DbUtils.close();
		return flag;
	}

	@Override
	public boolean addShelf(BookShelf bookshelf) {
		Connection con=DbUtils.getConnection();
		boolean flag=shelfdao.isExistInShlef(con,bookshelf.getUser().getId(), bookshelf.getBook().getId());
		if(!flag) {
			return shelfdao.addBookShlef(con,bookshelf);
		}
		DbUtils.close();
		return false;
	}
	@Override
	public boolean isExistInShlef(String user_id, String book_id) {
		Connection con=DbUtils.getConnection();
		boolean flag= shelfdao.isExistInShlef(con,user_id, book_id);
		
		DbUtils.close();
		return flag;
	}

}
