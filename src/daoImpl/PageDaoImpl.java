package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Book;

public class PageDaoImpl implements IPageDao {

	@Override
	public List<Book> queryRewardByPage(int currentpage, int pagesize) {
		List<Book> lists=new ArrayList<>();
		try {
			Connection con=null;
			con=DbUtils.getConnection();
			String sql="select * from b_reward_rank  order by id limit ?,?";
			int start=((currentpage-1)*pagesize);
			Object[] param={start,pagesize};
			ResultSet res=DbUtils.executeQuery(con, sql, param);
			Book book=null;
			if(res!=null){
				while(res.next()){
					book=new Book();
					book.setId(res.getString("book_id"));
					book.setName(res.getString("book_name"));
					book.setDes(res.getString("book_des"));
					book.setType(res.getString("book_type"));
					book.setDate(res.getTimestamp("book_date"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Book> queryPopularByPage(int currentpage, int pagesize) {
		List<Book> lists=new ArrayList<>();
		try {
			Connection con=null;
			con=DbUtils.getConnection();
			String sql="select * from b_popular_rank  order by id limit ?,?";
			int start=((currentpage-1)*pagesize);
			Object[] param={start,pagesize};
			ResultSet res=DbUtils.executeQuery(con, sql, param);
			Book book=null;
			if(res!=null){
				while(res.next()){
					book=new Book();
					book.setId(res.getString("book_id"));
					book.setName(res.getString("book_name"));
					book.setDes(res.getString("book_des"));
					book.setType(res.getString("book_type"));
					book.setDate(res.getTimestamp("book_date"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Book> querySearchByPage(int currentpage, int pagesize) {
		List<Book> lists=new ArrayList<>();
		try {
			Connection con=null;
			con=DbUtils.getConnection();
			String sql="select * from b_search_rank  order by id limit ?,?";
			int start=((currentpage-1)*pagesize);
			Object[] param={start,pagesize};
			ResultSet res=DbUtils.executeQuery(con, sql, param);
			Book book=null;
			if(res!=null){
				while(res.next()){
					book=new Book();
					book.setId(res.getString("book_id"));
					book.setName(res.getString("book_name"));
					book.setDes(res.getString("book_des"));
					book.setType(res.getString("book_type"));
					book.setDate(res.getTimestamp("book_date"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

}
