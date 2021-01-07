package com.example.demo.demo.controller;

import com.example.demo.demo.model.List;
import com.example.demo.demo.model.User;
import com.example.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    public String addNewUser(@RequestParam String name, @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userService.saveUser(n);
        return "Saved";
    }

    @GetMapping(path = "")
    public Iterable<User> getAllUsers() {

        return userService.findAll();
    }

    @GetMapping(path = "/{id}/lists")
    public List getListByUserId(@PathVariable("id") Integer Id){
        User user = userService.findById(Id).get();
        return user.getList();
    }
}
