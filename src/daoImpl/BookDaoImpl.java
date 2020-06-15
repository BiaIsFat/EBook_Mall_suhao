package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Author;
import javabean.Book;


public class BookDaoImpl implements IBookDao {

	@Override
	public List<Book> queryBookByName(Connection con,String book_name) {
		List<Book> lists=new ArrayList<Book>();
		try {
			String sql="select * from book where book_name=? and book_state=1";
			Object[] param= {book_name};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			Book book1=null;
			IAuthorDao ad=new AuthorDaoImpl();
			while(res.next()) {
				book1=new Book();
				book1.setId(res.getString("book_id"));
				book1.setDes(res.getString("book_des"));
				book1.setName(res.getString("book_name"));
				book1.setType(res.getString("book_type"));
				book1.setDate(res.getTimestamp("book_time"));
				book1.setImg(res.getString("book_img"));
				Author author=ad.queryAuthor(con,res.getString("author_id"));
				book1.setAuthor(author);
				lists.add(book1);
			}
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return lists;
	}

	@Override
	public Book queryBookDetail(Connection con,String book_id) {
		Book book=null;
		try {
			String sql="select * from book where book_id=? and book_state=1";
			Object[] param={book_id};
			ResultSet res=DbUtils.executeQuery(con, sql, param);
			IAuthorDao ad=new AuthorDaoImpl();
			if(res!=null){
				book=new Book();
				if(res.next()){
					//Author author=queryAuthor(res.getString("author_id"));
					book.setId(res.getString("book_id"));
					book.setName(res.getString("book_name"));
					book.setDes(res.getString("book_des"));
					book.setType(res.getString("book_type"));
					book.setDate(res.getTimestamp("book_time"));
					book.setImg(res.getString("book_img"));
					Author author=ad.queryAuthor(con,res.getString("author_id"));
					book.setAuthor(author);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> queryBookByType(Connection con,String type) {
		List<Book> lists=new ArrayList<>();
		try {
			String sql="select * from Book where book_type=? and book_state=1";
			Object[] param= {type};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			Book book=null;
			IAuthorDao ad=new AuthorDaoImpl();
			while(res!=null) {
				book=new Book();
				book.setId(res.getString("book_id"));
				book.setDes(res.getString("book_des"));
				book.setName(res.getString("book_name"));
				book.setType(res.getString("book_type"));
				book.setDate(res.getTimestamp("book_timr"));
				book.setImg(res.getString("book_img"));
				Author author=ad.queryAuthor(con,res.getString("author_id"));
				book.setAuthor(author);
				lists.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
		
	}

	@Override
	public List<Book> queryBookIsFree(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(Connection con,Book book) {
		boolean flag=false;
		String sql="insert into book(book_id,author_id,book_name,book_des,book_type,book_time,book_img) values(?,?,?,?,?,?,?)";
		Object[] param= {book.getId(),book.getAuthor().getId(),book.getName(),book.getDes(),book.getType(),book.getDate(),book.getImg()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public boolean soldOutBook(Connection con,String book_id) {
		boolean flag=false;
		String sql="update book set book_state=0 where book_id=?";
		Object[] param= {book_id};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public List<Book> queryAllApplyBook(Connection con) {
		IAuthorDao ad=new AuthorDaoImpl();
		List<Book> list=new ArrayList<Book>();
		try {
			String sql="select * from book where book_state=2";
			ResultSet rs=DbUtils.executeQuery(con, sql, null);
				while(rs.next())
				{
					String book_id=rs.getString(1);
					String author_id=rs.getString(2);
					String book_name=rs.getString(3);
					String book_des=rs.getString(4);
					String book_type=rs.getString(5);
					Timestamp book_time=rs.getTimestamp(6);
					int book_state=rs.getInt("book_state");
					Book book=new Book();
					book.setId(book_id);
					book.setAuthor(ad.queryAuthor(con,author_id));
					book.setName(book_name);
					book.setDate(book_time);
					book.setDes(book_des);
					book.setType(book_type);
					book.setState(book_state);
					book.setImg(rs.getString("book_img"));
					list.add(book);
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book> queryBookByAuthor(Connection con,String author_id) {
		List<Book> lists=new ArrayList<>();
		try {
			String sql="select * from Book where author_id=? and book_state=1";
			Object[] param= {author_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			Book book=null;
			IAuthorDao ad=new AuthorDaoImpl();
			while(res!=null) {
				book=new Book();
				book.setId(res.getString("book_id"));
				book.setDes(res.getString("book_des"));
				book.setName(res.getString("book_name"));
				book.setType(res.getString("book_type"));
				book.setDate(res.getTimestamp("book_time"));
				Author author=ad.queryAuthor(con,res.getString("author_id"));
				book.setAuthor(author);
				book.setImg(res.getString("book_img"));
				lists.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public boolean applySoldOut(Connection con,String book_id) {
		boolean flag=false;
		String sql="update book set book_state=2 where book_id=?";
		Object[] param= {book_id};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}
	@Override
	public List<Book> queryBookByAuthorName(Connection con,String author_name) {//新增
		List<Book> list=new ArrayList<Book>();
		try {
			String sqll="select * from author where author_name=?";
			Object[] paramm= {author_name};
			ResultSet res=DbUtils.executeQuery(con, sqll, paramm);
			Author author=new Author();
			while(res.next())
			{				
				String author_Id=res.getString("author_id");
				author.setId(author_Id);
			}
				String author_id=author.getId();
			String sql="select * from book where author_id=?";
			Object[] param= {author_id};
			ResultSet rs=DbUtils.executeQuery(con, sql, param);
				while(rs.next())
				{
					Book book=new Book();
					book.setId(rs.getString("book_id"));
					book.setDes(rs.getString("book_des"));
					book.setName(rs.getString("book_name"));
					book.setType(rs.getString("book_type"));
					book.setDate(rs.getTimestamp("book_date"));
					list.add(book);
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

}
