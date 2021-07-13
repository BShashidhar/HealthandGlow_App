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

import in.HealthAndGlowbel.model.Basket;
import in.HealthAndGlowbel.service.BasketService;

/**
 * @author B Shashidhar
 *
 * 
 */
@Controller
@RequestMapping("/basket")
public class BasketController {
	@Autowired
	private BasketService basketService;

	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to Basket";
	}
	
	@PostMapping(value = "/add")
	public Boolean addBasket(@RequestBody @Valid Basket basket) {
		return basketService.addBasket(basket);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Basket> get(@Valid @PathVariable("id") Integer basketId) {
		Basket basket = basketService.getBasketById(basketId);
		return ResponseEntity.ok().body(basket);
	}	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Basket>> listInBasket() {
		List<Basket> baskets = basketService.listInBasket();
	    return ResponseEntity.ok().body(baskets);
	}
	
	@PutMapping("/upd/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer basketId, @RequestBody Basket basket) {
		basketService.editBasket(basketId, basket);
		return ResponseEntity.ok().body("Basket has been updated successfully.");
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer basketId) {
		basketService.removeBasket(basketId);
		return ResponseEntity.ok().body("Basket has been deleted successfully.");
	}
}
