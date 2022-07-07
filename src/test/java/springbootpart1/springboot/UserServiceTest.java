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
	UserService mockService;

	@BeforeEach
	public void setup(){
		mockService = new UserServiceImpl(mockRepo);
	}

	@Test
	@DisplayName("This test should add a user")
	void addUserTest() {
		mockService.addUser("Paul", "Pogba");
		verify(mockRepo, times(1)).insertUser(121,"Paul","Pogba" );
	}

	@Test
	@DisplayName("This test should remove a user")
	void removeUserTest() {
		mockService.removeUser(121);
		verify(mockRepo, times(1)).deleteUser(121);
	}


	@Test
	@DisplayName("This test should get user by id")
	void getUserTest(){
	    mockService.addUser("Sadio", "Mane");
	    mockService.getUser(121);
	    verify(mockRepo, times(1)).findUserById(121);

    }


    @Test
	@DisplayName("This test should simulate the backend call 4 times")
	void getUserFourTimes(){
		mockService.getUser(121);
		mockService.getUser(121);
		mockService.getUser(121);
		mockService.getUser(121);
		verify(mockRepo, times(4)).findUserById(121);
	}
}
