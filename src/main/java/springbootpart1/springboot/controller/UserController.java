package springbootpart1.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootpart1.springboot.dao.FakeRepoInterface;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    FakeRepoInterface fakeRepo;

    @PostMapping(path = "/add/{id}")
    public ResponseEntity<String> addUser(@RequestBody String userName){
        fakeRepo.insertUser(13,userName.split(" ")[0],userName.split(" ")[1]);
        return new ResponseEntity("Success!", HttpStatus.CREATED);
    }

    @GetMapping(path = "/retrieve/{id}")
    public ResponseEntity<String> getUser(@PathVariable(value="id")long userId){
        return new ResponseEntity(fakeRepo.findUserById(userId), HttpStatus.OK);

    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value ="id") long userId){
        fakeRepo.deleteUser(userId);
        return new ResponseEntity("Success!", HttpStatus.OK);
    }
}
