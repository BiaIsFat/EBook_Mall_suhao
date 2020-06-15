package dao;

import java.sql.Connection;
import java.util.List;

import javabean.Recharge;

public interface IRechargeDao {
	boolean addRecharge(Connection con,Recharge recharge);//增加充值记录
	
	List<Recharge>queryRechrge(Connection con,String user_id);//查询充值记录
	
	List<Recharge> queryRechargeAll(Connection con);//查询所有的充值记录
}
