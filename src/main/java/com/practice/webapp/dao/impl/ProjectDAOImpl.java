package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.practice.webapp.dao.ProjectDAO;
import com.practice.webapp.entity.Project;

public class ProjectDAOImpl implements ProjectDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// @Override
	public void insert(Project project) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `project`(`Pro_ID`, `Prof_ID`, `Pro_Year`, `Pro_Title`, `Pro_Member`, `Pro_Introduction`, `Pro_Award`, `Pro_Video`) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, project.getProId());
			smt.setInt(2, project.getProfessor().getProfId());
			smt.setInt(3, project.getProYear());
			smt.setString(4, project.getProTitle());
			smt.setString(5, project.getProMember());
			smt.setString(6, project.getProIntroduction());
			smt.setString(7, project.getProAward());		
			smt.setString(8, project.getProVideo());
			smt.executeUpdate();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	// @Override
	public void delete(Project project) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `project` WHERE `project`.`Pro_ID` = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, project.getProId());
			smt.executeUpdate();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	// @Override
	public void update(Project project) {
		// TODO Auto-generated method stub

	}

	// @Override
	public List<Project> getList() {
		// TODO Auto-generated method stub
		List<Project> projectList = new ArrayList<Project>();
		String sql = "SELECT * FROM Project WHERE 'Pro_Year' = 2015 ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Project project = new Project();
				project.setProId(rs.getInt("Pro_ID"));			
				project.setProAward(rs.getString("Pro_Award"));
				project.setProIntroduction(rs.getString("Pro_Introduction"));
				project.setProMember(rs.getString("Pro_Member"));
				project.setProTitle(rs.getString("Pro_Title"));
				project.setProVideo(rs.getString("Pro_Video"));
				project.setProYear(rs.getInt("Pro_Year"));
				projectList.add(project);
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
	return projectList;
	}
	
	public List<Project> getyearList() {
		// TODO Auto-generated method stub
		List<Project> yearList = new ArrayList<Project>();
		String sql= "SELECT DISTINCT Pro_Year FROM Project order by Pro_Year DESC";
		
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				rs = smt.executeQuery();
				while(rs.next()){
					Project project = new Project();
					project.setProYear(rs.getInt("Pro_Year"));
					yearList.add(project);
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
		return yearList;
	}

	public ResultSet getRs() {
		return rs;
	}
}
