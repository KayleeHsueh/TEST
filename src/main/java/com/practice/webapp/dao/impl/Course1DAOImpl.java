package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.practice.webapp.dao.Course1DAO;
import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;

public class Course1DAOImpl implements Course1DAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public Course get1(Course Course111) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_Name  FROM 'course' where Cour_ID='11%' and Cour_Obligatory=必修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, Course111.getCourName());
			rs = smt.executeQuery();
			if(rs.next()){
				Course111.setCourName(rs.getString("Cour_Name"));
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
		return Course111;
	}
	public List<Course> getList111() {
		// TODO Auto-generated method stub
		List<Course> courNameList = new ArrayList<Course>();
		String sql = "SELECT Cour_Name FROM course WHERE Cour_ID LIKE '11%' and Cour_Obligatory='必修'";
		//String sql = "SELECT Cour_Name FROM course WHERE Cour_ID LIKE '%11' and Cour_Block_CourID='202'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			//System.out.println(rs.getString("Cour_Name"));
			while(rs.next()){
				System.out.println("123");
				Course courName = new Course();
				courName.setCourName(rs.getString("Cour_Name"));
				courNameList.add(courName);
			}
			//System.out.println(courNameList.get(0).getCourName());
			System.out.println("456");
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
		return courNameList;
	}
	public Course get2(Course Course112) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_Name  FROM 'course' where Cour_ID='11%' and Cour_Obligatory=選修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, Course112.getCourName());
			rs = smt.executeQuery();
			if(rs.next()){
				Course112.setCourName(rs.getString("Cour_Name"));
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
		return Course112;
	}
	public List<Course> getList112() {
		// TODO Auto-generated method stub
		List<Course> courNameList = new ArrayList<Course>();
		String sql = "SELECT Cour_Name FROM 'course' where Cour_ID='11%' and Cour_Obligatory=選修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Course courName = new Course();
				courName.setCourName(rs.getString("Cour_Name"));
				courNameList.add(courName);
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
		return courNameList;
	}
	public Course get3(Course Course121) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_Name  FROM 'course' where Cour_ID='12%' and Cour_Obligatory=必修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, Course121.getCourName());
			rs = smt.executeQuery();
			if(rs.next()){
				Course121.setCourName(rs.getString("Cour_Name"));
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
		return Course121;
	}
	public List<Course> getList121() {
		// TODO Auto-generated method stub
		List<Course> courNameList = new ArrayList<Course>();
		String sql = "SELECT Cour_Name FROM 'course' where Cour_ID='12%' and Cour_Obligatory=必修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Course courName = new Course();
				courName.setCourName(rs.getString("Cour_Name"));
				courNameList.add(courName);
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
		return courNameList;
	}
	public Course get4(Course Course122) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_Name  FROM 'course' where Cour_ID='12%' and Cour_Obligatory=選修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, Course122.getCourName());
			rs = smt.executeQuery();
			if(rs.next()){
				Course122.setCourName(rs.getString("Cour_Name"));
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
		return Course122;
	}
	public List<Course> getList122() {
		// TODO Auto-generated method stub
		List<Course> courNameList = new ArrayList<Course>();
		String sql = "SELECT Cour_Name FROM 'course' where Cour_ID='12%' and Cour_Obligatory=選修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Course courName = new Course();
				courName.setCourName(rs.getString("Cour_Name"));
				courNameList.add(courName);
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
		return courNameList;
	}
	public Course get(Course CourBriefIntro) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_BriefIntro FROM 'course' where Cour_ID='1%'";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, CourBriefIntro.getCourBriefIntro());
			rs = smt.executeQuery();
			if(rs.next()){
				CourBriefIntro.setCourBriefIntro(rs.getString("Cour_BriefIntro"));
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
		return CourBriefIntro;
	}
	public List<Course> getListCourBriefIntro() {
		// TODO Auto-generated method stub
		List<Course> courBriefIntroList = new ArrayList<Course>();
		String sql = "SELECT Cour_BriefIntro FROM 'course' where Cour_ID='1%'";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Course courBriefIntro = new Course();
				courBriefIntro.setCourBriefIntro(rs.getString("Cour_BriefIntro"));
				courBriefIntroList.add(courBriefIntro);
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
		return courBriefIntroList;
	}
	public CourseCate getCourseCate(CourseCate CourseCate) {
		// TODO Auto-generated method stub
		String sql = "SELECT CourCate_Name FROM 'coursecate' where CourCate_Name='801'";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, CourseCate.getCourCateName());
			rs = smt.executeQuery();
			if(rs.next()){
				CourseCate.setCourCateName(rs.getString("CourCate_Name"));
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
		return CourseCate;
	}
	public List<CourseCate> getListCate() {
		// TODO Auto-generated method stub
		List<CourseCate> courseCateList = new ArrayList<CourseCate>();
		String sql = "SELECT CourCate_Name FROM 'coursecate' where CourCate_Name='801' ";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				CourseCate courseCate = new CourseCate();
				courseCate.setCourCateName(rs.getString("CourCate_Name"));
				courseCateList.add(courseCate);
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
		return courseCateList;
	}
}
