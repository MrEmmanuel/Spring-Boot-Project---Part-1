package springbootpart1.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springbootpart1.springboot.dao.FakeRepo;
import springbootpart1.springboot.service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = Application.class)
public class UserServiceTest {

	
	UserServiceImpl mockService;
	FakeRepo mockRepo;
	@BeforeEach
	public void setup(){
		mockService = mock(FakeRepo.class);
		mockRepo = new FakeRepo();
	}

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

	@Test
	void insertUserTest() {
        String name = mockRepo.insertUser(37, "Sadio", "Mane");
        assertNotNull(name);
        assertEquals("Sadio", name);

	}

	@Test
	void findUserByIdTest(){
	    mockRepo.insertUser(121, "Sadio", "Mane");
	    String name = mockRepo.findUserById(121);
	    assertNotNull(name);
	    assertEquals("Sadio", name);

    }

    	@Test
    	void deleteUserTest(){
	    mockRepo.insertUser(95,"Tebogo", "Mane");
	    String name = mockRepo.deleteUser(95);
	    assertNotNull(name);
	    assertEquals("Tebogo",name);
    }
}
