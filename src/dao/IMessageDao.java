package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Message;

public interface IMessageDao {
	boolean addMessage(Connection con,Message message);//增加消息
	
	List<Message> queryUserMessage(Connection con,String user_id);//根据用户查找消息
	
	List<Message> queryAuthorMessage(Connection con,String author_id);//根据作者查找消息
}
