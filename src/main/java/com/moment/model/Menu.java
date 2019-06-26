package com.moment.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Size;

import com.moment.model.Item.ItemBuilder;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@Builder
public class Menu {

	String description;
	Boolean isActive;
	@Size(min = 1, message = "Menu should have atleast one item")
	List<Item> items;
	List<Menu> subMenu;

	public Menu(String description, Boolean isActive, List<Item> items, List<Menu> subMenu) {
		super();
		this.description = description;
		this.isActive = isActive;
		this.items = items;
		this.subMenu = subMenu;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void addSubMenu(Menu menu) {
		this.subMenu.add(menu);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	@Override
	public String toString() {
		return "Menu [description=" + description + ", isActive=" + isActive + ", items=" + items + ", subMenu="
				+ subMenu + "]";
	}

}
