package in.HealthAndGlowbel.TestModel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import in.HealthAndGlowbel.TestDao.TestDAOLayer;
import in.HealthAndGlowbel.model.User;

/**
 * @author B Shashidhar
 *
 * 
 */
public class TestModelValidation {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testUsersSuccess() {
    	User user = TestDAOLayer.getUserDetails();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testUserLoginId() {
    	User user = TestDAOLayer.getUserDetails();
    	user.setUser_Login_Id(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }
}