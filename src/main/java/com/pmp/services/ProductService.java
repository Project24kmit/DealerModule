package com.pmp.services;

import static com.pmp.sql.SQLQueries.SELECT_ALL_PRODUCTS_BY_DEALERID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pmp.elements.Product;

public class ProductService {
	private Connection dbconnection;

	public ProductService(Connection dbconnection) {
		this.dbconnection = dbconnection;
	}

	public List<Product> getAllProductsByDealerId(int dealerId) {
		List<Product> allProducts = new ArrayList<Product>();
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(SELECT_ALL_PRODUCTS_BY_DEALERID);
			preparedStatement.setInt(1, dealerId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs != null && rs.next()) {
				Product product = new Product();
				product.setCategoryId(rs.getInt("categoryId"));
				product.setCost(rs.getFloat("cost"));
				product.setDealerId(rs.getInt("dealerId"));
				product.setProductDescription(rs.getString("description"));
				product.setProductId(rs.getInt("productId"));
				product.setProductImage(rs.getBinaryStream("image"));
				product.setProductName(rs.getString("name"));
				product.setStockQuantity(rs.getInt("stock"));
				allProducts.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allProducts;
	}
}
