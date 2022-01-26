package springbootpart1.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springbootpart1.springboot.model.User;
import springbootpart1.springboot.service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Application.class)
public class ApplicationTest {

	private final UserServiceImpl userService;

	@Autowired
	public ApplicationTest(UserServiceImpl userService) {
		this.userService = userService;
	}

	@Test
	void addUserTest() {
		assertTrue(userService.addUser("Paul", "Pogba"));
	}

	@Test
	void removeUserTest() {
		long id = 121;
		userService.addUser(id, "Mo", "Salah");
		assertTrue(userService.removeUser(id));
	}

	@Test
	void getUserTest() {
		assertEquals("Paul", userService.getUser(121));
	}

}
