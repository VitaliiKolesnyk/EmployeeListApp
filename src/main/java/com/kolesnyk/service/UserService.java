package com.kolesnyk.service;

import com.kolesnyk.model.User;
import com.kolesnyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("service")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}

