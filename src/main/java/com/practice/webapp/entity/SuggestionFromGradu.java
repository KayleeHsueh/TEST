package com.practice.webapp.entity;

public class SuggestionFromGradu {
	private int sugId;
	private int sugState;
	private String sugForFresh;
	private String sugUploadDate;
	private String sugWorkSharing;
	private Graduate graduate = new Graduate();
	private Secretary secretary= new Secretary();

	public int getSugId() {
		return sugId;
	}
	public void setSugId(int sugId) {
		this.sugId = sugId;
	}
	public String getSugForFresh() {
		return sugForFresh;
	}
	public void setSugForFresh(String sugForFresh) {
		this.sugForFresh = sugForFresh;
	}
	public String getSugUploadDate() {
		return sugUploadDate;
	}
	public void setSugUploadDate(String sugUploadDate) {
		this.sugUploadDate = sugUploadDate;
	}
	public String getSugWorkSharing() {
		return sugWorkSharing;
	}
	public void setSugWorkSharing(String sugWorkSharing) {
		this.sugWorkSharing = sugWorkSharing;
	}
	
	public int getSugState() {
		return sugState;
	}
	public void setSugState(int sugState) {
		this.sugState = sugState;
	}
	public Graduate getGraduate() {
		return graduate;
	}
	public void setGraduate(Graduate graduate) {
		this.graduate = graduate;
	}
	public Secretary getSecretary() {
		return secretary;
	}
	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}
	
}
