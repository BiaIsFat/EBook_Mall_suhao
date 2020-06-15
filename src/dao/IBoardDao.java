package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Board;

public interface IBoardDao {
	boolean addBoard(Connection con,Board board);//增加公告
	
	boolean removeBoard(Connection con,String board_id);//删除公告
	
	List<Board> queryAllBoard(Connection con);//查询公告
	
	boolean modifyBoard(Connection con,String board_id,Board board);//修改公告
	
	Board queryBoard(Connection con,String board_id);
	
	
	
}
