package com.app;

import com.app.model.Role;
import com.app.model.User;
import com.app.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

@Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "John Bon Jovi", "jbjovi", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "John Lennon", "lennon", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "John Doe", "doe", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("jbjovi", "ROLE_MANAGER");
            userService.addRoleToUser("lennon", "ROLE_ADMIN");
            userService.addRoleToUser("doe", "ROLE_USER");
            userService.addRoleToUser("doe", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("doe", "ROLE_ADMIN");
        };
    }

}
