package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;
import com.practice.webapp.dao.CourseHMIDAO;
import com.practice.webapp.entity.CourseHasManyInformation;
//import com.practice.webapp.entity.ArticleCategory;

public class CourseHMIDAOImpl implements CourseHMIDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public List<CourseHasManyInformation> getList(CourseHasManyInformation courseHMI2) {
		// TODO Auto-generated method stub
		List<CourseHasManyInformation> courseHMIList = new ArrayList<CourseHasManyInformation>();
		String sql = "SELECT * FROM coursehasmanyinformation "
				+ "WHERE Cour_ID=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, courseHMI2.getCourse().getCourId());			
			rs = smt.executeQuery();
			while(rs.next()){
				CourseHasManyInformation courseHMI = new CourseHasManyInformation();
				courseHMI.getCourseInformation().setCourInfoId(rs.getInt("CourInfo_ID"));
				courseHMI.getCourseInformation().setCourInfoName(rs.getString("CourInfo_Name"));
				courseHMIList.add(courseHMI);
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
		return courseHMIList;
	}

	public CourseHasManyInformation get(CourseHasManyInformation courseHMI) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM coursehasmanyinformation WHERE Cour_ID = ? And CourInfo_ID=? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, courseHMI.getCourse().getCourId());
			smt.setInt(2, courseHMI.getCourseInformation().getCourInfoId());
			rs = smt.executeQuery();
			if(rs.next()){
				courseHMI.getCourse().setCourName(rs.getString("Cour_Name"));
				courseHMI.getCourseInformation().setCourInfoName(rs.getString("CourInfo_Name"));
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
		return courseHMI;
	}


}
