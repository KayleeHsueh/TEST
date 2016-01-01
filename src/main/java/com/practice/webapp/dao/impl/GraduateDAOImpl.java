package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.GraduateDAO;
import com.practice.webapp.entity.SuggestionFromGradu;
import com.practice.webapp.entity.Account;

public class GraduateDAOImpl implements GraduateDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(SuggestionFromGradu suggestionFG , Account account) {
		// TODO Auto-generated method stub
		String sql = "INSERT suggestionfromgradu(Sug_ID,Grad_ID,Sug_SugForFresh, Sug_WorkSharing) "
				+ "VALUES(?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, suggestionFG.getSugId());
			smt.setInt(2, account.getId());
			smt.setString(3, suggestionFG.getSugForFresh());
			smt.setString(4, suggestionFG.getSugWorkSharing());
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

	public void delete(SuggestionFromGradu suggestionFG) { /////Yilin:Sug_ID = ?
		// TODO Auto-generated method stub
		String sql = "DELETE FROM suggestionfromgradu WHERE Sug_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, suggestionFG.getSugId());
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

	public void stateOK(SuggestionFromGradu suggestionFG , Account account) {//系秘看過且通過       ///////Yilin
		// TODO Auto-generated method stub
		String sql = "UPDATE suggestionfromgradu SET Sug_State=?, Secre_ID=?, Sug_Upload_Date=NOW() "
				+ " WHERE Sug_ID =? And Sug_SugForFresh is not null And Sug_State=0";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, suggestionFG.getSugState());			
			smt.setInt(2, account.getId());
			smt.setInt(3, suggestionFG.getSugId());
			
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
	
	public List<SuggestionFromGradu> getList() {  //剛中生看到頁面
		// TODO Auto-generated method stub
		List<SuggestionFromGradu> sugList = new ArrayList<SuggestionFromGradu>();
		String sql = "SELECT * FROM suggestionfromgradu AS A, graduate AS B WHERE A.Grad_ID=B.Grad_ID  And A.Sug_State=1 ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			rs = smt.executeQuery();
			while(rs.next()){
				SuggestionFromGradu suggestionFG = new SuggestionFromGradu();
				
				suggestionFG.getGraduate().setGradName(rs.getString("Grad_Name"));
				suggestionFG.getGraduate().setGradWork(rs.getInt("Grad_Work"));
				suggestionFG.getGraduate().setGradCompany(rs.getString("Grad_Company"));
				suggestionFG.getGraduate().setGradPosition(rs.getString("Grad_Position"));
				suggestionFG.getGraduate().setGradPicture(rs.getString("Grad_Picture"));
				suggestionFG.setSugForFresh(rs.getString("Sug_SugForFresh"));				
				suggestionFG.setSugWorkSharing(rs.getString("Sug_WorkSharing"));
				
				sugList.add(suggestionFG);
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
		return sugList;
	}
	
	public List<SuggestionFromGradu> getMyList(SuggestionFromGradu suggestionFG2 , Account account) {  //剛中生看到頁面
		// TODO Auto-generated method stub
		List<SuggestionFromGradu> mySugList = new ArrayList<SuggestionFromGradu>();
		String sql = "SELECT * FROM suggestionfromgradu AS A, graduate AS B WHERE A.Grad_ID=B.Grad_ID  And A.Grad_ID=? And A.Sug_State=1 ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);	
			smt.setInt(1,  account.getId());
			rs = smt.executeQuery();
			while(rs.next()){
				SuggestionFromGradu suggestionFG = new SuggestionFromGradu();
				
				suggestionFG.getGraduate().setGradName(rs.getString("Grad_Name"));				
				suggestionFG.setSugForFresh(rs.getString("Sug_SugForFresh"));				
				suggestionFG.setSugWorkSharing(rs.getString("Sug_WorkSharing"));
				
				mySugList.add(suggestionFG);
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
		return mySugList;
	}
	
	public List<SuggestionFromGradu> getListSecretaryCheck() {  //系秘書審核頁面
		// TODO Auto-generated method stub
		List<SuggestionFromGradu> myListSecreCheck = new ArrayList<SuggestionFromGradu>();
		String sql = "SELECT  * FROM suggestionfromgradu AS A, Graduate AS B "
				+ " WHERE A.Grad_ID=B.Grad_ID And A.Sug_SugForFresh is not null And A.Sug_State=0";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);	
			
			rs = smt.executeQuery();
			while(rs.next()){
				SuggestionFromGradu suggestionFG = new SuggestionFromGradu();
				
				suggestionFG.getGraduate().setGradName(rs.getString("Grad_Name"));				
				suggestionFG.setSugForFresh(rs.getString("Sug_SugForFresh"));				
				suggestionFG.setSugWorkSharing(rs.getString("Sug_WorkSharing"));
				
				myListSecreCheck.add(suggestionFG);
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
		return myListSecreCheck;
	}
	
	public SuggestionFromGradu get(SuggestionFromGradu suggestionFG ) {///influence CommentDAOImpl, the type must implement the  
		///inherited abstract method CommentDAO.get(Comment)
				// TODO Auto-generated method stub
				String sql = "SELECT * FROM coursecomment AS A, Graduate AS B WHERE A.Grad_ID =B.Grad_ID And Sug_ID=? ";
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setInt(1, suggestionFG.getSugId());
					rs = smt.executeQuery();
					if(rs.next()){				
						suggestionFG.getGraduate().setGradName(rs.getString("Grad_Name"));
						suggestionFG.getGraduate().setGradWork(rs.getInt("Grad_Work"));
						suggestionFG.getGraduate().setGradCompany(rs.getString("Grad_Company"));
						suggestionFG.getGraduate().setGradPosition(rs.getString("Grad_Position"));
						suggestionFG.getGraduate().setGradPicture(rs.getString("Grad_Picture"));
						suggestionFG.setSugForFresh(rs.getString("Sug_SugForFresh"));				
						suggestionFG.setSugWorkSharing(rs.getString("Sug_WorkSharing"));
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
				return suggestionFG;
			}

	
}