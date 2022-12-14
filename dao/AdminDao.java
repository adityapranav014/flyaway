package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

//	SQL Connection
	private Connection conn;

//	Default Constructor
	public AdminDao() {
		conn = DBConfig.getConnection();
	}

//	method for checking admin login 
	public boolean checkadmin(String email, String password) {

		try {
			PreparedStatement stat = conn.prepareStatement("select * from admin_table where email=? and password=?");
			stat.setString(1, email);
			stat.setString(2, password);
			ResultSet rs = stat.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

//	method for changing admin password
	public boolean newpasswordadmin(String email, String newpassword) {
		try {
			PreparedStatement stat = conn.prepareStatement("update admin_table set password=? where email=?;");
			stat.setString(1, newpassword);
			stat.setString(2, email);
			stat.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

}
