package service;

import java.util.List;

import javabean.Book;

public interface IM_BookManagerSerive {
		boolean SoldOutBook(String book_id);//下架图书(上架)
		
		List<Book> queryAllBookApply();//显示所有申请下架的图书
}
