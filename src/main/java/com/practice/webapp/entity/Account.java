package com.practice.webapp.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)

public class Account implements java.io.Serializable {

	/**
	 * serialVersionUID is generated automatically
	 */
	private static final long serialVersionUID = 3476619468809859762L;
	private String username;
	private String password;
	private String identity;
	private String schoolID;
	private String className;
	private boolean isLogin;

	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

	public void setIdentity(String identity){
		this.identity = identity;
	}
	public String getIdentity(){
		return identity;
	}
	public void setSchoolID(String schoolID){
		this.schoolID=schoolID;
	}
	public String getSchoolID(){
		return schoolID;
	}
	public void setClassName(String className){
		this.className=className;
	}
	public String getclassName(){
		return className;
	}
	public boolean getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
}
