package com.example.demo.utils;

import com.example.demo.model.Category;
import com.example.demo.model.Role;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... strings) throws Exception{
        Role r = new Role();
        r.setRole("USER");
        roleRepository.save(r);

        Category business = new Category("business");
        Category entertainment = new Category("entertainment");
        Category general = new Category("general");
        Category health = new Category("health");
        Category science = new Category("science");
        Category sports = new Category("sports");
        Category technology = new Category("technology");
        categoryRepository.save(business);
        categoryRepository.save(entertainment);
        categoryRepository.save(general);
        categoryRepository.save(health);
        categoryRepository.save(science);
        categoryRepository.save(sports);
        categoryRepository.save(technology);
    }
}
