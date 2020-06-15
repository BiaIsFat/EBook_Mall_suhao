package dao;

import java.util.List;

import javabean.Book;

public interface IRankDao {
	List<Book> queryPopularRank();//查询所有的图书
	List<Book> queryRewardRank();
}
