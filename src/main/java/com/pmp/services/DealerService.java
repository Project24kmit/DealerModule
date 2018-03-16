package com.pmp.services;

import static com.pmp.sql.SQLQueries.SELECT_FROM_DEALER_TABLE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DealerService {

	public boolean isUserValid(int userId, String password, Connection dbconnection) {
		try {
			ResultSet rs = dbconnection.prepareStatement(SELECT_FROM_DEALER_TABLE).executeQuery();
			while (rs.next()) {
				if (rs.getInt("dealerId") == userId && rs.getString("password").equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
