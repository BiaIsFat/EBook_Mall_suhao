package service;

import java.sql.Connection;
import java.util.List;
import DbUtils.DbUtils;
import dao.*;
import javabean.Board;

public class BoardManagerServiceImpl implements IM_BoardManagerService {

	private IBoardDao boarddao=null;
	public BoardManagerServiceImpl()
	{
		boarddao=new BoardDaoImpl();
	}
	@Override
	public boolean addBoard(Board board) {
		Connection con=DbUtils.getConnection();
		boolean flag=boarddao.addBoard(con, board);
		DbUtils.close();
		return flag;
	}

	@Override
	public boolean removeBoard(String board_id) {
		Connection con=DbUtils.getConnection();
		boolean flag=boarddao.removeBoard(con, board_id);
		DbUtils.close();
		return flag;
	}

	@Override
	public boolean motifyBoard(String board_id, Board board) {
		Connection con=DbUtils.getConnection();
		boolean flag=boarddao.modifyBoard(con, board_id, board);
		DbUtils.close();
		return flag;
	}

	@Override
	public List<Board> queryAllBoard() {
		Connection con=DbUtils.getConnection();
		List<Board> list=boarddao.queryAllBoard(con);
		DbUtils.close();
		return list;
	}

	@Override
	public Board queryBoard(String board_id) {
		Connection con=DbUtils.getConnection();
		Board board=null;
		board=boarddao.queryBoard(con, board_id);
		return board;
	}

}
