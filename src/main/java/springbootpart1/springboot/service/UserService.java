package springbootpart1.springboot.service;

public interface UserService {

    void addUser(String name, String surname);
    void removeUser(long Id);
    String getUser(long Id);
}
