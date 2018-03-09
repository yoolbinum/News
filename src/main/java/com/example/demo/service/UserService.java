package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public void saveUser(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        userRepository.save(user);
        user.addCategory("business");
        userRepository.save(user);
        user.addCategory("entertainment");
        userRepository.save(user);
        user.addCategory("general");
        userRepository.save(user);
        user.addCategory("health");
        userRepository.save(user);
        user.addCategory("science");
        userRepository.save(user);
        user.addCategory("sports");
        userRepository.save(user);
        user.addCategory("technology");
        userRepository.save(user);
    }


}
