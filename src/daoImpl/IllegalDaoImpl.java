package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Illegal;

public class IllegalDaoImpl implements IIllegalDao {

	@Override
	public List<Illegal> queryAllIllegal(Connection con) {
		List<Illegal> lists=new ArrayList<>();
		IUserDao ud=new UserDaoImpl();
		try {
			String sql="select * from illegal";
			ResultSet res=DbUtils.executeQuery(con, sql, null);
			Illegal illegal=null;
			while(res.next()) {
				illegal=new Illegal();
				illegal.setUser(ud.queryUser(con,res.getString("user_id")));
				illegal.setContext(res.getString("context"));
				illegal.setTime(res.getTimestamp("illegal_time"));
				lists.add(illegal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
		
		
	}

	@Override
	public List<Illegal> allBlockUser(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addIllegal(Connection con, Illegal illegal) {
		boolean flag=false;
		String sql="insert into illegal values(?,?,?)";
		Object[] param= {illegal.getUser().getId(),illegal.getContext(),illegal.getTime()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	
	//public List<Illegal> allBlockUser() {
	//	return lists;
	//}

}
