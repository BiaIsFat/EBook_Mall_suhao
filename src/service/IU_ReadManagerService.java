package service;

import java.util.List;

import javabean.Book;
import javabean.Chapter;
import javabean.Evaluate;

public interface IU_ReadManagerService {
	Chapter readChapter(String user_id,String chapterid,String book_id); //阅读章节
	
	boolean rewardBook(String user_id,String book_id,double amount); //打赏图书
	
	boolean evaluateBook(Evaluate evaluate);//评论图书
	
	Chapter isExistRead(String user_id,String book_id);//查看是否已经阅读过
	
	Book showBookDetail(String user_id,String book_id);//查看图书细则
	
	Chapter queryfirstChapter(String book_id);//查看第一章节

	List<Book> showBook(String author_name);//显示某作者的图书

	Object showAuthor(String author_name);//显示作者信息
	
	List<Evaluate> queryBookEvaluate(String book_id);//查询图书评价
}
