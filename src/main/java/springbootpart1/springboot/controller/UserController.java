package springbootpart1.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootpart1.springboot.dao.FakeRepoInterface;
import springbootpart1.springboot.model.User;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    FakeRepoInterface fakeRepo;

    @PostMapping(path = "/add")
    public String addUser(@RequestBody User user){
        return fakeRepo.insertUser(user.getId(),user.getName(),user.getSurname());
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value="id")long userId){

        return new ResponseEntity(fakeRepo.findUserById(userId), HttpStatus.OK);

    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value ="id") long userId){
        fakeRepo.deleteUser(userId);
        return new ResponseEntity("Success!", HttpStatus.OK);
    }



}


