package com.moment.model;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Item item;
	
	@Before
	public void init() {
        Set<DayOfWeek> availableDays = new HashSet<DayOfWeek>();
        availableDays.add(DayOfWeek.SUNDAY);
        availableDays.add(DayOfWeek.of(2));
        String url = "http://google/hrlp";
        LocalTime from = LocalTime.of(8, 00);
        LocalTime to = LocalTime.of(22, 00);
        item = new Item("pizza","with cheese toppings",20,url,availableDays,from,to,3);
	}
	
	@After
	public void clear() {
		item = null;
	}
	
	@Test
	public void testBuilder() {
		item = Item.builder().name("Test Item").build();
		assertNotNull(item);
	}

	@Test
	public void testFullArgsConstructor() {
		assertNotNull(item);
	}
}
