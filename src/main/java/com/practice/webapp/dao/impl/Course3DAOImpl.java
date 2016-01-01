package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;
import com.practice.webapp.dao.Course3DAO;
import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;

public class Course3DAOImpl implements Course3DAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public Course get1(Course Course311) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_Name  FROM 'course' where Cour_ID='31%' and Cour_Obligatory=必修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, Course311.getCourName());
			rs = smt.executeQuery();
			if(rs.next()){
				Course311.setCourName(rs.getString("Cour_Name"));
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
		return Course311;
	}
	public List<Course> getList311() {
		// TODO Auto-generated method stub
		List<Course> courNameList = new ArrayList<Course>();
		String sql = "SELECT Cour_Name FROM 'course' where Cour_ID='31%' and Cour_Obligatory=必修";
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
	
	public Course get2(Course Course312) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_Name  FROM 'course' where Cour_ID='31%' and Cour_Obligatory=選修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, Course312.getCourName());
			rs = smt.executeQuery();
			if(rs.next()){
				Course312.setCourName(rs.getString("Cour_Name"));
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
		return Course312;
	}
	public List<Course> getList312() {
		// TODO Auto-generated method stub
		List<Course> courNameList = new ArrayList<Course>();
		String sql = "SELECT Cour_Name FROM 'course' where Cour_ID='31%' and Cour_Obligatory=選修";
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
	public Course get3(Course Course321) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_Name  FROM 'course' where Cour_ID='32%' and Cour_Obligatory=必修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, Course321.getCourName());
			rs = smt.executeQuery();
			if(rs.next()){
				Course321.setCourName(rs.getString("Cour_Name"));
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
		return Course321;
	}
	public List<Course> getList321() {
		// TODO Auto-generated method stub
		List<Course> courNameList = new ArrayList<Course>();
		String sql = "SELECT Cour_Name FROM 'course' where Cour_ID='32%' and Cour_Obligatory=必修";
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
	public Course get4(Course Course322) {
		// TODO Auto-generated method stub
		String sql = "SELECT Cour_Name  FROM 'course' where Cour_ID='32%' and Cour_Obligatory=選修";
		try {
			conn = dataSource.getConnection();
			smt = (PreparedStatement) conn.prepareStatement(sql);
			smt.setString(1, Course322.getCourName());
			rs = smt.executeQuery();
			if(rs.next()){
				Course322.setCourName(rs.getString("Cour_Name"));
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
		return Course322;
	}
	public List<Course> getList322() {
		// TODO Auto-generated method stub
		List<Course> courNameList = new ArrayList<Course>();
		String sql = "SELECT Cour_Name FROM 'course' where Cour_ID='32%' and Cour_Obligatory=選修";
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
		String sql = "SELECT Cour_BriefIntro FROM 'course' where Cour_ID='3%'";
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
		String sql = "SELECT Cour_BriefIntro FROM 'course' where Cour_ID='3%'";
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