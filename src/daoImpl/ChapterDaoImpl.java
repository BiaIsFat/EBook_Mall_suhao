package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Author;
import javabean.Book;
import javabean.Chapter;

public class ChapterDaoImpl implements IChapterDao {

	@Override
	public boolean addChapter(Connection con,Chapter chapter) {
		boolean flag=false;
		String sql="insert into Chapter values(?,?,?,?,?,?)";
		Object[] param={chapter.getId(),chapter.getBook().getId(),chapter.getName(),chapter.getContext(),chapter.getPrice(),chapter.getTime()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public List<Chapter> queryChapter(Connection con,String book_id) {
		List<Chapter> lists=new ArrayList<>();
		IBookDao bd=new BookDaoImpl();
		try {
			String sql="select * from chapter where book_id=? order by chapter_time";
			Object[] param={book_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				Chapter chapter=null;
				while(res.next()){
					chapter=new Chapter();
					chapter.setId(res.getString("chapter_id"));
					chapter.setName(res.getString("chapter_name"));
					chapter.setBook(bd.queryBookDetail(con,res.getString("book_id")));
					chapter.setContext(res.getString("chapter_context"));
					chapter.setPrice(res.getDouble("chapter_price"));
					chapter.setTime(res.getTimestamp("chapter_time"));
					lists.add(chapter);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public Chapter queryChapterById(Connection con,String book_id, String chapter_id) {
		Chapter chapter=new Chapter();
		IBookDao bd=new BookDaoImpl();
		try {
			String sql="select * from Chapter where book_id=? and chapter_id=?";
			Object[] param= {book_id,chapter_id};
			ResultSet res=DbUtils.executeQuery(con, sql, param);
			if(res.next()) {
				chapter.setBook(bd.queryBookDetail(con,res.getString("book_id")));
				chapter.setId(res.getString("chapter_id"));
				chapter.setName(res.getString("chapter_name"));
				chapter.setPrice(res.getDouble("chapter_price"));
				String chapter_context=res.getString("chapter_context");
				chapter_context="  "+chapter_context.trim(); 
				chapter.setContext(chapter_context);
				chapter.setTime(res.getTimestamp("chapter_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chapter;
				
	}

	@Override
	public Chapter queryfirstChpater(Connection con, String book_id) {
		Chapter chapter=new Chapter();
		String sql="select * from Chapter where book_id=? order by chapter_time";
		Object[] param= {book_id};
		ResultSet res=DbUtils.executeQuery(con, sql, param);
		IBookDao bd=new BookDaoImpl();
		try {
			if(res.next()) {
				chapter.setBook(bd.queryBookDetail(con,res.getString("book_id")));
				chapter.setId(res.getString("chapter_id"));
				chapter.setName(res.getString("chapter_name"));
				chapter.setPrice(res.getDouble("chapter_price"));
				chapter.setContext(res.getString("chapter_context"));
				chapter.setTime(res.getTimestamp("chapter_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chapter;
	}

	@Override
	public int getPreChapterId(Connection con, String book_id) {
		String sql="select count(chapter_id) from chapter group by(book_id) having  book_id=?";
		Object[] param= {book_id};
		ResultSet res=DbUtils.executeQuery(con, sql, param);
		int chapter_id=0;
		if(res!=null) {
			try {
				if(res.next()){
					chapter_id=Integer.valueOf(res.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		chapter_id++;
		return chapter_id;
	}

	@Override
	public List<Chapter> queryChapterRecord(Connection con) {
		List<Chapter> lists=new ArrayList<>();
		IBookDao bd=new BookDaoImpl();
		try {
			String sql="select * from chapter order by chapter_time";
			ResultSet res=DbUtils.executeQuery(con,sql,null);
			if(res!=null){
				Chapter chapter=null;
				while(res.next()){
					chapter=new Chapter();
					chapter.setId(res.getString("chapter_id"));
					chapter.setName(res.getString("chapter_name"));
					chapter.setBook(bd.queryBookDetail(con,res.getString("book_id")));
					chapter.setContext(res.getString("chapter_context"));
					chapter.setPrice(res.getDouble("chapter_price"));
					chapter.setTime(res.getTimestamp("chapter_time"));
					lists.add(chapter);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists; 
	}

	@Override
	public boolean isExistChapter(Connection con,String book_id) {
		String sql="select * from chapter where book_id=?";
		Object[] param= {book_id};
		ResultSet res=DbUtils.executeQuery(con, sql, param);
		boolean flag=false;
		try {
			if(res.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
