package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;
import com.practice.webapp.dao.CommentDAO;
import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.Comment;
import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.Professor;
import com.practice.webapp.entity.TeacherHMC;
//import com.practice.webapp.entity.ArticleCategory;

public class CommentDAOImpl implements CommentDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Comment comment, Account account, Professor professor, Course course) {
		// TODO Auto-generated method stub
		//String sql = "INSERT coursecomment(Cour_ID,Stu_ID,Com_Content,Prof_ID,Com_CourStars) "
		//		+ "VALUES(?,?,?,?,?)";
		String sql = "INSERT coursecomment(Cour_ID,Stu_ID,Com_Content,Prof_ID,Com_CourStars) "
				+ "VALUES(?,?,?,?,?)";
		try {
			System.out.println("123");
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, course.getCourId());//課程規劃傳來的Cour_ID
			smt.setInt(2, account.getId());//登入的Stu_ID
			smt.setString(3, comment.getComContent());
			smt.setInt(4, professor.getProfId());
			smt.setInt(5, comment.getCourStars());
			smt.executeUpdate();			
			smt.close();
			System.out.println(comment.getComContent());
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public void delete(Comment comment, Course course) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM coursecomment WHERE Com_ID = ? And Cour_ID=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment.getComId());
			smt.setInt(2, course.getCourId());
			smt.executeUpdate();			
			smt.close();
			System.out.println(comment.getComId());
			System.out.println(course.getCourId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public void update(Comment comment) {
		// TODO Auto-generated method stub
		String sql = "UPDATE coursecomment SET Com_Content=?,Prof_ID=? Com_CourStars=?"
				+ "WHERE Cour_ID = ? And Stu_ID=? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, comment.getComContent());
			smt.setInt(2, comment.getProfessor().getProfId());
			smt.setInt(3, comment.getCourStars());		
			smt.setInt(4, comment.getCourse().getCourId());
			smt.setInt(5, comment.getStudent().getStuId());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	
	public void AddLikes(Comment comment) {//在學生按別人評論讚
		// TODO Auto-generated method stub
		String sql = "UPDATE coursecomment SET Com_Likes=? "
				+ "WHERE Com_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment.getAddLikes()+1);					
			smt.setInt(2, comment.getComId());
			smt.executeUpdate();			
			smt.close();
			System.out.println(comment.getAddLikes());
			System.out.println(comment.getComId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	
	public void stateOK(Comment comment, Account account) {//系秘看過且通過
		// TODO Auto-generated method stub
		String sql = "UPDATE coursecomment SET Com_State=?, Secre_ID=?, Com_Upload_Date=NOW() "
				+ "WHERE Com_ID =? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, 1);			
			smt.setInt(2, account.getId());
			smt.setInt(3, comment.getComId());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	
	public void stateNotOK(Comment comment) { //系秘有看過但退回
		// TODO Auto-generated method stub
		String sql = "UPDATE coursecomment SET Secre_ID=?"
				+ "WHERE Com_ID =? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);					
			smt.setInt(1, comment.getSecretary().getSecreId());
			smt.setInt(2, comment.getComId());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public List<Comment> getList(Course course) {
		// TODO Auto-generated method stub
		List<Comment> commentList = new ArrayList<Comment>();
		String sql = "SELECT  * FROM coursecomment As A,course As B, student As C, professor As D WHERE A.Cour_ID=B.Cour_ID And A.Stu_ID=C.Stu_ID And A.Prof_ID=D.Prof_ID And A.Cour_ID=? And A.Com_State=1 ORDER BY Com_Likes DESC LIMIT 3";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			//smt.setInt(1, comment2.getCourse().getCourId());//課程規劃傳來的Cour_ID
			//smt.setInt(1, 311);
			smt.setInt(1, course.getCourId());
			
			rs = smt.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				
				comment.getStudent().setStuId(rs.getInt("Stu_ID"));
				comment.getStudent().setStuClass(rs.getString("Stu_Class"));
				comment.getStudent().setStuName(rs.getString("Stu_Name"));
				comment.setComId(rs.getInt("Com_ID"));
				comment.setComContent(rs.getString("Com_Content"));
				//comment.setComLikes(rs.getInt("Com_Likes"));
				comment.setCourStars(rs.getInt("Com_CourStars"));
				//comment.setComState(rs.getBoolean("Com_State"));
				//comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				//comment.getSecretary().setSecreId(rs.getInt("Secre_ID"));
				commentList.add(comment);
				System.out.println(course.getCourId());
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return commentList;
	}
	
	public List<Comment> getListOthersComment(Course course) {
		// TODO Auto-generated method stub
		List<Comment> commentListOthersComment = new ArrayList<Comment>();
		String sql = "SELECT  * FROM coursecomment As A,course As B, student As C, professor As D "
				+ "WHERE A.Cour_ID=B.Cour_ID  And A.Stu_ID=C.Stu_ID And A.Prof_ID=D.Prof_ID And A.Cour_ID=? And A.Com_State=1 "
				+ "ORDER BY Com_Likes DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setInt(1, course.getCourId());//課程規劃傳來的Cour_ID
			rs = smt.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				//Course course2=new Course();
				//course2.setCourId(course.getCourId());
				comment.getCourse().setCourId(rs.getInt("Cour_ID"));
				System.out.println("Course ID= "+rs.getInt("Cour_ID"));
				comment.getStudent().setStuId(rs.getInt("Stu_ID"));
				comment.getStudent().setStuClass(rs.getString("Stu_Class"));
				comment.getStudent().setStuName(rs.getString("Stu_Name"));
				comment.setComId(rs.getInt("Com_ID"));
				comment.setComContent(rs.getString("Com_Content"));
				comment.getProfessor().setProfName(rs.getString("Prof_Name"));
				comment.setComLikes(rs.getInt("Com_Likes"));
				comment.setCourStars(rs.getInt("Com_CourStars"));
				//comment.setComState(rs.getBoolean("Com_State"));
				comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				//comment.getSecretary().setSecreId(rs.getInt("Secre_ID"));
				commentListOthersComment.add(comment);
				System.out.println("GetOtherCOmment"+rs.getInt("Com_Likes"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return commentListOthersComment;
	}

	public Comment getListMyComment(Course course, Account account) {
		// TODO Auto-generated method stub
		String sql = "SELECT  * FROM coursecomment As A,course As B, student As C, professor As D "
				+ "WHERE A.Cour_ID=B.Cour_ID  And A.Stu_ID=C.Stu_ID And A.Prof_ID=D.Prof_ID And A.Cour_ID=? And A.Stu_ID=?";
		Comment comment = new Comment();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, course.getCourId());//課程規劃傳來的Cour_ID
			smt.setInt(2, account.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				comment.getStudent().setStuId(rs.getInt("Stu_ID"));
				comment.getStudent().setStuClass(rs.getString("Stu_Class"));
				comment.getStudent().setStuName(rs.getString("Stu_Name"));
				comment.setComId(rs.getInt("Com_ID"));
				comment.setComContent(rs.getString("Com_Content"));
				comment.getProfessor().setProfName(rs.getString("Prof_Name"));
				comment.setComLikes(rs.getInt("Com_Likes"));
				comment.setCourStars(rs.getInt("Com_CourStars"));
				comment.setComState(rs.getInt("Com_State"));
				comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				comment.getSecretary().setSecreId(rs.getInt("Secre_ID"));
				System.out.println("Is there anyone?");
			}
			System.out.println("Course Id: "+course.getCourId());
			System.out.println("My school Id:"+account.getId() );
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return comment;
	}

	
	public List<Comment> getListSecretaryCheck() {     ///////Yilin
		// TODO Auto-generated method stub
		List<Comment> commentListSecretaryCheck = new ArrayList<Comment>();
		String sql = "SELECT  * FROM coursecomment As A,course As B, student As C, professor As D"
				+ " WHERE A.Cour_ID=B.Cour_ID  And A.Stu_ID=C.Stu_ID And A.Prof_ID=D.Prof_ID And A.Com_Content is not null And A.Secre_ID is null";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			//smt.setInt(1, comment2.getCourse().getCourId());//課程規劃傳來的Cour_ID
			//smt.setInt(2, comment2.getStudent().getStuId());
			rs = smt.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				
				comment.getStudent().setStuId(rs.getInt("Stu_ID"));
				comment.getStudent().setStuClass(rs.getString("Stu_Class"));
				comment.getStudent().setStuName(rs.getString("Stu_Name"));
				comment.setComId(rs.getInt("Com_ID"));
				comment.setComContent(rs.getString("Com_Content"));
				comment.getProfessor().setProfName(rs.getString("Prof_Name"));
				comment.setComLikes(rs.getInt("Com_Likes"));
				comment.setCourStars(rs.getInt("Com_CourStars"));
				comment.setComState(rs.getInt("Com_State"));
				comment.getCourse().setCourName(rs.getString("Cour_Name"));
				//comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				//comment.getSecretary().setSecreId(rs.getInt("Secre_ID"));
				commentListSecretaryCheck.add(comment);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return commentListSecretaryCheck;
	}
	
	public List<Comment> getListPassComment() {     ///////Yilin
		// TODO Auto-generated method stub
		List<Comment> commentListPassComment = new ArrayList<Comment>();
		String sql = "SELECT  * FROM coursecomment As A,course As B, student As C, professor As D"
				+ " WHERE  A.Cour_ID=B.Cour_ID  And A.Stu_ID=C.Stu_ID And A.Prof_ID=D.Prof_ID And A.Com_State=1 And A.Secre_ID is not null";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			//smt.setInt(1, comment2.getCourse().getCourId());//課程規劃傳來的Cour_ID
			//smt.setInt(2, comment2.getStudent().getStuId());
			rs = smt.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				System.out.println(rs.getInt("Cour_ID"));
				comment.getStudent().setStuId(rs.getInt("Stu_ID"));
				comment.getStudent().setStuClass(rs.getString("Stu_Class"));
				comment.getStudent().setStuName(rs.getString("Stu_Name"));
				comment.setComId(rs.getInt("Com_ID"));
				comment.setComContent(rs.getString("Com_Content"));
				comment.getProfessor().setProfName(rs.getString("Prof_Name"));
				comment.setComLikes(rs.getInt("Com_Likes"));
				comment.setCourStars(rs.getInt("Com_CourStars"));
				comment.setComState(rs.getInt("Com_State"));
				comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				comment.getCourse().setCourId(rs.getInt("Cour_ID"));
				comment.getCourse().setCourName(rs.getString("Cour_Name"));
				//comment.getSecretary().setSecreId(rs.getInt("Secre_ID"));
				commentListPassComment.add(comment);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return commentListPassComment;
	}
	
	public List<TeacherHMC> getTeacherList(Course course) {     ///////Yilin
		// TODO Auto-generated method stub
		List<TeacherHMC> teacherList = new ArrayList<TeacherHMC>();
		String sql = "SELECT * FROM teacherteachmanycourse AS A , professor AS B WHERE A.Cour_ID=? And A.prof_ID=B.prof_ID";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, course.getCourId());//課程規劃傳來的Cour_ID
			//smt.setInt(2, comment2.getStudent().getStuId());
			rs = smt.executeQuery();
			while(rs.next()){
				TeacherHMC teacherHMC= new TeacherHMC();
				System.out.println(rs.getInt("Cour_ID"));
				teacherHMC.getProfessor().setProfName(rs.getString("Prof_Name"));
				teacherHMC.getProfessor().setProfId(rs.getInt("Prof_ID"));
				teacherList.add(teacherHMC);
				System.out.println("Professor ID: "+rs.getInt("Prof_ID"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return teacherList;
	}



	public Comment get(Comment comment) {///influence CommentDAOImpl, the type must implement the  
///inherited abstract method CommentDAO.get(Comment)
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM coursecomment WHERE Com_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment.getComId());
			rs = smt.executeQuery();
			if(rs.next()){				
				comment.setComContent(rs.getString("Com_Content"));
				comment.setComLikes(rs.getInt("Com_Likes"));
				comment.setCourStars(rs.getInt("Com_CourStars"));
				comment.setComState(rs.getInt("Com_State"));
				comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				comment.getCourse().setCourId(rs.getInt("Cour_ID"));
				comment.getStudent().setStuId(rs.getInt("Stu_ID"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return comment;
	}

	


}
