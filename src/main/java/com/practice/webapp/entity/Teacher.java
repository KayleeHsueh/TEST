package com.practice.webapp.entity;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	private int profID;
    private String profName;
    private List<String> profSpeName = new ArrayList<String>();
    private String profPicture;
    private String profGraduateSchool;
    private String profGraduateDepartment;
    private String profDegree;
    
    
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public List<String> getProfSpeName() {
		return profSpeName;
	}
	public void setProfSpeName(List<String> profSpeName) {
		this.profSpeName = profSpeName;
	}
	public String getProfPicture() {
		return profPicture;
	}
	public void setProfPicture(String profPicture) {
		this.profPicture = profPicture;
	}
	public String getProfGraduateSchool() {
		return profGraduateSchool;
	}
	public void setProfGraduateSchool(String profGraduateSchool) {
		this.profGraduateSchool = profGraduateSchool;
	}
	public String getProfGraduateDepartment() {
		return profGraduateDepartment;
	}
	public void setProfGraduateDepartment(String profGraduateDepartment) {
		this.profGraduateDepartment = profGraduateDepartment;
	}
	public String getProfDegree() {
		return profDegree;
	}
	public void setProfDegree(String profDegree) {
		this.profDegree = profDegree;
	}
	public int getProfID() {
		return profID;
	}
	public void setProfID(int profID) {
		this.profID = profID;
	}
    
    /* SELECT COLUMN */

    /* getters and setters */
    /*
    public String getProf_Name(){
            return prof_Name;
    }
    public void setProf_Name(String Prof_Name){
    	this.prof_Name = Prof_Name;
    }

    public List<String> getProfSpe_Name(){
            return ProfSpe_Name;
    }
    public void setProfSpe_Name(String ProfSpe_Name){
        this.ProfSpe_Name.add(ProfSpe_Name);
    }
    
    public String getProf_Picture(){
        return Prof_Picture;
    }
    public void setProf_Picture(String Prof_Picture){
    	this.Prof_Picture = Prof_Picture;
    }

    public String Prof_GraduateSchool(){
    		return Prof_GraduateSchool;
    }
    public void setProf_GraduateSchool(String Prof_GraduateSchool){
		this.Prof_GraduateSchool = Prof_GraduateSchool;
    }
    
    public String getProf_GraduateDepartment(){
    		return Prof_GraduateDepartment;
    }
    public void setProf_GraduateDepartment(String Prof_GraduateDepartment){
		this.Prof_GraduateDepartment = Prof_GraduateDepartment;
    }
    
    public String getProf_Degree(){
		return Prof_Degree;
    }
    public void setProf_Degree(String Prof_Degree){
	this.Prof_Degree = Prof_Degree;
    }
  */
}