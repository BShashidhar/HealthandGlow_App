package in.HealthAndGlowbel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.HealthAndGlowbel.dao.UserDAO;
import in.HealthAndGlowbel.model.User;

/**
 * @author B Shashidhar
 *
 * 
 */
@Service("UserService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public Boolean registerUser(User user) {
		try {
			userDAO.registerUser(user);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public User getUserById(Long userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	public List<User> listAllUsers() {
		return userDAO.listAllUsers();
	}

	@Override
	@Transactional
	public void editUser(Long userId, User user) {
		userDAO.editUser(userId, user);
	}

	@Override
	@Transactional
	public void removeUser(Long userId) {
		userDAO.removeUser(userId);
	}
}
