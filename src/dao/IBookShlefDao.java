package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Book;
import javabean.BookShelf;
import javabean.User;

public interface IBookShlefDao {
	boolean isExistInShlef(Connection con,String user_id,String book_id); //判断是否存在书架
	boolean removeInShlef(Connection con,String user_id,String book_id); //从书架中移除
	boolean addBookShlef(Connection con,BookShelf bookshlef);//收藏图书到书架
	List<Book> showUserShlef(Connection con,String user_id); //显示用户书架的图书
	
}
