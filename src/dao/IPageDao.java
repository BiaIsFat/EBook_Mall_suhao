package dao;

import java.util.List;

import javabean.Book;

public interface IPageDao {
	List<Book> queryRewardByPage(int currentpage,int pagesize);//根据页面查询打赏排行榜
	List<Book> queryPopularByPage(int currentpage,int pagesize);//根据页面查询收藏排行榜
	List<Book> querySearchByPage(int currentpage,int pagesize);//根据页面查询点击排行榜
}
