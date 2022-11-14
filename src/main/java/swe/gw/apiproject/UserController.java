package swe.gw.apiproject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import swe.gw.apiproject.User;
import swe.gw.apiproject.UserService;

@RestController
public class UserController {
    //autowired the StudentService class
    @Autowired
    UserService userService;


    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/user")
        private List<User> getAllUser()
    {
        System.out.println("Cheese");
        return userService.getAllUser();
    }
    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/user/{id}")
    private User getUser(@PathVariable("id") int id)
    {
        return userService.getUserById(id);
    }
    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") int id)
    {
        userService.delete(id);
    }
    //creating post mapping that post the student detail in the database
    @PostMapping("/user")
    private String saveUser(@RequestBody User user)
    {
        userService.saveOrUpdate(user);
        return user.getName();

    }

}