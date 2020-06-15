package service;

import java.util.List;

import javabean.Chapter;
import javabean.Evaluate;
import javabean.Read;
import javabean.Recharge;
import javabean.Reward;

public interface IRecordManagerService {
	List<Recharge> showReChargeRecord(); //显示所有的充值记录
	
	List<Reward> showRewardRecord();//显示所有的打赏记录
	
	List<Evaluate> showEvaluateRecord();//显示所有的评论记录
	
	List<Read> showReadRecord();//显示所有的阅读记录
	
	List<Chapter> showChapterRecord();//显示所有图书章节更新记录
	
	List<Recharge> showReChargeRecord(String user_id); //根据用户id查找充值记录
	
	List<Reward> showRewardRecord(String user_id);//根据用户id查找打赏记录
	
	List<Evaluate> showEvaluateRecord(String user_id);//根据用户id查找评论记录
	
	List<Read> showReadRecord(String user_id);//根据用户id查找阅读记录

	List<Chapter> showChapterRecord(String book_id);//显示某本图书章节更新记录

	
}
