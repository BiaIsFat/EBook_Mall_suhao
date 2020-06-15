package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DbUtils.DbUtils;
import dao.BookDaoImpl;
import dao.ChapterDaoImpl;
import dao.EvaluateDaoImpl;
import dao.IBookDao;
import dao.IChapterDao;
import dao.IEvaluateDao;
import dao.IReadDao;
import dao.IRechargeDao;
import dao.IRewardDao;
import dao.IUserDao;
import dao.ReadDaoImpl;
import dao.RechargeDaoImpl;
import dao.RewardDaoImpl;
import dao.UserDaoImpl;
import javabean.Chapter;
import javabean.Evaluate;
import javabean.Read;
import javabean.Recharge;
import javabean.Reward;

public class RecordManagerServiceImpl implements IRecordManagerService {
	private IUserDao userdao=null;
	private IRechargeDao rechargedao=null;
	private IBookDao bookdao=null;
	private IRewardDao rewarddao=null;
	private IEvaluateDao evaluatedao=null;
	private IReadDao readdao=null;
	private IChapterDao chapterdao=null;
	public RecordManagerServiceImpl() {
		userdao=new UserDaoImpl();
		rechargedao=new RechargeDaoImpl();
		rewarddao=new RewardDaoImpl();
		bookdao=new BookDaoImpl();
		evaluatedao=new EvaluateDaoImpl();
		readdao=new ReadDaoImpl();
		chapterdao=new ChapterDaoImpl();
	}
	@Override
	public List<Recharge> showReChargeRecord() {
		Connection con=DbUtils.getConnection();
		List<Recharge> lists=rechargedao.queryRechargeAll(con);
		DbUtils.close();
		return lists;
	}

	@Override
	public List<Reward> showRewardRecord() {
		Connection con=DbUtils.getConnection();
		List<Reward> list=rewarddao.queryAllReward(con);
		DbUtils.close();
		return list;
	}

	@Override
	public List<Evaluate> showEvaluateRecord() {
		Connection con=DbUtils.getConnection();
		List<Evaluate> list=evaluatedao.queryAllEvaluate(con);
		DbUtils.close();
		return list;
	}

	@Override
	public List<Read> showReadRecord() {
		Connection con=DbUtils.getConnection();
	    List<Read> list=readdao.queryAllReadRecord(con);
	    DbUtils.close();
	    return list;
	}

	@Override
	public List<Recharge> showReChargeRecord(String user_id) {
		Connection con=DbUtils.getConnection();
		List<Recharge> lists=rechargedao.queryRechrge(con, user_id); //调用dao层对应的方法，返回
		DbUtils.close();
		return lists;
	}

	@Override
	public List<Reward> showRewardRecord(String user_id) {
		Connection con=DbUtils.getConnection();
		List<Reward> list=rewarddao.queryUserReward(con, user_id);
		DbUtils.close();
		return list;
	}

	@Override
	public List<Evaluate> showEvaluateRecord(String user_id) {
		Connection con=DbUtils.getConnection();
		List<Evaluate> list=evaluatedao.queryUserEvaluate(con, user_id);
		DbUtils.close();
		return list;
	}

	@Override
	public List<Read> showReadRecord(String user_id) {
		Connection con=DbUtils.getConnection();
	    List<Read> list=readdao.queryReadRecord(con, user_id);
	    DbUtils.close();
	    return list;
	}
	
	@Override
	public List<Chapter> showChapterRecord() {
		Connection con=DbUtils.getConnection();
	    List<Chapter> list=chapterdao.queryChapterRecord(con);
	    DbUtils.close();
	    return list;
	}@Override
	public List<Chapter> showChapterRecord(String book_id) {
		Connection con=DbUtils.getConnection();
	    List<Chapter> list=chapterdao.queryChapter(con, book_id);
	    DbUtils.close();
	    return list;
	}
}
