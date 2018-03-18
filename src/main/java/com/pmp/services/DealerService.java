package com.pmp.services;

import static com.pmp.sql.SQLQueries.INSERT_INTO_CATEGORY_TABLE;
import static com.pmp.sql.SQLQueries.INSERT_INTO_PRODUCT_TABLE;
import static com.pmp.sql.SQLQueries.SELECT_FROM_DEALER_TABLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pmp.elements.Product;

public class DealerService {
	private Connection dbconnection;

	public DealerService(Connection dbconnection) {
		this.dbconnection = dbconnection;
	}

	public boolean isDealerValid(int userId, String password) {
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

	public void addNewCategory(String categoryName) {
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(INSERT_INTO_CATEGORY_TABLE);
			preparedStmt.setString(1, categoryName);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addNewProduct(Product product) {
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(INSERT_INTO_PRODUCT_TABLE);
			preparedStmt.setInt(1, product.getDealerId());
			preparedStmt.setString(2, product.getProductName());
			preparedStmt.setInt(3, product.getCategoryId());
			preparedStmt.setString(4, product.getProductDescription());
			preparedStmt.setFloat(5, product.getCost());
			preparedStmt.setInt(6, product.getStockQuantity());
			preparedStmt.setBinaryStream(7, product.getProductImage());

			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
