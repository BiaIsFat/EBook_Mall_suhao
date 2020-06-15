package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Book;
import javabean.BookShelf;

public class BookShlefDaoImpl implements IBookShlefDao {

	@Override
	public boolean isExistInShlef(Connection con,String user_id,String book_id){		
		boolean flag=false;
		try {
			String sql="select * from bookshlef where user_id=? and book_id=?";
			Object[] param={user_id,book_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeInShlef(Connection con,String user_id,String book_id) {
		boolean flag=false;
		String sql="delete from bookshlef where user_id=? and book_id=?";
		Object[] param={user_id,book_id};
		flag=DbUtils.executeUpdate(con,sql,param);
		return flag;
	}

	@Override
	public boolean addBookShlef(Connection con,BookShelf bookshelf) {
		boolean flag=false;
		String sql="insert into bookshlef values(?,?,?)";
		Object[] param= {bookshelf.getUser().getId(),bookshelf.getBook().getId(),bookshelf.getDate()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
		
	}

	@Override
	public List<Book> showUserShlef(Connection con,String user_id) {
		List<Book> lists =new ArrayList<>();
		IBookDao bd=new BookDaoImpl();
		try {
			String sql="select * from bookshlef where user_id=?";
			Object[] param={user_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				while(res.next()){
					String book_id=res.getString("book_id");
					Book book=bd.queryBookDetail(con,book_id);
					lists.add(book);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
		
	}


}
