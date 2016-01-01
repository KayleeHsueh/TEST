package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.ResourceAndIntroPicture;

public interface ResourceAndIntroPictureDAO {
	public void insert(ResourceAndIntroPicture resourceandintropicture);
	public void delete(ResourceAndIntroPicture resourceandintropicture);
	//public void update(ResourceAndIntroPicture resourceandintropicture);
	List<ResourceAndIntroPicture> getRIPlist();
	List<ResourceAndIntroPicture> getHomepageList();
	List<ResourceAndIntroPicture> getHomepageList_Home();
}
