package springbootpart1.springboot.dao;

import org.springframework.stereotype.Repository;
import springbootpart1.springboot.model.User;
import java.util.ArrayList;
import java.util.List;

@Repository("fakeRepo")
public class FakeRepo implements FakeRepoInterface {

    private static List<User> users = new ArrayList<>();

    @Override
    public String insertUser(long id, String name, String surname) {
        users.add(new User(id, name, surname));
        return name;
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
