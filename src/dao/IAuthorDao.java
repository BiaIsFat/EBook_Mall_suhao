package dao;

import java.sql.Connection;

import javabean.Author;

public interface IAuthorDao {
	Author queryAuthor(Connection con,String id);//根据id查作者
	
	boolean addAuthor(Connection con,Author author);//增加作者
	
	boolean isExistAuthor(Connection con,String author_id);//作者是否存在
	
	boolean checkAuthor(Connection con,Author author);//作者登入检验
	
	Author queryAuthorByTel(Connection con,String author_tel);
	
	boolean rewarded(Connection con,String author_id,double amount);

	Author queryBookByAuthorName(Connection con, String author_name);
}
