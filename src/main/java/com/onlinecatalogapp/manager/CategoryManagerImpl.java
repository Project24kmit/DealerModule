package com.onlinecatalogapp.manager;

import static com.onlinecatalogapp.sql.SQLStatements.SQL_CATEGORY_INSERT_STMT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.onlinecatalogapp.elements.Category;
import com.onlinecatalogapp.sql.DatabaseConnector;

public class CategoryManagerImpl implements CategoryManager {
	private Connection dbConnection = null;
	private PreparedStatement statement = null;

	public CategoryManagerImpl() {
		dbConnection = DatabaseConnector.getDBConnection();
	}

	@Override
	public void addCategory(Category category) {
		try {
			statement = dbConnection.prepareStatement(SQL_CATEGORY_INSERT_STMT);
			statement.setString(1, "dummy1");
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Category> returnAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
