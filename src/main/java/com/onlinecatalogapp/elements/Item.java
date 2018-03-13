package com.onlinecatalogapp.elements;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	private int itemId;
	private String itemName;
	private double itemCost;
	private ItemStatus itemStatus;
}
