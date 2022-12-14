package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flyaway.model.Customer;

public class CustomerDao {

//	SQL Connection
	private Connection conn;

//	Default Constructor
	public CustomerDao() {
		conn = DBConfig.getConnection();
	}

//	method to register new customer into DB	
	public int saveCustomer(Customer cust) {

		try {
			PreparedStatement stat = conn.prepareStatement(
					"insert into customer_table" + "(first_name,last_name,email,phone_no,password) values (?,?,?,?,?)");

			stat.setString(1, cust.getFirstName());
			stat.setString(2, cust.getLastName());
			stat.setString(3, cust.getEmail());
			stat.setString(4, cust.getMobileNo());
			stat.setString(5, cust.getPassword());

			return stat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

//	method for checking customer login

	public int check(String email, String password) {

		try {
			PreparedStatement stat = conn.prepareStatement("select * from customer_table where email=? and password=?");
			stat.setString(1, email);
			stat.setString(2, password);
			ResultSet rs = stat.executeQuery();

			if (rs.next()) {
				int customerId = rs.getInt("customer_id");
				return customerId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

//	method for changing customer password
	public boolean newpasswordCustomer(String email, String newpassword) {
		try {
			PreparedStatement stat = conn.prepareStatement("update customer_table set password=? where email=?;");
			stat.setString(1, newpassword);
			stat.setString(2, email);
			stat.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
