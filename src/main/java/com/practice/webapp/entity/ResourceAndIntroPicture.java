package com.practice.webapp.entity;

import java.sql.Date;
import java.util.List;

public class ResourceAndIntroPicture {
	private int RIPicId;
	private String RIPicTitle;
	private String RIPicPicture;
	private String RIPicContent;
	private Date RIPicUploadDate;

	
	public int getRIPicId() {
		return RIPicId;
	}
	public void setRIPicId(int rIPicId) {
		RIPicId = rIPicId;
	}
	public String getRIPicTitle() {
		return RIPicTitle;
	}
	public void setRIPicTitle(String rIPicTitle) {
		RIPicTitle = rIPicTitle;
	}
	public String getRIPicPicture() {
		return RIPicPicture;
	}
	public void setRIPicPicture(String rIPicPicture) {
		RIPicPicture = rIPicPicture;
	}
	public String getRIPicContent() {
		return RIPicContent;
	}
	public void setRIPicContent(String rIPicContent) {
		RIPicContent = rIPicContent;
	}
	public Date getRIPicUploadDate() {
		return RIPicUploadDate;
	}
	public void setRIPicUploadDate(Date rIPicUploadDate) {
		RIPicUploadDate = rIPicUploadDate;
	}

		
}
