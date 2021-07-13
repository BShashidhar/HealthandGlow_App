package in.HealthAndGlowbel.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.HealthAndGlowbel.model.Product;

/**
 * @author B Shashidhar
 *
 * 
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);		
	}

	@Override
	public Product getProductById(String productId) {
		return sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@Override
	public List<Product> listAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		cq.select(root);
		Query<Product> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void editProduct(String productId, Product product) {
		Session session = sessionFactory.getCurrentSession();
		Product updProduct = session.byId(Product.class).load(productId);
		
		updProduct.setProduct_Id(product.getProduct_Id());
		updProduct.setCategory_Id(product.getCategory_Id());
		updProduct.setCategory_Name(product.getCategory_Name());
		updProduct.setParent_Category_Link(product.getParent_Category_Link());
		updProduct.setBrand_Id(product.getBrand_Id());				
		updProduct.setBrand_Name(product.getBrand_Name());				
		updProduct.setProduct_Title(product.getProduct_Title());				
		updProduct.setMrp_Price(product.getMrp_Price());				
		updProduct.setList_Price(product.getList_Price());				
		updProduct.setCreated_Stamp(product.getCreated_Stamp());				
		updProduct.setLast_Update_Stamp(product.getLast_Update_Stamp());				
		session.flush();		
	}

	@Override
	public void removeProduct(String productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.byId(Product.class).load(productId);
		session.delete(product);
	}

}
