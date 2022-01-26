package springbootpart1.springboot.service;

public interface UserService {


    boolean addUser(String name, String surname);
    default boolean addUser(long id, String name, String surname){
        addUser(name, surname);
        return true;
    }

    boolean removeUser(long Id);

    String getUser(long Id);

}
