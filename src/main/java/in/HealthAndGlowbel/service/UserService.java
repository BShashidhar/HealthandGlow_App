package in.HealthAndGlowbel.service;

import java.util.List;

import in.HealthAndGlowbel.model.User;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface UserService {

	Boolean registerUser(User user);

	User getUserById(Long userId);

	List<User> listAllUsers();

	void editUser(Long userId, User user);

	void removeUser(Long userId);
}
