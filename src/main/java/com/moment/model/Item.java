package com.moment.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shomveer Kherwa
 *
 */
@ApiModel
@Data
@NoArgsConstructor
@Builder
public class Item implements Comparable<Item> {
	@NotEmpty
	private String name;
	private String description;
	private int price;
	private String url;
	private Set<DayOfWeek> availableDays;
	private LocalTime from;
	private LocalTime to;
	@Min(value = 1)
	@Max(value = 5)
	private float rating;

	/**
	 * Constructor with all the fields ,because we wouldn't want an empty field item
	 * , unless we have a "coming soon dish , use builder for that"
	 * 
	 * @param String                             name
	 * @param String                             description
	 * @param int                                price
	 * @param String                             url
	 * @param Set<{@link}DayOFWeek>availableDays
	 * @param LocalTime                          from
	 * @param LocalTime                          to
	 * @param float                              rating
	 */
	public Item(String name, String description, int price, String url, Set<DayOfWeek> availableDays, LocalTime from,
			LocalTime to, float rating) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.url = url;
		this.availableDays = availableDays;
		this.from = from;
		this.to = to;
		this.rating = rating;
	}

	@Override
	public int compareTo(Item that) {
		return this.price - that.price;
	}

	/**
	 * Comparator to group items by price
	 */
	public static final Comparator<Item> priceComparator = new Comparator<Item>() {
		@Override
		public int compare(Item o1, Item o2) {
			return o1.price - o2.price;
		}
	};

	/**
	 * Comparator to group items by star
	 */
	public static final Comparator<Item> starComparator = new Comparator<Item>() {
		@Override
		public int compare(Item o1, Item o2) {
			return (int) (o1.rating - o2.rating);
		}
	};
}
