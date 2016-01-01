package com.practice.webapp.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements java.io.Serializable {

	/**
	 * serialVersionUID is generated automatically
	 */
	private static final long serialVersionUID = 3476619468809859762L;
	private List<Long> productList = new ArrayList<Long>();

	public List<Long> getCart(){
		return productList;
	}
	public void add(long aProduct){
		productList.add(aProduct);
	}
	public int count(){
		return productList.size();
	}
	public void cleanup(){
		productList = new ArrayList<Long>();
	}

}
