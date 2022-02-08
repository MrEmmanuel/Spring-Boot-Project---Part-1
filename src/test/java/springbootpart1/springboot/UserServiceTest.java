package springbootpart1.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springbootpart1.springboot.service.UserServiceImpl;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = UserService.class)
public class UserServiceTest {

	UserServiceImpl userService;
	UserServiceImpl mockService = mock(UserServiceImpl.class);

	@Autowired
	public UserServiceTest(UserServiceImpl userService) {
		this.userService = userService;
	}

	@Test
	void addUserTest() {
		doNothing().when(mockService).addUser("Paul", "Pogba");
		mockService.addUser("Paul", "Pogba");
		verify(mockService, times(1)).addUser("Paul","Pogba" );
	}

	@Test
	void removeUserTest() {
		long id = 1;
		mockService.addUser(id, "Mo", "Salah");
		doNothing().when(mockService).removeUser(1);
		mockService.removeUser(1);
		verify(mockService, times(1)).removeUser(1);
	}

	@Test
	void getUserTest() {
		long id = 3;
		mockService.addUser(id, "Diego", "Jota");
		doNothing().when(mockService).getUser(3);
		mockService.getUser(3);
		verify(mockService, times(1)).getUser(3);
	}
}
