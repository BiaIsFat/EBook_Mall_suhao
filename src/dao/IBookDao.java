package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Book;

public interface IBookDao {
	List<Book> queryBookByName(Connection con,String book_name); //根据图书名字查找图书
	Book queryBookDetail(Connection con,String book_id); //显示图书具体信息
	List<Book> queryBookByType(Connection con,String type);//根据图书类型查找图书
	List<Book> queryBookIsFree(Connection con);//根据是否免费查找
	boolean addBook(Connection con,Book book);//增加图书
	boolean soldOutBook(Connection con,String book_id);//下架图书
	List<Book> queryAllApplyBook(Connection con);//显示所有申请下架的图书
	boolean applySoldOut(Connection con,String book_id);//申请下架
	List<Book> queryBookByAuthor(Connection con,String author_id);//显示某作者的所有图书
	List<Book> queryBookByAuthorName(Connection con,String author_name);//显示某作者的所有作评
	
}
