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

import in.HealthAndGlowbel.model.Basket;

/**
 * @author B Shashidhar
 *
 * 
 */
@Repository
public class BasketDAOImpl implements BasketDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addBasket(Basket basket) {
		sessionFactory.getCurrentSession().save(basket);
	}

	@Override
	public Basket getBasketById(Integer basketId) {
		return sessionFactory.getCurrentSession().get(Basket.class, basketId);
	}

	@Override
	public List<Basket> listInBasket() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Basket> cq = cb.createQuery(Basket.class);
		Root<Basket> root = cq.from(Basket.class);
		cq.select(root);
		Query<Basket> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void editBasket(Integer basketId, Basket basket) {
		Session session = sessionFactory.getCurrentSession();
		Basket updBasket = session.byId(Basket.class).load(basketId);
		updBasket.setId(basket.getId());
		updBasket.setNo_Of_Items(basket.getNo_Of_Items());
		updBasket.setGrand_Total(basket.getGrand_Total());
		updBasket.setDelivery_Charge(basket.getDelivery_Charge());
		updBasket.setApplied_Coupon_Code(basket.getApplied_Coupon_Code());
		updBasket.setCoupon_Amount(basket.getCoupon_Amount());					
		session.flush();
	}

	@Override
	public void removeBasket(Integer basketId) {
		Session session = sessionFactory.getCurrentSession();
		Basket basket = session.byId(Basket.class).load(basketId);
		session.delete(basket);
	}

}
