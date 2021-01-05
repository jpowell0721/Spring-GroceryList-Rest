package com.example.demo.demo.service;

import com.example.demo.demo.model.User;
import com.example.demo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<User> findById(Integer Id) { return userRepository.findById(Id); }
}
