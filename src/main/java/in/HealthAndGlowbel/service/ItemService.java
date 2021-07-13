package in.HealthAndGlowbel.service;

import java.util.List;

import in.HealthAndGlowbel.model.Item;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface ItemService {

	Boolean addItem(Item item);

	Item getItemById(Integer itemId);

	List<Item> listAllItems();

	void editItem(Integer itemId, Item item);

	void removeItem(Integer itemId);
}
