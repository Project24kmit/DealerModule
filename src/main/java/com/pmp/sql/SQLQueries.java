package com.pmp.sql;

public class SQLQueries {
	private SQLQueries() {
	}

	public static final String SELECT_FROM_DEALER_TABLE = "SELECT * FROM dealer;";
	public static final String INSERT_INTO_CATEGORY_TABLE = "INSERT INTO category(name) VALUES(?);";
	public static final String INSERT_INTO_PRODUCT_TABLE = "INSERT INTO product(dealerId, name, categoryId, description, cost, stock, image) VALUES(?,?,?,?,?,?,?);";
	public static final String SELECT_CATEGORY_BY_CATEGORYNAME = "SELECT categoryId FROM category WHERE name=?;";
}