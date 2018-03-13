package com.onlinecatalogapp.manager;

import java.util.List;

import com.onlinecatalogapp.elements.Category;

public interface CategoryManager {
	void addCategory(Category category);

	List<Category> returnAllCategories();
}
