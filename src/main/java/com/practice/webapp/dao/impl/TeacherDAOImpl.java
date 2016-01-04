package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;
import com.practice.webapp.entity.Teacher;
import com.practice.webapp.dao.TeacherDAO;

public class TeacherDAOImpl implements TeacherDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Teacher aTeacher) {

		// Add Teacher
	    String sql = "INSERT INTO professor(Prof_Name, Prof_Picture, Prof_GraduateSchool, Prof_GraduateDepartment, Prof_Degree) VALUES(?, ?, ?, ?, ?)";	
		try {
			System.out.println("hi");
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aTeacher.getProfName());
			smt.setString(2, aTeacher.getProfPicture());
			smt.setString(3, aTeacher.getProfGraduateSchool());
			smt.setString(4, aTeacher.getProfGraduateDepartment());
			smt.setString(5, aTeacher.getProfDegree());
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
		
		// Add Professor Specialty
//		for (int i =0; i< aTeacher.getProfSpeName().size(); i++)
//		{
//		//	Check professorspecialty exist ?
//		sql = "SELECT ProfSpe_ID FROM professorspecialty WHERE ProfSpe_Name = ?";
//		try {
//			conn = dataSource.getConnection();
//			smt = conn.prepareStatement(sql);
//			// Choose i'st Professor Specialty
//			smt.setString(1, aTeacher.getProfSpeName().get(i));
//			rs = smt.executeQuery();
//			// IF professorspecialty not exist
//			if (rs.getRow() == 0)
//			{
//				// INSERT professorspecialty
//				sql = "INSERT INTO professorspecialty(ProfSpe_Name) VALUES(?)";
//			    smt = conn.prepareStatement(sql);
//			    smt.setString(1, aTeacher.getProfSpeName().get(i));
//			    smt.executeUpdate();
//			}
//			rs.close();
//			smt.close();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
// 
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {}
//			}
//		}
//		}
		
		// Add professorhasmanyspecialty
		for (int i =0; i< aTeacher.getProfSpeName().size(); i++)
		{
		sql = "SELECT ProfSpe_ID, Prof_ID From professor, professorspecialty WHERE ProfSpe_Name = N? AND Prof_Name = N? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aTeacher.getProfSpeName().get(i));
			smt.setString(2, aTeacher.getProfName());
			rs = smt.executeQuery();
			while(rs.next()){
				System.out.println("name" + aTeacher.getProfName());
				// INSERT professorhasmanyspecialty
				sql = "INSERT INTO professorhasmanyspecialty(ProfSpe_ID, Prof_ID) VALUES(?, ?)";
			    smt = conn.prepareStatement(sql);
			    smt.setInt(1, rs.getInt("ProfSpe_ID"));
			    smt.setInt(2, rs.getInt("Prof_ID"));
			    smt.executeUpdate();
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
		}
		
	}

	public void delete(Teacher aTeacher) {
		
		//  SELECT Prof_ID
		String sql = "";
		try {
			System.out.println("chuchu1");
			conn = dataSource.getConnection();
				// Delete professor
				sql = "DELETE FROM professor WHERE Prof_ID = ?";	
			    smt = conn.prepareStatement(sql);
			    smt.setInt(1, aTeacher.getProfID());
			    smt.executeUpdate();
			    
			    // Delete professorhasmanyspecialty
				sql = "DELETE FROM professorhasmanyspecialty WHERE Prof_ID = ?";
			    smt = conn.prepareStatement(sql);
			    smt.setInt(1,aTeacher.getProfID());
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

	/* public void update(Product aProduct) {
		
		String sql = "UPDATE product SET Category=?, Description=?, Inventory=?, ReorderPoint=? "
				+ "WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aProduct.getCategory());
			smt.setString(2, aProduct.getDesc());
			smt.setInt(3, aProduct.getInventory());
			smt.setInt(4, aProduct.getReorderPoint());
			smt.setLong(5, aProduct.getId());
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
	*/
	
/*	
	public List<Teacher> getAvailableList() {
		String sql = "SELECT * FROM professor WHERE Prof_ID > 0";
		return getList(sql);
	}
	

	public List<Product> getReorderList() {
		String sql = "SELECT * FROM product WHERE Inventory < ReorderPoint";
		return getList(sql);
	}
	
*/
	public List<Teacher> getTeacherList() {
		String sql = "SELECT * FROM professor";
		return getList(sql);
	}
	public List<Teacher> getSpecialtyList(int profSpeID) {
		List<Teacher> SpecialtyList = new ArrayList<Teacher>();
		String sq1= "SELECT professor.Prof_ID AS Prof_ID, professor.Prof_Name AS Prof_Name, professor.Prof_Picture AS Prof_Picture, professor.Prof_GraduateSchool AS Prof_GraduateSchool, professor.Prof_GraduateDepartment AS Prof_GraduateDepartment, professor.Prof_Degree AS Prof_Degree FROM professor, professorspecialty, professorhasmanyspecialty WHERE professorspecialty.ProfSpe_ID = ? AND professorhasmanyspecialty.ProfSpe_ID = ? AND professor.Prof_ID = professorhasmanyspecialty.Prof_ID";
			try { 
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sq1);
			smt.setInt(1,profSpeID);
			smt.setInt(2,profSpeID);
			rs = smt.executeQuery();
			while(rs.next()){
				Teacher aTeacher = new Teacher();
				aTeacher.setProfName(rs.getString("Prof_Name"));			
				aTeacher.setProfPicture(rs.getString("Prof_Picture"));
				aTeacher.setProfGraduateSchool(rs.getString("Prof_GraduateSchool"));
				aTeacher.setProfGraduateDepartment(rs.getString("Prof_GraduateDepartment"));
				aTeacher.setProfDegree(rs.getString("Prof_Degree"));
				aTeacher.setProfID(rs.getInt("Prof_ID"));
				SpecialtyList.add(aTeacher);
				
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
		return SpecialtyList;
	}

	// make it a generic method for different conditions
	public List<Teacher> getList(String sql) {
		
		List<Teacher> TeacherList = new ArrayList<Teacher>();
		//will need this part later
		/*
		String sql = "SELECT * FROM article a "
				+ "JOIN article_category b ON a.articleCategoryID = b.articleCategoryID "
				+ "ORDER BY articleID DESC";
		*/
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Teacher aTeacher = new Teacher();
				aTeacher.setProfName(rs.getString("profName"));			
				aTeacher.setProfPicture(rs.getString("profPicture"));
				aTeacher.setProfGraduateSchool(rs.getString("profGraduateSchool"));
				aTeacher.setProfGraduateDepartment(rs.getString("profGraduateDepartment"));
				aTeacher.setProfDegree(rs.getString("profpDegree"));
				
				// Add Multiple ProfSpe_Name
				sql = "SELECT professorspecialty.ProfSpe_Name AS ProfSpe_Name FROM professor, professorspecialty, professorhasmanyspecialty WHERE professor.Prof_ID = professorhasmanyspecialty.Prof_ID AND professorspecialty.ProfSpe_ID = professorhasmanyspecialty.ProfSpe_ID AND professor.Prof_Name =?";
				smt = conn.prepareStatement(sql);
			    smt.setString(1, rs.getString("profName"));
			    ResultSet rs2 = smt.executeQuery();
			    while(rs2.next())
				//aTeacher.setProfSpeName(rs.getString("ProfSpe_Name"));
			    rs2.close();
			    
				TeacherList.add(aTeacher);
				
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
		return TeacherList;
	}
    
	
	// Know Prof_Name, Query Another
	public Teacher get(Teacher aTeacher) {
		
		String sql = "SELECT * FROM professor WHERE Prof_Name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aTeacher.getProfName());
			rs = smt.executeQuery();
			if(rs.next()){		
				aTeacher.setProfPicture(rs.getString("profPicture"));
				aTeacher.setProfGraduateSchool(rs.getString("profGraduateSchool"));
				aTeacher.setProfGraduateDepartment(rs.getString("profGraduateDepartment"));
				aTeacher.setProfDegree(rs.getString("profDegree"));
				
				// Add Multiple ProfSpe_Name
				sql = "SELECT professorspecialty.ProfSpe_Name AS ProfSpe_Name FROM professor, professorspecialty, professorhasmanyspecialty WHERE professor.Prof_ID = professorhasmanyspecialty.Prof_ID AND professorspecialty.ProfSpe_ID = professorhasmanyspecialty.ProfSpe_ID AND professor.Prof_Name = ?";
				smt = conn.prepareStatement(sql);
			    smt.setString(1, rs.getString("profName"));
			    ResultSet rs2 = smt.executeQuery();
			    while(rs2.next())
				//aTeacher.setProfSpeName(rs2.getString("profSpeName"));
			    rs2.close();
				
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
		return aTeacher;
	}


}
