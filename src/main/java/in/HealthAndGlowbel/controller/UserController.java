package in.HealthAndGlowbel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.HealthAndGlowbel.model.User;
import in.HealthAndGlowbel.service.UserService;

/**
 * @author B Shashidhar
 *
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to User";
	}

	@PostMapping(value = "/reg")
	public String addUser(@RequestBody @Valid User user) {
		Boolean value = userService.registerUser(user);
		if (value) {
			return "ok";
		}
		return "record not saved";
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> get(@PathVariable("id") Long userId) {
		User user = userService.getUserById(userId);
		return ResponseEntity.ok().body(user);
	}	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllUsers() {
		try {
			List<User> user = userService.listAllUsers();
			if(!CollectionUtils.isEmpty(user)) {
				return "ok";
			}
			throw new RuntimeException("No Records Found");
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@PutMapping("/upd/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long userId, @RequestBody User user) {
		userService.editUser(userId, user);
		return ResponseEntity.ok().body("User has been updated successfully.");
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long userId) {
		userService.removeUser(userId);
		return ResponseEntity.ok().body("User has been deleted successfully.");
	}
}
