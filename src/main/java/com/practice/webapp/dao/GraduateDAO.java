package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.SuggestionFromGradu;

public interface GraduateDAO {
	public void insert(SuggestionFromGradu suggestionFG , Account account);//�s�W�դͫ�ĳ
	public void delete(SuggestionFromGradu suggestionFG);//�R���ӤH���
	public void stateOK(SuggestionFromGradu suggestionFG , Account account);
	public List<SuggestionFromGradu> getList();	
	public List<SuggestionFromGradu> getMyList(SuggestionFromGradu suggestionFG2 , Account account);
	public List<SuggestionFromGradu> getListSecretaryCheck();
	public SuggestionFromGradu get(SuggestionFromGradu suggestionFG);
	
}
