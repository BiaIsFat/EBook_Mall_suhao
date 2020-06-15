package service;

import java.sql.*;
import java.util.*;

import javabean.Board;

public interface IM_BoardManagerService {
	boolean addBoard(Board board); //增加公告
	
	boolean removeBoard(String board_id); //移除公告
	
	boolean motifyBoard(String board_id,Board board); //修改公告
	
	List<Board> queryAllBoard(); //查找所有公告
	
	Board queryBoard(String board_id); //查找一条公告
}
