package com.moment.resource;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moment.config.LogExecutionTime;
import com.moment.model.Item;
import com.moment.model.Menu;
import com.moment.service.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/menu")
@Api(value = "Controller pertaining to menus")
public class MenuResource {
	@Autowired
	private MenuService menuService;

	@LogExecutionTime
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Gets all the menus in the system", notes = "Check the Menu schema for more details")
	public List<Menu> getAllMenu() {
		return menuService.getAllMenu();
	}

	@PostMapping
	@LogExecutionTime
	@ApiOperation(value = "Add item to the menu , Singleton menu in our case", notes = "Check the Item schema for more details")
	public ResponseEntity<Object> addItem(@Valid @RequestBody Item item) {
		menuService.addItem(item);
		return ResponseEntity.ok("Item added");
	}

	@GetMapping(path = "/group")
	@LogExecutionTime
	@ApiOperation(value = "Gets all the items of menu in the system grouped by price")
	public Map<Integer, List<Item>> groupItems() {
		return menuService.groupItemsByPrice(menuService.getAllMenu().get(0));
	}

	@GetMapping(path = "/group/{groupBy}")
	@LogExecutionTime
	@ApiOperation(value = "Gets all the items of menu in the system grouped by parameter", notes = "available grouping parameters are 'price','rating'")
	public List<Item> groupItemsBy(@RequestBody Menu menu, @PathVariable String groupBy) {
		return menuService.groupBy(menu, groupBy);
	}

}
