package springbootpart1.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import springbootpart1.springboot.dao.FakeRepoInterface;
import springbootpart1.springboot.service.UserService;
import springbootpart1.springboot.service.UserServiceImpl;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = Application.class)
public class UserServiceTest {

	@Mock
	FakeRepoInterface mockRepo;
	UserService userService;

	@BeforeEach
	public void setup(){
		userService = new UserServiceImpl(mockRepo);
	}

	@Test
	@DisplayName("This test should add a user")
	void addUserTest() {
		userService.addUser("Paul", "Pogba");
		verify(mockRepo, times(1)).insertUser(121,"Paul","Pogba" );
	}

	@Test
	@DisplayName("This test should remove a user")
	void removeUserTest() {
		userService.removeUser(100);
		verify(mockRepo, times(1)).deleteUser(100);
	}


	@Test
	@DisplayName("This test should get user by id")
	void getUserTest(){
	    userService.addUser("Sadio", "Mane");
	    userService.getUser(11);
	    verify(mockRepo, times(1)).findUserById(11);

    }


    @Test
	@DisplayName("This test should simulate the backend call 4 times")
	void getUserFourTimes(){
		userService.getUser(121);
		userService.getUser(121);
		userService.getUser(121);
		userService.getUser(121);
		verify(mockRepo, times(4)).findUserById(121);
	}
}
