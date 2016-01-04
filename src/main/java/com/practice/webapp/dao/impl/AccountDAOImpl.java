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

	public boolean checkLoginStudent(String name, String password){
		boolean flag=false;
		String sql="SELECT Stu_ID, Stu_Password FROM `student`";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				String dName=rs.getString("Stu_ID");
				String dPassword=rs.getString("Stu_Password");
				if(name.equals(dName)&&password.equals(dPassword)){
					flag=true;
					/*
					smt.setInt(1, name);
					smt.setString(2, password);
					*/
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
	
	public boolean checkLoginSecretary(String name, String password){
		boolean flag=false;
		String sql="SELECT Secre_ID, Secre_Password FROM `secretary`";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				String dName=rs.getString("Secre_ID");
				String dPassword=rs.getString("Secre_Password");
				if(name.equals(dName)&&password.equals(dPassword)){
					flag=true;
					/*
					smt.setInt(1, name);
					smt.setString(2, password);
					*/
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
}

