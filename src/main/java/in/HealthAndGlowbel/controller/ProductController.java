package in.HealthAndGlowbel.controller;

import java.util.List;

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

import in.HealthAndGlowbel.model.Product;
import in.HealthAndGlowbel.service.ProductService;

/**
 * @author B Shashidhar
 *
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to Product";
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> save(@RequestBody Product product) {
		String id = productService.addProduct(product);
		return ResponseEntity.ok().body("New Product has been added with id:" + id);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Product> get(@PathVariable("id") String productId) {
		Product product = productService.getProductById(productId);
		return ResponseEntity.ok().body(product);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	  public ResponseEntity<List<Product>> list() {
		List<Product> products = productService.listAllProducts();
	      return ResponseEntity.ok().body(products);
	}

	@PutMapping("/upd/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String productId, @RequestBody Product product) {
		productService.editProduct(productId, product);
		return ResponseEntity.ok().body("User has been updated successfully.");
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String productId) {
		productService.removeProduct(productId);
		return ResponseEntity.ok().body("User has been deleted successfully.");
	}
}
