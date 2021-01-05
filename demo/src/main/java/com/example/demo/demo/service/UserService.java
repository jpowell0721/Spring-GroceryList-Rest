package com.example.demo.demo.service;

import com.example.demo.demo.model.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {

    void saveUser(User user);

    Iterable<User> findAll();

    Optional<User> findById(Integer Id);
}
