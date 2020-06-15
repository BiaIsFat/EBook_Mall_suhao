package service;

import javabean.Book;
import javabean.Chapter;

public interface IA_WorkManagerService {
	boolean addBook(Book book);//发布作品
	
	boolean addChapter(Chapter chapter);//发布章节
	
	boolean  applySoldOut(String book_id);//申请下架
	
	Book showBookById(String book_id);//查询图书
	
	boolean isExistInChapter(String book_id);
}
