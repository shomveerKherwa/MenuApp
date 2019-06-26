package com.moment.repository;

import com.moment.model.Item;
import com.moment.model.Menu;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

@Repository("MenuRepository")
public class MenuRepositoryImpl implements MenuRepository {

    List<Menu> menus = new ArrayList<Menu>();


    @Override
	public List<Menu> getAllMenu(){
        if(menus.isEmpty()) {
            initializeFromDB();
        }
        return menus;
    }

    private void initializeFromDB() {
        Set<DayOfWeek> availableDays = new HashSet<DayOfWeek>();
        availableDays.add(DayOfWeek.SUNDAY);
        availableDays.add(DayOfWeek.of(2));
        String url = "http://google/hrlp";
        LocalTime from = LocalTime.of(8, 00);
        LocalTime to = LocalTime.of(22, 00);
        Item item = new Item("pizza","with cheese toppings",20,url,availableDays,from,to,3);
        Item item2 = new Item("macaroni","small long srong",10,url,availableDays,from,to,4);
        Item item3 = new Item("papad","masala papad ",10,url,availableDays,from,to,2);
        Item item4 = new Item("salad","green peas ",20,url,availableDays,from,to,5);


        List<Item>items = new ArrayList<Item>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        List<Menu>subMenu = Arrays.asList();
        Menu menu = new Menu("Breakfast", true, items,subMenu);
        menus.add(menu);
    }

    @Override
	public void addMenu(Menu menu) {
        menus.add(menu);
    }

    @Override
	public void addItem(Item item) {
        menus.get(0).addItem(item);
    }

}

