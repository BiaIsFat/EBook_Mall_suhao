package servlet;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class baseservlet
 */ 
@WebServlet("/baseservlet")
public class baseservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public baseservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String optionname=request.getParameter("option"); //�õ���Ҫ�Ĳ�������
        if(optionname==null) {
            throw new RuntimeException("阿斯顿撒method啊打算大苏打撒");
        }
        Method method=null;
        try {  //�����thisָ���ǵ�ǰ�࣬�������̳���bseservlet����this��������
			method=this.getClass().getDeclaredMethod(optionname,HttpServletRequest.class,HttpServletResponse.class);
			//�����optionnameָ���Ƿ������������ǲ���request��response�����������������
			//�÷����Ǹ����㴫�ķ���������ģ�����̬��
		} catch(NoSuchMethodException e){
            //���û���ҵ���˵����д��Servlet��û�д˷���
            throw new RuntimeException("�����õ�"+optionname+
            "(HttpServletRequest request , HttpServletResponse response)����������",e);
        }
        try {
			method.invoke(this,request,response);//��̬����this��method����Ϊrequest��response����������servlet�ķ���
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
