package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Chapter;

public interface IChapterDao {
	boolean addChapter(Connection con,Chapter chapter);//增加章节
	
	List<Chapter> queryChapter(Connection con,String book_id);//查询图书章节
	 
	Chapter queryChapterById(Connection con,String book_id,String chapter_id);//查询章节
	
	Chapter queryfirstChpater(Connection con,String book_id);//查询第一章
	
	int getPreChapterId(Connection con,String book_id);//查询上一章的id
	
	List<Chapter> queryChapterRecord(Connection con);//查询章节跟新记录
	
	boolean isExistChapter(Connection con,String book_id);
}
