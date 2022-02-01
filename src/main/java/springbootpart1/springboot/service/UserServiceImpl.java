package springbootpart1.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springbootpart1.springboot.dao.FakeRepo;

@Service
public class UserServiceImpl implements UserService{

    private final FakeRepo fakeRepo;

    @Autowired
    public UserServiceImpl(@Qualifier("fakeRepo") FakeRepo fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public void addUser(String name, String surname) {
        fakeRepo.insertUser(121, name, surname);
        System.out.println(name + " Entered");
    }

    @Override
    public void removeUser(long id) {
            String name = fakeRepo.deleteUser(id);
            System.out.println(name+" Removed");
    }

    @Override
    public void getUser(long id) {
        String name =  fakeRepo.findUserById(id);
        System.out.println("Hello "+name);
    }

}
