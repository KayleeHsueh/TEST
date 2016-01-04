package com.practice.webapp.dao.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;


//import com.mysql.jdbc.Statement;
import com.practice.webapp.dao.QADAO;
import com.practice.webapp.entity.QA;
import com.practice.webapp.entity.QuestionCategory;
//import com.practice.webapp.entity.ArticleCategory;


import java.text.MessageFormat;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class QADAOImpl implements QADAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	
	boolean sessionDebug = false;
	
	boolean Send_Status = false;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	//Ask the Question
	public void insert(QA qa) {
		// TODO Auto-generated method stub
		String sql = "INSERT qa(Asker_Name, Asker_Email, QCate_ID, Question_Content, Upload_Date)" + "VALUES(?,?,?,?,NOW())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, qa.getAsker_Name());
			smt.setString(2, qa.getAsker_Email());
			smt.setInt(3, qa.getQuestionCategory().getqCate_ID());
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
		String sql = "DELETE FROM qa WHERE Question_ID= ?";
		try{
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
		String sql = "UPDATE qa SET Answer_Content=?, ProblemSet=?, Upload_Date=NOW() "
				+ "WHERE Question_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, qa.getAnswer_Content());
			smt.setBoolean(2, qa.isProblemSet());
			smt.setInt(3, qa.getQuestion_ID());
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
		
		sql = "SELECT * FROM qa a WHERE Question_ID=?";//To get asker info
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, qa.getQuestion_ID());
			rs = smt.executeQuery();
			while(rs.next()){
				System.out.println("hihihi");
				qa.getQuestionCategory().setqCate_ID(rs.getInt("QCate_ID"));
				qa.setAsker_Name(rs.getString("Asker_Name"));
				qa.setAsker_Email(rs.getString("Asker_Email"));
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
			}
			rs.close();
			smt.close();
			
			doSendMail(qa.getAsker_Name(),qa.getAsker_Email(),qa.getQuestion_Content(),qa.getAnswer_Content());
			
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
	
	public void doSendMail(String asker_Name, String asker_Email, String question_Content, String answer_Content) {
		String subject="輔大資管系相關問題回覆";
	    String template = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
		"<html>\n" + "<head>\n" + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
	    "<title>輔大資管系相關問題回覆</title>\n" +
	    "</head>\n" + "<body>\n" + 
		"親愛的{0}您好，您所發問的{1}之解答如下。<br/>\n" + 
	    "解答：{2}。\n" + 
		"</body>\n" + "</html>\n";
	    String message = "";

	    HtmlEmail email = new HtmlEmail();
	    String authuser = "winterhan10@gmail.com";
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
	      message = MessageFormat.format(template, new Object[] { asker_Name, question_Content, answer_Content});
	      email.setHtmlMsg(message);
	      email.addTo(asker_Email, asker_Name);
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
				qa.getQuestionCategory().setqCate_ID(rs.getInt("QCate_ID"));
				qa.getQuestionCategory().setqCate_Name(rs.getString("QCate_Name"));
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
		String sql = "SELECT * FROM qa as a, questioncategory as b "
				+ "WHERE  a.ProblemSet IS true "
				+ "AND a.QCate_ID = b.QCate_ID "
				+ "ORDER BY Question_ID DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				QA qa = new QA();
				QuestionCategory qc = new QuestionCategory();
				qc.setqCate_ID(rs.getInt("QCate_ID"));
				qc.setqCate_Name(rs.getString("QCate_Name"));
				qa.setQuestionCategory(qc);
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
				qa.setProblemSet(rs.getBoolean("ProblemSet"));
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
	//待回答
	public List<QA> getTrueList() {
		// TODO Auto-generated method stub
		List<QA> qaList = new ArrayList<QA>();
		String sql = "SELECT * FROM qa as a, questioncategory as b "
				+ "WHERE  a.Answer_Content IS NULL "
				+ "AND a.QCate_ID = b.QCate_ID "
				+ "ORDER BY Question_ID DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				System.out.println("HAHAHA");
				QA qa = new QA();
				QuestionCategory qc = new QuestionCategory();
				qc.setqCate_ID(rs.getInt("QCate_ID"));
				qc.setqCate_Name(rs.getString("QCate_Name"));
				qa.setQuestionCategory(qc);
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
				qa.setQuestion_ID(rs.getInt("Question_ID"));
				qa.setProblemSet(rs.getBoolean("ProblemSet"));
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
	//已回答
	public List<QA> getFalseList() {
		// TODO Auto-generated method stub
		List<QA> qaList = new ArrayList<QA>();
		String sql = "SELECT * FROM qa as a, questioncategory as b "
				+ "WHERE  a.Answer_Content IS NOT NULL "
				+ "AND a.QCate_ID = b.QCate_ID "
				+ "ORDER BY Question_ID DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				QA qa = new QA();
				QuestionCategory qc = new QuestionCategory();
				qc.setqCate_ID(rs.getInt("QCate_ID"));
				qc.setqCate_Name(rs.getString("QCate_Name"));
				qa.setQuestionCategory(qc);
				qa.setQuestion_Content(rs.getString("Question_Content"));
				qa.setAnswer_Content(rs.getString("Answer_Content"));
				qa.setUpload_Date(rs.getDate("Upload_Date"));
				qa.setQuestion_ID(rs.getInt("Question_ID"));
				qa.setProblemSet(rs.getBoolean("ProblemSet"));
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
				qa.getQuestionCategory().setqCate_ID(rs.getInt("QCate_ID"));
				qa.getQuestionCategory().setqCate_Name(rs.getString("QCate_Name"));
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
