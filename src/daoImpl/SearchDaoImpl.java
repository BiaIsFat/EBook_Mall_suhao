package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DbUtils.DbUtils;
import javabean.Search;

public class SearchDaoImpl implements ISearchDao {

	@Override
	public boolean addSearch(Connection con,Search search) {
		boolean flag=false;
		String sql="insert into search values(?,?,?)";
		Object[] param= {search.getUser().getId(),search.getBook().getId(),search.getTime()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;

	}

	@Override
	public List<Search> querySearch(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
