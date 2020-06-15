package DbUtils;

import java.util.Calendar;
import java.util.Date;

import dao.ChapterDaoImpl;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Utils {
	public static Timestamp getNowTime() {
		Timestamp time=null;
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time=Timestamp.valueOf(sdf.format(date));
		return time;
	}
	
	public static String getTimeId() {
		 Calendar calendar = Calendar.getInstance();  
		  String year=String.valueOf(calendar.get(Calendar.YEAR));
		  String mounth=String.valueOf(calendar.get(Calendar.MONTH));
		  String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		  String hour=String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		  String min=String.valueOf(calendar.get(Calendar.MINUTE));
		  String second=String.valueOf(calendar.get(Calendar.SECOND));
		  String time=year+mounth+day+hour+min+second;
		  return time;
		  
	}
	
	public static String getBookImg(String type) {
		String path="./images/bookimages/"+type+".jpg";
		return path;
	}
	
	public static int getChapterId(String book_id){
		Connection con=DbUtils.getConnection();
		int chapter_id=new ChapterDaoImpl().getPreChapterId(con, book_id);
		DbUtils.close();
		chapter_id=chapter_id;
		return chapter_id;
	}
}
