package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Board;

public class BoardDaoImpl implements IBoardDao {

	@Override
	public boolean addBoard(Connection con,Board board) {
		boolean flag=false;
		String sql="insert into board value(?,?,?)";
		Object[] param= {board.getId(),board.getContext(),board.getDate()};
		//获取当前时间
		//执行插入语句
		flag= DbUtils.executeUpdate(con, sql, param);
		return flag;
		
	}

	@Override
	public boolean removeBoard(Connection con,String board_id) {

		boolean flag=false;
		Object[] param= {board_id};
		 String sql="delete  from board where board_id=?";
		  flag=DbUtils.executeUpdate(con, sql, param);
		return flag;

	}


	@Override
	public boolean modifyBoard(Connection con,String id, Board board) {
		boolean flag=false;
        	try {
		        String sql="update board set board_context=?,board_time=? where board_id=?";
		        Object[] param= {board.getContext(),board.getDate(),id};
		        flag=DbUtils.executeUpdate(con,sql,param);
            } 
        	catch(Exception e){
	        		e.printStackTrace();
	        }
        return flag;
	}

	@Override
	public List<Board> queryAllBoard(Connection con) {
		Board board=null;
		List<Board> lists=new ArrayList<Board>();
		try {

			String sql="select * from board";
			ResultSet res=DbUtils.executeQuery(con, sql,null);
			while(res.next()) {
				board=new Board();
				board.setId(res.getString("board_id"));
				board.setContext(res.getString("board_context"));
				board.setDate(res.getTimestamp("board_time"));
				lists.add(board);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
		
	}

	@Override
	public Board queryBoard(Connection con,String board_id) {
		Board board=null;
		try {
			String sql="select * from board where board_id=?";
			Object[] param= {board_id};
			ResultSet res=DbUtils.executeQuery(con, sql, param);
			while(res.next()) {
				board=new Board();
				board.setId(res.getString("board_id"));
				board.setContext(res.getString("board_context"));
				board.setDate(res.getTimestamp("board_time"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
		
		
	}

}
