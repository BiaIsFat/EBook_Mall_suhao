package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Search;

public interface ISearchDao {
	boolean addSearch(Connection con,Search search);//增加搜索记录
	
	List<Search> querySearch(Connection con);//查询搜索记录
}
