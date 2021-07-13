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

import in.HealthAndGlowbel.model.Item;

/**
 * @author B Shashidhar
 *
 * 
 */
@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addItem(Item item) {
		sessionFactory.getCurrentSession().save(item);
	}

	@Override
	public Item getItemById(Integer itemId) {
		return sessionFactory.getCurrentSession().get(Item.class, itemId);
	}

	@Override
	public List<Item> listAllItems() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Item> cq = cb.createQuery(Item.class);
		Root<Item> root = cq.from(Item.class);
		cq.select(root);
		Query<Item> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void editItem(Integer itemId, Item item) {
		Session session = sessionFactory.getCurrentSession();
		Item updItem = session.byId(Item.class).load(itemId);
		updItem.setQuantity(item.getQuantity());				
		updItem.setMrp_Price(item.getMrp_Price());				
		updItem.setList_Price(item.getList_Price());				
		updItem.setProduct_Name(item.getProduct_Name());				
		session.flush();
	}

	@Override
	public void removeItem(Integer itemId) {
		Session session = sessionFactory.getCurrentSession();
		Item item = session.byId(Item.class).load(itemId);
		session.delete(item);
	}
}
