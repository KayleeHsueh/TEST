package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.ResourceAndIntroPictureDAO;
import com.practice.webapp.entity.ResourceAndIntroPicture;

public class ResourceAndIntroPictureDAOImpl implements ResourceAndIntroPictureDAO {
	private DataSource dataSource;
	private Connection conn = null;
	// private ResultSet rs = null;
	private PreparedStatement smt = null;
	private ResultSet rs;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(ResourceAndIntroPicture resourceandintropicture) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `resourceandintropicture` (`RIPic_ID`, `RIPic_Title`, `RIPic_Content`, `RIPic_Picture`) VALUES (?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, resourceandintropicture.getRIPicId());
			smt.setString(2, resourceandintropicture.getRIPicTitle());
			smt.setString(3, resourceandintropicture.getRIPicContent());
			smt.setString(4, resourceandintropicture.getRIPicPicture());
			smt.executeUpdate();
			smt.close();
			conn.close();

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

	public void delete(ResourceAndIntroPicture resourceandintropicture) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `resourceandintropicture` WHERE `resourceandintropicture`.`RIPic_ID` = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, resourceandintropicture.getRIPicId());
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

	public List<ResourceAndIntroPicture> getRIPlist() {
		// TODO Auto-generated method stub
		List<ResourceAndIntroPicture> resourceandintropictureList = new ArrayList<ResourceAndIntroPicture>();
		String sql = "SELECT * FROM `resourceandintropicture` WHERE `RIPic_Place`=0";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				ResourceAndIntroPicture resourceandintropicture = new ResourceAndIntroPicture();
				resourceandintropicture.setRIPicPicture(rs.getString("RIPic_Picture"));
				resourceandintropicture.setRIPicId(rs.getInt("RIPic_ID"));
				resourceandintropicture.setRIPicContent(rs.getString("RIPic_Content"));
				resourceandintropicture.setRIPicTitle(rs.getString("RIPic_Title"));
				resourceandintropictureList.add(resourceandintropicture);
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
	return resourceandintropictureList;
	}
	
	
	public List<ResourceAndIntroPicture> getHomepageList() {
		// TODO Auto-generated method stub
		List<ResourceAndIntroPicture> homepagepicList = new ArrayList<ResourceAndIntroPicture>();
		String sql = "SELECT * FROM `resourceandintropicture` WHERE `RIPic_Place`=1";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				ResourceAndIntroPicture homepagepic = new ResourceAndIntroPicture();
				homepagepic.setRIPicPicture(rs.getString("RIPic_Picture"));
				homepagepic.setRIPicId(rs.getInt("RIPic_ID"));
				homepagepic.setRIPicContent(rs.getString("RIPic_Content"));
				homepagepic.setRIPicTitle(rs.getString("RIPic_Title"));
				homepagepicList.add(homepagepic);
			}
			rs.close();
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
		return homepagepicList;
	}

	public List<ResourceAndIntroPicture> getHomepageList_Home() {
		// TODO Auto-generated method stub
		List<ResourceAndIntroPicture> homepagepicList = new ArrayList<ResourceAndIntroPicture>();
		String sql = "SELECT * FROM `resourceandintropicture` WHERE `RIPic_Place`=1";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				ResourceAndIntroPicture homepagepic = new ResourceAndIntroPicture();
				homepagepic.setRIPicPicture(rs.getString("RIPic_Picture"));
				homepagepic.setRIPicId(rs.getInt("RIPic_ID"));
				homepagepic.setRIPicContent(rs.getString("RIPic_Content"));
				homepagepic.setRIPicTitle(rs.getString("RIPic_Title"));
				homepagepicList.add(homepagepic);
			}
			rs.close();
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
		return homepagepicList;
	}

	// public void update(ResourceAndIntroPicture resourceandintropicture) {
	// TODO Auto-generated method stub
	// String sql = "UPDATE `resourceandintropicture` SET `RIPic_Content` = ?,
	// `RIPic_Title`=?, `RIPic_Content`=?, WHERE
	// `resourceandintropicture`.`RIPic_ID` = ?";
	// try {
	// conn = dataSource.getConnection();
	// smt = conn.prepareStatement(sql);
	// smt.setInt(1, resourceandintropicture.getRIPicId());
	// smt.setString(2, resourceandintropicture.getRIPicTitle());
	// smt.executeUpdate();
	// smt.close();

}
