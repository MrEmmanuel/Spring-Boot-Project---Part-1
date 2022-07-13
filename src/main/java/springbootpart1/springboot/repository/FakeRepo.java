package springbootpart1.springboot.repository;

import org.springframework.stereotype.Repository;
import springbootpart1.springboot.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository("fakeRepo")
public class FakeRepo implements FakeRepoInterface {

    private static List<User> users = new ArrayList<>();
    Random random = new Random();

    @Override
    public String insertUser(long id, String name, String surname) {
        users.add(new User(id, name, surname));
        return name;
    }
    @Override
    public String insertUser(String name, String surname){
        long id = random.nextLong();
        return insertUser(id,name, surname);
    }

    @Override
    public String findUserById(long id) {
        for(User user:users){
            if(user.getId() == id){
                return user.getName();
            }
        }
        return null;
    }

    @Override
    public String deleteUser(long id) {
        for(User user:users){
            if(user.getId() == id){
                users.remove(user);
                return user.getName();
            }
        }
       return null;
    }
}
