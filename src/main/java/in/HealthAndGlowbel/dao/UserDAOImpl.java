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

import in.HealthAndGlowbel.model.User;

/**
 * @author B Shashidhar
 *
 * 
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registerUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getUserById(Long userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public List<User> listAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query<User> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void editUser(Long userId, User user) {
		Session session = sessionFactory.getCurrentSession();
		User updUser = session.byId(User.class).load(userId);
		
		updUser.setUser_Login_Id(user.getUser_Login_Id());
		updUser.setCurrent_Password(user.getCurrent_Password());
		updUser.setUser_Mobile(user.getUser_Mobile());
		updUser.setUser_Auth_Token(user.getUser_Auth_Token());
		updUser.setUser_Status(user.getUser_Status());				
		session.flush();
	}

	@Override
	public void removeUser(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(userId);
		session.delete(user);
	}
}
