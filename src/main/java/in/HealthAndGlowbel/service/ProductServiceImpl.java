package in.HealthAndGlowbel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.HealthAndGlowbel.dao.ProductDAO;
import in.HealthAndGlowbel.model.Product;

/**
 * @author B Shashidhar
 *
 * 
 */
@Service("ProductService")
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public String addProduct(Product product) {
		productDAO.addProduct(product);
		return product.getProduct_Id();
	}

	@Override
	public Product getProductById(String productId) {
		return productDAO.getProductById(productId);
	}

	@Override
	public List<Product> listAllProducts() {
		return productDAO.listAllProducts();
	}

	@Override
	@Transactional
	public void editProduct(String productId, Product product) {
		productDAO.editProduct(productId, product);
	}

	@Override
	@Transactional
	public void removeProduct(String productId) {
		productDAO.removeProduct(productId);
	}

}
