package com.onlinecatalogapp.manager;

import java.util.List;

import com.onlinecatalogapp.elements.Item;

public interface ItemManager {
	void addItem();

	List<Item> returnItemsOfACategory(String categoryName);

	List<Item> returnAllItems();
}
