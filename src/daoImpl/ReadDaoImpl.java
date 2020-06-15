package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Chapter;
import javabean.Read;
import javabean.User;


public class ReadDaoImpl implements IReadDao {

	@Override
	public boolean addreadRecord(Connection con,Read read) {
		String sql="insert into readrecord values(?,?,?,?)";
		Object[] param= {read.getUser().getId(),read.getChapter().getBook().getId(),read.getChapter().getId(),read.getTime()};
		boolean flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public boolean isRead(Connection con,String user_id, String book_id) {
		boolean flag=false;
		try {
			String sql="select * from ReadRecord where user_id=? and book_id=?";
			Object[] param= {user_id,book_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

	@Override
	public Chapter alreadyChapter(Connection con,String user_id, String book_id) {
		Chapter chapter=null;
		IChapterDao cd=new ChapterDaoImpl();
		try {
			String sql="select * from Readrecord where user_id=? and book_id=? order by read_time";
			Object[] param={user_id,book_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					chapter=cd.queryChapterById(con,res.getString("book_id"), res.getString("chapter_id"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chapter;
	}

	@Override
	public List<Read> queryAllReadRecord(Connection con) {
		
		
		List<Read> list=new ArrayList<>();
		IUserDao userdao=new UserDaoImpl();
		IChapterDao chapterdao=new ChapterDaoImpl();
		try {	
			String sql="select * from readrecord";
			ResultSet rs=DbUtils.executeQuery(con,sql,null);
			while(rs.next())
			{
				String user_id=rs.getString("user_id");
				String book_id=rs.getString("book_id");
				String chapter_id=rs.getString("chapter_id");
				Timestamp read_time=rs.getTimestamp("read_time");
		
				User user=userdao.queryUser(con,user_id);
				
				Chapter chapter=chapterdao.queryChapterById(con,book_id, chapter_id);
				Read read= new Read();
				read.setUser(user);
				read.setChapter(chapter);
				read.setTime(read_time);
				list.add(read);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Read> queryReadRecord(Connection con,String id) {
		ResultSet rs=null;
		List<Read> list=new ArrayList<>();
		IUserDao userdao=new UserDaoImpl();
		IChapterDao chapterdao=new ChapterDaoImpl();
		try {
			String sql="select * from readrecord where user_id=?";
			Object[] param= {id};
			rs=DbUtils.executeQuery(con,sql,param);
				while(rs.next())
				{
					String user_id=rs.getString("user_id");
					String book_id=rs.getString("book_id");
					String chapter_id=rs.getString("chapter_id");
					Timestamp read_time=rs.getTimestamp("read_time");
					User user=userdao.queryUser(con,user_id);
					Chapter chapter=chapterdao.queryChapterById(con,book_id, chapter_id);
					Read read= new Read();
					read.setChapter(chapter);
					read.setUser(user);
					read.setTime(read_time);
					list.add(read);
				}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
			
	}

}
