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
import com.practice.webapp.entity.Comment;
//import com.practice.webapp.entity.ArticleCategory;

public class CommentDAOImpl implements CommentDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Comment comment) {
		// TODO Auto-generated method stub
		//String sql = "INSERT coursecomment(Cour_ID,Stu_ID,Com_Content,Prof_ID,Com_CourStars) "
		//		+ "VALUES(?,?,?,?,?)";
		String sql = "INSERT coursecomment(Cour_ID,Stu_ID,Com_Content,Com_CourStars) "
				+ "VALUES(?,?,?,?)";
		try {
			System.out.println("123");
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment.getCourse().getCourId());//課程規劃傳來的Cour_ID
			smt.setInt(2, comment.getStudent().getStuId());//登入的Stu_ID
			smt.setString(3, comment.getComContent());
			//smt.setInt(4, comment.getProfessor().getProfId());
			smt.setInt(4, comment.getCourStars());
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

	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM coursecomment WHERE Com_ID = ? And Cour_ID=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment.getComId());
			smt.setInt(2, comment.getCourse().getCourId());
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
			smt.setInt(1, comment.getAddLikes());					
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
	
	
	public void stateOK(Comment comment) {//系秘看過且通過
		// TODO Auto-generated method stub
		String sql = "UPDATE coursecomment SET Com_State=?, Secre_ID=?, Com_Upload_Date=NOW() "
				+ "WHERE Com_ID =? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setBoolean(1, comment.getComState());			
			smt.setInt(2, comment.getSecretary().getSecreId());
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

	public List<Comment> getList(Comment comment2) {
		// TODO Auto-generated method stub
		List<Comment> commentList = new ArrayList<Comment>();
		String sql = "SELECT * FROM CourseComment AS A, Course AS B WHERE A.Cour_ID=B.Cour_ID And B.Cour_ID=? And A.Com_State=1 ORDER BY Com_Likes DESC LIMIT 3";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment2.getCourse().getCourId());//課程規劃傳來的Cour_ID
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
	
	public List<Comment> getListOthersComment(Comment comment2) {
		// TODO Auto-generated method stub
		List<Comment> commentListOthersComment = new ArrayList<Comment>();
		String sql = "SELECT  * FROM coursecomment As A,course As B"
				+ "WHERE A.Cour_ID=B.Cour_ID And B.Cour_ID=? And A.Com_State=1"
				+ "ORDER BY Com_Likes DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setInt(1, comment2.getCourse().getCourId());//課程規劃傳來的Cour_ID
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
				//comment.setComState(rs.getBoolean("Com_State"));
				comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				//comment.getSecretary().setSecreId(rs.getInt("Secre_ID"));
				commentListOthersComment.add(comment);
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

	public List<Comment> getListMyComment(Comment comment2) {
		// TODO Auto-generated method stub
		List<Comment> commentListMyComment = new ArrayList<Comment>();
		String sql = "SELECT  * FROM coursecomment "
				+ "WHERE Cour_ID=? And Stu_ID=? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment2.getCourse().getCourId());//課程規劃傳來的Cour_ID
			smt.setInt(2, comment2.getStudent().getStuId());
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
				//comment.setComState(rs.getBoolean("Com_State"));
				comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				//comment.getSecretary().setSecreId(rs.getInt("Secre_ID"));
				commentListMyComment.add(comment);
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
		return commentListMyComment;
	}
	
	public List<Comment> getListSecretaryCheck(Comment comment2) {
		// TODO Auto-generated method stub
		List<Comment> commentListSecretaryCheck = new ArrayList<Comment>();
		String sql = "SELECT  * FROM coursecomment "
				+ "WHERE Cour_ID=? And Com_Content is not null And Secre_ID is null";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment2.getCourse().getCourId());//課程規劃傳來的Cour_ID
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
				comment.setComState(rs.getBoolean("Com_State"));
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
	
	public List<Comment> getListPassComment(Comment comment2) {
		// TODO Auto-generated method stub
		List<Comment> commentListPassComment = new ArrayList<Comment>();
		String sql = "SELECT  * FROM coursecomment "
				+ "WHERE Cour_ID=? And Cour_State=1 And Secre_ID is not null";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment2.getCourse().getCourId());//課程規劃傳來的Cour_ID
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
				//comment.setComState(rs.getBoolean("Com_State"));
				comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
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
				comment.setComState(rs.getBoolean("Com_State"));
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
