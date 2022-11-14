package swe.gw.apiproject.controller;

import swe.gw.apiproject.model.Users;
import swe.gw.apiproject.service.UsersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/create")
    public Users createUsers(@RequestBody Users data) { return usersService.createUsers(data);}

    @GetMapping("/all")
    public List<Users> readUsers() { return usersService.getUsers();}

    @PutMapping("/update/{id}")
    public Users readUsers(@PathVariable(value = "id") Long id, @RequestBody Users input)
    {return usersService.updateUsers(id, input);}

    @GetMapping("/finduser/{id}")
    public Optional<Users> readUsers(@PathVariable(value = "id") Long id) {return usersService.getUsersById(id);}
}