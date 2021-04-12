package com.adminportal;

import com.adminportal.domain.User;
import com.adminportal.domain.security.Role;
import com.adminportal.domain.security.UserRole;
import com.adminportal.service.UserService;
import com.adminportal.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AdminportalApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AdminportalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setUsername("ruhaifi");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
        user1.setEmail("nazRuhaifi@gmail.com");
        user1.setFirstName("ruhaifi");
        user1.setLastName("naz");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(0);
        role1.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user1, role1));
        

        userService.createUser(user1, userRoles);
        
        User user2 = new User();
        user2.setUsername("farhana13");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("naz"));
        user2.setEmail("naz@gmail.com");
        user2.setFirstName("farhana");
        user2.setLastName("naz");
        Set<UserRole> userRole = new HashSet<>();
        Role role2 = new Role();
        role2.setRoleId(1);
        role2.setName("ROLE_ADMIN");
        userRole.add(new UserRole(user2, role2));
        

        userService.createUser(user2, userRole);
    }
}
