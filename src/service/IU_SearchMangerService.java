package service;

import java.util.List;

import javabean.Book;

public interface IU_SearchMangerService {
	List<Book> searchBookByType(String type);//按类型搜索图书
	
	List<Book> searchBookByName(String name);//按照名字模糊查询
	
	List<Book> searchBookByRank(String rank);//按排行版搜索图书
	
	List<Book> searchBookByIsfree();//查免费的图书
	
	Book queryBookById(String book_id);//根据id查询book
}
