package com.moment.service;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.moment.model.Item;
import com.moment.model.Menu;
import com.moment.repository.MenuRepository;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {

	@InjectMocks
	MenuServiceImpl menuServiceMock;
	
	@Mock
	MenuRepository menuRepoMock;
	
	private List<Menu> menus;

	@Before
	public void setUp() {
		menus = new ArrayList<Menu>();
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
	
	@Test
	public void testGetMenu() {
		Mockito.when(menuRepoMock.getAllMenu()).thenReturn(menus);
        assertEquals(1, menuServiceMock.getAllMenu().size());
	}
}
