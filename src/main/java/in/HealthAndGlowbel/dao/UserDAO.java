package in.HealthAndGlowbel.dao;

import java.util.List;

import in.HealthAndGlowbel.model.User;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface UserDAO {

	void registerUser(User user);

	User getUserById(Long userId);

	List<User> listAllUsers();

	void editUser(Long userId, User user);

	void removeUser(Long userId);
}
