package com.practice.webapp.dao.impl;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;
import javax.websocket.Session;

//import com.mysql.jdbc.Statement;
import com.practice.webapp.dao.QADAO;
import com.practice.webapp.entity.QA;
//import com.practice.webapp.entity.ArticleCategory;

import java.io.File;
import java.text.MessageFormat;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class QADAOImpl implements QADAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	
	String mailsever = "gmail.com";
	String From = "winterhan10@gmail.com";
	
	String Subject = "輔大資管系問題相關回復，請查看";
	
	boolean sessionDebug = false;
	
	boolean Send_Status = false;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	//Ask the Question
	public void insert(QA qa) {
		// TODO Auto-generated method stub
		String sql = "INSERT qa(Asker_Name, Asker_Email, QCate_ID,Question_Content,Upload_Date)" + "VALUES(?,?,?,?,NOW())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, qa.getAsker_Name());
			smt.setString(2, qa.getAsker_Email());
			smt.setInt(3, qa.getQuestionCategory().getQCate_ID());
			smt.setString(4, qa.getQuestion_Content());
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
	
	public void delete(QA qa) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM qa WHERE Question_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, qa.getQuestion_ID());
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
	//Answer the Question
	public void update(QA qa) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM qa a WHERE QCate_ID=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, qa.getQuestionCategory().getQCate_ID());
			rs = smt.executeQuery();
			while(rs.next()){
				qa.getQuestionCategory().setQCate_ID(rs.getInt("QCate_ID"));
				qa.getQuestionCategory().setQCate_Name(rs.getString("QCate_Name"));
				qa.setAsker_Name(rs.getString("Asker_Name"));
				qa.setAsker_Email(rs.getString("Asker_Email"));
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
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
		
		sql = "UPDATE qa SET QCate_ID=?, Answer_Content=?, ProblemSet=?, Upload_Date=NOW() "
				+ "WHERE Question_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, qa.getQuestionCategory().getQCate_ID());
			smt.setString(2, qa.getAnswer_Content());
			smt.setBoolean(3, qa.getProblemSet());
			smt.setInt(4, qa.getQuestion_ID());
			smt.executeUpdate();	
			doSendMail(qa.getAsker_Name(),qa.getAsker_Email(),qa.getQuestion_Content(),qa.getAnswer_Content());
			
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
	
	public void doSendMail(String Asker_Name, String Asker_Email, String Question_Content, String Answer_Content) {
		String subject="輔大資管系相關問題回覆";
	    String template = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
		"<html>\n" + "<head>\n" + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
	    "<title>輔大資管系相關問題回覆</title>\n" +
	    "</head>\n" + "<body>\n" + 
		"親愛的{Asker_Name}您好，您所發問的{Question_Content}之解答如下。<br/>\n" + 
	    "解答：{Answer_Content}。\n" + 
		"</body>\n" + "</html>\n";
	    String message = "";

	    HtmlEmail email = new HtmlEmail();
	    String authuser = "winterhan10@gmail.com@gmail.com";
	    String authpwd = "defy364tick4377";
	    email.setHostName("smtp.gmail.com");
	    email.setSmtpPort(465);
	    email.setAuthenticator(new DefaultAuthenticator(authuser, authpwd));
	    email.setDebug(true);
	    email.setSSL(true);
	    email.setSslSmtpPort("465");
	    email.setCharset("UTF-8");
	    email.setSubject(subject);
	    try {
	      email.setFrom("winterhan10@gmail.com", "FJU");
	      message = MessageFormat.format(template, new Object[] { Asker_Name, Question_Content, Answer_Content});
	      email.setHtmlMsg(message);
	      email.addTo(Asker_Email, Asker_Name);
	      email.send();
	      // out.println("郵件發送成功");
	    } catch (EmailException e) {
	      e.printStackTrace();
	    }
	}
	
	public List<QA> getProblemSetFalseList() {
		// TODO Auto-generated method stub
		List<QA> qaList = new ArrayList<QA>();
		String sql = "SELECT * FROM qa a "
				+ "WHERE ProblemSet = 0 JOIN QCate_ID b ON a.QCate_ID = b.QCate_ID "
				+ "ORDER BY Question_ID DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				QA qa = new QA();
				qa.getQuestionCategory().setQCate_ID(rs.getInt("QCate_ID"));
				qa.getQuestionCategory().setQCate_Name(rs.getString("QCate_Name"));
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
				qaList.add(qa);
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
		return qaList;
	}
	
	public List<QA> getProblemSetTrueList() {
		// TODO Auto-generated method stub
		List<QA> qaList = new ArrayList<QA>();
		String sql = "SELECT * FROM qa a "
				+ "WHERE ProblemSet = 1 JOIN QCate_ID b ON a.QCate_ID = b.QCate_ID "
				+ "ORDER BY Question_ID DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				QA qa = new QA();
				qa.getQuestionCategory().setQCate_ID(rs.getInt("QCate_ID"));
				qa.getQuestionCategory().setQCate_Name(rs.getString("QCate_Name"));
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
				qaList.add(qa);
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
		return qaList;
	}
	public List<QA> getTrueList() {
		// TODO Auto-generated method stub
		List<QA> qaList = new ArrayList<QA>();
		String sql = "SELECT * FROM qa a "
				+ "WHERE Answer_Content = NULL JOIN QCate_ID b ON a.QCate_ID = b.QCate_ID "
				+ "ORDER BY Question_ID DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				QA qa = new QA();
				qa.getQuestionCategory().setQCate_ID(rs.getInt("QCate_ID"));
				qa.getQuestionCategory().setQCate_Name(rs.getString("QCate_Name"));
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
				qaList.add(qa);
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
		return qaList;
	}
	public List<QA> getFalseList() {
		// TODO Auto-generated method stub
		List<QA> qaList = new ArrayList<QA>();
		String sql = "SELECT * FROM qa a "
				+ "WHERE Answer_Content != NULL JOIN QCate_ID b ON a.QCate_ID = b.QCate_ID "
				+ "ORDER BY Question_ID DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				QA qa = new QA();
				qa.getQuestionCategory().setQCate_ID(rs.getInt("QCate_ID"));
				qa.getQuestionCategory().setQCate_Name(rs.getString("QCate_Name"));
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
				qaList.add(qa);
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
		return qaList;
	}

	public QA get(QA qa) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM qa WHERE Question_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, qa.getQuestion_ID());
			rs = smt.executeQuery();
			if(rs.next()){
				qa.getQuestionCategory().setQCate_ID(rs.getInt("QCate_ID"));
				qa.getQuestionCategory().setQCate_Name(rs.getString("QCate_Name"));
				qa.setQuestion_ID(rs.getInt("Question_ID"));
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setProblemSet(rs.getBoolean("ProblemSet"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
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
		return qa;
	}


}
