package springbootpart1.springboot.dao;


public interface FakeRepoInterface {

    String insertUser(long id, String name, String surname);
    String findUserById(long id);
    String deleteUser(long id);
    String insertUser(String name, String surname);
}
