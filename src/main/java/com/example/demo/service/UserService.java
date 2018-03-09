package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void saveUser(User user) {
        HashSet<Role> hash = new HashSet<>();
        hash.add(roleRepository.findByRole("USER"));
        user.setRoles(hash);
        userRepository.save(user);
    }

    public void initializeCategory(User user){
        user.addCategory(categoryRepository.findByName("business"));
        user.addCategory(categoryRepository.findByName("entertainment"));
        user.addCategory(categoryRepository.findByName("general"));
        user.addCategory(categoryRepository.findByName("health"));
        user.addCategory(categoryRepository.findByName("science"));
        user.addCategory(categoryRepository.findByName("sports"));
        user.addCategory(categoryRepository.findByName("technology"));
        userRepository.save(user);
    }


}
