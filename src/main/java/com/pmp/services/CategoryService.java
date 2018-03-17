package com.pmp.services;

import static com.pmp.sql.SQLQueries.SELECT_CATEGORY_BY_CATEGORYNAME;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryService {
	private Connection dbconnection;

	public CategoryService(Connection dbconnection) {
		this.dbconnection = dbconnection;
	}

	public int getCategoryIdByCategoryName(String categoryName) {
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(SELECT_CATEGORY_BY_CATEGORYNAME);
			preparedStatement.setString(1, categoryName);
			ResultSet rs = preparedStatement.executeQuery();
			int categoryId = 0;
			while (rs.next()) {
				categoryId = rs.getInt("categoryId");
			}
			return categoryId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
