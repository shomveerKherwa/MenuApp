package com.moment.repository;

import java.util.List;

import com.moment.model.Item;
import com.moment.model.Menu;

public interface MenuRepository {

	List<Menu> getAllMenu();

	void addMenu(Menu menu);

	void addItem(Item item);

}