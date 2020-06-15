package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtils.DbUtils;
import javabean.Author;

public class AuthorDaoImpl implements IAuthorDao {

	@Override
	public Author queryAuthor(Connection con,String author_id) { //����id���Ҷ���
		Author author=new Author();
		try {
			String sql="select * from Author where author_id=?";
			Object[] param={author_id};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					author.setId(res.getString("author_id"));
					author.setName(res.getString("author_name"));
					author.setPass(res.getString("author_pass"));
					author.setTel(res.getString("author_tel"));
					author.setAddr(res.getString("author_addr"));
					author.setBalan(res.getDouble("author_balan"));
					author.setBrief(res.getString("author_brief"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public boolean addAuthor(Connection con,Author author){		
		boolean flag=false;
		String sql="insert into Author values(?,?,?,?,?,?,?)";
		Object[] param={author.getId(),author.getName(),author.getPass(),author.getTel(),author.getAddr(),0,author.getBrief()};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public boolean isExistAuthor(Connection con,String author_tel) {
		boolean flag=false;
		try {
			String sql="select * from Author where author_tel=?";
			Object[] param= {author_tel};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean checkAuthor(Connection con,Author author) {
		boolean flag=false;
		try {
			String sql="select * from Author where author_tel=? and author_pass=?";
			Object[] param={author.getTel(),author.getPass()};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean rewarded(Connection con, String author_id, double amount) {
		boolean flag=false;
		String sql="update author set author_balan=author_balan+? where author_id=?;";
		Object[] param= {amount,author_id};
		flag=DbUtils.executeUpdate(con, sql, param);
		return flag;
	}

	@Override
	public Author queryBookByAuthorName(Connection con, String author_name) {
		Author author=new Author();
		try {
			String sql="select * from Author where author_name=?";
			Object[] param={author_name};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					author.setId(res.getString("author_id"));
					author.setName(res.getString("author_name"));
					author.setPass(res.getString("author_pass"));
					author.setTel(res.getString("author_tel"));
					author.setAddr(res.getString("author_addr"));
					author.setBalan(res.getDouble("author_balan"));
					author.setBrief(res.getString("author_brief"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public Author queryAuthorByTel(Connection con, String author_tel) {
		Author author=new Author();
		try {
			String sql="select * from Author where author_tel=?";
			Object[] param={author_tel};
			ResultSet res=DbUtils.executeQuery(con,sql,param);
			if(res!=null){
				if(res.next()){
					author.setId(res.getString("author_id"));
					author.setName(res.getString("author_name"));
					author.setPass(res.getString("author_pass"));
					author.setTel(res.getString("author_tel"));
					author.setAddr(res.getString("author_addr"));
					author.setBalan(res.getDouble("author_balan"));
					author.setBrief(res.getString("author_brief"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return author;
	}

}
