package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Author;
import javabean.Book;
import javabean.Chapter;
import javabean.Evaluate;
import javabean.User;

public class EvaluateDaoImpl implements IEvaluateDao {

	@Override
	public boolean addEvaluate(Connection con,Evaluate evaluate) {
		boolean flag=false;
		String sql="insert into evaluate values(?,?,?,?)";
		Object[] param= {evaluate.getUser().getId(),evaluate.getBook().getId(),evaluate.getTime(),evaluate.getContext()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public boolean removeEvaluate(Connection con,Evaluate evaluate) {
		boolean flag=false;
		String sql="delete from Evaluate where user_id=? and book_id=?";
		Object[] param= {evaluate.getUser().getId(),evaluate.getBook().getId(),evaluate.getTime(),evaluate.getContext()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public List<Evaluate> queryEvaluate(Connection con,String id) {
		List<Evaluate> lists=new ArrayList<>();
		IBookDao bd=new BookDaoImpl();
		IUserDao ud=new UserDaoImpl();
		try {
			String sql="select * from evaluate where book_id=? order by date desc";
			Object[] param={id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				Evaluate evaluate=null;
				Book book=null;
				User user=null;
				while(res.next()){
					/*
					evaluate.setUser(ud.queryUser(con,res.getString("user_id")));
					evaluate.setBook(bd.queryBookDetail(con,res.getString("book_id")));
					evaluate.setTime(res.getTimestamp("evaluate_time"));
					evaluate.setContext(res.getString("evaluate_context"));
					evaluate.setState(res.getInt("evaluate_state"));
					evaluate=new Evaluate();
					lists.add(evaluate);
					*/
					String user_id=res.getString("user_id");
					String book_id=res.getString("book_id");
					Timestamp evaluate_time=res.getTimestamp("evaluate_time");
					String context=res.getString("evaluate_context");
					int state=res.getInt("evaluate_state");
					user=ud.queryUser(con,user_id);
					book=bd.queryBookDetail(con,book_id);
					evaluate=new Evaluate();
					evaluate.setUser(user);
					evaluate.setBook(book);
					evaluate.setTime(evaluate_time);
					evaluate.setContext(context);
					evaluate.setState(state);
					lists.add(evaluate);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public boolean isContainIllegal(Connection con,String context) {
		boolean flag=false;
		if(context.contains("*")) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<Evaluate> queryAllEvaluate(Connection con) {
		List<Evaluate> list=new ArrayList<>();
		IUserDao ud=new UserDaoImpl();
		IBookDao bd=new BookDaoImpl();
		try {
			String sql="select * from evaluate";
			ResultSet rs=DbUtils.executeQuery(con,sql,null);
			if(rs!=null)
			{
				Evaluate evaluate=null;
				User user=null;
				Book book=null;
				System.out.println(rs.next());
				while(rs.next())
				{
					/*
					evaluate.setUser(ud.queryUser(con,rs.getString("user_id")));
					evaluate.setBook(bd.queryBookDetail(con,rs.getString("book_id")));
					evaluate.setTime(rs.getTimestamp("evaluate_time"));
					evaluate.setContext(rs.getString("evaluate_context"));
					evaluate.setState(rs.getInt("evaluate_state"));
					evaluate=new Evaluate();
					list.add(evaluate);
					*/
					String user_id=rs.getString("user_id");
					String book_id=rs.getString("book_id");
					Timestamp evaluate_time=rs.getTimestamp("evaluate_time");
					String context=rs.getString("evaluate_context");
					int state=rs.getInt("evaluate_state");
					user=ud.queryUser(con,user_id);
					book=bd.queryBookDetail(con,book_id);
					evaluate=new Evaluate();
					evaluate.setUser(user);
					evaluate.setBook(book);
					evaluate.setTime(evaluate_time);
					evaluate.setContext(context);
					evaluate.setState(state);
					list.add(evaluate);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Evaluate> queryUserEvaluate(Connection con, String id) {
		List<Evaluate> list=new ArrayList<>();
		IUserDao ud=new UserDaoImpl();
		IBookDao bd=new BookDaoImpl();
		try {
			String sql="select * from evaluate where user_id=?";
			Object[] param={id};
			ResultSet rs=DbUtils.executeQuery(con, sql, param);
			if(rs!=null)
			{
				Evaluate evaluate=null;
				User user=null;
				Book book=null;
				while(rs.next())
				{
					/*
					evaluate.setUser(ud.queryUser(con,rs.getString("user_id")));
					evaluate.setBook(bd.queryBookDetail(con,rs.getString("book_id")));
					evaluate.setTime(rs.getTimestamp("evaluate_time"));
					evaluate.setContext(rs.getString("evaluate_context"));
					evaluate.setState(rs.getInt("evaluate_state"));
					evaluate=new Evaluate();
					list.add(evaluate);
					*/
					String user_id=rs.getString("user_id");
					String book_id=rs.getString("book_id");
					Timestamp evaluate_time=rs.getTimestamp("evaluate_time");
					String context=rs.getString("evaluate_context");
					int state=rs.getInt("evaluate_state");
					user=ud.queryUser(con,user_id);
					book=bd.queryBookDetail(con,book_id);
					evaluate=new Evaluate();
					evaluate.setUser(user);
					evaluate.setBook(book);
					evaluate.setTime(evaluate_time);
					evaluate.setContext(context);
					evaluate.setState(state);
					list.add(evaluate);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateState(Connection con, String evaluate_time) {
		boolean flag=false;
		String sql="update evaluate set evaluate_state=0 where  evaluate_time=?";
		Object[] param= {evaluate_time};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
		
	}

}
