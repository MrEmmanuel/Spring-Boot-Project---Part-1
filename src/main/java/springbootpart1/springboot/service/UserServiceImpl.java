package springbootpart1.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springbootpart1.springboot.repository.FakeRepoInterface;

@Service
public class UserServiceImpl implements UserService{

    private final FakeRepoInterface fakeRepo;

    @Autowired
    public UserServiceImpl(@Qualifier("fakeRepo") FakeRepoInterface fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public void addUser(String name, String surname) {
        fakeRepo.insertUser(name, surname);
        System.out.println(name + " Entered");
    }

    @Override
    public void removeUser(long id) {
            String name = fakeRepo.deleteUser(id);
            System.out.println(name+" Removed");
    }

    @Cacheable("name")
    @Override
    public String getUser(long id) {
        String name =  fakeRepo.findUserById(id);
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return name;
    }

}
