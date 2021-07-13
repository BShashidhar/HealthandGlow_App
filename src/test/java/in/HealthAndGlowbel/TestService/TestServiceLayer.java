package in.HealthAndGlowbel.TestService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import in.HealthAndGlowbel.TestDao.TestDAOLayer;
import in.HealthAndGlowbel.dao.UserDAO;
import in.HealthAndGlowbel.model.User;
import in.HealthAndGlowbel.service.UserServiceImpl;

/**
 * @author B Shashidhar
 *
 * 
 */
public class TestServiceLayer {
	
	@Mock
	private UserDAO userDAO;

	@InjectMocks
	private UserServiceImpl userServiceImp;
	
	@Before
	public void setup() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testViewAllUsers() throws Exception {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		when(userDAO.listAllUsers()).thenReturn((List<User>) userList);
		List<User> list =userServiceImp.listAllUsers();
	    assertEquals(2, list.size());
	}
	
	@Test
	public void testViewEmptyUsers() throws Exception {
		List<User> userList = new ArrayList<>();
		when(userDAO.listAllUsers()).thenReturn((List<User>) userList);
		List<User> list =userServiceImp.listAllUsers();
	    assertEquals(Collections.EMPTY_LIST, list);
	}
	
	@Test
	public void testViewAllUser() throws Exception {
		when(userDAO.listAllUsers()).thenReturn(null);
		List<User> list =userServiceImp.listAllUsers();
	    assertEquals(null, list);
	}
	
	@Test
	public void testSaveUser() throws Exception {
		Boolean value = userServiceImp.registerUser(TestDAOLayer.getUserDetails());
		assertEquals(Boolean.TRUE, value);
	}
}
