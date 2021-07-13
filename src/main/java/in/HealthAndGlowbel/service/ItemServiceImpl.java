package in.HealthAndGlowbel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.HealthAndGlowbel.dao.ItemDAO;
import in.HealthAndGlowbel.model.Item;

/**
 * @author B Shashidhar
 *
 * 
 */
@Service("ItemService")
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;

	@Override
	@Transactional
	public Boolean addItem(Item item) {
		try {
			itemDAO.addItem(item);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Item getItemById(Integer itemId) {
		return itemDAO.getItemById(itemId);
	}

	@Override
	public List<Item> listAllItems() {
		return itemDAO.listAllItems();
	}

	@Override
	public void editItem(Integer itemId, Item item) {
		itemDAO.editItem(itemId, item);
	}

	@Override
	public void removeItem(Integer itemId) {
		itemDAO.removeItem(itemId);
	}
}
