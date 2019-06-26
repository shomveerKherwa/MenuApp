package com.moment.service;

import java.util.List;
import java.util.Map;

import com.moment.model.Item;
import com.moment.model.Menu;

public interface MenuService {

	List<Menu> getAllMenu();

	void addMenu(Menu menu);

	void addItem(Item item);

	List<Item> groupBy(Menu menu, String groupBy);

	Map<Integer, List<Item>> groupItemsByPrice(Menu menu);

}