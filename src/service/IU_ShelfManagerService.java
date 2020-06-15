package service;

import java.util.List;

import javabean.Book;
import javabean.BookShelf;

public interface IU_ShelfManagerService {
	List<Book> showShelf(String user_id); //显示书架
	
	boolean removeFromShelf(String user_id,String book_id); //移除书架
	
	boolean addShelf(BookShelf bookshelf); //加入书架
	
	boolean isExistInShlef(String user_id,String book_id);//查看是否在书架中
	
	
}
