package springbootpart1.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootpart1.springboot.service.UserService;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody String userName){
        userService.addUser(userName.split(" ")[0],userName.split(" ")[1]);
        return new ResponseEntity("Success!", HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<String> getUser(@PathVariable(value="id")long userId){
        return new ResponseEntity(userService.getUser(userId), HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value ="id") long userId){
        userService.removeUser(userId);
        return new ResponseEntity("Success!", HttpStatus.OK);
    }
}
