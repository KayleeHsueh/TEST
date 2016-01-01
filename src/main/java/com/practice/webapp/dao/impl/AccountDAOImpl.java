package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;
import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.Student;
import com.practice.webapp.dao.AccountDAO;

public class AccountDAOImpl implements AccountDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean checkLoginStudent(int id, String password){
		boolean flag=false;
		String sql="SELECT * FROM student";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				int sId=rs.getInt("Stu_ID");
				String dPassword=rs.getString("Stu_Password");
				if(id==sId&&password.equals(dPassword)){
					flag=true;
				}
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
		return flag;
	}
	
	public boolean checkLoginSecretary(int id, String password){
		boolean flag=false;
		String sql="SELECT Secre_ID, Secre_Password FROM `secretary`";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				int sId=rs.getInt("Secre_ID");
				String dPassword=rs.getString("Secre_Password");
				if(id==sId&&password.equals(dPassword)){
					flag=true;
				}
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
		return flag;
	}
	
	public boolean checkLoginGraduate(int id, String password){
		boolean flag=false;
		String sql="SELECT * FROM `graduate`";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				int gId=rs.getInt("Grad_ID");
				String dPassword=rs.getString("Grad_Password");
				if(id==gId&&password.equals(dPassword)){
					flag=true;
				}
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
		return flag;
	}
	
	public Account getStudent(Account account){
		String sql="SELECT * FROM student WHERE Stu_ID=?";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,account.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				account.setUserName(rs.getString("Stu_Name"));
				account.setClassName(rs.getString("Stu_Class"));
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
		return account;
	}
	
	public Account getGraduate(Account account){
		String sql="SELECT * FROM graduate WHERE Grad_ID=?";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,account.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				account.setCompanyName(rs.getString("Grad_Company"));
				account.setPosition(rs.getString("Grad_Position"));
				account.setPicture(rs.getString("Grad_Picture"));
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
		return account;
	}
}

