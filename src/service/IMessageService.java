package service;

import java.util.List;

import javabean.Message;

public interface IMessageService {
	List<Message> queryAuthorMessage(String author_id);
	List<Message> queryUserMessage(String user_id);
	boolean addMessage(Message message) ;
}
