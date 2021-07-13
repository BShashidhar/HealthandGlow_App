package in.HealthAndGlowbel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.HealthAndGlowbel.dao.BasketDAO;
import in.HealthAndGlowbel.model.Basket;

/**
 * @author B Shashidhar
 *
 * 
 */
@Service("BasketService")
@Transactional(readOnly = true)
public class BasketServiceImpl implements BasketService {

	@Autowired
	private BasketDAO basketDAO;

	@Override
	@Transactional
	public Boolean addBasket(Basket basket) {
		try {
			basketDAO.addBasket(basket);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Basket getBasketById(Integer basketId) {
		return basketDAO.getBasketById(basketId);
	}

	@Override
	public List<Basket> listInBasket() {
		return basketDAO.listInBasket();
	}

	@Override
	@Transactional
	public void editBasket(Integer basketId, Basket basket) {
		basketDAO.editBasket(basketId, basket);
	}

	@Override
	@Transactional
	public void removeBasket(Integer basketId) {
		basketDAO.removeBasket(basketId);

	}

}
