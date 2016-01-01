package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;
import com.practice.webapp.dao.CourseDAO;
import com.practice.webapp.entity.Course;
//import com.practice.webapp.entity.ArticleCategory;
import com.practice.webapp.entity.CourseCate;

public class CourseDAOImpl implements CourseDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Course course) {
		// TODO Auto-generated method stub
		String sql = "INSERT course(Cour_Name,CourCate_ID,Cour_BriefIntro) "
				+ "VALUES(?,?,?)";
		try {
			
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, course.getCourName());
			smt.setInt(2, course.getCourseCate().getCourCateId());			
			smt.setString(3, course.getCourBriefIntro());
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
	
	
	public void newSem1Obl1(Course course) {  //上學期必修,新增
		// TODO Auto-generated method stub
		String sql = "UPDATE course SET Cour_Semester=?, Cour_Obligatory=?"
				+ " WHERE Cour_ID =? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, 1);			
			smt.setString(2, "A");
			smt.setInt(3, course.getCourId());
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
	public void newSem2Obl1(Course course) { //新增課程:下學期必修
		// TODO Auto-generated method stub
		String sql = "UPDATE course SET Cour_Semester=?, Cour_Obligatory=?"
				+ " WHERE Cour_ID =? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, 2);			
			smt.setString(2, "A");
			smt.setInt(3, course.getCourId());
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

	public void delete(Course course) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM course WHERE Cour_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, course.getCourId());			  
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


	public List<Course> getListSem1Obli1(CourseCate courseCate) {/////上學期必修list
		// TODO Auto-generated method stub
		List<Course> courListSem1Obli1 = new ArrayList<Course>();
		String sql = "SELECT * FROM Course AS A, CourseCate AS B WHERE A.CourCate_ID=B.CourCate_ID And A.CourCate_ID=? And A.Cour_Semester=1 And A.Cour_Obligatory='A'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, courseCate.getCourCateId());//大一到大四的ID
			rs = smt.executeQuery();
			System.out.println(courseCate.getCourCateId());
			while(rs.next()){
				Course course = new Course();
				course.setCourName(rs.getString("Cour_Name"));
				course.setCourId(rs.getInt("Cour_ID"));
				courListSem1Obli1.add(course);
				
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
		return courListSem1Obli1;
	}
	
	public List<Course> getListSem1Obli2(CourseCate courseCate) {/////上學期選修list
		// TODO Auto-generated method stub
		List<Course> courListSem1Obli1 = new ArrayList<Course>();
		String sql = "SELECT * FROM Course AS A, CourseCate AS B WHERE A.CourCate_ID=B.CourCate_ID And A.CourCate_ID=? And A.Cour_Semester=1 And A.Cour_Obligatory='B'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, courseCate.getCourCateId());//大一到大四的ID
			rs = smt.executeQuery();
			while(rs.next()){
				Course course = new Course();
				course.setCourId(rs.getInt("Cour_ID"));				
				course.setCourName(rs.getString("Cour_Name"));				
				courListSem1Obli1.add(course);
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
		return courListSem1Obli1;
	}
	
	public List<Course> getListSem2Obli1(CourseCate courseCate) {/////下學期必修
		// TODO Auto-generated method stub
		List<Course> courListSem2Obli1 = new ArrayList<Course>();
		String sql = "SELECT * FROM Course AS A, CourseCate AS B WHERE A.CourCate_ID=B.CourCate_ID And A.CourCate_ID=? And A.Cour_Semester=2 And A.Cour_Obligatory='A'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, courseCate.getCourCateId());//大一到大四的ID
			rs = smt.executeQuery();
			while(rs.next()){
				Course course = new Course();
				course.setCourId(rs.getInt("Cour_ID"));				
				course.setCourName(rs.getString("Cour_Name"));				
				courListSem2Obli1.add(course);
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
		return courListSem2Obli1;
	}
	
	public List<Course> getListSem2Obli2(CourseCate courseCate) {/////下學期必修
		// TODO Auto-generated method stub
		List<Course> courListSem2Obli1 = new ArrayList<Course>();
		String sql = "SELECT * FROM Course AS A, CourseCate AS B WHERE A.CourCate_ID=B.CourCate_ID And A.CourCate_ID=? And A.Cour_Semester=2 And A.Cour_Obligatory='B'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, courseCate.getCourCateId());//大一到大四的ID
			rs = smt.executeQuery();
			while(rs.next()){
				Course course = new Course();
				course.setCourId(rs.getInt("Cour_ID"));				
				course.setCourName(rs.getString("Cour_Name"));				
				courListSem2Obli1.add(course);
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
		return courListSem2Obli1;
	}
	
	

	public Course get(Course course) {///influence CommentDAOImpl, the type must implement the  
///inherited abstract method CommentDAO.get(Comment)
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM course WHERE Cour_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, course.getCourId());
			rs = smt.executeQuery();
			if(rs.next()){				
				course.setCourName(rs.getString("Cour_Name"));
				course.setCourSemester(rs.getInt("Cour_Semester"));
				course.setCourObligatory(rs.getString("Cour_Obligatory"));
				course.setCourBriefIntro(rs.getString("Cour_BriefIntro"));
//				comment.setComUploadDate(rs.getDate("Com_Upload_Date"));
				course.getCourseCate().setCourCateId(rs.getInt("CourCate_ID"));
				
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
		return course;
	}

	


}
