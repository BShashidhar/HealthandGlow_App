package in.HealthAndGlowbel.dao;

import java.util.List;

import in.HealthAndGlowbel.model.Basket;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface BasketDAO {
	
	void addBasket(Basket basket);

	Basket getBasketById(Integer basketId);

	List<Basket> listInBasket();

	void editBasket(Integer basketId, Basket basket);

	void removeBasket(Integer basketId);
}
