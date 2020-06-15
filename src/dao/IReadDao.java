package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Chapter;
import javabean.Read;

public interface IReadDao {
	boolean addreadRecord(Connection con,Read read);//增加阅读记录
	boolean isRead(Connection con,String user_id,String book_id);//查看是否曾经阅读过
	Chapter alreadyChapter(Connection con,String user_id,String book_id);//查看最近阅读的章节
	List<Read> queryAllReadRecord(Connection con);//所有的阅读记录
	List<Read> queryReadRecord(Connection con,String user_id);//根据user用户id查找记录
	
}
