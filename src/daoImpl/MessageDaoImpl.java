package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Author;
import javabean.Chapter;
import javabean.Message;

public class MessageDaoImpl implements IMessageDao {

	@Override
	public boolean addMessage(Connection con,Message message) {
		boolean flag=false;
		String sql="insert into Message values(?,?,?,?)";
		Object[] param= {message.getUser().getId(),message.getAuthor().getId(),message.getContext(),message.getTime()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public List<Message> queryUserMessage(Connection con,String user_id) {
		List<Message> lists=new ArrayList<>();
		IUserDao ud=new UserDaoImpl();
		IAuthorDao ad=new AuthorDaoImpl();
		try {
			String sql="select * from chapter where user_id=? ";
			Object[] param={user_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				Message message=null;
				while(res.next()){
					message=new Message();
					message.setAuthor(ad.queryAuthor(con,res.getString("author_id")));
					message.setUser(ud.queryUser(con,res.getString("user_id")));
					message.setContext(res.getString("message_context"));
					message.setTime(res.getTimestamp("message_time"));
					lists.add(message);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Message> queryAuthorMessage(Connection con,String author_id) {
		List<Message> lists=new ArrayList<>();
		IUserDao ud=new UserDaoImpl();
		IAuthorDao ad=new AuthorDaoImpl();
		try {
			String sql="select * from chapter where author_id=? ";
			Object[] param={author_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				Message message=null;
				while(res.next()){
					message=new Message();
					message.setAuthor(ad.queryAuthor(con,res.getString("author_id")));
					message.setUser(ud.queryUser(con,res.getString("user_id")));
					message.setContext(res.getString("message_context"));
					message.setTime(res.getTimestamp("message_time"));
					lists.add(message);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

}
