package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Illegal;

public interface IIllegalDao {
	List<Illegal> queryAllIllegal(Connection con); //显示所有违规信息
	
	List<Illegal> allBlockUser(Connection con);//显示所有违规的人
	
	boolean addIllegal(Connection con,Illegal illegal);//增加违规记录
	
	
}
