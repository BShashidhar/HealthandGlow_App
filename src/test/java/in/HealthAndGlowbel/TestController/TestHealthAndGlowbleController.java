package in.HealthAndGlowbel.TestController;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import in.HealthAndGlowbel.TestDao.TestDAOLayer;
import in.HealthAndGlowbel.controller.UserController;
import in.HealthAndGlowbel.model.User;
import in.HealthAndGlowbel.service.UserService;

/**
 * @author B Shashidhar
 *
 * 
 */
public class TestHealthAndGlowbleController {
	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testLoadingPageUrl() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void testViewAllUsersApi() throws Exception {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		when(userService.listAllUsers()).thenReturn((List<User>) userList);
		this.mockMvc.perform(get("/listAllUsers")).andExpect(status().isOk()).andExpect(view().name("ok"));
	}

	@Test
	public void testViewAllUsersApiCase1() throws Exception {
		when(userService.listAllUsers()).thenReturn(null);
		this.mockMvc.perform(get("/listAllUsers")).andExpect(status().isOk())
				.andExpect(view().name("No Records Found"));
	}

	@Test
	public void testSaveUsers() throws Exception {
		Gson gson = new Gson();
		when(userService.registerUser(TestDAOLayer.getUserDetails())).thenReturn(false);
		this.mockMvc
				.perform(post("/regUser").content(gson.toJson(TestDAOLayer.getUserDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));

	}
}
