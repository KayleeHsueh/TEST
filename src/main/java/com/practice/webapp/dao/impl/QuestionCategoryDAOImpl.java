package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.QuestionCategoryDAO;
import com.practice.webapp.entity.QuestionCategory;

public class QuestionCategoryDAOImpl implements QuestionCategoryDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<QuestionCategory> getList() {
		// TODO Auto-generated method stub
		List<QuestionCategory> questionCategoryList = new ArrayList<QuestionCategory>();
		String sql = "SELECT * FROM questioncategory";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				QuestionCategory questionCategory = new QuestionCategory();
				questionCategory.setqCate_ID(rs.getInt("QCate_ID"));
				questionCategory.setqCate_Name(rs.getString("QCate_Name"));
				questionCategoryList.add(questionCategory);
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
		return questionCategoryList;
	}
	
}
