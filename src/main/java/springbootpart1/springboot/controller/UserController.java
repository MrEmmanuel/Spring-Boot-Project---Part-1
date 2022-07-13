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
        String name = userName.split(" ")[0];
        String surname = userName.split(" ")[1];
        userService.addUser(name,surname);
        return new ResponseEntity<String>(String.format("%s added", name), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<String> getUser(@PathVariable(value="id")long userId){
        String name = userService.getUser(userId);
        return new ResponseEntity<String>(String.format("Hello %s", name), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value ="id") long userId){
        String name = userService.getUser(userId);
        userService.removeUser(userId);
        return new ResponseEntity<String>(String.format("%s removed", name), HttpStatus.OK);
    }
}
