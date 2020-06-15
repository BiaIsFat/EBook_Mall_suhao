package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DbUtils.DbUtils;
import DbUtils.Utils;
import dao.AuthorDaoImpl;
import dao.IMessageDao;
import dao.ManagerDaoImpl;
import dao.MessageDaoImpl;
import dao.UserDaoImpl;
import javabean.Author;
import javabean.Message;
import javabean.User;

public class MessageServiceImpl implements IMessageService {
	private IMessageDao md=null;
	public MessageServiceImpl() {
		md=new MessageDaoImpl();
	}

	@Override
	public List<Message> queryAuthorMessage(String author_id) {
        Connection con=DbUtils.getConnection();
        List<Message> lists=md.queryAuthorMessage(con, author_id);
        DbUtils.close();
		return lists;
	}

	@Override
	public List<Message> queryUserMessage(String user_id) {
        Connection con=DbUtils.getConnection();
        List<Message> lists=md.queryUserMessage(con, user_id);
        DbUtils.close();
		return lists;
	}

	@Override
	public boolean addMessage(Message message) {
		Connection con=DbUtils.getConnection();
		boolean result=false;
		User user=message.getUser();
		Author author=message.getAuthor();
		String context=message.getContext();
		try {
			con.setAutoCommit(false);
			boolean flag=md.addMessage(con, message);
			if(flag) {
			   Message message1=new Message();
			   message1.setAuthor(author);
			   message1.setUser(user);
			message1.setContext(context);
			   message1.setTime(Utils.getNowTime());
			   result=md.addMessage(con, message);
			}
			con.commit();
			}catch(SQLException e) {
				e.printStackTrace();
				try {
					con.rollback();
				}catch (SQLException e1) {
					e1.printStackTrace();
			}
			
		}
		
		
		return result;
	}

}
