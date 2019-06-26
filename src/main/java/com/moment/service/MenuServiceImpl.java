package com.moment.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moment.model.Item;
import com.moment.model.Menu;
import com.moment.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepo;

	@Override
	public List<Menu> getAllMenu() {
		return menuRepo.getAllMenu();
	}

	@Override
	public void addMenu(Menu menu) {
		menuRepo.addMenu(menu);
	}

	@Override
	public void addItem(Item item) {
		menuRepo.addItem(item);
	}

	@Override
	public List<Item> groupBy(Menu menu, String groupBy) {
		List<Item> items = menu.getItems();
		if (groupBy.equalsIgnoreCase("price")) {
			Collections.sort(items, Item.priceComparator);
		}
		if (groupBy.equalsIgnoreCase("star")) {
			Collections.sort(items, Item.starComparator);
		}
		return items;
	}
	
	/**
	 * If requirement was to group them based on price and return as a map then this is a clean approach using java streams
	 * @param menu
	 * 
	 */
	@Override
	public Map<Integer,List<Item>> groupItemsByPrice(Menu menu){
		Map<Integer,List<Item>> itemsByPrice = new HashMap<Integer,List<Item>>();
		List<Item>items = menu.getItems();
		itemsByPrice = items.stream().collect(Collectors.groupingBy(Item::getPrice));
		return itemsByPrice;
	}

	/**
	 * @param menu
	 * @return sum of all the items and its items from sub-menu
	 */
	public float getSum(Menu menu) {
		float totalSum = 0;
		totalSum = totalSum + getListSum(menu.getItems());
		List<Menu> submenu = menu.getSubMenu();
		if (submenu.size() > 0) {
			for (Menu sMenu : submenu) {
				totalSum = totalSum + getSum(sMenu);
			}
		}
		return totalSum;
	}

	private float getListSum(List<Item> items) {
		float sum = 0;
		if (items.size() > 0) {
			for (Item i : items) {
				sum = sum + i.getPrice();
			}
		}
		return sum;
	}

}
