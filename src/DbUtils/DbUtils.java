package DbUtils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DbUtils {
	 private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>() ;
	public static Connection getConnection() {
        Connection conn = threadLocal.get() ;    // 先判断一下在ThreadLocal里是否有连接对象
        if(conn == null) {    // 第一次使用，没有连接，没有连接应该创建一个连接
            conn = connectionDatabase() ;    // 获取连接对象
            threadLocal.set(conn);     // 将刚刚创建好的连接对象保存在ThreadLocal之中
        }
        return conn ;    // 返回连接对象
    }
    /**
     * 进行数据库的关闭处理。
     */
    public static void close() {
        Connection conn = threadLocal.get() ;
        if (conn != null) {    // 现在有连接对象了
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            threadLocal.remove();     // 从当前线程之中删除掉指定连接
        }
    }
    /**
     * 负责创建一个数据库连接对象
     * @return 数据库连接的实例化对象
     */
    private static Connection connectionDatabase() {    // 该方法只能本类调用
        Connection conn = null ;
        try {    // 一旦连接出现了错误，整个程序都无发执行
        	Class.forName("com.mysql.cj.jdbc.Driver");
            ResourceBundle bundle=ResourceBundle.getBundle("database");
    		String url=bundle.getString("url");
    		String user=bundle.getString("user");
    		String password=bundle.getString("password");
            conn = DriverManager.getConnection(url, user, password) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn ;    // 获得数据库连接对象
    }
//	private static PreparedStatement ps; //�������������̬��ʱδ����
	//private static ResultSet res;
	static{ //��̬����飬��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static PreparedStatement getps(Connection con,String sql,Object[] param){ //���preparedstatement����
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					ps.setObject(i+1,param[i]);
				}
			}
			return ps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static boolean executeUpdate(Connection con,String sql,Object[] param){ //ִ����ɾ�Ĳ�������
		try {
			PreparedStatement ps=getps(con,sql,param);
			int count=ps.executeUpdate(); 
			if(count>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static ResultSet executeQuery(Connection con,String sql,Object[] param){ //ִ�в�ѯ���
		try {
			PreparedStatement ps=getps(con,sql,param);
			return ps.executeQuery(); //���ؽ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
