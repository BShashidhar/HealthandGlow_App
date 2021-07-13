package in.HealthAndGlowbel.TestDao;

import in.HealthAndGlowbel.model.User;

/**
 * @author B Shashidhar
 *
 * 
 */
public class TestDAOLayer {

	public static User getUserDetails() {
		User user = new User();
		user.setUser_Id(1L);
		user.setUser_Login_Id("Shashidhar");
		user.setCurrent_Password("1234567890");
		user.setUser_Mobile("9876543210");
		user.setUser_Auth_Token("Shashi123");
		user.setUser_Status("Active");
		user.setCreated_Stamp(null);
		user.setLast_Update_Stamp(null);
		return user;
	}
}
