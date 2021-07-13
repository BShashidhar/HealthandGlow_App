package in.HealthAndGlowbel.dao;

import java.util.List;

import in.HealthAndGlowbel.model.Item;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface ItemDAO {
	
	void addItem(Item item);

	Item getItemById(Integer itemId);

	List<Item> listAllItems();

	void editItem(Integer itemId, Item item);

	void removeItem(Integer itemId);
}
