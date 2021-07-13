package in.HealthAndGlowbel.service;

import java.util.List;

import in.HealthAndGlowbel.model.Product;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface ProductService {

	String addProduct(Product product);

	Product getProductById(String productId);

	List<Product> listAllProducts();

	void editProduct(String productId, Product product);

	void removeProduct(String productId);
}
