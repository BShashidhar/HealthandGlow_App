package in.HealthAndGlowbel.service;

import java.util.List;

import in.HealthAndGlowbel.model.Basket;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface BasketService {

	Boolean addBasket(Basket basket);

	Basket getBasketById(Integer basketId);

	List<Basket> listInBasket();

	void editBasket(Integer basketId, Basket basket);

	void removeBasket(Integer basketId);
}
