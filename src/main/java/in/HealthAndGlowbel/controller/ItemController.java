package in.HealthAndGlowbel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.HealthAndGlowbel.model.Item;
import in.HealthAndGlowbel.service.ItemService;

/**
 * @author B Shashidhar
 *
 * 
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to Item";
	}
	
	@PostMapping(value = "/add")
	public String addUser(@RequestBody @Valid Item item) {
		boolean id = itemService.addItem(item);
		if (id) {
			return "Item added id DB!...";
		}
	    return "Item not added in to DB!...";
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Item> get(@PathVariable("id") int itemId) {
		Item item = itemService.getItemById(itemId);
		return ResponseEntity.ok().body(item);
	}	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> listAllItems() {
		List<Item> items = itemService.listAllItems();
	      return ResponseEntity.ok().body(items);
	}
	
	@PutMapping("/upd/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int itemId, @RequestBody Item item) {
		itemService.editItem(itemId, item);
		return ResponseEntity.ok().body("Item has been updated successfully.");
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int itemId) {
		itemService.removeItem(itemId);
		return ResponseEntity.ok().body("Item has been deleted successfully.");
	}
}
