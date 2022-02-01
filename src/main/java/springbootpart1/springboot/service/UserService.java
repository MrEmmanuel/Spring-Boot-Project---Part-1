package springbootpart1.springboot.service;

public interface UserService {


    void addUser(String name, String surname);
    default void addUser(long id, String name, String surname){
        addUser(name, surname);
    }

    void removeUser(long Id);

    void getUser(long Id);

}
